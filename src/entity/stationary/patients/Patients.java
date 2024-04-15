package entity.stationary.patients;
import java.util.ArrayList;

import grid.City;
import med.Medicine;
import med.Sickness;

public class Patients extends grid.Stationary {

    protected ArrayList<Medicine> cart = new ArrayList<Medicine>();
    protected ArrayList<Sickness> sicknesses = new ArrayList<Sickness>();

    protected String name;
    protected City city;

    public Patients(String name, int x, int y, City city){
        super(x, y);
        this.name = name;
        this.city = city;
    }
    public String getPatientsName(){
        return this.name;
    }
    public void addMedicine(Medicine x){
        cart.add(x);
    }
    public ArrayList<Medicine> getCart(){
        return cart;
    }
    public int getCartSize(){
        return cart.size();
    }
    
    /**
     * Make cart empty when patients purchase all their medicines
     */
    public void setCartNull(){
        this.cart = new ArrayList<Medicine>();
    }

    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }

    public ArrayList<Sickness> getSicknesses() {
        return sicknesses;
    }
    public void assSickness(Sickness sickness) {
        this.sicknesses.add(sickness);
    }
}
