/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadrevel.UI.Main.EventsPane;

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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.json.simple.JSONObject;
import roadrevel.UI.Events.view.View_SingleController;
import roadrevel.entities.Events.Events;
import roadrevel.entities.Events.SingleEvent;
import roadrevel.resources.Util;

/**
 * FXML Controller class
 *
 * @author Nasr
 */
public class EventController {

    @FXML
    private ImageView bkimg;
    
    @FXML
    private Label cname;
    @FXML
   
    private JFXButton showM;
    @FXML
    private Label Event_Name;
    @FXML
    private Label Event_Price;
    

    public void setData(Events ev) throws MalformedURLException {
        Image img = new Image(ev.getEventPoster());
        bkimg.setImage(img);
        Event_Name.setText(ev.getEvent_name());
        cname.setText(ev.getCityName());
        Event_Price.setText(String.valueOf(ev.getEventPrice() + " TND"));
        
        EventHandler<ActionEvent> Showmore = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {
                    SingleEvent holder = SingleEvent.getInstance();
                    Events p = holder.getEvent();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/roadrevel/UI/Events/view/View_Single.fxml"));
                    Parent parent = loader.load();
                    
                    View_SingleController controller = (View_SingleController) loader.getController();
                    controller.infalteUI(ev);
                    
                    Stage stage = new Stage(StageStyle.DECORATED);
                    stage.setTitle("Edit Member");
                    stage.setScene(new Scene(parent));
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        showM.setOnAction(Showmore);
    }

    private void ShowmeMore(ActionEvent event) throws IOException {
        SingleEvent holder = SingleEvent.getInstance();
        Events p = holder.getEvent();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/roadrevel/UI/Events/view/View_Single.fxml"));
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
    private void ShowMore(MouseEvent event)  {
        showM.setOpacity(1);
        showM.setDisable(false);
        
        
    }



}
