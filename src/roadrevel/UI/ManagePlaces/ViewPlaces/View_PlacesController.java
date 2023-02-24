/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package roadrevel.UI.ManagePlaces.ViewPlaces;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.PrefixSelectionChoiceBox;
import roadrevel.UI.ManagePlaces.AddPlace.AddPlaceController;
import roadrevel.UI.ManagePlaces.PlacesList.PlaceListController;
import roadrevel.database.DatabaseHandler;
import roadrevel.entities.Favourites.Favourites;
import roadrevel.entities.Favourites.ServiceFavourites;
import roadrevel.entities.Place;
import roadrevel.entities.PlaceToVisit.PlaceToVisit;
import roadrevel.entities.PlaceToVisit.ServicePlace;
import roadrevel.entities.SingleUser;
import roadrevel.entities.User.User;
import roadrevel.resources.AlertMaker;
import roadrevel.resources.Util;

/**
 * FXML Controller class
 *
 * @author Nasr
 */
public class View_PlacesController implements Initializable {

    @FXML
    private JFXTextField SearchName;
    @FXML
    private PrefixSelectionChoiceBox<String> filterchoie;
    @FXML
    private JFXButton Searchbtn;



    ServicePlace sp = new ServicePlace() ;
 private Connection cnx = DatabaseHandler.getInstance().getCnx();
    ObservableList<PlaceToVisit> list = FXCollections.observableArrayList();

    @FXML
    private TableView<PlaceToVisit> tableView;
    @FXML
    private TableColumn<PlaceToVisit, String> place_nameCol;

    @FXML
    private TableColumn<PlaceToVisit, String > CityNameCol;
    @FXML
    private TableColumn<PlaceToVisit, String > typeCol;

    @FXML
    private TableColumn<PlaceToVisit, String > AdressCol;
    @FXML
    private TableColumn<PlaceToVisit, String > ticketCol;
        SingleUser hold = SingleUser.getInstance(); 
    User u = hold.getUser();
    ServiceFavourites sf = new ServiceFavourites() ;
    int id ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        initCol();
        loadData();
    }
        private void initCol() {
            place_nameCol.setCellValueFactory(new PropertyValueFactory<>("Place_name"));
            CityNameCol.setCellValueFactory(new PropertyValueFactory<>("Cityname"));
            typeCol.setCellValueFactory(new PropertyValueFactory<>("Place_Type"));
            AdressCol.setCellValueFactory(new PropertyValueFactory<>("Place_Address"));
            ticketCol.setCellValueFactory(new PropertyValueFactory<>("Tickets_Price"));


        }

    private Stage getStage() {
        return (Stage) tableView.getScene().getWindow();
    }

    private void loadData() {
        list.clear();
        String req = "SELECT * FROM placetovisit";
  
                    PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while(result.next()) {
                list.add(new PlaceToVisit(result.getInt("Place_Id"), result.getString("Place_Name"), result.getString("CityName"),result.getString("Place_Type"), result.getString("Place_Description"), result.getString("Place_Address"), result.getDouble("Tickets_Price"), result.getString("Place_Img"), result.getString("Place_img2"), result.getString("Place_Img3")));    
            }
    } catch (SQLException ex) {
            Logger.getLogger(PlaceListController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        tableView.setItems(list);
    }

     @FXML
    private void handleRefresh(ActionEvent event) {
        loadData();
    }

    @FXML
    private void handleViewmore(ActionEvent event) { 
        PlaceToVisit selectedForEdit = tableView.getSelectionModel().getSelectedItem();
        id = tableView.getSelectionModel().getSelectedItem().getPlace_Id();
        if (selectedForEdit == null) {
            AlertMaker.showErrorMessage("No Place selected", "Please select a Place for edit.");
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/roadrevel/UI/ManagePlaces/ViewPlaces/View_Single.fxml"));
            Parent parent = loader.load();

            View_SingleController controller = (View_SingleController) loader.getController();
            controller.infalteUI(selectedForEdit);

            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Edit Member");
            stage.setScene(new Scene(parent));
            stage.show();

        } catch (IOException ex) {
            ex.getMessage();
        }


    }

    @FXML
    private void handleFavs(ActionEvent event) {
        System.out.println(u.toString());
        id = tableView.getSelectionModel().getSelectedItem().getPlace_Id();

        sf.ajouter(new Favourites(u.getUser_Id(), id));
         AlertMaker.showErrorMessage("Success", " Places added To favourites  ");
        
    }

}
