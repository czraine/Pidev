/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package roadrevel.UI.ManagePlaces.ViewPlaces;

import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import roadrevel.entities.PlaceToVisit.PlaceToVisit;

/**
 * FXML Controller class
 *
 * @author Nasr
 */
public class View_SingleController implements Initializable {

    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private JFXTextArea pdesc;
    @FXML
    private Label tp;
    @FXML
    private Label cname;
    @FXML
    private Label padress;
    @FXML
    private Label ptype;
    @FXML
    private Label pname;
    @FXML
    private ImageView img3;
    Image image , image2 , image3 ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void  infalteUI(PlaceToVisit selected) {
                image = new Image (selected.getPlace_img());
        image2 = new Image (selected.getPlace_img2());
        image3 = new Image (selected.getPlace_img3());
        pname.setText(selected.getPlace_name());
        cname.setText(selected.getCityname());
        ptype.setText(selected.getPlace_Type());
        pdesc.setText(selected.getPlace_Description());
        padress.setText(selected.getPlace_Address());
        tp.setText(String.valueOf(selected.getTickets_Price()));
        img1.setImage(image);
        img2.setImage(image2);
        img3.setImage(image3);
    }
    
}
