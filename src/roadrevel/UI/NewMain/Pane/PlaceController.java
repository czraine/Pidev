/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadrevel.UI.NewMain.Pane;

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
import org.json.simple.JSONObject;
import roadrevel.UI.ManagePlaces.ViewPlaces.View_SingleController;
import roadrevel.api.Weather;
import roadrevel.entities.PlaceToVisit.PlaceToVisit;
import roadrevel.entities.SinglePlace;
import roadrevel.resources.Util;

/**
 * FXML Controller class
 *
 * @author Nasr
 */
public class PlaceController {

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
    Weather weath = new Weather();

    public void setData(PlaceToVisit pv) throws MalformedURLException {
        Image img = new Image(pv.getPlace_img());
        bkimg.setImage(img);
        placename.setText(pv.getPlace_name());
        cname.setText(pv.getCityname());
        ticketp.setText(String.valueOf(pv.getTickets_Price() + " TND"));
        JSONObject weatherobj = weath.GetTwi(pv.getCityname());
        System.out.println(" talking about weather in genral  " + weatherobj);
        JSONObject tempeture = (JSONObject) weatherobj.get("current");
        temp.setText(String.valueOf(tempeture.get("temp_c")) + "°C");
        JSONObject condition = (JSONObject) tempeture.get("condition");
        System.out.println(" talking about tempture  " + tempeture.get("temp_c"));

        String lin = "/roadrevel/resources" + weath.searchMe((String) condition.get("icon"));
        System.out.println(lin);
        Image wimg = new Image(lin);

        weather.setImage(wimg);
        EventHandler<ActionEvent> Showmore = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {
                    SinglePlace holder = SinglePlace.getInstance();
                    PlaceToVisit p = holder.getPlace();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/roadrevel/UI/ManagePlaces/ViewPlaces/View_Single.fxml"));
                    Parent parent = loader.load();
                    
                    View_SingleController controller = (View_SingleController) loader.getController();
                    controller.infalteUI(pv);
                    
                    Stage stage = new Stage(StageStyle.DECORATED);
                    stage.setTitle("Edit Member");
                    stage.setScene(new Scene(parent));
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(PlaceController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        showM.setOnAction(Showmore);
    }

    private void ShowmeMore(ActionEvent event) throws IOException {
        SinglePlace holder = SinglePlace.getInstance();
        PlaceToVisit p = holder.getPlace();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/roadrevel/UI/ManagePlaces/ViewPlaces/View_Single.fxml"));
        Parent parent = loader.load();

        View_SingleController controller = (View_SingleController) loader.getController();
        controller.infalteUI(p);

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Edit Member");
        stage.setScene(new Scene(parent));
        stage.show();
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
