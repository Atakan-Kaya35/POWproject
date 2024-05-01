package Simulation;
import java.util.ArrayList;
import java.util.Random;
import grid.City;
import grid.Order;
import grid.Stationary;
import med.AcutSickness;
import med.PeriodicSickness;
import med.Serum;
import med.Sickness;
import med.Medicine;
import med.Pill;
import entity.mobile.physcian.*;
import entity.stationary.Patients;

public class SimMethods {

    private static ArrayList<Stationary> users = new ArrayList<>();
    private static ArrayList<String> usernames = new ArrayList<>();
    private static ArrayList<String> passwords = new ArrayList<>();

    /**
     * Registers a new user with the provided information.
     */
    public static boolean signUp(String name, int x, int y, City city, String username, String password) {
        // Check if username is already taken
        if (isUsernameTaken(username)) {
            System.out.println("Username is already taken.");
            return false;
        }

        // Check if password meets length requirement
        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            return false;
        }

        // Create a new user
        Stationary newUser = new Patients(name, x, y, city);

        // Add the new user to the list of users
        users.add(newUser);
        usernames.add(username); 
        passwords.add(password); 

        System.out.println("User signed up successfully.");
        System.out.println(usernames.get(0));
        return true;
    }

    /**
    * Checks if the given username is already taken.
    * @param username The username to check.
    * @return True if the username is already taken, false otherwise.
    */
    private static boolean isUsernameTaken(String username) {
        return usernames.contains(username);
    }

    public static boolean login(String username, String password) {
        // Check if the username exists
        int index = usernames.indexOf(username);
        if (index == -1) {
            System.out.println("Username not found.");
            return false;
        }
    
        // Check if the password matches
        if (!passwords.get(index).equals(password)) {
            System.out.println("Incorrect password.");
            return false;
        }
    
        System.out.println("Login successful. Welcome, " + users.get(index).getName() + "!");
        return true;
    }

    // Method to initialize the city with desired parameters
    public static City createCity() {
        final int cityWidth = 100;
        final int cityHeight = 100;
        City Ankara = new City(cityWidth, cityHeight);
        return Ankara;
    }
    
    // Method to create a certain number of patients with Turkish names
    public static void createPatients(int numPatients, City city) {
        ArrayList<String> turkishNames = getTurkishNames(); // Get a list of Turkish names
        
        Random random = new Random();
        for (int i = 0; i < numPatients; i++) {
            String name = turkishNames.get(random.nextInt(turkishNames.size()));
            // Get random coordinates from a stationary in the city
            int[] coordinates = getRandomStationaryCoordinates(city);   // her bir patientı bir stationary ile aynı lokasyona atıyoruz
            Patients patient = new Patients(name, coordinates[0], coordinates[1], city);
            city.getPatientList().add(patient);
        }
    }
    /* 
    // Method to create a certain number of nurses with Turkish names
    public static void createNurses(int numNurses, City city) {
        ArrayList<String> turkishNames = getTurkishNames(); // Get a list of Turkish names
        
        Random random = new Random();
        for (int i = 0; i < numNurses; i++) {
            String name = turkishNames.get(random.nextInt(turkishNames.size()));
            Nurses nurse = new Nurses(name);
            city.getNurseList().add(nurse);
        }
    }
    */

    // Helper method to get a list of common Turkish names
    private static ArrayList<String> getTurkishNames() {
        ArrayList<String> turkishNames = new ArrayList<>();
        turkishNames.add("Ahmet");
        turkishNames.add("Mehmet");
        turkishNames.add("Ayşe");
        turkishNames.add("Fatma");
        // daha ekleriz
        
        return turkishNames;
    }

    // Helper method to get random coordinates from a stationary in the city
    public static int[] getRandomStationaryCoordinates(City city) {
        Random random = new Random();
        // Get a random stationary from the city
        int index = random.nextInt(city.getStationaryList().size());
        // Get the coordinates of the stationary
        return city.getStationaryList().get(index).getCoordinates();
    }

    public static void buildCity(City city) {

        city.createRandomBuildings(5, 0.4);
        city.createVansAndScooters();
        createPatients(10, city);
        //createNurses(5, city);
    }

    public static Sickness getRandomSickness(Patients patient) {
        Random random = new Random();
        // random number to determine the type of sickness
        int sicknessType = random.nextInt(10); 
    
        // acute daha nadir olmalı
        if (sicknessType < 3) {
            // Create an AcuteSickness
            int cycles = random.nextInt(10); // Random cycles between 1 and 10
            int cycleFrequency = random.nextInt(4); // Random freq between 1 and 3
            Medicine[] neededMeds;
            if (random.nextBoolean()) {
                // Select medicines from the Over The Counter 
                neededMeds = getRandomOTCMedicines(4); // Get up to 4 random OTC medicines
            } else {
                // Use Serum as one of the medicines
                neededMeds = new Medicine[] { new Serum(), getRandomOTCMedicine() }; // Include Serum and one OTC medicine
            }
            return new AcutSickness(cycles, cycleFrequency, patient, neededMeds);
        } else {
            // Create a PeriodicSickness
            int cycleFrequency = random.nextInt(5) + 1; // Random frequency between 1 and 5
            Medicine[] neededMeds = getRandomPrescribedMedicines(4); // Get up to 4 random prescribed medicines
            return new PeriodicSickness(cycleFrequency, patient, neededMeds);
        }
    }
    
    private static Medicine[] getRandomOTCMedicines(int maxMedicines) {
        Random random = new Random();
        int numMedicines = random.nextInt(maxMedicines + 1); // Random number of medicines between 0 and maxMedicines
        Medicine[] Medicines = new Medicine[numMedicines];
        @SuppressWarnings("unchecked")
        ArrayList<String[]> otcPills = Pill.OTCpills; // Assuming you have a static ArrayList containing OTC pill data
    
        for (int i = 0; i < numMedicines; i++) {
            // Get a random pill ID
            int pillID = random.nextInt(7);  // 6 tane otcmiz var
            Medicines[i] = new Pill(pillID);
        }
    
        return Medicines;
    }
    
    private static Medicine getRandomOTCMedicine() {
        Random random = new Random();
        @SuppressWarnings("unchecked")
        ArrayList<String[]> otcPills = Pill.OTCpills; //
        // Get a random pill ID
        int pillID = random.nextInt(7);
        return new Pill(pillID);
    }
    
    private static Medicine[] getRandomPrescribedMedicines(int maxMedicines) {
        Random random = new Random();
        int numMedicines = random.nextInt(maxMedicines + 1); 
        Medicine[] medicines = new Medicine[numMedicines];
        @SuppressWarnings("unchecked")
        ArrayList<String[]> prescribedPills = Pill.prescribedPills;
    
        for (int i = 0; i < numMedicines; i++) {
            // Get a random pill ID
            int pillID = random.nextInt(52);    // csvnin uzunluğunu alamadım hardcode bu
            medicines[i] = new Pill(pillID);
        }
        return medicines;
    }

    // Method to create orders for a patient with predefined sicknesses
    public static void createOrdersForPatients(Patients patient, City city) {
        ArrayList<Medicine> neededMeds = new ArrayList<>();

        // Get all sicknesses of the patient
        ArrayList<Sickness> sicknesses = patient.getSicknesses();

        // Iterate through each sickness and add its needed medicines to the list
        for (Sickness sickness : sicknesses) {
            neededMeds.addAll(sickness.getNeededMeds());
        }

        // Create orders for each needed medicine
        for (Medicine medicine : neededMeds) {
            if (medicine instanceof Pill) {
                assignOrdersToNurses(patient, neededMeds,new Order(patient, (Pill) medicine), city);
            } else if (medicine instanceof Serum) {
                assignOrdersToNurses(patient, neededMeds, new Order(patient, (Serum) medicine), city);
            }
        }
    }

    // Method to assign orders to nurses based on their baggages
    private static void assignOrdersToNurses(Patients patient, ArrayList<Medicine> neededMeds, Order order, City city) {
        ArrayList<Nurses> nurses = patient.getCity().getNurseList();
        Nurses leastOccupiedNurse = null;
        int minBaggageSize = Integer.MAX_VALUE;
        boolean serum = false;
        for (Medicine med : neededMeds) {
            if (med instanceof Serum) {
            serum = true;
            break;
            }
        }

        // Find the least occupied scooter
        for (Scooter scooter : city.getScooterList()) {
            if (scooter.getBaggage() == null) {
                // Nurse has no baggage, assign order directly
                if (serum){
                    scooter.receiveOrder(new Order(patient, neededMeds));
                }
                
                return;
            } else if (scooter.getBaggage().size() < minBaggageSize) {
                minBaggageSize = scooter.getBaggage().size();
                leastOccupiedNurse = scooter;
            }
        }

        // Assign order to the least occupied nurse
        /*if (leastOccupiedNurse != null) {
            leastOccupiedNurse.receiveOrder(new Order(patient, neededMeds));
        } else {
            // If all nurses have maximum baggage size, choose any nurse
            city.getScooterList().get(0).receiveOrder(new Order(patient, neededMeds));
        }


        // Find the least occupied scooter
        for (Van van : city.getVanList()) {
            if (van.getBaggage() == null) {
                // Nurse has no baggage, assign order directly
                if (serum){
                    van.receiveOrder(new Order(patient, neededMeds));
                }
                
                return;
            } else if (van.getBaggage().size() < minBaggageSize) {
                minBaggageSize = van.getBaggage().size();
                leastOccupiedNurse = van;
            }
        }

        // Assign order to the least occupied nurse
        if (leastOccupiedNurse != null) {
            leastOccupiedNurse.receiveOrder(new Order(patient, neededMeds));
        } else {
            // If all nurses have maximum baggage size, choose any nurse
            city.getVanList().get(0).receiveOrder(new Order(patient, neededMeds));
        }
    }
    


    // Method to simulate events within the city
    public static void simulateEvents(City city) {
        // Simulate new orders from patients
        Random random = new Random();
        int numNewOrders = random.nextInt(5); // Generate a random number of new orders (0-4)
        for (int i = 0; i < numNewOrders; i++) {
            // Simulate a new order from a patient
            //city.createRandomOrder();
        }

        // Simulate traffic (optional)
        // For simplicity, we won't implement traffic simulation in this example

         */
    }
}

