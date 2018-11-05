/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobuyerdesign;

import static autobuyerdesign.Main.instance;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yannick
 */
public class AccountsController implements Initializable {

    @FXML
    private Label lblMail1;
    @FXML
    private Label lblClub1;
    @FXML
    private Label lblProfit1;
    @FXML
    private Label lblMail2;
    @FXML
    private Label lblClub2;
    @FXML
    private Label lblProfit2;
    @FXML
    private Label lblMail3;
    @FXML
    private Label lblClub3;
    @FXML
    private Label lblProfit3;
    @FXML
    private Label lblMail4;
    @FXML
    private Label lblClub4;
    @FXML
    private Label lblProfit4;
    @FXML
    private Label lblMail5;
    @FXML
    private Label lblClub5;
    @FXML
    private Label lblProfit5;
    @FXML
    private Button btnChecked1;
    @FXML
    private Button btnSettings2;
    @FXML
    private Button btnChecked2;
    @FXML
    private Button btnSettings3;
    @FXML
    private Button btnChecked3;
    @FXML
    private Button btnSettings4;
    @FXML
    private Button btnChecked4;
    @FXML
    private Button btnSettings5;
    @FXML
    private Button btnChecked5;
    private ImageView imgHover;
    @FXML
    private Button btnSettings1;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void checkAccountOne(ActionEvent event) throws IOException, InterruptedException {

            Data data = Data.getInstance();
            data.loginEA(event);
            data.progressBar();

    }

    @FXML
    private void checkAccountTwo(ActionEvent event) {
    }

    @FXML
    private void checkAccountThree(ActionEvent event) {
    }

    @FXML
    private void checkAccountFour(ActionEvent event) {
    }

    @FXML
    private void checkAccountFive(ActionEvent event) {
    }

    @FXML
    private void settingsAccountOne(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
        stage = new Stage();
        stage.setTitle("Account 1");
        stage.setScene(new Scene(root));
        stage.show();
    }

}
