package roadrevel.UI.Admin.Toolbar;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import roadrevel.resources.Util;


public class ToolbarController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }




    @FXML
    private void loadSeePlaces(ActionEvent event) {
                System.out.println(" See New place  ");
        Util.loadWindow(getClass().getResource("/roadrevel/UI/ManagePlaces/PlacesList/Place_list.fxml"), "Add New Place", null);
    }


    @FXML
    private void loadAddPlaces(ActionEvent event) {
                        System.out.println(" Add New Places  ");
        Util.loadWindow(getClass().getResource("/roadrevel/UI/ManagePlaces/AddPlace/AddPlace.fxml"), "Add New Place", null);
    }



}
