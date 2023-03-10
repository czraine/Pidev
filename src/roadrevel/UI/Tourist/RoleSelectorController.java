package roadrevel.UI.Tourist;

 
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import roadrevel.resources.Util;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class RoleSelectorController implements Initializable {

    @FXML
    private Button tourist;
    @FXML
    private Button guide;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void tourist(ActionEvent event) 
    {                 Util.loadWindow(getClass().getResource("/roadrevel/UI/Tourist/AddTourist/Add.fxml"), "Add New Place", null);

    }

    @FXML
    private void guide(ActionEvent event) {
        Util.loadWindow(getClass().getResource("/roadrevel/UI/Guide/AddGuide/Add.fxml"), "Add New Place", null);
    }
    
}
