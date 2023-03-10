/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package roadrevel.UI.Tourist;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTabPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import roadrevel.UI.Main.EventsPane.EventController;
import roadrevel.UI.Main.PlacePane.PlaceController;
import roadrevel.UI.ProductPane.ProducController;
import roadrevel.circuit_touristique.controllers.CircuitController;
import roadrevel.circuit_touristique.controllers.CircuitDetailsController;
import roadrevel.circuit_touristique.controllers.EntryController;
import roadrevel.circuit_touristique.entities.Circuit;
import roadrevel.circuit_touristique.services.ServiceCircuit;
import roadrevel.circuit_touristique.utils.CircuitListener;

import roadrevel.entities.Events.Events;
import roadrevel.entities.Events.ServicesEvents;
import roadrevel.entities.PlaceToVisit.PlaceToVisit;
import roadrevel.entities.PlaceToVisit.ServicePlace;
import roadrevel.entities.Product.Product;
import roadrevel.entities.Product.ServiceProduct;
import roadrevel.entities.SingleUser;
import roadrevel.entities.User.User;
import roadrevel.resources.Util;


/**
 * FXML Controller class
 *
 * @author Nasr
 */
public class TouristPageController implements Initializable {
    private List<PlaceToVisit> list;
    ServicePlace sp = new ServicePlace();
        private List<Events> Eventlist;
    ServicesEvents se = new ServicesEvents();
       private List<Product> Prodlist;
    ServiceProduct spr = new ServiceProduct();
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
    @FXML
    private Label nbEventPst;
    @FXML
    private GridPane EventsGrid;
    @FXML
    private Label nbProdPst;
    @FXML
    private JFXButton OpenC;
    @FXML
    private GridPane PlrodGrid;
    @FXML
    private JFXButton btn_workbench22;
    @FXML
    private GridPane circuitGrid;

    private List<Circuit> circuits;
    private CircuitListener circuitListener;

    private List<Circuit> data() {
        ServiceCircuit serviceCircuit = new ServiceCircuit();
        return serviceCircuit.afficher();
    }



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       list = sp.afficher();
       Eventlist = se.afficher();
        initDrawer();
        loadPlaceData(list);
        loadEventsData(Eventlist);
        loadShop();
        loadPlans();
    }

    public void loadPlaceData( List<PlaceToVisit> list) {
      
        int colmn = 0;
        int row = 1;
        nbPst.setText(list.size() + " posts ");
        try {
            for (PlaceToVisit place : list) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/roadrevel/UI/Main/PlacePane/Place.fxml"));
                Pane pane = loader.load();
                PlaceController plc = loader.getController();
                plc.setData(place);
                System.out.println("colmn  " + colmn + " row  " + row);
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
        public void loadEventsData( List<Events> list) {
      
        int colmn = 0;
        int row = 0;
        nbEventPst.setText(list.size() + " posts ");
        try {
            for (Events event : list) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/roadrevel/UI/Main/EventsPane/Event.fxml"));
                Pane pane = loader.load();
                EventController evc = loader.getController();
                evc.setData(event);
                System.out.println("colmn  " + colmn + " row  " + row);
                if (colmn == 3) {
                    colmn = 0;
                    row++;
                }
                EventsGrid.add(pane, colmn++, row);
                GridPane.setMargin(pane, new Insets(20));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }}
   public void loadShop() {
                   UserLogo.setStroke(javafx.scene.paint.Color.LIGHTSKYBLUE);
        UserLogo.setFill(new ImagePattern(new Image("/roadrevel/resources/logotest.jfif")));
        Prodlist = spr.afficher();
        int colmn = 0;
        int row = 1;
        nbProdPst.setText(Prodlist.size() + " posts ");
        try {
            for (Product prod : Prodlist) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/roadrevel/UI/ProductPane/Produc.fxml"));
                Pane pane = loader.load();
                ProducController plc = loader.getController();
                plc.setData(prod);
                System.out.println("colmn  "+colmn +" row  "+ row);
                if (colmn == 3) {
                    colmn = 0;
                    row++;
                }
                PlrodGrid.add(pane, colmn++, row);
                GridPane.setMargin(pane, new Insets(20));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
public void loadPlans(){
        circuits = new ArrayList<>(data());

        circuitListener = new CircuitListener() {
            @Override
            public void onClickListener(Circuit circuit) {
                System.out.println("Clicked: " + circuit.getNc());
                try {
                    FXMLLoader circuitDetailsLoader = new FXMLLoader(getClass().getResource("/roadrevel/UI/plans/gui/circuit_details.fxml"));
                    //FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/gui/entry.fxml"));
                    //mainLoader.load();
                    Parent circuitDetailRoot = circuitDetailsLoader.load();

                    CircuitDetailsController controller = circuitDetailsLoader.getController();
                    //System.out.println(controller.toString());
                    controller.setCircuit(circuit);

                    //controller.mainPane.setCenter(circuitDetailRoot);
                    //commenting that since it was not able to open new view on borderpane center
                    //open in a new window instead
                    Stage stage = new Stage();
                    stage.setTitle("Roadrevel");
                    stage.setScene(new Scene(circuitDetailRoot));
                    stage.show();
                    //controller.mainPane.setBackground(Background.EMPTY);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());                }

            }
        };
        int columns = 0;
        int rows = 1;

        try {
            for (int i = 0; i < circuits.size(); i++) {
               
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/roadrevel/UI/plans/gui/circuit.fxml"));
                HBox circuitBox = fxmlLoader.load();
                CircuitController circuitController = fxmlLoader.getController();
                circuitController.setData(circuits.get(i), circuitListener);
                
                if (columns == 1) {
                    columns = 0;
                    ++rows;

                }
                circuitGrid.add(circuitBox, columns++, rows);
                GridPane.setMargin(circuitBox, new Insets(10));

            }
        } catch (IOException ex) {
            Logger.getLogger(EntryController.class.getName()).log(Level.SEVERE, null, ex);
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
        Util.loadWindow(getClass().getResource("/roadrevel/UI/Main/MainPage.fxml"), "Add New Place", null);
        closeStage();


    }
    }

    @FXML
    private void HandleCart(ActionEvent event) {
              Util.loadWindow(getClass().getResource("/roadrevel/UI/Cart/Cart.fxml"), "My Cart", null);  

    }

    @FXML
    private void profile(ActionEvent event) {
                 Util.loadWindow(getClass().getResource("/roadrevel/UI/Tourist/automa.fxml"), "Auto Matching for Tourist", null);

    }






}
