package roadrevel.UI.Converter;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.RotateTransition;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.json.simple.parser.ParseException;
import roadrevel.api.CurrencyConverter;

public class ConverterController implements Initializable {

    CurrencyConverter prc = new CurrencyConverter();
    @FXML
    private Button btnConvert;

    @FXML
    private ComboBox<String> drpFrom;

    @FXML
    private ComboBox<String> drpTo;

    @FXML
    private TextField inpAmount;

    @FXML
    private VBox outVbox;

    @FXML
    private Label fromOut;

    @FXML
    private Label toOut;

    @FXML
    private Button btnSwap;

    @FXML
    private Text exchRate;

    @FXML
    private ImageView loader;

    @FXML
    private AnchorPane root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

            List<String> currList = prc.SymbolList();
            drpFrom.getItems().addAll(currList);
            drpTo.getItems().add("TND");
            outVbox.setVisible(false);
            loader.setVisible(false);
            root.setDisable(false);
        } catch (IOException ex) {
            Logger.getLogger(ConverterController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ConverterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void convert(ActionEvent actionEvent) throws IOException, MalformedURLException, ParseException {
        boolean isAmountOk = false, isFromCurrOk = false, isToCurrOk = false;

        if (isValidToCurr()) {
            isAmountOk = true;
        } else {
            isAmountOk = false;
            System.out.println("please where to convert ");

        }

        if (isValidFromCurr()) {
            isFromCurrOk = true;
        } else {
            isFromCurrOk = false;
            System.out.println("please from where to convert ");

        }

        if (isValidAmountData()) {
            isToCurrOk = true;
        } else {
            isToCurrOk = false;
            System.out.println("please put amount ");
        }

        if (isAmountOk && isFromCurrOk && isToCurrOk) {
            loader.setVisible(true);
            outVbox.setVisible(false);
            root.setDisable(true);

            Double amnt = Double.parseDouble(inpAmount.getText());
            String Cfrom = drpFrom.getSelectionModel().getSelectedItem();
            String Cto = drpTo.getSelectionModel().getSelectedItem();
            Double res = prc.converti(Cfrom, Cto, amnt);

            loader.setVisible(false);
            outVbox.setVisible(true);
            root.setDisable(false);
            fromOut.setText(amnt + " " + Cfrom + " =");
            System.out.println(amnt + " " + Cfrom + " =");
            toOut.setText(res + Cto);

        }
    }

    public boolean isValidAmountData() {
        boolean isValid = false;
        if (!inpAmount.getText().equals("")) {
            try {
                Double.parseDouble(inpAmount.getText());
                isValid = true;
            } catch (Exception e) {
                inpAmount.requestFocus();
                isValid = false;
            }
        } else {
            inpAmount.requestFocus();
            isValid = false;
        }
        return isValid;
    }

    public boolean isValidFromCurr() {
        boolean isValid = false;
        if (drpFrom.getSelectionModel().getSelectedItem() != null) {
            isValid = true;
        } else {
            drpFrom.requestFocus();
        }
        return isValid;
    }

    public boolean isValidToCurr() {
        boolean isValid = false;
        if (drpTo.getSelectionModel().getSelectedItem() != null) {
            isValid = true;
        } else {
            drpTo.requestFocus();
        }
        return isValid;
    }
}
