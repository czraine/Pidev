/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package roadrevel.UI.Events.Reviews.addReview;

import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import roadrevel.entities.EventReview.Review;
import roadrevel.entities.EventReview.ServiceReview;
import roadrevel.entities.Events.Events;
import roadrevel.entities.Events.SingleEvent;
import roadrevel.entities.SingleUser;
import roadrevel.entities.User.User;
import roadrevel.resources.AlertMaker;

/**
 * FXML Controller class
 *
 * @author GAMING A15
 */
public class AddEventReviewController implements Initializable {

    @FXML
    private Button submit;
    @FXML
    private JFXTextArea comment;

    
     String cmnts ;
    ServiceReview sr = new ServiceReview() ;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Submit(ActionEvent event) {
        
        
        SingleEvent holder = SingleEvent.getInstance();
        Events p = holder.getEvent();
        SingleUser hold = SingleUser.getInstance();
        User u = hold.getUser();
        cmnts = comment.getText() ;
        if (u == null){
          AlertMaker.showErrorMessage("No User Has Been Found", "Please Login to Comment"); 
           closeStage();
          return;
        } 
         if (cmnts.isEmpty()) {
            JOptionPane.showMessageDialog(null, " Please add a comment!");
            return;
       }
        System.out.println(p.getEvent_name()+"  "+cmnts+"   "+u.getId_User()+"   "+p.getEvent_id());
        sr.ajouter(new Review (p.getEvent_name(),cmnts,u.getId_User(),p.getEvent_id()));
         AlertMaker.showErrorMessage("success", "your comment has been added"); 
        closeStage();
    }
    
    private void closeStage() {
        ((Stage) submit.getScene().getWindow()).close();
    }
    
}