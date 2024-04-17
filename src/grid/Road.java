package grid;

import java.util.*;

import entity.mobile.Mobile;

public class Road {
    
    int[] coordinates;
    // maybe ArrayList for more complicated city arrangements in the future
    // though that would require a rework of a* which is not easy
    Stationary[] surroundingStationarys;
    Mobile contained = null;                                                //its abstract!!!   
    int costFromStart; // Cost from start node to current node
    int costToFinish; // Heuristic (estimated cost from current node to goal node)
    Road parent; 
    Stationary entrenceOf = null;
    boolean isThereRoad; //if there is no road there might be a stationary
    int[] traffic = {1,1};
    boolean wasCrossed = false;

    // melike boolean, constructor içine bina alma ve getter setter

    public boolean getWasCrossed() {
        return wasCrossed;
    }

    public void setWasCrossed(boolean wasCrossed) {
        this.wasCrossed = wasCrossed;
    }

    public int[] getTraffic() {
        return traffic;
    }

    public void setTraffic(int[] traffic) {
        int max = 100;
        int min = 1;

        // setting right traffic
        if( traffic[0] < min){
            this.traffic[0] = min;
        }
        else if( traffic[0] > max){
            this.traffic[0] = max;
        }
        else{
            this.traffic[0] = this.traffic[0];
        }

        // setting down traffic
        if( traffic[1] < min){
            this.traffic[1] = min;
        }
        else if( traffic[1] > max){
            this.traffic[1] = max;
        }
        else{
            this.traffic[1] = this.traffic[1];
        }


        this.traffic = traffic;
    }

    /*     public Road(int[] coords, Nurse contained){
        this.coordinates = coords;
        this.contained = contained;
    }

    public Road(int x, int y, Nurse contained){
        this.coordinates = new int[2];
        coordinates[0] = x;
        coordinates[1] = y;

        this.contained = contained;
    }
 */
    public Road (int x, int y, boolean isThereRoad){
        this.coordinates = new int[2];
        coordinates[0] = x;
        coordinates[1] = y;
        this.isThereRoad = isThereRoad;
        int[] initTraffic = {(int) (Math.random() * 6)+ 1, (int) (Math.random() * 6) +1 };
        setTraffic(initTraffic);
    }

    public Road(int x, int y){
        this.coordinates = new int[2];
        coordinates[0] = x;
        coordinates[1] = y;

        this.contained = null;

        int[] initTraffic = {(int) (Math.random() * 6) +1, (int) (Math.random() * 6) + 1};
        setTraffic(initTraffic);
    }

    //getter methods
    
    public int totalCost(){
        return this.costFromStart + this.costToFinish;
    }

    public Road getParent(){
        return this.parent;
    }

    public int[] getCoords(){
        return this.coordinates;
    }

    public int getCostFromStart() {
        return costFromStart;
    }

    public int getCostToFinish() {
        return costToFinish;
    }

    public boolean getIsThereRoad(){
        return isThereRoad;
    }

    public Mobile getContained(){
        return contained;
    }

    public Stationary getEnterenceOf(){
        return entrenceOf;
    }
    
    //setter methods

    public void setSurroundings(Stationary[] stationarys){
        this.surroundingStationarys = stationarys;
    }

    public void setSurroundings(Stationary stationary1, Stationary stationary2, Stationary stationary3, Stationary stationary4){
        this.surroundingStationarys = new Stationary[4];

        this.surroundingStationarys[0] = stationary1;
        this.surroundingStationarys[1] = stationary2;
        this.surroundingStationarys[2] = stationary3;
        this.surroundingStationarys[3] = stationary4;
    }

    public void setCostFromStart(int costFromStart) {
        this.costFromStart = costFromStart;
    }

    public void setCostToFinish(int costToFinish) {
        this.costToFinish = costToFinish;
    }

    public void setParent(Road newParent){
        this.parent = newParent;
    }

    public void setRoad(boolean isThereRoad){
        this.isThereRoad = isThereRoad;
    }

    public void setContined(Mobile contained){
        this.contained = contained;
    }

    public void setEnteranceOf(Stationary build){
        this.entrenceOf = build;
    }
} 
