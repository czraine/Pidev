package roadrevel.UI.ManagePlaces.PlacesList;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import roadrevel.UI.ManagePlaces.AddPlace.AddPlaceController;
import roadrevel.database.DatabaseHandler;
import roadrevel.entities.PlaceToVisit.PlaceToVisit;
import roadrevel.entities.PlaceToVisit.ServicePlace;
import roadrevel.resources.AlertMaker;


public class PlaceListController implements Initializable {

    ObservableList<PlaceToVisit> list = FXCollections.observableArrayList();

    @FXML
    private TableView<PlaceToVisit> tableView;
    @FXML
    private StackPane rootPane;
    @FXML
    private AnchorPane contentPane;
    @FXML
    private TableColumn<PlaceToVisit, String > CityNameCol;
    @FXML
    private TableColumn<PlaceToVisit, String > typeCol;
    @FXML
    private TableColumn<PlaceToVisit, String > DescpCol;
    @FXML
    private TableColumn<PlaceToVisit, String > AdressCol;
    @FXML
    private TableColumn<PlaceToVisit, String > ticketCol;
    @FXML
    private TableColumn<PlaceToVisit, String > img2Col;
        @FXML
    private TableColumn<PlaceToVisit, String > Img1Col;
    @FXML
    private TableColumn<PlaceToVisit, String > Img3Col;
ServicePlace sp = new ServicePlace() ;
 private Connection cnx = DatabaseHandler.getInstance().getCnx();
    @FXML
    private TableColumn<PlaceToVisit, String> place_nameCol;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initCol();
        loadData();
    }

        private void initCol() {
            place_nameCol.setCellValueFactory(new PropertyValueFactory<>("Place_name"));
            CityNameCol.setCellValueFactory(new PropertyValueFactory<>("Cityname"));
            typeCol.setCellValueFactory(new PropertyValueFactory<>("Place_Type"));
            DescpCol.setCellValueFactory(new PropertyValueFactory<>("Place_Description"));
            AdressCol.setCellValueFactory(new PropertyValueFactory<>("Place_Address"));
            ticketCol.setCellValueFactory(new PropertyValueFactory<>("Tickets_Price"));
            Img1Col.setCellValueFactory(new PropertyValueFactory<>("Place_img"));
            img2Col.setCellValueFactory(new PropertyValueFactory<>("Place_img2"));
            Img3Col.setCellValueFactory(new PropertyValueFactory<>("Place_img3"));

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
                list.add(new PlaceToVisit(result.getInt("Place_Id"), result.getString("Place_Name"), result.getString("CityName"),result.getString("Place_Type"), result.getString("Place_Description"), result.getString("Place_Address"), result.getInt("Tickets_Price"), result.getString("Place_Img"), result.getString("Place_img2"), result.getString("Place_Img3")));    
            }
    } catch (SQLException ex) {
            Logger.getLogger(PlaceListController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        tableView.setItems(list);
    }
    
    @FXML
    private void handlePlaceDelete(ActionEvent event) {
        //Fetch the selected row
        PlaceToVisit selectedForDeletion = tableView.getSelectionModel().getSelectedItem();
        if (selectedForDeletion == null) {
            AlertMaker.showErrorMessage("No Place selected", "Please select a Place for deletion.");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Deleting Place");
        alert.setContentText("Are you sure want to delete " + selectedForDeletion.getPlace_name() + " ?");
        Optional<ButtonType> answer = alert.showAndWait();
        if (answer.get() == ButtonType.OK) {
            sp.supprimer(selectedForDeletion);

                list.remove(selectedForDeletion);

    }}

    @FXML
    private void handleRefresh(ActionEvent event) {
        loadData();
    }

    @FXML
    private void handlePlaceEdit(ActionEvent event) {
        //Fetch the selected row
        PlaceToVisit selectedForEdit = tableView.getSelectionModel().getSelectedItem();
        if (selectedForEdit == null) {
            AlertMaker.showErrorMessage("No Place selected", "Please select a Place for edit.");
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/roadrevel/UI/ManagePlaces/AddPlace/AddPlace.fxml"));
            Parent parent = loader.load();

            AddPlaceController controller = (AddPlaceController) loader.getController();
            controller.infalteUI(selectedForEdit);

            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Edit Member");
            stage.setScene(new Scene(parent));
            stage.show();


            stage.setOnHiding((e) -> {
                handleRefresh(new ActionEvent());
            });

        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    @FXML

    private void closeStage(ActionEvent event) {
        getStage().close();
    }

    @FXML
    private void exportAsPDF(ActionEvent event) {
    }



}
