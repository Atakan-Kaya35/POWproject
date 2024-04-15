package grid;
import java.util.*;
import entity.mobile.physcian.Nurses;
import entity.stationary.patients.Patients;
import med.Medicine;
import med.Pill;
import med.Serum;

public class Order {
    
    int[] startingCord;
    int[] finishingCord;
    boolean assigned = false;
    boolean completed = false;
    ArrayList<int[]> path;
    Medicine carriedMedicine;
    public static ArrayList<Order> assignedOrders = new ArrayList<Order>();
    public static ArrayList<Order> completedOrders = new ArrayList<Order>();

    //atakan biz burda pathi array arraylisti yaptık da, biz citydeki 
    //find pathde road array listi olarak kullandık sıkıntı çıkarmaz mı bu????

    public void orderFiller(ArrayList<int[]> path){
        this.assigned = true;
        this.path = new ArrayList<int[]>();
    }
     
    // constructors
    public Order(Patients patient, Pill carriedPill){
        this.startingCord = patient.getCity().findMobile(patient.getCoordinates());
        this.finishingCord = patient.getCoordinates();
        this.carriedMedicine = new Pill(carriedPill.getPillID());
    }

    public Order(Patients patient, Serum carriedPill){
        this.startingCord = patient.getCity().findMobile(patient.getCoordinates());
        this.finishingCord = patient.getCoordinates();
        this.carriedMedicine = new Serum();
    }


    // manifest order path dolacak??
    
    //getter methods
    public int[] getStartingCord() {
        return this.startingCord;
    }

    public int[] getFinishingCord() {
        return this.finishingCord;
    }

    public boolean isAssigned() {
        return this.assigned;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public ArrayList<int[]> getPath() {
        return this.path;
    }

    public Medicine getCarriedMedication() {
        return this.carriedMedication;
    }

    //setter methods
    public void setAssignedOrder(boolean assigned){
        this.assigned = assigned;
        assignedOrders.add(this);
    }

    public void setCompletedOrder(boolean completed){
        this.completed = completed;
        completedOrders.add(this);
    }

} 
