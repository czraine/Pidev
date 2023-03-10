package roadrevel.UI.Tourist;

 
import com.jfoenix.controls.JFXButton;
 
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import roadrevel.entities.SingleUser;
import roadrevel.entities.User.User;
import roadrevel.resources.Util;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class InterfaceTouristController implements Initializable {

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
    @FXML
    private JFXButton btn_workbench111111;
 SingleUser hold = SingleUser.getInstance(); 
    User u = hold.getUser();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(u.getUser_mail()) ;
    }    

    @FXML
    private void profile(ActionEvent event) {
         Util.loadWindow(getClass().getResource("/cruduser/Tourist/automa.fxml"), "Add New Place", null);
    }
    
}
