/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobuyerdesign;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yannick
 */
public class AccountOverviewController implements Initializable {

    @FXML
    private Label lblCoins;
    @FXML
    private Label lblFifaPoints;
    @FXML
    private Label lblClub;
    static AccountOverviewController instance;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        instance = this;
    }

    @FXML
    private void sniping(ActionEvent event) throws InterruptedException, IOException {

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Autobuyer.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();

    }

    public static AccountOverviewController getInstance() {
        if (instance == null) {
            instance = new AccountOverviewController();
        }
        return instance;
    }

}
