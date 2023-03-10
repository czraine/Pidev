/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadrevel.UI.ProductPane;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import roadrevel.UI.Product.ViewProduct.View_ProductController;
import roadrevel.entities.Product.Product;

import roadrevel.resources.Util;

/**
 * FXML Controller class
 *
 * @author Nasr
 */
public class ProducController {

    @FXML
    private ImageView bkimg;
    @FXML
    private Label placename;
    @FXML
    private Label cname;
    @FXML
    private Label ticketp;
    @FXML
    private ImageView weather;
    @FXML
    private Label temp;
    @FXML
    private JFXButton showM;

    public void setData(Product pv) throws MalformedURLException {
        Image img = new Image(pv.getProduct_img());
        bkimg.setImage(img);
        placename.setText(pv.getName_prod());
        cname.setText(pv.getType_prod());
        ticketp.setText(String.valueOf(pv.getProduct_Price() + " Usd"));

        EventHandler<ActionEvent> Showmore = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/roadrevel/UI/Product/ViewProduct/View_Product.fxml"));
                    Parent parent = loader.load();
                    
                    View_ProductController controller = (View_ProductController) loader.getController();
                    controller.infalteUI(pv);
                    
                    Stage stage = new Stage(StageStyle.DECORATED);
                    stage.setTitle("Edit Member");
                    stage.setScene(new Scene(parent));
                    stage.show();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        };

        showM.setOnAction(Showmore);
    }

 

    @FXML
    private void ShowLess(MouseEvent event) {
        showM.setOpacity(0);
        showM.setDisable(true);
    }

    @FXML
    private void ShowMore(MouseEvent event) {
        showM.setOpacity(1);
        showM.setDisable(false);
    }

}
