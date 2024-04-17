package MapGridTaslak;

import javax.swing.*;
import java.awt.*;

public class Home 
{
    private final  int RADIUS = 5;

    private int x;
    private int y;

    public Home(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Draw homes as a blue point according to their coordinates
     * @param g graphics object
     */
    public void draw(Graphics g)
    {
        g.setColor(Color.BLUE);
        g.fillOval(x, y, RADIUS * 2, RADIUS * 2);
        
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
}
