package med;

import java.util.ArrayList;

import entity.stationary.patients.Patients;

public abstract class Sickness {
    //this is the amount of ticks that should pass before a whole cycle's worth of actions are made
    protected int cycleFreq;
    protected ArrayList<Medicine> neededMeds;
    protected Patients patient;

    Sickness( int cycleFrequency, Patients patient, Medicine ... neededMeds){
        this.neededMeds = new ArrayList<>();
        this.patient = patient;
        for (Medicine medicine : neededMeds) {
            this.neededMeds.add(medicine);
        }
        this.cycleFreq = cycleFrequency;
    }

    public abstract boolean fullCycle();
}
