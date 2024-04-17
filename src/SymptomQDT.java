import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SymptomQDT extends Application{

    @FXML
    private Button nextButton;

    public void start(Stage primaryStage) throws IOException{
       
        FXMLLoader fxml = new FXMLLoader(SymptomQDT.class.getResource("SymptomQDT.fxml"));
        Scene scene = new Scene(fxml.load(),1080,720);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
