/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package roadrevel.UI.Guide.GuideList;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javax.swing.JOptionPane;
import roadrevel.UI.Guide.AddGuide.AddController;
import roadrevel.UI.Guide.AddGuide.Ajouter_GuideController;
import roadrevel.database.DatabaseHandler;
import roadrevel.entities.Guide.Guide;
import roadrevel.entities.Guide.ServiceGuide;
import roadrevel.resources.Util;


/**
 * FXML Controller class
 *
 * @author Nasr
 */
public class GuideListController implements Initializable {
    ObservableList<Guide> list = FXCollections.observableArrayList();


     private Connection cnx = DatabaseHandler.getInstance().getCnx();
    @FXML
    private TableView<Guide> tableView;

    ServiceGuide sg= new ServiceGuide();
    @FXML
    private StackPane rootPane;
    @FXML
    private AnchorPane contentPane;
    @FXML
    private TableColumn<Guide, String> fnameCol;
    @FXML
    private TableColumn<Guide, String> lanameCol;
    @FXML
    private TableColumn<Guide, String> mailCol;
    @FXML
    private TableColumn<Guide, String> unameCol;
    @FXML
    private TableColumn<Guide, String> pwdCol;
    @FXML
    private TableColumn<Guide, String> phoneCol;
    @FXML
    private TableColumn<Guide, String> lng1Col;
    @FXML
    private TableColumn<Guide, String> lng2Col;
    @FXML
    private TableColumn<Guide, String> lng3Col;
    @FXML
    private TableColumn<Guide, String> CityCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
initCol();
    }
    private void initCol() {
        fnameCol.setCellValueFactory(new PropertyValueFactory<>("Fname"));
        lanameCol.setCellValueFactory(new PropertyValueFactory<>("Lname"));
        mailCol.setCellValueFactory(new PropertyValueFactory<>("Uemail"));
        unameCol.setCellValueFactory(new PropertyValueFactory<>("UserName"));
        pwdCol.setCellValueFactory(new PropertyValueFactory<>("Uphone"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("Uemail"));
        lng1Col.setCellValueFactory(new PropertyValueFactory<>("lang1"));
        lng2Col.setCellValueFactory(new PropertyValueFactory<>("lang2"));
        lng3Col.setCellValueFactory(new PropertyValueFactory<>("lang3"));
        CityCol.setCellValueFactory(new PropertyValueFactory<>("cityname"));

    }

   private Stage getStage() {
        return (Stage) tableView.getScene().getWindow();
    }

    private void loadData() {
        list.clear();
        String req = "SELECT * FROM user";
  
                    PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while(result.next()) {
                Guide g = new Guide(result.getInt("id_User"), result.getString("User_FirstName"), result.getString("User_lastName"),result.getString("User_mail"), result.getInt("User_phone"), result.getString("Username"),  result.getString("Password"),result.getString("Lang1"), result.getString("Lang2"), result.getString("Lang3"), result.getString("CityName") );    
                System.out.println(g);
                list.add(g);
            }
    } catch (SQLException ex) {
System.out.println(ex.getMessage()); }       
            
        tableView.setItems(list);}
    
    
    @FXML
    private void handlePlaceDelete(ActionEvent event) {
        //Fetch the selected row
        Guide selectedForDeletion = tableView.getSelectionModel().getSelectedItem();
        if (selectedForDeletion == null) {
            JOptionPane.showMessageDialog(null,"No Place selected , Please select a Place for deletion.");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Deleting Place");
        alert.setContentText("Are you sure want to delete " + selectedForDeletion.getFname()+ " ?");
        Optional<ButtonType> answer = alert.showAndWait();
        if (answer.get() == ButtonType.OK) {
            sg.supprimer(selectedForDeletion);

                list.remove(selectedForDeletion);

    }}

    @FXML
    private void handleRefresh(ActionEvent event) {
        loadData();
    }

    @FXML
    private void handlePlaceEdit(ActionEvent event) {
        //Fetch the selected row
        Guide selectedForEdit = tableView.getSelectionModel().getSelectedItem();
        if (selectedForEdit == null) {
            JOptionPane.showMessageDialog(null,"No Place selected , Please select a Place for deletion.");
            return;
        }
        try {
             //Util.loadWindow(getClass().getResource("/roadrevel/UI/Guide/AddGuide/Add.fxml"), "Add New Place", null);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/roadrevel/UI/Guide/AddGuide/Add.fxml"));
            Parent parent = loader.load();

            AddController controller = (AddController) loader.getController();
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
