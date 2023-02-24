/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package roadrevel.UI.ManagePlaces.AddPlace;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import static java.lang.Double.parseDouble;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import roadrevel.entities.PlaceToVisit.PlaceToVisit;
import roadrevel.entities.PlaceToVisit.ServicePlace;
import roadrevel.resources.AlertMaker;
import roadrevel.resources.Util;

/**
 * FXML Controller class
 *
 * @author Nasr
 */
public class AddPlaceController implements Initializable {

    @FXML
    private JFXTextField Place_Name;
    @FXML
    private JFXTextField CityName;
    @FXML
    private JFXTextField Place_Type;
    @FXML
    private JFXTextArea Place_Descrp;
    @FXML
    private JFXTextField Place_Adress;
    @FXML
    private JFXTextField Ticket_Price;
    @FXML
    private JFXButton img1;
    @FXML
    private JFXButton img2;
    @FXML
    private JFXButton img3;
    String res , res2 , res3 ;
    @FXML
    private StackPane rootPane;
    @FXML
    private AnchorPane mainContainer;
    ServicePlace sp = new ServicePlace() ;
    private Boolean isInEditMode = Boolean.FALSE;
    int id_place ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void choosefile(ActionEvent event) {
        Util u = new Util();
        res =  u.ImgPicker () ;
        

    }

    @FXML
    private void choosefile2(ActionEvent event) {
        Util u = new Util();
        res2 =  u.ImgPicker () ;
    }

    @FXML
    private void choosefile3(ActionEvent event) {
         Util u = new Util();
        res3 =  u.ImgPicker () ;
    }

    @FXML
    private void LoadSignIn(ActionEvent event) {
        String  pn =  Place_Name.getText() ;
        String cn =  CityName.getText() ;
        String pt =  Place_Type.getText() ;
        String pd =  Place_Descrp.getText() ;
        String pa =  Place_Adress.getText() ;
        Double tp =  parseDouble(Ticket_Price.getText()) ;
        String pi1 =   res ;
        String pi2 =  res2 ;
        String pi3 =  res3 ;
               if (pn.isEmpty() || cn.isEmpty() || pt.isEmpty() || pd.isEmpty() || pa.isEmpty() ) {
            AlertMaker.showMaterialDialog(rootPane, mainContainer, new ArrayList<>(), "Insufficient Data", "Please enter data in all fields.");
            return;
        }
         if (isInEditMode) {
            handleEditOperation();
            return;
        }    
        PlaceToVisit pv = new PlaceToVisit(pn, cn, pt, pd, pa, tp, pi1, pi2, pi3) ; 
         sp.ajouter(pv);

    }
        public void inflateUI(PlaceToVisit place) {
        Place_Name.setText(place.getPlace_name());
        CityName.setText(place.getCityname());
        Place_Type.setText(place.getPlace_Type());
        Place_Descrp.setText(place.getPlace_Description());
        Place_Adress.setText(place.getPlace_Address());
        Ticket_Price.setText(String.valueOf(place.getTickets_Price()));
        id_place = place.getPlace_Id() ;

       isInEditMode = Boolean.TRUE;
    }
   private Stage getStage() {
        return (Stage) rootPane.getScene().getWindow();
    }
    @FXML
    private void LoadCancel(ActionEvent event) {
        getStage().close();
    }
    private void handleEditOperation() {
        PlaceToVisit place = new PlaceToVisit(id_place ,Place_Name.getText(), CityName.getText(), Place_Type.getText(), Place_Descrp.getText(), Place_Adress.getText(),parseDouble(Ticket_Price.getText()), res, res2,res3);
        sp.modifier(place) ;
            AlertMaker.showMaterialDialog(rootPane, mainContainer, new ArrayList<>(), "Success", "Update complete");
        
    }

    public void infalteUI(PlaceToVisit place) {
        Place_Name.setText(place.getPlace_name());
        CityName.setText(place.getCityname());
        Place_Type.setText(place.getPlace_Type());
        Place_Descrp.setText(place.getPlace_Description());
        Place_Adress.setText(place.getPlace_Address());
        Ticket_Price.setText(String.valueOf(place.getTickets_Price()));
        id_place = place.getPlace_Id() ;

       isInEditMode = Boolean.TRUE;  }


    
}
