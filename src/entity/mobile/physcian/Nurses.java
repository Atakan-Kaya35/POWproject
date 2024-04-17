package entity.mobile.physcian;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

import entity.mobile.Mobile;
import med.Medicine;
import med.Pill;
import med.Serum;

public abstract class Nurses extends Mobile {
    
    protected ArrayList<Serum> serumBaggage = new ArrayList<Serum>();
    protected ArrayList<Pill> pillBaggage = new ArrayList<Pill>();
    protected String name;

    public Nurses(String name){
        this.name = name;

    }
    public String getName() {
        return name;
    }
    
    public void receiveOrder(grid.Order order){}
    
}
