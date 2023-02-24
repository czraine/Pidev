package roadrevel.UI.Main.Toolbar;

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
    private void loadPlaceTable(ActionEvent event) {
         System.out.println(" Show places List  ");
        Util.loadWindow(getClass().getResource("/roadrevel/UI/ManagePlaces/ViewPlaces/View_Places.fxml"), " Place List ", null);
    }



}
