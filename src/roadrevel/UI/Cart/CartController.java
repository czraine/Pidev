/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadrevel.UI.Cart;

import com.jfoenix.controls.JFXButton;
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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import roadrevel.UI.Cart.payment.ConfirmPayemntController;
import roadrevel.UI.Product.ViewProduct.View_ProductController;
import roadrevel.database.DatabaseHandler;
import roadrevel.entities.Product.Product;
import roadrevel.entities.Product.ServiceProduct;
import roadrevel.entities.CartProduct.ServiceCart;
import roadrevel.entities.CartProd;
import roadrevel.entities.SingleUser;
import roadrevel.entities.User.User;
import roadrevel.resources.AlertMaker;

/**
 * FXML Controller class
 *
 * @author Nasr
 */
public class CartController implements Initializable {

    ObservableList<CartProd> list = FXCollections.observableArrayList();

    int id;
    ServiceCart sp = new ServiceCart();
    private Connection cnx = DatabaseHandler.getInstance().getCnx();
    @FXML
    private TableView<CartProd> tableView;
    @FXML
    private TableColumn<CartProd, String> ProdImageCol;
    @FXML
    private TableColumn<CartProd, String> ProdName_nameCol;
    @FXML
    private TableColumn<CartProd, String> Prod_DescrpCol;
    @FXML
    private TableColumn<CartProd, String> QteCol;
    @FXML
    private TableColumn<CartProd, String> ProPriceCol;
    @FXML
    private Label TotalP;
    @FXML
    private JFXButton Paybtn;
    int res = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initCol();
        loadData();
    }

    private void initCol() {
        ProdImageCol.setCellValueFactory(new PropertyValueFactory<>("img"));
        ProdName_nameCol.setCellValueFactory(new PropertyValueFactory<>("ProdName"));
        Prod_DescrpCol.setCellValueFactory(new PropertyValueFactory<>("ProdDescrp"));
        QteCol.setCellValueFactory(new PropertyValueFactory<>("qte"));
        ProPriceCol.setCellValueFactory(new PropertyValueFactory<>("Price"));

    }

    private void loadData() {
        SingleUser hold = SingleUser.getInstance();
        User u = hold.getUser();
        Double price, qte;

        list.clear();
        String req1 = "SELECT * FROM  shopping_cart where user_id = ? ";

        PreparedStatement pst1;

        try {
            pst1 = cnx.prepareStatement(req1);
            pst1.setInt(1, u.getId_User());
            ResultSet result = pst1.executeQuery();
            while (result.next()) {
                price = result.getDouble("price");
                qte = result.getDouble("quantity");
                String req = "SELECT * FROM produit where id_Produit = ?";
                res = res + price.intValue();
                PreparedStatement pst;
                try {
                    pst = cnx.prepareStatement(req);
                    pst.setInt(1, result.getInt("id_Product"));
                    ResultSet result1 = pst.executeQuery();
                    while (result1.next()) {
                        ImageView prodimg = new ImageView(new Image(result1.getString("image_prod")));
                        list.add(new CartProd(prodimg, result1.getString("Name_prod"), result1.getString("Prod_Description"), qte, price, result.getInt("id_Cart"), u.getId_User(), result1.getInt("id_Produit")));
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        tableView.setItems(list);
        TotalP.setText(String.valueOf(res));
        EventHandler<ActionEvent> PayB = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/roadrevel/UI/Cart/payment/ConfirmPayemnt.fxml"));
                    Parent parent = loader.load();

                    ConfirmPayemntController controller = (ConfirmPayemntController) loader.getController();
                    System.out.println(res);
                    controller.setData(list,String.valueOf(res));

                    Stage stage = new Stage(StageStyle.DECORATED);
                    stage.setTitle("Edit Member");
                    stage.setScene(new Scene(parent));
                    stage.show();
                    closeStage();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        };
        Paybtn.setOnAction(PayB);
    }

    private void closeStage() {
        ((Stage) Paybtn.getScene().getWindow()).close();
    }

    @FXML
    private void handleRefresh(ActionEvent event) {
        loadData();

    }

    @FXML
    private void handleDelete(ActionEvent event) {
        CartProd selectedForDeletion = tableView.getSelectionModel().getSelectedItem();
        if (selectedForDeletion == null) {
            JOptionPane.showMessageDialog(null, "No Product selected , Please select a Product to remove.");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Deleting Place");
        alert.setContentText("Are you sure want to delete " + selectedForDeletion.getProdName() + " ?");
        Optional<ButtonType> answer = alert.showAndWait();
        if (answer.get() == ButtonType.OK) {
            sp.supprimer(selectedForDeletion);

            list.remove(selectedForDeletion);

        }
    }

    @FXML
    private void HandlePay(ActionEvent event) {
    }

    @FXML
    private void handleViewmore(ActionEvent event) {
    }

}
