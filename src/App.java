import med.*;
import DiagnosisTest.*;
import DiagnosisTest.Menu;
import entity.mobile.physcian.Nurses;
import entity.mobile.physcian.Van;
import entity.mobile.physcian.Scooter;
import entity.stationary.*;
import entity.*;
import javax.swing.*;
import java.awt.event.*;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.*;

public class App extends Application {

    @FXML
    private Label nameLabel;

    @FXML
    private Button loginButton;

    @FXML
    private Button signUpButton;

    @FXML
    private Button signUPButton2;

    @FXML
    private Button signUPButton3;

    @FXML
    private Button homePageButton;

    @FXML
    private Button personalInformationButton;

    @FXML
    private Button quickDiagnosisTestButton;

    @FXML
    private Button QDTStartButton;

    @FXML
    private Button QDTNextButton;

    //pop up will be opened and show recomendation
    @FXML
    private Button QDTNextButton2;

    @FXML
    private Button pillsButton;

    private Stage primaryStage;
    @FXML
    private Button purchaseButton;

    @FXML
    private TextField userNameLSignUpTextField;

    @FXML
    private TextField passwordSignUpTextField;

    @FXML
    private TextField nameLogInTextField;

    @FXML
    private TextField userNameLogInTextField;

    @FXML
    private TextField ageSignUpTextField;

    @FXML
    private TextField weightSignUpTextField;

    @FXML
    private TextField heightSignUpTextField;

    @FXML
    private TextField addressSignUpTextField;

    @FXML
    ComboBox<String> comboBox = new ComboBox<>();

    double totalCost;
    int totalProduct;
    ArrayList<Medicine> purchaseList = new ArrayList<Medicine>();

    private Scene logInPage, signInOccupationPage, signInPage, homePage, pillsPage, personalInfoPage, ordersPage, currentOrdersPage,
    quickDiagnosisPage, yesNoQuestPage, symptomsPage, homePageForOthers, personalInfoPageForOthers, deliveriesPage, currentDeliveryPage; 
    

    public void start(Stage primaryStage) throws IOException{

        nameLabel.setText("tarçın");

        FXMLLoader fxmlLogIn = new FXMLLoader(App.class.getResource("Merhaba.fxml"));
        logInPage = new Scene(fxmlLogIn.load(),1080,720);
        primaryStage.setScene(logInPage);
        
        comboBox.getItems().addAll("Customer", "Nurse", "Scooter", "Van");

        FXMLLoader fxmlHome = new FXMLLoader(App.class.getResource("HomePage.fxml"));
        homePage = new Scene(fxmlHome.load(),1080,720);

        FXMLLoader fxmlPersInfo = new FXMLLoader(App.class.getResource("PersonalInfoPage.fxml"));
        personalInfoPage = new Scene(fxmlPersInfo.load(),1080,720);

        FXMLLoader fxmlQuickDiag = new FXMLLoader(App.class.getResource("WelcomeQDT.fxml"));
        quickDiagnosisPage = new Scene(fxmlQuickDiag.load(),1080,720);

        FXMLLoader fxmlSymptoms = new FXMLLoader(App.class.getResource("SymptomQDT.fxml"));
        symptomsPage = new Scene(fxmlSymptoms.load(),1080,720);

        FXMLLoader fxmlYesNo = new FXMLLoader(App.class.getResource("YesNoQuestQDT.fxml"));
        yesNoQuestPage = new Scene(fxmlYesNo.load(),1080,720);

        FXMLLoader fxmlPills = new FXMLLoader(App.class.getResource("PillsPage.fxml"));
        pillsPage = new Scene(fxmlPills.load(),1080,720);

        //sign up
        signUpButton.setOnAction(e -> {
            primaryStage.setScene(signInOccupationPage);
            String selected = comboBox.getSelectionModel().getSelectedItem();
            User user; 
            if(selected.equals("Customer")){
                user = new Patients();
            }
            else if(selected.equals("Nurse")){
                user = new Nurses();
            }
            else if(selected.equals("Scooter")){
                user = new Scooter();
            }
            else{
                user = new Van();
            }

            signUPButton2.setOnAction(ee -> {
                primaryStage.setScene(signInPage);

                user.setUserName(userNameLSignUpTextField.getText());
                user.setPassword(passwordSignUpTextField.getText());
                user.setName(nameLogInTextField.getText());
                user.setAge(Integer.parseInt(ageSignUpTextField.getText()));
                user.setAge(Integer.parseInt(ageSignUpTextField.getText()));
                user.setWeight(Integer.parseInt(weightSignUpTextField.getText()));
                user.setHeight(Integer.parseInt(heightSignUpTextField.getText()));
                user.setHeight(Integer.parseInt(addressSignUpTextField.getText()));

                //enter home page
                loginButton.setOnAction(eee -> {
                    primaryStage.setScene(homePage);
                }); 
            }); 
        });

        //enter home page
        loginButton.setOnAction(e -> {
            primaryStage.setScene(homePage);
        }); 

        signUPButton3.setOnAction(e -> {
            primaryStage.setScene(homePage);
        }); 

        homePageButton.setOnAction(e -> {
            primaryStage.setScene(homePage);
        }); 

        personalInformationButton.setOnAction(e -> {
            primaryStage.setScene(personalInfoPage);
        }); 

        //quick diagnosis test
        quickDiagnosisTestButton.setOnAction(e -> {
            primaryStage.setScene(quickDiagnosisPage);
        }); 

        QDTStartButton.setOnAction(e -> {
            primaryStage.setScene(symptomsPage);
        });

        QDTNextButton.setOnAction(e -> {
            primaryStage.setScene(yesNoQuestPage);
        });

        pillsButton.setOnAction(e -> {
            primaryStage.setScene(pillsPage);
        });

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}