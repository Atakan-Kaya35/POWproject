package med;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Pill extends Medicine{

    public static ArrayList<String[]> AllPills;
    public static ArrayList OTCpills;
    public static ArrayList prescribedPills;
    public int pillID;

    public Pill(int IDnumber){
        super(AllPills.get(IDnumber)[0], AllPills.get(IDnumber)[1]);
        this.pillID = IDnumber;
    }

    public Pill(int IDnumber, int cyclesOfTaking, int[] takeingFrequency){
        super(AllPills.get(IDnumber)[0], AllPills.get(IDnumber)[1]);
        this.pillID = IDnumber;
        super.setCyclesOfTaking(cyclesOfTaking);
        super.setConsumeFreq(takeingFrequency);
    }

    public void fillPills(){
        AllPills = new ArrayList<>();
        OTCpills = new ArrayList<>();
        prescribedPills = new ArrayList<>();

        String csvFile = "over_the_counter.csv";
        String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // Split the line into fields
                String[] fields = line.split(csvSplitBy);
                
                // adds the pill into the big pile
                this.AllPills.add(fields);
                this.OTCpills.add(fields);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        csvFile = "prescribed.csv";
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // Split the line into fields
                String[] fields = line.split(csvSplitBy);
                
                // adds the pill into the big pile
                this.AllPills.add(fields);
                this.prescribedPills.add(fields);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
    public int getPillID() {
        return pillID;
    }

    public void setPillID(int pillID) {
        this.pillID = pillID;
    }

}
