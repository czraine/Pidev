/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadrevel.UI.Product.ProductList;

import com.jfoenix.controls.JFXTextField;
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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javax.swing.JOptionPane;
import roadrevel.UI.Product.Add_Product.AddController;
import roadrevel.UI.Product.ViewProduct.View_ProductController;
import roadrevel.database.DatabaseHandler;
import roadrevel.entities.Product.Product;
import roadrevel.entities.Product.ServiceProduct;
import roadrevel.resources.AlertMaker;

/**
 * FXML Controller class
 *
 * @author Nasr
 */
public class Product_ListController implements Initializable {

    ObservableList<Product> list = FXCollections.observableArrayList();
    int id;
    ServiceProduct sp = new ServiceProduct();
    private Connection cnx = DatabaseHandler.getInstance().getCnx();
    @FXML
    private JFXTextField SearchName;
    @FXML
    private TableView<Product> tableView;
    @FXML
    private TableColumn<Product, String> ProdName_nameCol;
    @FXML
    private TableColumn<Product, String> Prod_DescrpCol;
    @FXML
    private TableColumn<Product, String> typeProdCol;
    @FXML
    private TableColumn<Product, String> ProPriceCol;
    @FXML
    private TableColumn<Product, String> QteCol;
    @FXML
    private TableColumn<Product, String> StatusCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
initCol();  
    loadData() ;}

    private void initCol() {
        ProdName_nameCol.setCellValueFactory(new PropertyValueFactory<>("Name_prod"));
        Prod_DescrpCol.setCellValueFactory(new PropertyValueFactory<>("prodDescrp"));
        typeProdCol.setCellValueFactory(new PropertyValueFactory<>("Type_prod"));
        ProPriceCol.setCellValueFactory(new PropertyValueFactory<>("Product_Price"));
        QteCol.setCellValueFactory(new PropertyValueFactory<>("Qte"));
        StatusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

    }

    private void loadData() {

        list.clear();
        String req = "SELECT * FROM produit";

        PreparedStatement pst;
        try {
            pst = cnx.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                list.add(new Product(result.getInt("id_Produit"), result.getString("Name_prod"), result.getString("Prod_Description"), result.getString("Type_prod"), result.getDouble("Price_prod"), result.getDouble("quantité"), result.getString("image_prod"), result.getString("status")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        tableView.setItems(list);
        // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Product> filteredData = new FilteredList<>(list, b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        SearchName.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Place -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (Place.getName_prod().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches first name.
                } else if (Place.getType_prod().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                } else if (String.valueOf(Place.getProduct_Price()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false; // Does not match.
                }
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Product> sortedData = new SortedList<>(filteredData);

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
        Product selectedForEdit = tableView.getSelectionModel().getSelectedItem();
        id = tableView.getSelectionModel().getSelectedItem().getId_Produit();
        if (selectedForEdit == null) {
            AlertMaker.showErrorMessage("No Place selected", "Please select a Place for edit.");
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/roadrevel/UI/Product/ViewProduct/View_Product.fxml"));
            Parent parent = loader.load();

            View_ProductController controller = (View_ProductController) loader.getController();
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
    private void handleEdit(ActionEvent event) {
        //Fetch the selected row
        Product selectedForEdit = tableView.getSelectionModel().getSelectedItem();
        if (selectedForEdit == null) {
            JOptionPane.showMessageDialog(null, "No Place selected , Please select a Place for deletion.");
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/roadrevel/UI/Product/Add_Product/Add.fxml"));
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
    private void handleDelete(ActionEvent event) {
        Product selectedForDeletion = tableView.getSelectionModel().getSelectedItem();
        if (selectedForDeletion == null) {
            JOptionPane.showMessageDialog(null, "No Place selected , Please select a Place for deletion.");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Deleting Place");
        alert.setContentText("Are you sure want to delete " + selectedForDeletion.getName_prod() + " ?");
        Optional<ButtonType> answer = alert.showAndWait();
        if (answer.get() == ButtonType.OK) {
            sp.supprimer(selectedForDeletion);

            list.remove(selectedForDeletion);

        }
    }
}
