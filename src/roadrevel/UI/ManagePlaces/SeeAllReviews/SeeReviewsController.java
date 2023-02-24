/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package roadrevel.UI.ManagePlaces.SeeAllReviews;

import roadrevel.UI.ManagePlaces.SeeReviews.*;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.controlsfx.control.Rating;
import roadrevel.entities.PlaceToVisit.PlaceToVisit;
import roadrevel.entities.PlaceToVisit.Reviews.Reviews;
import roadrevel.entities.PlaceToVisit.Reviews.ServiceReviews;
import roadrevel.entities.SinglePlace;
import roadrevel.entities.SingleUser;
import roadrevel.entities.User.User;


/**
 * FXML Controller class
 *
 * @author Nasr
 */
public class SeeReviewsController implements Initializable {

    @FXML
    private JFXListView<Rating> ReviewRate;
    @FXML
    private JFXListView<Label> Review_txt;
    ServiceReviews sp = new ServiceReviews();
    @FXML
    private Label Place_Name;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         SinglePlace holder = SinglePlace.getInstance();
          PlaceToVisit p = holder.getPlace();
          SingleUser hold = SingleUser.getInstance();
          User u = hold.getUser();
          Place_Name.setMaxWidth(200) ;
        List<Reviews> list = sp.showByPlace(p.getPlace_Id()) ;
        for( Reviews pv : list ){
            Place_Name.setText(pv.getPlace_Name());
            Rating rate = new Rating(5, (int) pv.getRating());
            rate.setDisable(true);
            Label lbl = new Label(pv.getReview_txt());
            ReviewRate.getItems().add(rate) ;
            Review_txt.getItems().add(lbl);
    
    
    }
    
    }    
    
}
