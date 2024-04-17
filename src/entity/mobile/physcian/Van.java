package entity.mobile.physcian;

import med.Serum;
import java.util.ArrayList;

public class Van extends Nurses {
    
    final protected int speed = 3;

    public Van(String name){
        super(name);
    }

    @Override
    public void receiveOrder(grid.Order order){
        this.serumBaggage = order.getCarriedSerums();

    }

    /**
     * Give all medicines stored in baggage
     * @return baggage
     */
    public ArrayList<Serum> getBaggage() {
        return serumBaggage;
    }

    /**
     * Nurse added new medine to baggage
     * @param x added medicine
     */
    public void addToBaggage(ArrayList<Serum> x) {
        this.serumBaggage = x;
    }
    /**
     * When nurse deliver medicine to patient baggage update its current medicines
     * @param x given medicine 
     */
    public void giveMedicine(Serum x){
        this.serumBaggage.remove(x);
    }

    /**
     * Prints all medicines located in the baggage 
     */
    public String toString() {
        String result = "";
        for (Serum x : serumBaggage){
            result += x;
        }
        return result;
    }
}
