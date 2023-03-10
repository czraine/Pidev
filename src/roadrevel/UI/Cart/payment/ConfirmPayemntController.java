/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package roadrevel.UI.Cart.payment;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.HyperlinkLabel;
import org.json.simple.parser.ParseException;
import roadrevel.api.test;
import roadrevel.entities.CartProd;
import roadrevel.resources.AlertMaker;
import roadrevel.resources.Util;

/**
 * FXML Controller class
 *
 * @author Nasr
 */
public class ConfirmPayemntController implements Initializable {

    @FXML
    private JFXButton ConfirmPurchase;
    @FXML
    private JFXTextField ConfimationCode;
    @FXML
    private Hyperlink GetCode;
    String codeC;
    test flapi = new test();
    String codeG;
    String cbase = "https://flouci.com/pay/";
    String amount;
    String cli;
    @FXML
    private StackPane rootPane;
    @FXML
    private AnchorPane contentPane;

    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setData(ObservableList<CartProd> list, String amount) {
        try {
            codeG = String.valueOf(flapi.RandomCodeGenerator());
            String id_pay = flapi.GetCode(amount, codeG);
            String findin = "payment_id";
            String stopf = "success";
            int j = id_pay.indexOf(stopf) - 3;
            int i = id_pay.indexOf(findin);

            if (i > 0) {
                cli = id_pay.substring(i + findin.length() + 3, j);

            } else {
                System.out.println("string not found");
            }
            EventHandler<ActionEvent> GCode = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    try {
                        String url = cbase + cli;
                        try {
                            System.out.println(" amount is  " +amount + " code is " +codeG );
                            Desktop.getDesktop().browse(new URI(url));
                        } catch (IOException ex) {
                            Logger.getLogger(ConfirmPayemntController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (URISyntaxException ex) {
                        Logger.getLogger(ConfirmPayemntController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            GetCode.setOnAction(GCode);
            EventHandler<ActionEvent> Confirm = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    if (ConfimationCode.getText().isEmpty()) {
                        Util.showAlert(Alert.AlertType.ERROR, ((Stage) ConfimationCode.getScene().getWindow()), "Form Error!", "Please enter the Code");
                        return;
                    } else if (!(ConfimationCode.getText().matches("[0-9]+"))) {
                        Util.showAlert(Alert.AlertType.ERROR, ((Stage) ConfimationCode.getScene().getWindow()), "Form Error!", "Please enter Valid Code");
                        return;
                    } else {
                        codeC = ConfimationCode.getText();
                        System.out.println(codeC);
                        if (codeC.equals("0"+codeG)) {
                            List<List> printData = new ArrayList<>();

                            String[] headers = {"   Product Name   ","  Qte  ", "  Product Price  "};
                            printData.add(Arrays.asList(headers));
                            for (CartProd place : list) {
                                List<String> row = new ArrayList<>();
                                row.add(place.getProdName());

                                row.add(String.valueOf(place.getQte()));
                                System.out.println(String.valueOf(place.getQte()));
                                row.add(String.valueOf(place.getPrice()));
                                printData.add(row);
                            }
                            List<String> totalRow = new ArrayList<>();
                            totalRow.add("Total");
                            totalRow.add("");

                            totalRow.add(amount);
                            printData.add(totalRow);
                            Util.initPDFExprot(rootPane, contentPane, getStage(), printData);
                        }
                    }
                }
            };
            ConfirmPurchase.setOnAction(Confirm);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private Stage getStage() {
        return (Stage) ConfimationCode.getScene().getWindow();
    }

    private void exportAsPDF(ObservableList<CartProd> list) {
        List<List> printData = new ArrayList<>();
        String title = "My Receipt ";
        List<String> titleRow = new ArrayList<>();
        titleRow.add(title);
        printData.add(0, titleRow);
        String[] headers = {"   Product Name   ", "   Product Description   ", "  Qte  ", "  Product Price  "};
        printData.add(Arrays.asList(headers));
        for (CartProd place : list) {
            List<String> row = new ArrayList<>();
            row.add(place.getProdName());
            row.add(place.getProdDescrp());
            System.out.println(place.getProdDescrp());
            row.add(String.valueOf(place.getQte()));
            System.out.println(String.valueOf(place.getQte()));
            row.add(String.valueOf(place.getPrice()));
            printData.add(row);
        }
        Util.initPDFExprot(rootPane, contentPane, getStage(), printData);

    }
}
