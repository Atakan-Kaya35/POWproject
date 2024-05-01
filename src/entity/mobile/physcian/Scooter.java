package entity.mobile.physcian;

import grid.Order;
import med.Pill;

import java.util.ArrayList;

public class Scooter extends Nurses {
    
    final protected int speed = 5;

    public Scooter(){
        super("");
    }
    public Scooter(String name){
        super(name);
    }

    //@Override
    public void receiveOrder(grid.Order order){
        this.pillBaggage = order.getCarriedPills();

    }

    /**
     * Give all medicines stored in baggage
     * @return baggage
     */
    /*public ArrayList<Pill> getBaggage() {
        return pillBaggage;
    }*/

    /**
     * Nurse added new medine to baggage
     * @param x added medicine
     */
    /*public void addToBaggage(ArrayList<Pill> x) {
        this.pillBaggage = x;
    }*/
    /**
     * When nurse deliver medicine to patient baggage update its current medicines
     * @param x given medicine 
     */
    public void giveMedicine(Pill x){
        this.pillBaggage.remove(x);
    }

    /**
     * Prints all medicines located in the baggage 
     */
    public String toString() {
        String result = "";
        for (Pill x : pillBaggage){
            result += x;
        }
        return result;
    }
    
}