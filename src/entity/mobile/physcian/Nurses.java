package entity.mobile.physcian;
import java.util.ArrayList;

import entity.mobile.Mobile;
import grid.Road;
import med.Medicine;
import med.Pill;
import med.Serum;

public class Nurses extends Mobile {
    
    protected ArrayList<Serum> serumBaggage = new ArrayList<>();
    protected ArrayList<Pill> pillBaggage = new ArrayList<>();
    protected ArrayList<Medicine> baggage = new ArrayList<Medicine>();
    protected String name;

    public Nurses(){
        
    }

    Nurses(String name){
        this.name = name;

    }
    public String getName() {
        return name;
    }
    
    /**
     * Give all medicines stored in baggage
     * @return baggage
     */
    public ArrayList<Medicine> getBaggage() {
        return baggage;
    }

    /**
     * Nurse added new medine to baggage
     * @param x added medicine
     */
    public void addToBaggage(ArrayList<Medicine> x) {
        this.baggage = x;
    }
    /**
     * When nurse deliver medicine to patient baggage update its current medicines
     * @param x given medicine 
     */
    public void giveMedicine(Medicine x){
        this.baggage.remove(x);
    }

    /**
     * Prints all medicines located in the baggage 
     */
    public String toString() {
        String result = "";
        for (Medicine x : baggage){
            result += x;
        }
        return result;
    }
    
    
    
    
    
}
