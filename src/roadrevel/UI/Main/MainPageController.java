/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package roadrevel.UI.Main;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextFlow;
import org.controlsfx.control.Rating;
import roadrevel.UI.ManagePlaces.AddReviews.ReviewsController;
import roadrevel.entities.PlaceToVisit.ServicePlace;
import roadrevel.entities.PlaceToVisit.PlaceToVisit;
import roadrevel.entities.SinglePlace;

import roadrevel.resources.Util;


/**
 * FXML Controller class
 *
 * @author Nasr
 */
public class MainPageController implements Initializable {

    @FXML
    private StackPane rootPane;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private AnchorPane rootAnchorPane;
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
    private AnchorPane EventAnchor;
    @FXML
    private AnchorPane PlanAnchor;
    @FXML
    private AnchorPane ShopAnchor;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private ImageView imagePI;
    @FXML
    private JFXButton logIn;
    int i = 0 ;
    ServicePlace sp = new ServicePlace();
        List<PlaceToVisit> lp ;
    Image image , image2 , image3 ;
    @FXML
    private Label TicketP1;

    @FXML
    private JFXButton Review;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        Placedescp.setStyle("-fx-background-color : transparent ; -fx-text-fill: #2A2E37 ; -fx-font-size : 20pt; -fx-font-family : Arial ");
        initDrawer()  ;
        initPlace( i) ;
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

                EventHandler<ActionEvent> SReviws = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                SinglePlace holder = SinglePlace.getInstance();
                holder.setPlace(lp.get(id));
             Util.loadWindow(getClass().getResource("/roadrevel/UI/ManagePlaces/SeeReviews/SeeReviews.fxml"), "Add New Place", null);

            }
        };
        
        Review.setOnAction(SReviws);

    
    }
        private void initDrawer() {

      image = new Image ("/roadrevel/UI/Main/logoRoad.png");
            
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/roadrevel/UI/Main/Toolbar/toolbar.fxml"));
            VBox toolbar = loader.load();
            drawer.setSidePane(toolbar);
            imagePI.setImage(image);

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
    private void Log(ActionEvent event) {
                try {
            Parent parent = FXMLLoader.load(getClass().getResource("/roadrevel/UI/Login/login.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("RoadRevel");
            stage.setScene(new Scene(parent));
            stage.show();
            closeStage();
        }
        catch (IOException ex) {
            ex.getMessage();
        }
    }

  public void closeStage() {
         
        ((Stage) drawer.getScene().getWindow()).close();
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

 


}
