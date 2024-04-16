import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SignInPage extends Application{
    public void start(Stage primaryStage) throws IOException{
       
        FXMLLoader fxml = new FXMLLoader(PillsPage.class.getResource("SıgnInPage.fxml"));
        Scene scene = new Scene(fxml.load(),1080,1920);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

