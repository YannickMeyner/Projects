/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobuyerdesign;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Yannick
 */
public class SettingsAutobuyerController implements Initializable {

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
    private TextField txtSearchesPerMinute;
    @FXML
    private TextField txtPriceUpdate;
    @FXML
    private TextField txtSleepPeriodTime;
    @FXML
    private TextField txtSleepPeriodWhen;

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
    private void autobuyerSelected(MouseEvent event) {
    }

    @FXML
    private void tradepileSelected(MouseEvent event) {
    }

    @FXML
    private void snipingfilterSelected(MouseEvent event) {
    }

    @FXML
    private void statsSelected(MouseEvent event) {
    }

    @FXML
    private void settingsSelected(MouseEvent event) {
    }

}
