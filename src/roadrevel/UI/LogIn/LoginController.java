    package roadrevel.UI.Login;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import roadrevel.UI.Main.MainPageController;
import roadrevel.UI.Tourist.TouristPageController;
import roadrevel.entities.SingleUser;
import roadrevel.entities.User.ServiceUser;
import roadrevel.entities.User.User;
import roadrevel.resources.Util;




public class LoginController implements Initializable {


    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;



    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    
    private void handleLoginButtonAction(ActionEvent event) throws IOException {
        
        
        
        if (username.getText().isEmpty()) {
            Util.showAlert(Alert.AlertType.ERROR, ((Stage) username.getScene().getWindow()), "Form Error!",
                "Please enter your UserName");
            return;
        }
        if (password.getText().isEmpty()) {
            Util.showAlert(Alert.AlertType.ERROR, ((Stage) username.getScene().getWindow()), "Form Error!","Please enter a password");
            return;
        } 
        String user = username.getText();
        String pswd = password.getText();

        ServiceUser su = new ServiceUser();
        boolean flag = su.validate(user, pswd);
        String role = su.check(user, pswd) ;
        User u = su.GetUser(user, pswd) ;


        if (!flag) {
            infoBox("Please enter correct Email and Password", null, "Failed");
        } else {
            SingleUser hold = SingleUser.getInstance();
                hold.setUser(u);
            System.out.println("/roadrevel/UI/"+role+"/MainPage.fxml");
            Parent parent = FXMLLoader.load((getClass().getResource("/roadrevel/UI/"+role+"/MainPage.fxml")));
            
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("RoadRevel");
            stage.setScene(new Scene(parent , 1445,833));
            stage.show();
            closeStage();
            Util.showAlert(Alert.AlertType.INFORMATION, ((Stage) username.getScene().getWindow()), "Success","Login Sucessful");

        }
    }

    public static void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }
    

    @FXML
    private void handleCancelButtonAction(ActionEvent event) {
        closeStage();
        Util.loadWindow(getClass().getResource("/roadrevel/UI/NewMain/MainPage.fxml"), "Return back to main", null);
    }

    private void closeStage() {
        ((Stage) username.getScene().getWindow()).close();
    }

    void loadMain(String role) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/roadrevel/UI/"+role+"/MainPage.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("RoadRevel");
            stage.setScene(new Scene(parent));
            stage.show();
           
        }
        catch (IOException ex) {
            System.err.println(  ex.getMessage());
        }
    }


}
