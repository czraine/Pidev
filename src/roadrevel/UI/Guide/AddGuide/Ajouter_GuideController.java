/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package roadrevel.UI.Guide.AddGuide;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import roadrevel.entities.Guide.Guide;
import roadrevel.entities.Guide.ServiceGuide;


/**
 * FXML Controller class
 *
 * @author user
 */
public class Ajouter_GuideController implements Initializable {

    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField email;
    @FXML
    private TextField username;
    @FXML
    private TextField lang1;
    @FXML
    private TextField lang2;
    @FXML
    private TextField lang3;
    @FXML
    private TextField cityname;
    @FXML
    private TextField password;
    @FXML
    private TextField phone;
    
    ServiceGuide sg= new ServiceGuide();
    Boolean isInEditMode=Boolean.FALSE;
     String Role="Guide";
     int idGuide ;
    @FXML
    private Button cancel;
    @FXML
    private Button Addbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
  

    private void cancel(ActionEvent event) {
                getStage().close();
    }

    private void add_guide(ActionEvent event) {
        String Fname= firstname.getText();
         String Lname= lastname.getText();
          String Uname= username.getText();
          String mail= email.getText();
           String Pass= password.getText();
            int Tpho= Integer.parseInt(phone.getText());
             String Langue1= lang1.getText();
             String Langue2= lang2.getText();
             String Langue3= lang3.getText();
             String Cityname= cityname.getText();
             
if ( Fname.isEmpty() || Lname.isEmpty() || Uname.isEmpty() || mail.isEmpty() || Pass.isEmpty()|| Langue1.isEmpty() || Langue2.isEmpty() || Langue3.isEmpty() || Cityname.isEmpty()  ){
        JOptionPane.showMessageDialog(null, " please fill the Blank ");
return ;

}
         if (isInEditMode) {
            handleEditOperation();
            return;
        }    
        Guide pv = new Guide(Fname,Lname,Uname,mail,Pass,Role,Tpho,Langue1,Langue2,Langue3,Cityname) ; 
         sg.ajouter(pv);

    }

   public Stage getStage() {
        return (Stage) firstname.getScene().getWindow();
    }

    public void handleEditOperation() {
        Guide place = new Guide(idGuide ,firstname.getText(), lastname.getText(), username.getText(), email.getText(), password.getText(),Integer.parseInt(phone.getText()), lang1.getText(), lang2.getText(),lang3.getText(),cityname.getText());
        sg.modifier(place) ;
JOptionPane.showMessageDialog(null, " please fill the Blank ");        
    }

    public void infalteUI(Guide place) {
        firstname.setText(place.getFname());
        lastname.setText(place.getLname());
        username.setText(place.getUserName());
        email.setText(place.getUemail());
        password.setText(place.getPassword());
        phone.setText(String.valueOf(place.getUphone()));
        lang1.setText(place.getLang1()) ;
         lang2.setText(place.getLang2()) ;
          lang3.setText(place.getLang3()) ;
          cityname.setText(place.getCityname()) ;
          idGuide = place.getUser_Id();

       isInEditMode = Boolean.TRUE;    }

    @FXML
    private void LoadCancel(ActionEvent event) {
        getStage().close();
    }

    @FXML
    private void LoadAdd(ActionEvent event) {
                String Fname= firstname.getText();
         String Lname= lastname.getText();
          String Uname= username.getText();
          String mail= email.getText();
           String Pass= password.getText();
            int Tpho= Integer.parseInt(phone.getText());
             String Langue1= lang1.getText();
             String Langue2= lang2.getText();
             String Langue3= lang3.getText();
             String Cityname= cityname.getText();
             
if ( Fname.isEmpty() || Lname.isEmpty() || Uname.isEmpty() || mail.isEmpty() || Pass.isEmpty()|| Langue1.isEmpty() || Langue2.isEmpty() || Langue3.isEmpty() || Cityname.isEmpty()  ){
        JOptionPane.showMessageDialog(null, " please fill the Blank ");
return ;

}
         if (isInEditMode) {
            handleEditOperation();
            return;
        }    
        Guide pv = new Guide(Fname,Lname,Uname,mail,Pass,Role,Tpho,Langue1,Langue2,Langue3,Cityname) ; 
         sg.ajouter(pv);
    }
}

             
          
        
    
    

