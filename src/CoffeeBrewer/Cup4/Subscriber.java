package CoffeeBrewer.Cup4;

import java.util.ArrayList;

/**
 * Created by HanWei on 8/12/2016.
 */
interface Observer {
    void update(double airPollutionIndex);
}

class Subscriber implements Observer {
    private Subject subject;
    private String observerId;
    public static String outputMessage = "";

    public Subscriber(String observerId, Subject subject) {
        this.subject = subject;
        this.observerId = observerId;
        this.subject.register(this);        // register itself
    }

    @Override
    public void update(double airPollutionIndex) {
        String s = this.observerId + " received notification: " + airPollutionIndex;
        System.out.println(s);
        outputMessage += (s + " ");
    }
}

interface Subject {
    void register(Observer o);

    void unregister(Observer o);

    void notifyObservers();
}

//TODO: modify AirPollutionAlert to implement interface Subject, under Observer design pattern
class AirPollutionAlert implements Subject {
    private double airPollutionIndex;
    private ArrayList<Observer> observers;

    public AirPollutionAlert() {
        observers = new ArrayList<Observer>();
    }

    public void setAirPollutionIndex(double airPollutionIndex) {
        this.airPollutionIndex = airPollutionIndex;
        this.notifyObservers();
    }

    public void register(Observer observer) {
        observers.add(observer);
    }

    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer :
                observers) {
            observer.update(this.airPollutionIndex);
        }
    }

}