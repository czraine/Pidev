/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package roadrevel.UI.Events.Reviews.viewReviewList;

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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import roadrevel.UI.Events.Ajout.AjouterEventController;
import roadrevel.database.DatabaseHandler;
import roadrevel.entities.EventReview.Review;
import roadrevel.entities.EventReview.ServiceReview;
import roadrevel.entities.Events.Events;
import roadrevel.entities.Events.SingleEvent;

/**
 * FXML Controller class
 *
 * @author GAMING A15
 */
public class ReviewListController implements Initializable {

    ObservableList<Review> list = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Review, String> Event_Name;
    @FXML
    private TableColumn<Review, String> comment;
    @FXML
    private Button exitbuuton;
    @FXML
    private TableView<Review> commentTable;

    Connection cnx = DatabaseHandler.getInstance().getCnx();
    ServiceReview sr = new ServiceReview();
    @FXML
    private Button reload;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initCol();
        LoadData();
    }

    private void initCol() {
        Event_Name.setCellValueFactory(new PropertyValueFactory<>("Event_name"));
        comment.setCellValueFactory(new PropertyValueFactory<>("Review_txt"));

    }

    public void infalteUI(Events selected) {
        Event_Name.setText(selected.getEvent_name());
        comment.setCellValueFactory(new PropertyValueFactory<>("Review_txt"));
    }

    private void LoadData() {
        list.clear();
        SingleEvent holder = SingleEvent.getInstance();
        Events p = holder.getEvent();
        String req = "SELECT * FROM eventsreview where Event_id = ? ";

        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(req);
            pst.setInt(1, p.getEvent_id());
            ResultSet result = pst.executeQuery();
            

            while (result.next()) {
                list.add(new Review(result.getInt("Review_id"), result.getString("Event_name"), result.getString("Review_txt"), result.getInt("id_user"), result.getInt("Event_id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AjouterEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        commentTable.setItems(list);

    }

    private Stage getStage() {
        return (Stage) commentTable.getScene().getWindow();
    }

    @FXML
    private void exit(ActionEvent event) {
        getStage().close();
    }

    @FXML
    private void Reload(ActionEvent event) {
        LoadData();
    }

}
