/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadrevel.UI.Events.view;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import roadrevel.UI.ManagePlaces.PlacesList.PlaceListController;
import roadrevel.database.DatabaseHandler;
import roadrevel.entities.Events.Events;
import roadrevel.entities.Events.ServicesEvents;
import roadrevel.resources.AlertMaker;

/**
 * FXML Controller class
 *
 * @author GAMING A15
 */
public class View_EventsController implements Initializable {
    
    ServicesEvents e = new ServicesEvents() ;
 private Connection cnx = DatabaseHandler.getInstance().getCnx();
    ObservableList<Events> list = FXCollections.observableArrayList();
    @FXML
    private JFXTextField SearchName;
    @FXML
    private TableView<Events> tableView;
    @FXML
    private TableColumn<Events, String> Event_nameCol;
    @FXML
    private TableColumn<Events, String> CityNameCol;
    @FXML
    private TableColumn<Events, String> descCol;
    @FXML
    private TableColumn<Events, String> priceCol;

    
    int id ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    private void initCol() {
            Event_nameCol.setCellValueFactory(new PropertyValueFactory<>("Event_name"));
            CityNameCol.setCellValueFactory(new PropertyValueFactory<>("CityName"));
            descCol.setCellValueFactory(new PropertyValueFactory<>("Event_description"));
            priceCol.setCellValueFactory(new PropertyValueFactory<>("EventPrice"));
            


        }
    private void loadData() {
        list.clear();
        String req = "SELECT * FROM Events";
  
                    PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while(result.next()) {
                list.add(new Events(result.getInt("Event_id"), result.getString("Event_name"), result.getString("CityName"),result.getString("Event_description"), result.getInt("EventPrice")));    
            }
    } catch (SQLException ex) {
            Logger.getLogger(PlaceListController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        tableView.setItems(list);
                // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Events> filteredData = new FilteredList<>(list, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		SearchName.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Event -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Event.getEvent_name().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (Event.getCityName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				} else if (Event.getEvent_description().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				} 
				else if (String.valueOf(Event.getEventPrice()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Events> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tableView.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tableView.setItems(sortedData);
    }

    @FXML
    private void handleRefresh(ActionEvent event) {
        loadData();
    }

    @FXML
    private void handleViewmore(ActionEvent event) {
        Events selectedForEdit = tableView.getSelectionModel().getSelectedItem();
        id = tableView.getSelectionModel().getSelectedItem().getEvent_id();
        if (selectedForEdit == null) {
            AlertMaker.showErrorMessage("No event selected", "Please select an event to edit.");
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/roadrevel/UI/Events/view/View_Single.fxml"));
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
    }
    
}
