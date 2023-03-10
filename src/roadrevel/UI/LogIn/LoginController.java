package roadrevel.UI.Login;

 

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField; 
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.taskrouter.v1.workspace.Task;
import com.twilio.type.PhoneNumber;
import cruduser.util.SessionManager;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.mindrot.jbcrypt.BCrypt;
import roadrevel.entities.SingleUser;
import roadrevel.entities.User.ServiceUser;
import roadrevel.entities.User.User;
import roadrevel.resources.AlertMaker;
import roadrevel.resources.Util;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class LoginController implements Initializable {

    @FXML
    private JFXButton signUp;
    @FXML
    private JFXTextField user_name;
    @FXML
    private JFXPasswordField user_pass;
    @FXML
    private Text error_password;
    @FXML
    private Button forg_btn;
    @FXML
    private JFXButton login_btn;
 public static String validEmail;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

}    

    @FXML
    private void login(ActionEvent event) throws SQLException {
       String login = user_name.getText();
       String pass = user_pass.getText();
          ServiceUser su = new ServiceUser();
          User ui = su.existe(login) ;
          SingleUser hold = SingleUser.getInstance();
                hold.setUser(ui);
            if(login.equals("Admin") && pass.equals("Admin"))
           {

                Util.loadWindow(getClass().getResource("/roadrevel/UI/Admin/MainPage.FXML"), "Admin Interface", null);  
                closeStage();
           }    
           else
            {
    
 User user =su.existe(login);
        boolean flag = su.validate(login);
                if (!flag) {
showAlert(Alert.AlertType.ERROR, ((Stage) user_name.getScene().getWindow()), "Form Error!",
                "UserName doesn't exist ");

        } else {


                System.out.println(user.getPassword());
       boolean etat=BCrypt.checkpw(pass,user.getPassword());
       System.out.println("pass hash =" +etat);
       
        if (login.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, ((Stage) user_name.getScene().getWindow()), "Form Error!",
                "Please enter your UserName");
            return;
        }
        if (pass.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, ((Stage) user_name.getScene().getWindow()), "Form Error!",
                "Please enter a password");
            return;
        } 
        

 
                
        if(user==null)
       {
           error_password.setText("Account Not Found");
       }
       else if(etat==true)
       {
                    // String sendList[] = jTextFieldTo.getText().split(",");
           List<User> touristList=su.findTourist();
            for(User u:touristList)
            {
            System.out.println("id : "+u.getId_User()) ;
                List<User> guideList=su.findGuides(u.getCityname1(),u.getDateBegin(),u.getDateEnd());
                if(!guideList.isEmpty())
                {
                    System.out.println("id : "+u.getId_User()+" id : "+guideList.get(0).getId_User() );
                    su.autoMatch(u.getId_User(),guideList.get(0).getId_User());
                    
                    /*  Twilio.init("ACe22bde01d21a2d70d5939186bda43e99","6df7d9bddedf00e609a31d18dd70cde1");
                    Message message =   Message.creator(new PhoneNumber("+21694133229"),
                    new PhoneNumber("+15675571680"), "\n The Guide accorded to u is "+guideList.get(0).getUser_FirstName()+" "+guideList.get(0).getUser_LastName()+ "\n 📞"+guideList.get(0).getUser_phone()+"").create();
                */
                }
           } 
            SessionManager.setId(user.getId_User());
            SessionManager.setEmail(user.getUser_mail());
            SessionManager.setRole(user.getRole());
            SessionManager.setTel(user.getUser_phone());
           
           if(user.getRole().equals("Tourist"))
           {
               System.out.println(etat);
                Util.loadWindow(getClass().getResource("/roadrevel/UI/Tourist/MainPage.fxml"), "Tourist Interface", null);
                closeStage();
           }
           else
           {
            Util.loadWindow(getClass().getResource("/roadrevel/UI/Guide/MainPage.fxml"), "Guide Interface", null);  
           closeStage();
           }
     
       }
            }
    }
    }

    @FXML
    private void signUp(ActionEvent event) {
        Util.loadWindow(getClass().getResource("/roadrevel/UI/Tourist/RoleSelector.fxml"), "Code Mail", null);
    }


 
       private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

   
    @FXML
    private void Email_forget_Code(ActionEvent event) {
          ServiceUser su = new ServiceUser();
          String UserName = user_name.getText();
      User ui = su.existe(UserName) ;
                  validEmail = ui.getUser_mail();
            System.out.println(validEmail);
            SingleUser hold = SingleUser.getInstance();
                hold.setUser(ui);
         if (UserName.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, ((Stage) user_name.getScene().getWindow()), "Form Error!",
                "Please enter your UserName");
            return;
        }else if( ui !=null)
        {

            Util.loadWindow(getClass().getResource("/roadrevel/UI/Tourist/ForgetPassword.fxml"), "Code Mail", null);
        }    
         else
        {showAlert(Alert.AlertType.ERROR, ((Stage) user_name.getScene().getWindow()), "Form Error!",
                "Account does not exist");
         return;
        }
    }

    @FXML
    private void handleCancelButtonAction(ActionEvent event) {
                closeStage();
        Util.loadWindow(getClass().getResource("/roadrevel/UI/Main/MainPage.fxml"), "Return back to main", null);
    }
   private void closeStage() {
        ((Stage) user_name.getScene().getWindow()).close();
    }

}
