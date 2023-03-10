package roadrevel.UI.Tourist;

 
import com.jfoenix.controls.JFXButton;
 
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import roadrevel.resources.Util;

/**
 * FXML Controller class
 *
 * @author user
 */
public class InterfaceGuideController implements Initializable {

    @FXML
    private JFXButton btn_workbench211;
    @FXML
    private AnchorPane sideBar;
    @FXML
    private JFXButton btn_workbench212;
    @FXML
    private JFXButton btn_workbench22;
    @FXML
    private JFXButton btn_workbench112;
    @FXML
    private JFXButton btn_workbench1112;
    @FXML
    private JFXButton btn_workbench11112;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Profile(ActionEvent event) {
             Util.loadWindow(getClass().getResource("/cruduser/Tourist/automa.fxml"), "Add New Place", null);

    }
    
}
