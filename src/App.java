import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {
    @FXML
    private Button loginButton;

    @FXML
    private Button signInButton;

    @FXML
    private Button signInButton2;

    @FXML
    private Button signInButton3;

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
    private Scene logInPage, signInOccupationPage, signInPage, homePage, pillsPage, personalInfoPage, ordersPage, currentOrdersPage,
    quickDiagnosisPage, yesNoQuestPage, symptomsPage, homePageForOthers, personalInfoPageForOthers, deliveriesPage, currentDeliveryPage; 
    

    public void start(Stage primaryStage) throws IOException{

        FXMLLoader fxmlLogIn = new FXMLLoader(App.class.getResource("Merhaba.fxml"));
        logInPage = new Scene(fxmlLogIn.load(),1080,720);
        primaryStage.setScene(logInPage);
        

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

        //sign in
        signInButton.setOnAction(e -> {
            primaryStage.setScene(signInOccupationPage);
        }); 

        signInButton2.setOnAction(e -> {
            primaryStage.setScene(signInPage);
        }); 

        //enter home page
        loginButton.setOnAction(e -> {
            primaryStage.setScene(homePage);
        }); 

        signInButton3.setOnAction(e -> {
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