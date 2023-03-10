/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package roadrevel.UI.Report.Ajouter;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import static javafx.util.Duration.millis;
import javafx.util.StringConverter;
import roadrevel.api.Mail;
import roadrevel.api.ReportsMail;
import roadrevel.entities.Reports.Reports;
import roadrevel.entities.Reports.ServiceReports;
import roadrevel.entities.SingleUser;
import roadrevel.entities.User.User;
import roadrevel.resources.AlertMaker;


/**
 * FXML Controller class
 *
 * @author GAMING A15
 */
public class AjouterReportController implements Initializable {

    ServiceReports sp = new ServiceReports();
    private Boolean isInEditMode = Boolean.FALSE;
    int Report_id;
    int Id_User;
    @FXML
    private StackPane rootPane;
    @FXML
    private AnchorPane mainContainer;
    @FXML
    private ChoiceBox<String> repType;
    @FXML
    private JFXTextField Subject;
    @FXML
    private JFXTextField Involvment;
    @FXML
    private JFXTextArea Report_Descrp;
    @FXML
    private JFXTextField Location;
    @FXML
    public DatePicker incidentDate ;
   //private ObservableList list;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = repType.getItems();
        list.add("platform");
        list.add("guide");
        list.add("field");

    }

    @FXML
    private void LoadSignIn(ActionEvent event) throws IOException {
long millis=System.currentTimeMillis(); 
        int tp;
Date date = Date.valueOf(incidentDate.getValue());
        String pn = Subject.getText();
        String cn = Involvment.getText();
        String pt = Report_Descrp.getText();
        String pd = Location.getText();
        String Cfrom = repType.getValue();
        

        
        if (pn.isEmpty()) {
            AlertMaker.showMaterialDialog(rootPane, mainContainer, new ArrayList<>(), "Insufficient Data", "Please enter subject.");
            return;
        }
        if (cn.isEmpty()) {
            AlertMaker.showMaterialDialog(rootPane, mainContainer, new ArrayList<>(), "Insufficient Data", "Please enter Involvment.");
            return;
        }
        
        if (Cfrom.isEmpty()) {
            AlertMaker.showMaterialDialog(rootPane, mainContainer, new ArrayList<>(), "Insufficient Data", "Please select a type.");
            return;
            

        }
        if (pd.isEmpty()) {
            AlertMaker.showMaterialDialog(rootPane, mainContainer, new ArrayList<>(), "Insufficient Data", "Please enter a location.");
            return;
        }
        if (pt.isEmpty()) {
            AlertMaker.showMaterialDialog(rootPane, mainContainer, new ArrayList<>(), "Insufficient Data", "Please enter Report Description.");
            return;
        }

        if (isInEditMode) {
            handleEditOperation();
            return;
        }else {
            System.out.println("Connexion réussie!");
                 String recipient = "morched.ammar@esprit.tn";
                 try {
                 ReportsMail.envoyer(recipient);
                 System.out.println("Le message a été envoyé avec succès.");
                 } catch (Exception e) {
                 System.err.println("Erreur lors de l'envoi du message : " + e.getMessage());
                 e.printStackTrace();
        }
        }
                   SingleUser hold = SingleUser.getInstance();
          User u = hold.getUser();
          if (u == null){
          AlertMaker.showErrorMessage("No User Has Been Found", "Please Login to Rate"); 
           closeStage();
          return;
         
          
          }
        Reports pv = new Reports(pn , pt, cn, Cfrom,date,pd,u.getId_User());
        sp.ajouter(pv);
        Parent root = FXMLLoader.load(getClass().getResource("/roadrevel/UI/Report/List/Report_list.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

   }
            private void closeStage() {
        ((Stage) rootPane.getScene().getWindow()).close();
    }

    public void inflateUI(Reports r) {
        Subject.setText(r.getReport_Subject());
        Involvment.setText(r.getInvolvment());
        Report_Descrp.setText(r.getReport_Description());
        Location.setText(r.getIncident_location());
        repType.getItems();
        Report_id = r.getReport_id();
        Id_User = r.getId_User();
        isInEditMode = Boolean.TRUE;
    }

    private Stage getStage() {
        return (Stage) rootPane.getScene().getWindow();
    }

    @FXML
    private void LoadCancel(ActionEvent event) {
        getStage().close();
    }

    private void handleEditOperation()  {
       // DatePicker();
        Reports r = new Reports(Report_id, Subject.getText(),Report_Descrp.getText(), Involvment.getText(), Location.getText(),Date.valueOf(incidentDate.getValue()), repType.getValue(), Id_User);
        sp.modifier(r);
        AlertMaker.showMaterialDialog(rootPane, mainContainer, new ArrayList<>(), "Success", "Update complete");

    }

    public void infalteUI(Reports r) {
        Subject.setText(r.getReport_Subject());
        Involvment.setText(r.getInvolvment());
        Report_Descrp.setText(r.getReport_Description());
        Location.setText(r.getIncident_location());
        Report_id = r.getReport_id();
        //incidentDate = r.setIncident_date();
        Id_User = r.getId_User();
        isInEditMode = Boolean.TRUE;
    }

   

    

}
