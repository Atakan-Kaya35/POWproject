package med;

import entity.stationary.patients.Patients;
import grid.Order;

public class PeriodicSickness extends Sickness{

    PeriodicSickness(int cycleFreq, Patients patient, Medicine ... neededMeds){
        super(cycleFreq, patient, neededMeds);
    }

    @Override
    public boolean fullCycle() {
        for (int i = 0; i < neededMeds.size(); i++) {
            if( neededMeds.get(i).takePill()){
                neededMeds.remove(i);
                new Order(this.patient, (Pill)neededMeds.get(i));
            }
        }

        return false;
    }

}
