/**
 * 
 *  @author Ryan Kelley
 *  @version 3/16/17
 */

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Project2Driver extends Application {

    /**
     * Launches the application and starts the whole program.
     *  
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(Project2Driver.class, (java.lang.String[])null);
    }

    
    /**
     * The start method loads the GUI and sets up the basics of the application.
     * 
     *
     */
    
    @Override
    public void start(Stage primaryStage) throws IOException {
    	Pane page = FXMLLoader.load(Project2Driver.class.getResource("SB_Test.fxml"));
        Scene scene = new Scene(page);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator");
        primaryStage.show();

    }
}