import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WelcomeQDT extends Application{

    @FXML
    private TextField warningText;

    @FXML
    private Button startButton;
    

    public void start(Stage primaryStage) throws IOException{
       
        warningText.setEditable(false);

        FXMLLoader fxml = new FXMLLoader(WelcomeQDT.class.getResource("WelcomeQDT.fxml"));
        Scene scene = new Scene(fxml.load(),1080,1920);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

