package roadrevel.UI.Product.Add_Product;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import roadrevel.entities.Product.Product;
import roadrevel.entities.Product.ServiceProduct;
import roadrevel.resources.AlertMaker;
import roadrevel.resources.Util;

public class AddController implements Initializable {

    @FXML
    private ComboBox<String> ProductStatus;
    @FXML
    private JFXTextField ProductName;
    @FXML
    private JFXTextField ProductType;
    @FXML
    private JFXTextField ProductPrice;
    @FXML
    private JFXTextField ProductQte;
    @FXML
    private JFXButton ProductImg;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton Cancel;
    String res, pi1, Protstatus;
    ServiceProduct sp = new ServiceProduct();
    private Boolean isInEditMode = Boolean.FALSE;
    int id_Product;
    @FXML
    private StackPane rootPane;
    @FXML
    private AnchorPane mainContainer;
    @FXML
    private JFXTextArea ProdDescrp;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ProductStatus.getItems().add("Available");
        ProductStatus.getItems().add("Limited");
        ProductStatus.getItems().add("Currently Unavailable");

    }

    @FXML
    private void HandleAddOperation(ActionEvent event) {
        String Proname = ProductName.getText();
        String prodDescrp = ProdDescrp.getText();

        String Protype = ProductType.getText();
        Double Proprice;
        Double Proqte;
        Protstatus = ProductStatus.getSelectionModel().getSelectedItem();
        EventHandler<MouseEvent> Cfile = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Util u = new Util();
                res = u.ImgPicker();
            }
        };
        ProductImg.setOnMouseClicked(Cfile);
        pi1 = res;

        if (Proname.isEmpty()) {
            AlertMaker.showMaterialDialog(rootPane, mainContainer, new ArrayList<>(), "Insufficient Data", "Please enter Product Name.");
            return;
        }
        if (prodDescrp.isEmpty()) {
            AlertMaker.showMaterialDialog(rootPane, mainContainer, new ArrayList<>(), "Insufficient Data", "Please enter the Product Type.");
            return;
        }
        if (Protype.isEmpty()) {
            AlertMaker.showMaterialDialog(rootPane, mainContainer, new ArrayList<>(), "Insufficient Data", "Please enter the Product Type.");
            return;
        }
        if (ProductPrice.getText().isEmpty()) {
            AlertMaker.showMaterialDialog(rootPane, mainContainer, new ArrayList<>(), "Insufficient Data", "Please enter The Product Price.");
            return;
        } else if (!(ProductPrice.getText().matches("[0-9]+"))) {
            AlertMaker.showMaterialDialog(rootPane, mainContainer, new ArrayList<>(), "Insufficient Data", "Ticket Price Must Be a Number");
            return;
        } else {
            Proprice = Double.parseDouble(ProductPrice.getText());
        }
        if (ProductQte.getText().isEmpty()) {
            AlertMaker.showMaterialDialog(rootPane, mainContainer, new ArrayList<>(), "Insufficient Data", "Please enter the Quantity of the Product.");
            return;
        } else if (!(ProductQte.getText().matches("[0-9]+"))) {
            AlertMaker.showMaterialDialog(rootPane, mainContainer, new ArrayList<>(), "Insufficient Data", "Ticket Price Must Be a Number");
            return;
        } else {
            Proqte = Double.parseDouble(ProductQte.getText());
        }
        if (Protstatus == null) {
            AlertMaker.showMaterialDialog(rootPane, mainContainer, new ArrayList<>(), "Insufficient Data", "Please enter the Product Status.");
            return;
        }

        if (pi1 == null) {
            AlertMaker.showMaterialDialog(rootPane, mainContainer, new ArrayList<>(), "Insufficient Data", "Please enter an Image.");
            return;
        }
        if (isInEditMode) {
            handleEditOperation();
            return;
        }
        Product pv = new Product(Proname,prodDescrp, Protype, Proprice, Proqte, pi1, Protstatus);
        sp.ajouter(pv);
        getStage().close();

    }

    public void inflateUI(Product place) {
        ProductName.setText(place.getName_prod());
        ProductType.setText(place.getType_prod());
        ProductPrice.setText(String.valueOf(place.getProduct_Price()));
        ProductQte.setText(String.valueOf(place.getQte()));
        id_Product = place.getId_Produit();

        isInEditMode = Boolean.TRUE;
    }

    private Stage getStage() {
        return (Stage) mainContainer.getScene().getWindow();
    }


    private void handleEditOperation() {
        Product place = new Product(id_Product, ProductName.getText(),ProdDescrp.getText(), ProductType.getText(), Double.parseDouble(ProductQte.getText()), Double.parseDouble(ProductQte.getText()), pi1, Protstatus);
        sp.modifier(place);
        AlertMaker.showMaterialDialog(rootPane, mainContainer, new ArrayList<>(), "Success", "Update complete");

    }

    public void infalteUI(Product place) {
        ProductName.setText(place.getName_prod());
        ProdDescrp.setText(place.getProdDescrp());
        ProductType.setText(place.getType_prod());
        ProductPrice.setText(String.valueOf(place.getProduct_Price()));
        ProductQte.setText(String.valueOf(place.getQte()));
        id_Product = place.getId_Produit();

        isInEditMode = Boolean.TRUE;
    }

    @FXML
    private void HandleCancelOperation(ActionEvent event) {
                getStage().close();

    }

    @FXML
    private void AddImage(ActionEvent event) {
        Util u = new Util();
        res = u.ImgPicker();
    }

}
