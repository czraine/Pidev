/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package roadrevel.UI.Tourist;

import roadrevel.UI.Admin.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTabPane;
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
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Rating;
import static roadrevel.UI.Login.LoginController.infoBox;
import roadrevel.UI.NewMain.Pane.PlaceController;
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
    private List<PlaceToVisit> list;
    ServicePlace sp = new ServicePlace();
    @FXML
    private StackPane rootPane;
    @FXML
    private BorderPane rootAnchorPane;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private JFXHamburger hamburger;


        List<PlaceToVisit> lp ;
            Image image , image2 , image3 ;
             boolean flag;
    SingleUser hold = SingleUser.getInstance(); 
    User u = hold.getUser();

    int i = 0 ;
    @FXML
    private ImageView imagePI;
    @FXML
    private Circle UserLogo;
    @FXML
    private JFXTabPane mainTabPane;
    @FXML
    private Label nbPst;
    @FXML
    private GridPane PlacesGrid;
    @FXML
    private JFXButton logout;





    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initDrawer()  ;
        loadData();


    }    


   public void loadData() {
                   UserLogo.setStroke(javafx.scene.paint.Color.LIGHTSKYBLUE);
        UserLogo.setFill(new ImagePattern(new Image("/roadrevel/resources/logotest.jfif")));
        list = sp.afficher();
        int colmn = 0;
        int row = 1;
        nbPst.setText(list.size() + " posts ");
        try {
            for (PlaceToVisit place : list) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/roadrevel/UI/NewMain/Pane/Place.fxml"));
                Pane pane = loader.load();
                PlaceController plc = loader.getController();
                plc.setData(place);
                System.out.println("colmn  "+colmn +" row  "+ row);
                if (colmn == 3) {
                    colmn = 0;
                    row++;
                }
                PlacesGrid.add(pane, colmn++, row);
                GridPane.setMargin(pane, new Insets(20));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

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


  public void closeStage() {
         
        ((Stage) drawer.getScene().getWindow()).close();
    }
  

    @FXML
    private void HandleLogOut(ActionEvent event) {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Log Out");
        alert.setContentText("Are you sure want to log Out ?");
        Optional<ButtonType> answer = alert.showAndWait();
        if (answer.get() == ButtonType.OK) {
        Util.loadWindow(getClass().getResource("/roadrevel/UI/NewMain/MainPage.fxml"), "Add New Place", null);
        closeStage();


    }
    }

    @FXML
    private void HandleFilter(ActionEvent event) {
    }





}
