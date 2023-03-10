/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package roadrevel.UI.Tourist;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.util.Random;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;
import roadrevel.UI.Login.LoginController;
import roadrevel.api.Mail;
import roadrevel.entities.SingleUser;
import roadrevel.entities.User.ServiceUser;
import roadrevel.entities.User.User;
import roadrevel.resources.AlertMaker;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class ForgetPasswordController implements Initializable {

    /**
     * Initializes the controller class.
     */
    int code=0;
    @FXML
    private JFXTextField codeText;
    @FXML
    private Text msg;
    @FXML
    private JFXTextField pass;
    @FXML
    private JFXTextField cpass;
    @FXML
    private JFXButton verifierCode;
    @FXML
    private JFXButton NewPasse_btn;
    @FXML
    private StackPane rootPane;
    @FXML
    private AnchorPane mainContainer;



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Random random = new Random();
        code=random.nextInt(89999) + 10000;
        String mailCode=""+code;
        Mail mail=new Mail();
        mail.envoyerCode(mailCode,LoginController.validEmail /*"sarra.bachhamba@esprit.tn"*/);
    }    

    @FXML
    private void VerifierCode(ActionEvent event) {

        if(Integer.parseInt(codeText.getText())==code)
        {
            codeText.setVisible(false);
            verifierCode.setVisible(false);
            msg.setVisible(false);
            
            pass.setVisible(true);
            cpass.setVisible(true);
            NewPasse_btn.setVisible(true);
                          EventHandler<ActionEvent> CPassword = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
        if (verifierCode.getText().isEmpty()){
         AlertMaker.showMaterialDialog(rootPane, mainContainer, new ArrayList<>(), "Insufficient Data", "Please enter The code.");
            return;
        }
               if (pass.getText().isEmpty()) {
            AlertMaker.showMaterialDialog(rootPane, mainContainer, new ArrayList<>(), "Insufficient Data", "Please enter password.");
            return;
        }
        if (cpass.getText().isEmpty()) {
            AlertMaker.showMaterialDialog(rootPane, mainContainer, new ArrayList<>(), "Insufficient Data", "Please re-enter password.");
            return;
        }
        if (!(pass.getText().equalsIgnoreCase(cpass.getText()))) {
            System.out.println(pass + " / " + cpass);
            AlertMaker.showMaterialDialog(rootPane, mainContainer, new ArrayList<>(), "Wrong Data", "Make sure you write the same Password.");
            return;
        }else{
            ServiceUser su = new ServiceUser();
          //  
          SingleUser hold = SingleUser.getInstance();
          User user= hold.getUser();
            String Pass=BCrypt.hashpw(pass.getText(), BCrypt.gensalt());
            System.out.println(LoginController.validEmail);
            System.out.println(pass.getText());
            
            su.modify(Pass , user.getId_User());
            closeStage();
        }

            }
        };
        
        NewPasse_btn.setOnAction(CPassword);
        
        }
        else
            System.out.println(" try  again " );
    }
  private void closeStage() {
        ((Stage) pass.getScene().getWindow()).close();
    }
    
}