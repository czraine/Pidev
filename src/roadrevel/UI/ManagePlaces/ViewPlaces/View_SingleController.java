/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package roadrevel.UI.ManagePlaces.ViewPlaces;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import roadrevel.entities.PlaceToVisit.PlaceToVisit;
import roadrevel.entities.SinglePlace;
import roadrevel.resources.Util;

/**
 * FXML Controller class
 *
 * @author Nasr
 */
public class View_SingleController implements Initializable {

    Image image, image2, image3;
    @FXML
    private ImageView placeimg;
    @FXML
    private ImageView placeimg2;
    @FXML
    private ImageView placeimg3;
    @FXML
    private Label Cityname;
    @FXML
    private Label placeadres;
    @FXML
    private Label TicketP;
    @FXML
    private Label PlaceName;
    @FXML
    private JFXButton Rate;
    @FXML
    private JFXButton Review;
    @FXML
    private Label placetype;
    @FXML
    private JFXTextArea placedescrp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void infalteUI(PlaceToVisit selected) {
        image = new Image(selected.getPlace_img());
        image2 = new Image(selected.getPlace_img2());
        image3 = new Image(selected.getPlace_img3());
        PlaceName.setText(selected.getPlace_name());
        Cityname.setText(selected.getCityname());
        placetype.setText(selected.getPlace_Type());
        placedescrp.setText(selected.getPlace_Description());
        placeadres.setText(selected.getPlace_Address());
        TicketP.setText(String.valueOf(selected.getTickets_Price()) + " TND");
        placeimg.setImage(image);
        placeimg2.setImage(image2);
        placeimg3.setImage(image3);
        EventHandler<ActionEvent> Grate = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                SinglePlace holder = SinglePlace.getInstance();
                holder.setPlace(selected);
                Util.loadWindow(getClass().getResource("/roadrevel/UI/ManagePlaces/AddReviews/Add_Reviews.fxml"), "Add New Place", null);

            }
        };
        EventHandler<ActionEvent> SReviws = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                SinglePlace holder = SinglePlace.getInstance();
                holder.setPlace(selected);
                Util.loadWindow(getClass().getResource("/roadrevel/UI/ManagePlaces/SeeAllReviews/SeeReviews.fxml"), "Add New Place", null);

            }
        };
        Rate.setOnAction(Grate);
        Review.setOnAction(SReviws);
    }

    @FXML
    private void loadRatePage(ActionEvent event) {
    }

}
