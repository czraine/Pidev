/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package roadrevel.UI.ManagePlaces.ViewPlaces.Favs;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import roadrevel.UI.ManagePlaces.PlacesList.PlaceListController;
import roadrevel.UI.ManagePlaces.ViewPlaces.View_SingleController;
import roadrevel.database.DatabaseHandler;
import roadrevel.entities.Favourites.ServiceFavourites;
import roadrevel.entities.PlaceToVisit.PlaceToVisit;
import roadrevel.entities.PlaceToVisit.ServicePlace;
import roadrevel.entities.SingleUser;
import roadrevel.entities.User.User;
import roadrevel.resources.AlertMaker;

/**
 * FXML Controller class
 *
 * @author Nasr
 */
public class Favs_listController implements Initializable {
    ObservableList<PlaceToVisit> list = FXCollections.observableArrayList();
     private Connection cnx = DatabaseHandler.getInstance().getCnx();
             SingleUser hold = SingleUser.getInstance(); 
    User u = hold.getUser();

     ServiceFavourites sf = new ServiceFavourites() ;
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

    ServicePlace sp = new ServicePlace();
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
        boolean flag = sf.checkfavs(u.getUser_Id());
        if (flag){
        String req = "SELECT * FROM placetovisit where Place_id=( Select id_Place FROM user_favsplaces where id_User=?  ) ";
  
                    PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(req);
            pst.setInt(1,u.getUser_Id());
            ResultSet result = pst.executeQuery();
            while(result.next()) {
                list.add(new PlaceToVisit(result.getInt("Place_Id"), result.getString("Place_Name"), result.getString("CityName"),result.getString("Place_Type"), result.getString("Place_Description"), result.getString("Place_Address"), result.getDouble("Tickets_Price"), result.getString("Place_Img"), result.getString("Place_img2"), result.getString("Place_Img3")));    
            }
    } catch (SQLException ex) {
            Logger.getLogger(PlaceListController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            System.out.println(  ex.getMessage());
        }


    }

    @FXML
    private void handleRemove(ActionEvent event) {
                PlaceToVisit selectedForDeletion = tableView.getSelectionModel().getSelectedItem();
        if (selectedForDeletion == null) {
            AlertMaker.showErrorMessage("No Place selected", "Please select a Place for Remove.");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Removing Place From Favourite ");
        alert.setContentText("Are you sure want to Remove " + selectedForDeletion.getPlace_name() + " ?");
        Optional<ButtonType> answer = alert.showAndWait();
        if (answer.get() == ButtonType.OK) {
            sp.supprimer(selectedForDeletion);

                list.remove(selectedForDeletion);

    }
    }
    
}
