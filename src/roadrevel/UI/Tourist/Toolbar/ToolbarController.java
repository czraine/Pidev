package roadrevel.UI.Tourist.Toolbar;

import roadrevel.UI.Admin.Toolbar.*;
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
        Util.loadWindow(getClass().getResource("/roadrevel/UI/ManagePlaces/ViewPlaces/View_Places.fxml"), "Add New Place", null);
    }

    @FXML
    private void loadSeeReview(ActionEvent event) {
                System.out.println(" See My reviews  ");
        Util.loadWindow(getClass().getResource("/roadrevel/UI/ManagePlaces/SeeReviews/SeeReviews.fxml"), "Add New Place", null);
    }

    @FXML
    private void loadFavourites(ActionEvent event) {
                System.out.println(" See My Favourite places  ");
        Util.loadWindow(getClass().getResource("/roadrevel/UI/ManagePlaces/ViewPlaces/Favs/favs_list.fxml"), "Add New Place", null);
    }

}
