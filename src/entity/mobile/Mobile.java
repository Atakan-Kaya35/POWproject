package entity.mobile;

import grid.*;
import entity.Entity;
import entity.mobile.physcian.Nurses;
import grid.*;

public abstract class Mobile extends Entity {

    int[] coordinates;
    // maybe ArrayList for more complicated city arrangements in the future
    // though that would require a rework of a* which is not easy
    //Building[] surroundingBuildings;

    // Burkay affet
    Road containedIn;

    /**
     * Gives the specific road which mobile (nurse, scooter, van) locates.
     * @return road
     */
    public Road getCurrentRoad(){
        return this.containedIn;
    }

    /**
     * Put mobile to the given road
     * @param containedIn road
     */
    public void setContainedIn(Road containedIn) {
        this.containedIn = containedIn;
    }

/* 

    public void Road(int[] coords, Nurses contained){
        this.coordinates = coords;
        this.containedIn = contained;
    }

    public void Road(int x, int y, Nurses contained){
        this.coordinates = new int[2];
        coordinates[0] = x;
        coordinates[1] = y;

        this.containedIn = contained;
    }
 
     public void Road(int x, int y){
        this.coordinates = new int[2];
        coordinates[0] = x;
        coordinates[1] = y;

        this.containedIn = null;
    }

    public void setSurroundings(Building[] buildings){
        this.surroundingBuildings = buildings;
    }

    public void setSurroundings(Building building1, Building building2, Building building3, Building building4){
        this.surroundingBuildings = new Building[4];

        this.surroundingBuildings[0] = building1;
        this.surroundingBuildings[1] = building2;
        this.surroundingBuildings[2] = building3;
        this.surroundingBuildings[3] = building4;
    }
 */
}
