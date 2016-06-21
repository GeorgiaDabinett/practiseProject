import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Write a description of class Application here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Application
{
    // instance variables - replace the example below with your own
    public static DatabaseConnection database;

    public static void main(String args[])
    {       
        /* JavaFX apps run in a different processing thread to the main method so that they keep running
         * after the main method has completed. The 'start' method is invoked when this thread starts. */
        JFXPanel panel = new JFXPanel();        
        Platform.runLater(() -> start());               
    }

    private static void start() 
    {
        try
        {         
            //database = new DatabaseConnection("Test.db");        // Initiate the database connection.

            /* Load the first fxml file that will create our first JavaFX scene. */
            FXMLLoader loader = new FXMLLoader(Application.class.getResource("mainview.fxml"));

            /* Each scene requires a Window, called a stage. The following creates and displays the stage. */
            Stage stage = new Stage();
            stage.setTitle("Main");
            stage.setScene(new Scene(loader.load()));
            stage.show();           

            /* Loading the scene will have resulted in the creation of a scene controller. In order for this
             * controller to have direct access to the stage its scene is displayed, the stage is passed to the 
             * controller's prepareStage method. */
            mainSceneController controller = loader.getController();
            controller.prepareStageEvents(stage);
        }
        catch (Exception ex)    // If anything goes wrong starting the application then call the terminate method.
        {
            System.out.println(ex.getMessage());
            terminate();
        }
    }

    /* The following method can be called from any controller class and will terminate the application. */
    public static void terminate()
    {
        System.out.println("Closing database connection and terminating application...");                                

        if (database != null) database.disconnect();    // Close the connection to the database (if it exists!)
        System.exit(0);                                 // Finally, terminate the entire application.
    }
}
