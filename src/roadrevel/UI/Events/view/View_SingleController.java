/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadrevel.UI.Events.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import roadrevel.entities.Events.Events;
import roadrevel.entities.Events.SingleEvent;
import roadrevel.resources.Util;

/**
 * FXML Controller class
 *
 * @author GAMING A15
 */
public class View_SingleController implements Initializable {
    
    Image image, image2, image3;
    
    
    
    @FXML
    private ImageView eventimg;
    @FXML
    private ImageView eventimg2;
    @FXML
    private ImageView eventimg3;
    @FXML
    private JFXButton Review;
    @FXML
    private Label eventdescription;
    @FXML
    private Label EventName;
    @FXML
    private Label cityname;
    @FXML
    private Label Prix;
    @FXML
    private JFXButton ReviewList;
    @FXML
    private JFXButton AddCart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void infalteUI(Events selected) {
        System.out.println(selected.toString());
        image = new Image(selected.getEventPoster());
        image2 = new Image(selected.getEvent_pic2());
        image3 = new Image(selected.getEvent_pic3());
        EventName.setText(selected.getEvent_name());
        cityname.setText(selected.getCityName());
        eventdescription.setText(selected.getEvent_description());
        Prix.setText(String.valueOf(selected.getEventPrice()) + " TND");
        eventimg.setImage(image);
        eventimg2.setImage(image2);
        eventimg3.setImage(image3);
        EventHandler<ActionEvent> Grate = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                SingleEvent holder = SingleEvent.getInstance();
                holder.setEvent(selected);
                Util.loadWindow(getClass().getResource("/roadrevel/UI/Events/Reviews/AddReview/AddEventReview.fxml"), "Add New comment", null);

            }
        };
        EventHandler<ActionEvent> SReviws = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                SingleEvent holder = SingleEvent.getInstance();
                holder.setEvent(selected);
                Util.loadWindow(getClass().getResource("/roadrevel/UI/Events/Reviews/viewReviewList/ReviewList.fxml"), "See Reviews", null);

            }
        };
         ReviewList.setOnAction(SReviws);
        Review.setOnAction(Grate);
    }

    private void loadcommentPage(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/roadrevel/UI/Events/addReview/AddEventReview.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void ReviewListLoader(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/roadrevel/UI//Events/viewReviewList/ReviewList.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void setData(Events e) {
        
        EventName.setText(e.getEvent_name());
        cityname.setText(e.getCityName());
        eventdescription.setText(e.getEvent_description());
        Prix.setText(String.valueOf(e.getEventPrice()) + " TND");
        eventimg.setImage(image);
        eventimg2.setImage(image2);
        eventimg3.setImage(image3);
        
    }

    
    
}
