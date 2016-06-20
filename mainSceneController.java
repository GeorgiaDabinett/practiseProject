import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import java.util.List;

public class mainSceneController
{
    // instance variables - replace the example below with your own
    @FXML   private Button removeButton;
    @FXML   private Button editButton;
    @FXML   private Button exitButton;
    @FXML   private Button addButtonw;
    @FXML   private Button searchButton;
    @FXML   private TableView everythingTable;
    /**
     * Constructor for objects of class mainSceneController
     */
    public mainSceneController()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
