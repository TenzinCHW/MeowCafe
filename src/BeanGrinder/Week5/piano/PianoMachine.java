package BeanGrinder.Week5.piano;

import javax.sound.midi.MidiUnavailableException;

import BeanGrinder.Week5.midi.Instrument;
import BeanGrinder.Week5.midi.Midi;
import BeanGrinder.Week5.music.NoteEvent;
import BeanGrinder.Week5.music.Pitch;

import java.util.ArrayList;
import java.util.Iterator;

import static BeanGrinder.Week5.music.NoteEvent.Kind.start;
import static BeanGrinder.Week5.music.NoteEvent.Kind.stop;
//import midi.Midi;
//import music.Pitch;

public class PianoMachine {
	
	private Midi midi;
    private ArrayList<Pitch> beingPlayed = new ArrayList<Pitch>();
    private Instrument instrument = Instrument.PIANO;
    private int octavery = 0;
    private boolean recording = false;
    private ArrayList<NoteEvent> currentlyRecording = new ArrayList<NoteEvent>();
	/**
	 * constructor for PianoMachine.
	 * 
	 * initialize midi device and any other state that we're storing.
	 */
    public PianoMachine() {
    	try {
            midi = Midi.getInstance();
        } catch (MidiUnavailableException e1) {
            System.err.println("Could not initialize midi device");
            e1.printStackTrace();
            return;
        }
    }

    public void beginNote(Pitch rawPitch) {
        Pitch pitch = rawPitch.transpose(octavery*Pitch.OCTAVE);
        if (!beingPlayed.contains(pitch)){
            beingPlayed.add(pitch);
            if (recording){
                currentlyRecording.add(new NoteEvent(pitch, System.currentTimeMillis(), instrument, NoteEvent.Kind.start));
            }
            midi.beginNote(pitch.toMidiFrequency(), instrument);
        }
    }

    public void endNote(Pitch rawPitch) {
        Pitch pitch = rawPitch.transpose(octavery*Pitch.OCTAVE);
        if (beingPlayed.contains(pitch)){
            beingPlayed.remove(pitch);
            if (recording){
                currentlyRecording.add(new NoteEvent(pitch, System.currentTimeMillis(), instrument, NoteEvent.Kind.stop));
            }
            midi.endNote(pitch.toMidiFrequency(), instrument);
        }
    }

    public void changeInstrument() {
        if (beingPlayed.isEmpty()) {
            instrument = instrument.next();
        }
    }

    public void shiftUp() {
        if (octavery < 2) {
            octavery += 1;
        }
    }

    public void shiftDown() {
        if (octavery > -2) {
        octavery -= 1;
        }
    }

    public boolean toggleRecording() {
    	recording = !recording;
        if (recording){
            currentlyRecording = new ArrayList<NoteEvent>();
        }
        return recording;
    }

    private void playNote(NoteEvent note){
        if (note.getKind() == NoteEvent.Kind.start){
            midi.beginNote(note.getPitch().toMidiFrequency(), note.getInstr());
        }else{
            midi.endNote(note.getPitch().toMidiFrequency(), note.getInstr());
        }
    }

    public void playback(){
        long now = 0;
        for (int i = 0; i < currentlyRecording.size(); i++) {
            if (now != 0){
                Midi.rest((int)(currentlyRecording.get(i).getTime() - now)/10);
            }
            now = currentlyRecording.get(i).getTime();
            playNote(currentlyRecording.get(i));
        }
        System.out.println(midi.history());
    }
//    public void playback() {
//        Iterator<NoteEvent> toBePlayed = recorded.iterator();
//        NoteEvent note1 = toBePlayed.next();
//        NoteEvent note2;
//        long now;
//        long end;
//        do {
//            note2 = toBePlayed.next();
//            now = note1.getTime();
//            end = note2.getTime();
//            playNote(note1);
//            Midi.rest((int)(end-now)/10);
//            playNote(note2);
//            note1 = note2;
//        }while (toBePlayed.hasNext());
//    }

}
