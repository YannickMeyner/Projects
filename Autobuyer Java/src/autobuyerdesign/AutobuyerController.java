/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobuyerdesign;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
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
import javafx.scene.control.TextArea;
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
public class AutobuyerController implements Initializable {

    @FXML
    public TextArea test;
    static AutobuyerController instance;
    String line;
    public Boolean stopPressed = false;
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
    public Label lblFilterName;
    @FXML
    private Button btnStop;
    @FXML
    public Label lblStatus;
    @FXML
    private Button btnStartBidding;
    @FXML
    private Button btnAdminTool;
    @FXML
    public Label lblTimer;
    @FXML
    public Label lblTimerStatus;
    @FXML
    private Button btnIconTool;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {

            String username = System.getProperty("user.name");
            File fileActive = new File("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filteractive.txt");
            Scanner scanner = new Scanner(fileActive);
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                lblFilterName.setText(line);
            }

            SnipingFilterController snipingcontroller = SnipingFilterController.getInstance();
            snipingcontroller.createFiles();
            snipingcontroller.autoDataSniping();

            instance = this;
            // TODO
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AutobuyerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static AutobuyerController getInstance() {
        if (instance == null) {
            instance = new AutobuyerController();
        }
        return instance;
    }

    @FXML
    private void start(ActionEvent event) throws FileNotFoundException {

        Sniping sniping = Sniping.getInstance();
        //sniping.timer();

        lblStatus.setText("Running");
        stopPressed = false;
        sniping.counter = 1;
        try {

            if (line.equals("Filter 1") || line.equals("Filter 2") || line.equals("Filter 3")) {
                sniping.searchFilter();
            } else {
                sniping.searchPlayer();
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(AutobuyerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void autobuyerSelected(MouseEvent event) {
        lblSettingsSelected.setVisible(false);
        lblAutobuyer.setVisible(false);
        lblAutobuyerSelected.setVisible(true);
        lblSnipingFilterSelected.setVisible(false);
        lblTradePileSelected.setVisible(false);
        lblStatsSelected.setVisible(false);
    }

    @FXML
    private void tradepileSelected(MouseEvent event) throws IOException {

        lblSettingsSelected.setVisible(false);
        lblAutobuyerSelected.setVisible(false);
        lblAutobuyer.setVisible(true);
        lblSnipingFilterSelected.setVisible(false);
        lblTradePileSelected.setVisible(true);
        lblStatsSelected.setVisible(false);

        stopPressed = true;

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("TradePile.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    private void snipingfilterSelected(MouseEvent event) throws IOException {
        lblSettingsSelected.setVisible(false);
        lblAutobuyer.setVisible(true);
        lblAutobuyerSelected.setVisible(false);
        lblSnipingFilterSelected.setVisible(true);
        lblTradePileSelected.setVisible(false);
        lblStatsSelected.setVisible(false);

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("SnipingFilter.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();

    }

    @FXML
    private void statsSelected(MouseEvent event) {
        lblSettingsSelected.setVisible(false);
        lblAutobuyer.setVisible(true);
        lblAutobuyerSelected.setVisible(false);
        lblSnipingFilterSelected.setVisible(false);
        lblTradePileSelected.setVisible(false);
        lblStatsSelected.setVisible(true);

    }

    @FXML
    private void settingsSelected(MouseEvent event) throws IOException {
        lblSettingsSelected.setVisible(true);
        lblAutobuyer.setVisible(true);
        lblAutobuyerSelected.setVisible(false);
        lblSnipingFilterSelected.setVisible(false);
        lblTradePileSelected.setVisible(false);
        lblStatsSelected.setVisible(false);

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("SettingsAutobuyer.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();

    }

    @FXML
    private void stop(ActionEvent event) throws InterruptedException {

        try {

            Sniping sniping = Sniping.getInstance();

            Platform.runLater(new Runnable() {
                @Override
                public void run() {

                    //sniping.setCountdown("300");
                    //lblTimer.setText("5 Minutes");
                    lblStatus.setText("Stopping");

                    stopPressed = true;
                    Data data = Data.getInstance();
                    WebDriverWait wait = new WebDriverWait(data.driver(), 10);

                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[2]/button[1]")));
                    data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[2]/button[1]")).click();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AutobuyerController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/nav/button[3]")));
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AutobuyerController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    data.driver().findElement(By.xpath("/html/body/section/section/nav/button[3]")).click();
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/div/div/div[2]")));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AutobuyerController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/div/div/div[2]")).click();
                    try {
                        Thread.sleep(1000);
//                    try {
//                        data.transfermarket();
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(AutobuyerController.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AutobuyerController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    lblStatus.setText("Not Running");
                    sniping.counter = 1;
                }
            });

        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println(e);
        }

    }

    @FXML
    private void details(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("Details.fxml"));
        stage = new Stage();
        stage.setTitle("Details");
        stage.setScene(new Scene(root));
        stage.show();

    }

    @FXML
    private void startBidding(ActionEvent event) throws FileNotFoundException {

        lblStatus.setText("Running");
        Sniping sniping = Sniping.getInstance();
        stopPressed = false;
        try {

            if (line.equals("Filter 1") || line.equals("Filter 2") || line.equals("Filter 3")) {
                //sniping.searchFilter();
            } else {
                sniping.searchPlayerBidding();
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(AutobuyerController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void admin(ActionEvent event) throws FileNotFoundException {

        lblStatus.setText("Running");
        Sniping sniping = Sniping.getInstance();
        stopPressed = false;
        try {

            sniping.snipePosition();

        } catch (InterruptedException ex) {
            Logger.getLogger(AutobuyerController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void icon(ActionEvent event) throws FileNotFoundException {

        lblStatus.setText("Running");
        Sniping sniping = Sniping.getInstance();
        stopPressed = false;
        try {

            sniping.snipeIcon();

        } catch (InterruptedException ex) {
            Logger.getLogger(AutobuyerController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
