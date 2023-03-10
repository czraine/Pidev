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
        Util.loadWindow(getClass().getResource("/roadrevel/UI/ManagePlaces/ViewPlaces/Favs/favs_list.fxml"), " My favourites ", null);
    }

    @FXML
    private void loadConverter(ActionEvent event) {
                        System.out.println(" Convert Money ");
        Util.loadWindow(getClass().getResource("/roadrevel/UI/Converter/Converter.fxml"), " Convert Money", null);
    }

    @FXML
    private void loadSeeProducts(ActionEvent event) {
                        Util.loadWindow(getClass().getResource("/roadrevel/UI/Product/ProductList/Product_list.fxml"), "See Products", null);

    }

    @FXML
    private void loadSeeCart(ActionEvent event) {
                        Util.loadWindow(getClass().getResource("/roadrevel/UI/Cart/Cart.fxml"), "My Cart", null);

    }

    @FXML
    private void loadSeePlans(ActionEvent event) {
        
    }

}
