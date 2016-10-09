package BeanGrinder.Week4;

import java.util.Scanner;

/**
 * Created by HanWei on 9/10/2016.
 */

public class Grind4_5 {

    public static void main(String[] args) {
        System.out.println("Welcome to the Appointment Scheduler");
        System.out.println("You can schedule an appointment at 1 or 2 pm.");

        Scanner reader = new Scanner(System.in);
        String name;
        int time;

        String appointments[] = new String[2];  // CHANGED TO 2 FROM 3
        int appointmentsMade = 0;

        while (appointmentsMade < 2) {
            System.out.println("What is your name?");
            name = reader.nextLine();
            System.out.println("What time would you like the appointment?");
            time = Integer.parseInt(reader.nextLine());

            try{
                assignSchedule(name, appointments, time);
                appointmentsMade += 1;
            }catch (InvalidTimeException timeInvalid){
                System.out.println("Time value not in range\n" +
                        "Sorry, that is not a legal time");
            }catch (TimeInUseException someoneBeatYouToIt){
                System.out.println("Appointment already made at that time\n" +
                        "Sorry, that time is already in use");
            }
        }

        System.out.println("All appointments made");
        String onePM = String.format("At 1 pm: %s", appointments[0]);
        String twoPM = String.format("At 2 pm: %s", appointments[1]);
        System.out.println(onePM);
        System.out.println(twoPM);
    }

    public static void assignSchedule(String name, String[] appointments, int time) throws InvalidTimeException, TimeInUseException {
        if (time < 1 || time > 2){
            throw new InvalidTimeException();
        }
        if (appointments[time-1] != null){
            throw new TimeInUseException();
        }else{
            appointments[time-1] = name;
        }
    }

    public static class InvalidTimeException extends Exception {

        public InvalidTimeException() {
            super();
        }

        public InvalidTimeException(String message) {
            super(message);
        }

        public InvalidTimeException(String message, Throwable cause) {
            super(message, cause);
        }

        public InvalidTimeException(Throwable cause) {
            super(cause);
        }

    }

    public static class TimeInUseException extends Exception {

        public TimeInUseException() {
            super();
        }

        public TimeInUseException(String message) {
            super(message);
        }

        public TimeInUseException(String message, Throwable cause) {
            super(message, cause);
        }

        public TimeInUseException(Throwable cause) {
            super(cause);
        }
    }
}
