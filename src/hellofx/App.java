package hellofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("hellofx.fxml"));
        
        Scene scene = new Scene(root, 600, 300);
        scene.getStylesheets().add("hellofx/styles.css");
        primaryStage.setTitle("Conversor de monedas");
        primaryStage.getIcons().add(new Image("/images/icons/icono-de-conversion.png"));
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}