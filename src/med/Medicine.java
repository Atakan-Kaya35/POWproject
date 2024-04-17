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
    protected int purchaseCount = 0;

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

    // Getter for ID
    public static int getID() {
        return ID;
    }

    // Getter for price
    public double getPrice() {
        return price;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Getter for consumeFreq
    public int[] getConsumeFreq() {
        return consumeFreq;
    }

    // Getter for cyclesLeft
    public int getCyclesLeft() {
        return cyclesLeft;
    }

    // Getter for purchaseCount
    public int getPurchaseCount() {
        return purchaseCount;
    }

    // Setter for purchaseCount
    public void setPurchaseCount(int purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    /**
     * Assign a price to each medicine. (in order to calculate totol price that cart has)
     * @param price medicine price
     */
    public void setPrice(double price){
        this.price = price;
    }
}