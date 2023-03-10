package roadrevel.UI.Tourist;

 
import com.jfoenix.controls.JFXButton;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
 
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import roadrevel.resources.Util;

/**
 * FXML Controller class
 *
 * @author Nasr
 */
public class CrudAController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private AnchorPane one;
    
    @FXML
    private JFXButton Login;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Login(ActionEvent event) throws SQLException {
        
            Util.loadWindow(getClass().getResource("/Login/login.fxml"), "Login", null);
            
    }
    
}
