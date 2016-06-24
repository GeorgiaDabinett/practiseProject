import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
/**
 * Write a description of class secondSceneController here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class secondSceneController
{
    private static Stage stage;     
        @FXML private RadioButton veggieRButton;
        @FXML private TextField toppingsText;
        @FXML private TextField baseText;
        @FXML private TextField nameText;
        @FXML private Label titleLabel;
        
    @FXML   void initialize()           // The method automatically called by JavaFX after the constructor.
    {            
        /* The following assertions check to see if the JavaFX controls exists. If one of these fails, the
         * application won't work. If the control names in Scene Builder don't match the variables this fails. */ 
        
         System.out.println("Asserting controls...");
        try
        {
            assert veggieRButton != null : "Can't find vegetarian radio button.";
            assert toppingsText != null : "Can't find toppings text field.";
            assert baseText != null : "Can't find base text field.";
            assert nameText != null : "Can't find name field text.";
            assert titleLabel != null: "Can't find title label.";
            
        }
        catch (AssertionError ae)
        {
            System.out.println("FXML assertion failure: " + ae.getMessage());
            Application.terminate();
        }

        /* Next, we load the list of fruit from the database and populate the listView. */
                         // Hand over control to the fruit model to populate this list.
    }
}
