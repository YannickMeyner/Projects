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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * FXML Controller class
 *
 * @author Yannick
 */
public class TradePileController implements Initializable {

    @FXML
    private Label lblAutobuyer;
    @FXML
    private Label lblTradePile;
    @FXML
    private Label lblSnipingFilter;
    @FXML
    private Label lblStats;
    @FXML
    private Label lblAutobuyerSelected;
    @FXML
    private Label lblSnipingFilterSelected;
    @FXML
    private Label lblTradePileSelected;
    @FXML
    private Label lblStatsSelected;
    @FXML
    private Label lblSettings;
    @FXML
    private Label lblSettingsSelected;
    @FXML
    public Label lblNumberPlayers;
    @FXML
    public Label lblListedPlayers;
    @FXML
    public Label lblPlayer1;
    @FXML
    public Label lblPlayer2;
    @FXML
    public Label lblPlayer3;
    @FXML
    public Label lblPlayer4;
    @FXML
    public Label lblPlayer5;
    @FXML
    public Label lblPlayer6;
    @FXML
    public Label lblPlayer7;
    @FXML
    public Label lblPlayer8;
    @FXML
    public Label lblPlayer9;
    @FXML
    public Label lblPlayer10;
    @FXML
    public Label lblPlayer11;
    @FXML
    public Label lblPlayer12;
    @FXML
    public Label lblPlayer13;
    @FXML
    public Label lblPlayer14;
    @FXML
    public Label lblPrice1;
    @FXML
    public Label lblPrice2;
    @FXML
    public Label lblPrice3;
    @FXML
    public Label lblPrice4;
    @FXML
    public Label lblPrice5;
    @FXML
    public Label lblPrice6;
    @FXML
    public Label lblPrice7;
    @FXML
    public Label lblPrice8;
    @FXML
    public Label lblPrice9;
    @FXML
    public Label lblPrice10;
    @FXML
    public Label lblPrice11;
    @FXML
    public Label lblPrice12;
    @FXML
    public Label lblPrice13;
    @FXML
    public Label lblPrice14;
    static TradePileController instance;
    @FXML
    public Label lblPlayerPrize1;
    @FXML
    public Label lblPlayerPrize2;
    @FXML
    public Label lblPlayerPrize3;
    @FXML
    public Label lblPlayerPrize4;
    @FXML
    public Label lblPlayerPrize5;
    @FXML
    public Label lblPlayerPrize6;
    @FXML
    public Label lblPlayerPrize7;
    @FXML
    public Label lblPlayerPrize8;
    @FXML
    public Label lblPlayerPrize9;
    @FXML
    public Label lblPlayerPrize10;
    @FXML
    public Label lblPlayerPrize11;
    @FXML
    public Label lblPlayerPrize12;
    @FXML
    public Label lblPlayerPrize13;
    @FXML
    public Label lblPlayerPrize14;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            instance = this;

            Tradepile tr = Tradepile.getInstance();
            tr.checkItems();

            // TODO
        } catch (InterruptedException | IOException ex) {
            Logger.getLogger(TradePileController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static TradePileController getInstance() {
        if (instance == null) {
            instance = new TradePileController();
        }
        return instance;
    }

    @FXML
    private void autobuyerSelected(MouseEvent event) throws IOException, InterruptedException {

//        try {
//            Data data = Data.getInstance();
//            WebDriverWait wait = new WebDriverWait(data.driver(), 5);
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"footer\"]/button[5]")));
//            Thread.sleep(3000);
//            data.driver().findElement(By.xpath("//*[@id=\"footer\"]/button[5]")).click();
//            data.transfermarket();
//        } catch (org.openqa.selenium.TimeoutException e) {
//            System.out.println(e);
//        }

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Autobuyer.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    private void tradepileSelected(MouseEvent event) {
    }

    @FXML
    private void snipingfilterSelected(MouseEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("SnipingFilter.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    private void statsSelected(MouseEvent event) {
//        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Autobuyer.fxml"));
//        Scene tableViewScene = new Scene(tableViewParent);
//        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        window.setScene(tableViewScene);
//        window.show();
    }

    @FXML
    private void settingsSelected(MouseEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("SettingsAutobuyer.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

}
