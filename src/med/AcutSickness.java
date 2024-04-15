package med;

import entity.stationary.patients.Patients;
import grid.Order;

public class AcutSickness extends Sickness{

    protected int cyclesLeft;
    private boolean done = false;
    
    AcutSickness(int cycles, int cycleFrequency, Patients patient, Medicine ... neededMeds) {
        super(cycleFrequency, patient, neededMeds);
        this.cyclesLeft = cycles;

        for (Medicine medicine : neededMeds) {
            new Order(patient, (Pill)medicine);
        }
    }

    /**
     * @return a boolean stating whether the treatment for the sickness has been concluded
     */
    public boolean fullCycle(){
        for (int i = 0; i < neededMeds.size(); i++) {
            if( neededMeds.get(i).takePill()){
                neededMeds.remove(i);
            }
        }

        // TODO: make the reminding system into the cycle

        if( neededMeds.size() == 0){
            done = true;
            return true;
        }
        else return false;
    }

    public boolean getIfDone(){
        return done;
    }
    
}
