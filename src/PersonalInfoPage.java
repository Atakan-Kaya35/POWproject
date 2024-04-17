import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PersonalInfoPage extends Application{

    Person person;

    @FXML
    protected TextField nameTextField;

    @FXML
    protected TextField agetTextField;

    @FXML
    protected TextField weightTextField;

    @FXML
    protected TextField heighttTextField;

    @FXML
    protected TextField addresstTextField;

    @FXML
    protected TextField iDtTextField;

    public void start(Stage primaryStage) throws IOException{
       
        FXMLLoader fxml = new FXMLLoader(PersonalInfoPage.class.getResource("PersonalInfoPage.fxml"));
        Scene scene = new Scene(fxml.load(),1080,720);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}