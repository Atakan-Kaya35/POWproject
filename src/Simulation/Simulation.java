package Simulation;

import java.time.LocalTime;
import java.util.Random;

import entity.stationary.Patients;
import grid.City;

public class Simulation extends SimMethods {
    
    public static void main(String[] args) {
        
        // Initialize the city with desired parameters
        City city = createCity();

        /*sign upa tıklanırsa
        boolean signedUp = false;
        while (!signedup) {
            signedUp = signUp(name, x, y, ankara, username, password);
                //kordinatları önce default bir şey yapıp sonra kendimiz atarız. kullanıcı sign upta kordinat veremez çünkü.
                //diğer bilgiler sign up ekranından çekilecek.patient classını editleyip age, height vb constructora eklicem.
            if (!signedUp) {
                System.out.println("Sign up unsuccessful. Try again.")
                // boş sign up ekranı yüklenmeli burada tekrar.
            } else {
                System.out.println("Welcome to Pills on Wheels!")
                // bu yazı da UI işi
            }
        }
        logine tıklanırsa:
        boolean login = false;
        while (!login)
            login(username, password);
            if (!login) {
                System.out.println("Login unsuccessful. Try again.")
                // boş login ekranı yüklenmeli
            } else {
                System.out.println("Login successfull!")
                // UI
            }
         */

        buildCity(city);


        boolean running = true;
        int tick = 0; // Track the current tick

        // Duration of a tick in minutes
        final int TICK_DURATION_MINUTES = 5;
        final int REFRESH_CONSTANT = 3; //kaç iteration'da bir komut çalışsın

        // Start time for the simulation
        final LocalTime START_TIME = LocalTime.of(0, 0);
        
        while (running) {

            for (Patients patient : city.getPatientList()) {
                getRandomSickness(patient);
                createOrdersForPatients(patient, city);
            }

            // Perform actions within the simulation
            if (tick % (TICK_DURATION_MINUTES * REFRESH_CONSTANT / TICK_DURATION_MINUTES) == 0) {   // 


                
            


            }

            // Advance the time by one tick
            tick++;

            // Pause execution to simulate the duration of a tick
            try {
                Thread.sleep(TICK_DURATION_MINUTES * 1000); // constant saniye boyunca uyuyor. real time simüle ediliyor.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Check the progress of activities
            //checkActivityProgress();
        }
    }
}