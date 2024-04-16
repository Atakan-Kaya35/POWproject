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

    public void start(Stage primaryStage) throws IOException{

        //EventListener
        /* loginButton.setOnAction(e -> {
            HomePage.show(primaryStage);
        }); */

        FXMLLoader fxml = new FXMLLoader(App.class.getResource("Merhaba.fxml"));
        Scene scene1 = new Scene(fxml.load(),1080,720);
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}