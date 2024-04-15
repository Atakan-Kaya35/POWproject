package grid;

import java.util.ArrayList;
import java.util.List;

import entity.mobile.Mobile;
import entity.mobile.physcian.Nurses;
import entity.mobile.physcian.Van;

public class GridTest {
    public static void main(String[] args) {

        City city = new City(10, 10);
        Mobile a = new Van("mert");
        city.setRoad(a, 0,0);
        Mobile v = new Van("atakanisko");
        city.setRoad(a, 0,0);
        Stationary b = new Stationary(9,9);
        city.buildCustomeStationary(9,9, 1,1, b);     //We already passed the coordinates of stationary by using "b". Not need!!!!!!!!!!?
        Stationary Z = new Stationary(0,1);
        city.buildCustomeStationary(0,1, 9,6, b);

        int[] newTraffic = {10,14};
        city.getRoad(10, 5).setTraffic(newTraffic);


        List<Road> d = city.findPath((Nurses)a, b);
        System.out.println(city.viewMap(false));
        System.out.println("a"); // bu a neden acaba...gercek bir gizem -> map printinin gerçekten bittiğini anlamak için bence :)

        //Mutlulukkk a* a kurban olim
    }
}
