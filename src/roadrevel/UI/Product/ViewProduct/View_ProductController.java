/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadrevel.UI.Product.ViewProduct;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import roadrevel.entities.CartProduct.Cart;

import roadrevel.entities.CartProduct.ServiceCart;
import roadrevel.entities.Product.Product;
import roadrevel.entities.Product.ServiceProduct;
import roadrevel.entities.SingleUser;
import roadrevel.entities.User.User;

/**
 * FXML Controller class
 *
 * @author Nasr
 */
public class View_ProductController implements Initializable {

    @FXML
    private JFXTextField ProductName;
    @FXML
    private JFXTextField ProductType;
    @FXML
    private JFXTextField ProductPrice;
    @FXML
    private JFXTextField ProductQte;
    @FXML
    private JFXTextArea ProdDescrp;
    @FXML
    private ImageView ProdImage;
    @FXML
    private JFXTextField Status;
    @FXML
    private JFXButton AddToCart;
    @FXML
    private JFXTextField CartQte;
    Double cartQte ;
    ServiceProduct sp = new ServiceProduct();
        ServiceCart sc = new ServiceCart();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void infalteUI(Product pv) {
        SingleUser hold = SingleUser.getInstance();
        User u = hold.getUser();
        ProductName.setText(pv.getName_prod());
                ProductType.setText(pv.getName_prod());
        ProductPrice.setText(String.valueOf(pv.getProduct_Price()));
        ProductQte.setText(String.valueOf(pv.getQte()));
        ProdDescrp.setText(pv.getProdDescrp());
                ProdImage.setImage(new Image(pv.getProduct_img()));
                        Status.setText(pv.getStatus());
        EventHandler<ActionEvent> MCart = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
      cartQte = Double.parseDouble(CartQte.getText());
      sp.modifier(pv.getId_Produit(),pv.getQte()-cartQte);
      sc.ajouter(new Cart(pv.getId_Produit(),u.getId_User(),cartQte,pv.getProduct_Price()*cartQte));
      infalteUI(new Product(pv.getId_Produit(), pv.getName_prod(), pv.getProdDescrp(),pv.getType_prod(), pv.getProduct_Price(),pv.getQte()- cartQte,pv.getProduct_img() , pv.getStatus()));
            }
        };
        AddToCart.setOnAction(MCart);



    }

 
    
}
