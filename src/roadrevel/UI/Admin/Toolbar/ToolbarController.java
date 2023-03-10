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
        Util.loadWindow(getClass().getResource("/roadrevel/UI/ManagePlaces/PlacesList/Place_list.fxml"), "See Places", null);
    }

    @FXML
    private void loadAddPlaces(ActionEvent event) {
        System.out.println(" Add New Places  ");
        Util.loadWindow(getClass().getResource("/roadrevel/UI/ManagePlaces/AddPlace/AddPlace.fxml"), "Add New Place", null);
    }

    @FXML
    private void loadAddProducts(ActionEvent event) {
        Util.loadWindow(getClass().getResource("/roadrevel/UI/Product/Add_Product/Add.fxml"), "Add New Product", null);

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
    private void loadConverter(ActionEvent event) {
        System.out.println(" Convert Money ");
        Util.loadWindow(getClass().getResource("/roadrevel/UI/Converter/Converter.fxml"), "Convert Money", null);
    }

    @FXML
    private void loadAddEvents(ActionEvent event) {
        Util.loadWindow(getClass().getResource("/roadrevel/UI/Events/Ajout/AjouterEvent.fxml"), "Add Events", null);

    }

    @FXML
    private void loadSeeEvents(ActionEvent event) {
        Util.loadWindow(getClass().getResource("/roadrevel/UI/Events/List/Event_list.fxml"), "Load Events", null);

    }

    @FXML
    private void loadSeetourist(ActionEvent event) {
        Util.loadWindow(getClass().getResource("/roadrevel/UI/Tourist/TouristList/tourist_list.fxml"), "Show Tourists", null);

    }

    @FXML
    private void loadSeeGuides(ActionEvent event) {
        Util.loadWindow(getClass().getResource("/roadrevel/UI/Guide/GuideList/Guide_list.fxml"), "Show Guides", null);

    }

    @FXML
    private void loadAddAdmin(ActionEvent event) {
        Util.loadWindow(getClass().getResource("/roadrevel/UI/Admin/AddAdmin/Add.fxml"), "Add Admin", null);

    }

    @FXML
    private void loadSeeReports(ActionEvent event) {
        Util.loadWindow(getClass().getResource("/roadrevel/UI/Reports/List/Report_list.fxml"), "See Reports", null);

    }

    @FXML
    private void loadSeeAdmin(ActionEvent event) {
        Util.loadWindow(getClass().getResource("/roadrevel/UI/Admin/AdminList/Admin_list.fxml"), "See Admin List", null);

    }

}
