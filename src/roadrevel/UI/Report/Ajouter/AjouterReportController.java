/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package roadrevel.UI.Report.Ajouter;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
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
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import static javafx.util.Duration.millis;
import javafx.util.StringConverter;
import roadrevel.entities.Reports.Reports;
import roadrevel.entities.Reports.ServiceReports;
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
    public DatePicker incidentDate = new DatePicker();
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
    private void LoadSignIn(ActionEvent event) {
long millis=System.currentTimeMillis(); 
        int tp;
java.sql.Date incidentDate = new java.sql.Date(millis); 
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
            //handleEditOperation();
            return;
        }else {
            System.out.println("Connexion réussie!");
                 String recipient = "morched.ammar@esprit.tn";
                 try {
                 roadrevel.database.Mail.envoyer(recipient);
                 System.out.println("Le message a été envoyé avec succès.");
                 } catch (Exception e) {
                 System.err.println("Erreur lors de l'envoi du message : " + e.getMessage());
                 e.printStackTrace();
        }
        }
        Reports pv = new Reports(pn, cn, pt, pd, incidentDate, Cfrom);
        sp.ajouter(pv);

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
        Reports r = new Reports(Report_id, Subject.getText(), Involvment.getText(), Location.getText(),incidentDate, repType.getValue(), Id_User);
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

   

    @FXML
    private void DatePicker(ActionEvent event) {
        
             incidentDate.setConverter(new StringConverter<LocalDate>() {
     String pattern = "yyyy-MM-dd";
     DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

     {
         incidentDate.setPromptText(pattern.toLowerCase());
     }

     @Override public String toString(LocalDate date) {
         if (date != null) {
             return dateFormatter.format(date);
         } else {
             return "";
         }
     }

     @Override public LocalDate fromString(String string) {
         if (string != null && !string.isEmpty()) {
             return LocalDate.parse(string, dateFormatter);
         } else {
             return null;
         }
     }
 });
    }

    

}
