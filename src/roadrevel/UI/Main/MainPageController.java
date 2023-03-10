/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadrevel.UI.Main;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import roadrevel.UI.Main.EventsPane.EventController;
import roadrevel.UI.Main.PlacePane.PlaceController;
import roadrevel.entities.Events.Events;
import roadrevel.entities.Events.ServicesEvents;
import roadrevel.entities.PlaceToVisit.PlaceToVisit;
import roadrevel.entities.PlaceToVisit.ServicePlace;
import roadrevel.resources.AlertMaker;

/**
 * FXML Controller class
 *
 * @author Nasr
 */
public class MainPageController implements Initializable {

    private List<PlaceToVisit> list;
    ServicePlace sp = new ServicePlace();
    private List<Events> Eventlist;
    ServicesEvents se = new ServicesEvents();
    @FXML
    private GridPane PlacesGrid;
    @FXML
    private Label nbPst;
    Image image;
    @FXML
    private StackPane rootPane;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private BorderPane rootAnchorPane;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private ImageView imagePI;
    @FXML
    private JFXTabPane mainTabPane;
    @FXML
    private Tab bookIssueTab;
    @FXML
    private Tab renewTab;
    private JFXTextField Search;
    @FXML
    private Label nbEventPst;
    @FXML
    private GridPane EventsGrid;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       list = sp.afficher();
       Eventlist = se.afficher();
        initDrawer();
        loadPlaceData(list);
        loadEventsData(Eventlist);
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
        }

    }

    private void initDrawer() {

        image = new Image("roadrevel/resources/logoRoad.png");

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
    private void HandleLoginOperation(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/roadrevel/UI/Login/log.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("RoadRevel");
            stage.setScene(new Scene(parent));
            stage.show();
            closeStage();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    public void closeStage() {

        ((Stage) drawer.getScene().getWindow()).close();
    }

    


    }


