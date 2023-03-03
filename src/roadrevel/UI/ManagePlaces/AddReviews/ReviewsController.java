/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package roadrevel.UI.ManagePlaces.AddReviews;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;
import org.json.simple.parser.ParseException;
import roadrevel.api.TextFilter;
import roadrevel.entities.PlaceToVisit.PlaceToVisit;
import roadrevel.entities.PlaceToVisit.Reviews.Reviews;
import roadrevel.entities.PlaceToVisit.Reviews.ServiceReviews;
import roadrevel.entities.SinglePlace;
import roadrevel.entities.SingleUser;
import roadrevel.entities.User.User;
import roadrevel.resources.AlertMaker;

/**
 * FXML Controller class
 *
 * @author Nasr
 */
public class ReviewsController implements Initializable {

    @FXML
    private Rating PlaceRate;
    @FXML
    private JFXTextArea Comments;
    @FXML
    private JFXButton Submit;
    

    Double Rating ;
    String cmnts ;
    ServiceReviews sr = new ServiceReviews() ;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void LoadAddReview(ActionEvent event) throws MalformedURLException, UnsupportedEncodingException, ParseException {
long millis=System.currentTimeMillis(); 
java.sql.Date Review_date = new java.sql.Date(millis); 
          SinglePlace holder = SinglePlace.getInstance();
          PlaceToVisit p = holder.getPlace();
           SingleUser hold = SingleUser.getInstance();
          User u = hold.getUser();
          if (u == null){
          AlertMaker.showErrorMessage("No User Has Been Found", "Please Login to Rate"); 
           closeStage();
          return;
         
          
          }
        Rating = PlaceRate.getRating() ;
        cmnts = Comments.getText() ;
        TextFilter txtf = new TextFilter();
        String filtredcmnts = txtf.GetTwi(cmnts) ;
        sr.ajouter(new Reviews(p.getPlace_name(), Rating, filtredcmnts, p.getPlace_Id(),Review_date,u.getUser_Id()));
        closeStage();
    }
        private void closeStage() {
        ((Stage) Submit.getScene().getWindow()).close();
    }
    
}
