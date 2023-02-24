/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package roadrevel.UI.Tourist;

import roadrevel.UI.Admin.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import java.util.List;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Rating;
import static roadrevel.UI.Login.LoginController.infoBox;
import roadrevel.entities.Favourites.Favourites;
import roadrevel.entities.Favourites.ServiceFavourites;
import roadrevel.entities.PlaceToVisit.PlaceToVisit;
import roadrevel.entities.PlaceToVisit.ServicePlace;
import roadrevel.entities.SinglePlace;
import roadrevel.entities.SingleUser;
import roadrevel.entities.User.User;
import roadrevel.resources.AlertMaker;
import roadrevel.resources.Util;


/**
 * FXML Controller class
 *
 * @author Nasr
 */
public class TouristPageController implements Initializable {

    @FXML
    private StackPane rootPane;
    @FXML
    private AnchorPane rootAnchorPane;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private Tab placetab;
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
    private TextArea Placedescp;
    @FXML
    private Label PlaceName;
    @FXML
    private JFXButton previous;
    @FXML
    private JFXButton Next;
    @FXML
    private Label TicketP1;
    @FXML
    private JFXButton Rate;
    @FXML
    private JFXButton Review;
    @FXML
    private AnchorPane EventAnchor;
    @FXML
    private AnchorPane PlanAnchor;
    @FXML
    private AnchorPane ShopAnchor;

        ServicePlace sp = new ServicePlace();
        List<PlaceToVisit> lp ;
            Image image , image2 , image3 ;
             boolean flag;
    SingleUser hold = SingleUser.getInstance(); 
    User u = hold.getUser();

    int i = 0 ;





    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initDrawer()  ;
        initPlace(i);


    }    
        private void initPlace( int id){
         lp = sp.afficher();
        if (id == 0 ){
        previous.setOpacity(0); 
        }else {previous.setOpacity(1);}
        if ( id == lp.size()-1 ){
        Next.setOpacity(0);
        }else {Next.setOpacity(1);}

        image = new Image (lp.get(id).getPlace_img());
        image2 = new Image (lp.get(id).getPlace_img2());
        image3 = new Image (lp.get(id).getPlace_img3());
        PlaceName.setText(lp.get(id).getPlace_name());
        Cityname.setText(lp.get(id).getCityname());
        Placedescp.setText(lp.get(id).getPlace_Description());
        placeadres.setText(lp.get(id).getPlace_Address());
        TicketP.setText(String.valueOf(lp.get(id).getTickets_Price()));
        placeimg.setImage(image);
        placeimg2.setImage(image2);
        placeimg3.setImage(image3);
        EventHandler<ActionEvent> Grate = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                SinglePlace holder = SinglePlace.getInstance();
                holder.setPlace(lp.get(id));
             Util.loadWindow(getClass().getResource("/roadrevel/UI/ManagePlaces/AddReviews/Add_Reviews.fxml"), "Add New Place", null);

            }
        };
                EventHandler<ActionEvent> SReviws = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                SinglePlace holder = SinglePlace.getInstance();
                holder.setPlace(lp.get(id));
             Util.loadWindow(getClass().getResource("/roadrevel/UI/ManagePlaces/SeeAllReviews/SeeReviews.fxml"), "Add New Place", null);

            }
        };
        Rate.setOnAction(Grate);
        Review.setOnAction(SReviws);

    
    }
        private void initDrawer() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/roadrevel/UI/Tourist/Toolbar/toolbar.fxml"));
            VBox toolbar = loader.load();
            drawer.setSidePane(toolbar);

        } catch (IOException ex) {
            ex.getMessage();
        }
        HamburgerSlideCloseTransition task = new HamburgerSlideCloseTransition(hamburger);
        task.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event event) -> {
            drawer.toggle();
        });
        drawer.setOnDrawerOpening((event) -> {
            task.setRate(task.getRate() * -1);
            task.play();
            drawer.toFront();
        });
        drawer.setOnDrawerClosed((event) -> {
            drawer.toBack();
            task.setRate(task.getRate() * -1);
            task.play();
        });
    }


    @FXML
    private void movebackward(ActionEvent event) {
        
                i = i -1 ; 
        initPlace(i);
         System.out.println("let's go back  ");
    }

    @FXML
    private void moveforward(ActionEvent event) {
        i ++ ; 
        initPlace(i);
         System.out.println("here we go ");

    }
    @FXML
    private void loadRatePage(ActionEvent event) {
    }
  public void closeStage() {
         
        ((Stage) drawer.getScene().getWindow()).close();
    }
    @FXML
    private void handleLogOut(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Log Out");
        alert.setContentText("Are you sure want to log Out ?");
        Optional<ButtonType> answer = alert.showAndWait();
        if (answer.get() == ButtonType.OK) {
        Util.loadWindow(getClass().getResource("/roadrevel/UI/Main/MainPage.fxml"), "Add New Place", null);
        closeStage();


    }
    }





}
