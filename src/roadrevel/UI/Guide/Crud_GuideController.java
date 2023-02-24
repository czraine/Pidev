/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package roadrevel.UI.Guide;

import java.io.IOException;
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
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import roadrevel.entities.SinglePlace;
import roadrevel.resources.Util;

/**
 * FXML Controller class
 *
 * @author Nasr
 */
public class Crud_GuideController implements Initializable {

    @FXML
    private Button btnread;
    @FXML
    private Button AddGuide;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initbtn();
        // TODO
    }    

void initbtn(){

        EventHandler<ActionEvent> GAdd = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {

             Util.loadWindow(getClass().getResource("/roadrevel/UI/Guide/AddGuide/Add.fxml"), "Add New Place", null);

            }
        };
                EventHandler<ActionEvent> Gshow = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {

             Util.loadWindow(getClass().getResource("/roadrevel/UI/Guide/GuideList/Guide_List.fxml"), "Add New Place", null);

            }
        };
        btnread.setOnAction(Gshow);
        AddGuide.setOnAction(GAdd);}

    private void ReadGuide(ActionEvent event) {
                try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("/roadrevel/Guide/GuideList/showGuide.fxml"));
            Parent parent = loader.load();

            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Read Member");
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Crud_GuideController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void AddGuide(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/roadrevel/UI/Guide/AddGuide/Add.fxml"));
            Parent parent = loader.load();

            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Ajouter Member");
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Crud_GuideController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void LoadAdd(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("roadrevel/UI/Guide/GuideList/GuideList.fxml"));
            Parent parent = loader.load();

            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Ajouter Member");
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex) {
            System.out.println((ex.getMessage()));
        }
    }
}
