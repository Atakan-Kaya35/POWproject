package med;

import entity.*;
/**
 * medicine
 */
public abstract class Medicine {
    protected static int ID = 0;
    protected double price;
    protected String name;
    protected String description;
    protected int[] consumeFreq = new int[3];
    protected int cyclesLeft = -1;

    Medicine(String name, String desciption){
        this.name = name;
        this.description = desciption;
    }

    /**
     * Action when a pill is taken
     * @return a boolean that states if the medicine is done being used
     */
    public boolean takePill(){

        this.cyclesLeft--;
        if(this.cyclesLeft < 1){
            return true;
        }
        else{
            return false;
        }
    }

    public int[] getConsumeFreq() {
        return consumeFreq;
    }

    public void setConsumeFreq(int[] consumeFreq) {
        this.consumeFreq = consumeFreq;
    }

    public int getCyclesLeft() {
        return cyclesLeft;
    }

    public void setCyclesOfTaking(int cyclesOfTaking) {
        this.cyclesLeft = cyclesOfTaking;
    }

    /**
     * Assign a price to each medicine. (in order to calculate totol price that cart has)
     * @param price medicine price
     */
    public void setPrice(double price){
        this.price = price;
    }
    public static int getID() {
        return ID;
    }
}