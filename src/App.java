import med.*;
import DiagnosisTest.*;
import DiagnosisTest.Menu;
import javax.swing.*;
import java.awt.event.*;
import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Platform;



public class App extends Application {

    //buttons
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

    //TODO pop up will be opened and show recomendation
    @FXML
    private Button QDTNextButton2;

    @FXML
    private Button pillsButton;

    @FXML
    private Button purchaseButton;

    double totalCost;
    int totalProduct;
    ArrayList<Medicine> purchaseList = new ArrayList<Medicine>();

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

        QDTNextButton2.setOnAction(e -> {
            JFrame menuFrame = new Menu();
            menuFrame.setTitle("Pills on Wheels");
            menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            menuFrame.setVisible(true);
            // You can add Swing components to frame here
            
            // Create a SwingNode to embed the JFrame into JavaFX
            SwingNode swingNode = new SwingNode();
            swingNode.setContent((JComponent) menuFrame.getContentPane());
            
            // Create a JavaFX pane to hold the SwingNode
            StackPane javaFxPane = new StackPane(swingNode);
            
            // Create a new stage for the pop-up
            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setTitle("Popup");
            
            // Set the scene with the JavaFX pane
            popupStage.setScene(new Scene(javaFxPane, 400, 300));
            
            // Show the pop-up
            popupStage.show();
            
            // Set the size of the frame
            menuFrame.setSize(300, 200);
            // Make the frame visible
            menuFrame.setVisible(true);
        });

        pillsButton.setOnAction(e -> {
            primaryStage.setScene(pillsPage);
        });

        purchaseButton.setOnAction(e -> {
            openPurchasePopup();
            totalCost = 0;
            totalProduct = 0;
        });

        primaryStage.show();
    }

    private void openPurchasePopup() {
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL); // Modal dialog olarak ayarlanır, arka plana tıklanamaz.
        popupStage.setTitle("Purchase");

        GridPane popupLayout = new GridPane();
        popupLayout.setPadding(new Insets(10));
        popupLayout.setVgap(10);
        popupLayout.setHgap(10);
        //TODO Alışveriş içeriğini göstercek şekilde düzenle

        // Add headers
        popupLayout.add(new Label("Medication"), 0, 0);
        popupLayout.add(new Label("Quantity"), 1, 0);
        popupLayout.add(new Label("Price"), 2, 0);

        // Add purchase details
        for (int i = 0; i < purchaseList.size(); i++) {
            popupLayout.add(new Label(purchaseList.get(i).getName()), 0, i + 1);
            popupLayout.add(new Label(String.valueOf(purchaseList.get(i).getPurchaseCount())), 1, i + 1);
            double itemTotalPrice = purchaseList.get(i).getPurchaseCount() * purchaseList.get(i).getPrice();
            popupLayout.add(new Label(String.format("$%.2f", itemTotalPrice)), 2, i + 1);
            
        }

        for (int i = 0; i < purchaseList.size(); i++) {
            totalProduct += purchaseList.get(i).getPurchaseCount();
            totalCost += purchaseList.get(i).getPurchaseCount() * purchaseList.get(i).getPrice();
        }

        // Add total
        Label totalLabel = new Label("Total:");
        totalLabel.setStyle("-fx-font-weight: bold;");
        popupLayout.add(totalLabel, 1, purchaseList.size() + 1);
        popupLayout.add(new Label(String.format("$%.2f", totalCost)), 2, purchaseList.size() + 1);

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> popupStage.close());

        popupLayout.add(closeButton, 2, purchaseList.size() + 2);

        Scene popupScene = new Scene(popupLayout, 400, 300);
        popupStage.setScene(popupScene);
        popupStage.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}