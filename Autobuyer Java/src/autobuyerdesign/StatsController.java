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
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Yannick
 */
public class StatsController implements Initializable {

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
    private Label lblLoss;
    @FXML
    private Label lblProfit;
    public int profit = 0;
    static StatsController instance;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        instance = this;
    }

    public static StatsController getInstance() {
        if (instance == null) {
            instance = new StatsController();
        }
        return instance;
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
