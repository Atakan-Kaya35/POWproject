import med.*;
import DiagnosisTest.*;
import DiagnosisTest.Menu;
import entity.mobile.physcian.Nurses;
import entity.mobile.physcian.Van;
import entity.mobile.physcian.Scooter;
import entity.stationary.*;
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

public class App extends Application {
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
            if(selected.equals("Customer")){
                Patients customer = new Patients();
            }
            else if(selected.equals("Nurse")){
                Nurses nurse = new Nurses();
            }
            else if(selected.equals("Scooter")){
                Scooter scooter = new Scooter();
            }
            else if(selected.equals("Van")){
                Van van = new Van();
            }

            signUPButton2.setOnAction(ee -> {
                primaryStage.setScene(signInPage);

                User.setUserName(userNameLSignUpTextField.getText());
                User.setPassword(passwordSignUpTextField.getText());
                User.setName(nameLogInTextField.getText());
                User.setAge(ageSignUpTextField.getText());
                User.setAge(ageSignUpTextField.getText());
                User.setWeight(weightSignUpTextField.getText());
                User.setHeight(heightSignUpTextField.getText());
                User.setHeight(addressSignUpTextField.getText());

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