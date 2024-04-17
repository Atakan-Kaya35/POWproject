package entity.mobile.physcian;
    
import grid.*;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*; 

import javax.swing.*;
import entity.mobile.physcian.*;

public class Van extends Nurses {
    
    final protected int speed = 3;


    private int RADIUS = 5;
    private int[][] road;
    private int x;
    private int y;
    private int currentRoad;


    public Van(String name, int x, int y)
    {
        super(name);
        currentRoad = 0;
        this. x = x;
        this.y = y;
        road = createRoad();
    }

    public int [][] createRoad()
    {
        int[][] road = new int[12][2]; ////This will be determined by A* algorithm.(not hardcode)
<<<<<<< Updated upstream
        

        City city = new City(12, 12);
=======
        road[0][0] = 105;
        road[0][1] = 55;
        road[1][0] = 105;
        road[1][1] = 105;
        road[2][0] = 105;
        road[2][1] = 155;
        road[3][0] = 105;
        road[3][1] = 205;
        road[4][0] = 155;
        road[4][1] = 205;
        road[5][0] = 205;
        road[5][1] = 205;
        road[6][0] = 255;
        road[6][1] = 205;
        road[7][0] = 255;
        road[7][1] = 255;
        road[8][0] = 255;
        road[8][1] = 305;
        road[9][0] = 255;
        road[9][1] = 355;
        road[10][0] = 255;
        road[10][1] = 405;
        road[11][0] = 255;
        road[11][1] = 455;

        City city = new City(10, 10);
>>>>>>> Stashed changes
        
        city.setRoad(this, x,y);
        Stationary b = new Stationary(9,9);
        city.buildCustomeStationary(9,9, 1,1, b);     //We already passed the coordinates of stationary by using "b". Not need!!!!!!!!!!?
        Stationary Z = new Stationary(0,1);
        city.buildCustomeStationary(0,1, 9,6, b);

        int[] newTraffic = {10,14};
        city.getRoad(10, 5).setTraffic(newTraffic);


<<<<<<< Updated upstream
        List<Road> d = city.findPath((Van)this, b);
        System.out.println(city.viewMap(false));


        
        int base = 50;
        for(int i = 0; i<12; i++){
                road[i][0] = base*(city.wholeWay.get(i).get(0));
                road[i][1] = base*(city.wholeWay.get(i).get(1));
        } 

=======
        List<Road> d = city.findPath((Nurses)this, b);
        System.out.println(city.viewMap(false));

        



        //TODO HATALI KOD
        int base = 50;
        for(int i = 0; i<12; i++){
                road[i][0] = base + base*(city.wholeWay.get(i).get(0));
                road[i][1] = base + base*(city.wholeWay.get(i).get(1));
        } 

>>>>>>> Stashed changes
        return road;
    }

    /**
     * Draw van as a red point
     * @param g graphics object
     */
    public void draw(Graphics g)
    {
        g.setColor(Color.CYAN);
        g.fillOval(x, y, RADIUS * 4, RADIUS * 4);
    }

    //Setter methods
    public void setXCoor(int n)
    {
        this.x = n;
    }
    public void setYCoor(int n)
    {
        this.y = n;
    }
    public void setCurrentRoad()
    {
        currentRoad++;
    }

    //Getter methods
    public int getXCoor()
    {
        return x;
    }
    public int getYCoor()
    {
        return y;
    }
    public int getRadius()
    {
        return RADIUS;
    }
    public int[][] getRoad()
    {
        return road;
    }
    public int getCurrentRoad()
    {
        return currentRoad;
    }
}
