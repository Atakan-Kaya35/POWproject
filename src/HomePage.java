import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class HomePage extends Application{

    Person user;

    public HomePage(Person user, Parent root, double width, double height){
        //super(root, width, height);
        this.user = user;
    }
    public void start(Stage primaryStage) throws IOException{
       
        FXMLLoader fxml = new FXMLLoader(HomePage.class.getResource("HomePage.fxml"));
        Scene scene = new Scene(fxml.load(),1080,1920);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void show(Stage primaryStage) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'show'");
    }

    public static void main(String[] args) {
        launch(args);
    }
}