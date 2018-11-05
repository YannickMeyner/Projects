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
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author Yannick
 */
public class SnipingFilterController implements Initializable {

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
    private Label lblSnipingFilterSelected1;
    @FXML
    private Label lblSnipingFilterSelected11;
    @FXML
    private ImageView imgQuality;
    @FXML
    private ComboBox<String> comboQuality;
    @FXML
    private ComboBox<String> comboPosition;
    @FXML
    private ImageView imgPosition;
    @FXML
    private ComboBox<String> comboChemistry;
    @FXML
    private ImageView imgChemistry;
    @FXML
    private ComboBox<String> comboNationality;
    @FXML
    private ImageView imgNationality;
    @FXML
    private ComboBox<String> comboClub;
    @FXML
    private ImageView imgClub;
    @FXML
    private Label lblSnipingFilterSelected12;
    @FXML
    private TextField txtSearch;
    @FXML
    private Label lblSnipingFilterSelected121;
    @FXML
    private TextField txtFilterPrize;
    Boolean filterFilled = false;
    String username = System.getProperty("user.name");
    String filterLine1;
    String filterLine2;
    String filterLine3;
    String filterLine4;
    String filterLine5;
    String filterLine6;
    String filterLine7;
    String playerlistLine1;
    String playerlistLine2;
    String playerlistLine3;
    String playerlistLine4;
    String playerlistLine5;
    String playerBuyPrize;
    String playerSellPrize;
    static SnipingFilterController instance;
    @FXML
    private RadioButton radioFilter3;
    @FXML
    private RadioButton radioFilter2;
    @FXML
    private RadioButton radioFilter1;
    @FXML
    private RadioButton radioActive3;
    @FXML
    private RadioButton radioActive2;
    @FXML
    private RadioButton radioActive1;
    @FXML
    private Label lblActive1;
    @FXML
    private Label lblActive2;
    @FXML
    private Label lblActive3;
    @FXML
    private RadioButton radioList3;
    @FXML
    private RadioButton radioList2;
    @FXML
    private RadioButton radioList1;
    @FXML
    private RadioButton radioActive6;
    @FXML
    private RadioButton radioActive5;
    @FXML
    private RadioButton radioActive4;
    @FXML
    private TextField txtBuyNow;
    @FXML
    private TextField txtSellPrize;
    @FXML
    private RadioButton radioUpdateYes;
    @FXML
    private Label lblActive4;
    @FXML
    private Label lblActive5;
    @FXML
    private Label lblActive6;
    @FXML
    private TextField txtNation;
    @FXML
    private RadioButton radioUpdateNo;
    @FXML
    private Label lblProfitRed;
    @FXML
    private Label lblProfitGreen;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        instance = this;

        try {

            username = System.getProperty("user.name");
            File file = new File("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filter1.txt");

            File fileActive = new File("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filteractive.txt");
            Scanner scannerActive = new Scanner(fileActive);
            while (scannerActive.hasNextLine()) {
                String line = scannerActive.nextLine();
                switch (line) {
                    case "Filter 1":
                        radioActive1.setSelected(true);
                        lblActive1.setText("Active");
                        lblActive2.setText("Disabled");
                        lblActive3.setText("Disabled");
                        lblActive4.setText("Disabled");
                        lblActive5.setText("Disabled");
                        lblActive6.setText("Disabled");
                        File fileRead = new File("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filter1.txt");
                        try {
                            FileReader fr = new FileReader(fileRead);
                            BufferedReader br = new BufferedReader(fr);
                            filterLine1 = br.readLine();
                            filterLine2 = br.readLine();
                            filterLine3 = br.readLine();
                            filterLine4 = br.readLine();
                            filterLine5 = br.readLine();
                            filterLine6 = br.readLine();
                            filterLine7 = br.readLine();
                        } catch (IOException ex) {
                        }
                        break;
                    case "Filter 2":
                        radioActive2.setSelected(true);
                        lblActive1.setText("Disabled");
                        lblActive2.setText("Active");
                        lblActive3.setText("Disabled");
                        lblActive4.setText("Disabled");
                        lblActive5.setText("Disabled");
                        lblActive6.setText("Disabled");
                        File fileRead2 = new File("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filter2.txt");
                        try {
                            FileReader fr = new FileReader(fileRead2);
                            BufferedReader br = new BufferedReader(fr);
                            filterLine1 = br.readLine();
                            filterLine2 = br.readLine();
                            filterLine3 = br.readLine();
                            filterLine4 = br.readLine();
                            filterLine5 = br.readLine();
                            filterLine6 = br.readLine();
                            filterLine7 = br.readLine();
                        } catch (IOException ex) {
                        }
                        break;
                    case "Filter 3":
                        radioActive3.setSelected(true);
                        lblActive1.setText("Disabled");
                        lblActive2.setText("Disabled");
                        lblActive3.setText("Active");
                        lblActive4.setText("Disabled");
                        lblActive5.setText("Disabled");
                        lblActive6.setText("Disabled");
                        File fileRead3 = new File("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filter3.txt");
                        try {
                            FileReader fr = new FileReader(fileRead3);
                            BufferedReader br = new BufferedReader(fr);
                            filterLine1 = br.readLine();
                            filterLine2 = br.readLine();
                            filterLine3 = br.readLine();
                            filterLine4 = br.readLine();
                            filterLine5 = br.readLine();
                            filterLine6 = br.readLine();
                            filterLine7 = br.readLine();
                        } catch (IOException ex) {
                        }
                        break;
                    case "PlayerList 1":
                        radioActive4.setSelected(true);
                        lblActive1.setText("Disabled");
                        lblActive2.setText("Disabled");
                        lblActive3.setText("Disabled");
                        lblActive4.setText("Active");
                        lblActive5.setText("Disabled");
                        lblActive6.setText("Disabled");
                        File fileRead4 = new File("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\playerlist1.txt");
                        try {
                            FileReader fr = new FileReader(fileRead4);
                            BufferedReader br = new BufferedReader(fr);
                            playerlistLine1 = br.readLine();
                            playerlistLine2 = br.readLine();
                            playerlistLine3 = br.readLine();
                            playerlistLine4 = br.readLine();
                            playerlistLine5 = br.readLine();
                        } catch (IOException ex) {
                        }
                        break;
                    case "PlayerList 2":
                        radioActive5.setSelected(true);
                        lblActive1.setText("Disabled");
                        lblActive2.setText("Disabled");
                        lblActive3.setText("Disabled");
                        lblActive4.setText("Disabled");
                        lblActive5.setText("Active");
                        lblActive6.setText("Disabled");
                        File fileRead5 = new File("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\playerlist2.txt");
                        try {
                            FileReader fr = new FileReader(fileRead5);
                            BufferedReader br = new BufferedReader(fr);
                            playerlistLine1 = br.readLine();
                            playerlistLine2 = br.readLine();
                            playerlistLine3 = br.readLine();
                            playerlistLine4 = br.readLine();
                            playerlistLine5 = br.readLine();
                        } catch (IOException ex) {
                        }
                        break;
                    case "PlayerList 3":
                        radioActive6.setSelected(true);
                        lblActive1.setText("Disabled");
                        lblActive2.setText("Disabled");
                        lblActive3.setText("Disabled");
                        lblActive4.setText("Disabled");
                        lblActive5.setText("Disabled");
                        lblActive6.setText("Active");
                        File fileRead6 = new File("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\playerlist3.txt");
                        try {
                            FileReader fr = new FileReader(fileRead6);
                            BufferedReader br = new BufferedReader(fr);
                            playerlistLine1 = br.readLine();
                            playerlistLine2 = br.readLine();
                            playerlistLine3 = br.readLine();
                            playerlistLine4 = br.readLine();
                            playerlistLine5 = br.readLine();
                        } catch (IOException ex) {
                        }
                        break;
                    default:
                }
            }

            Nations nations = Nations.getInstance();
            TextFields.bindAutoCompletion(txtNation, nations.nations);

            Players players = Players.getInstance();
            TextFields.bindAutoCompletion(txtSearch, players.allPlayers);
            imgQuality.setVisible(false);
            imgPosition.setVisible(false);
            imgNationality.setVisible(false);
            // TODO
            comboQuality.getItems().addAll("Special", "Gold", "Silver", "Bronze", "None");
            comboQuality.setValue("Special");
            comboQuality.setValue("Gold");
            comboQuality.setValue("Silver");
            comboQuality.setValue("Bronze");
            comboQuality.setValue("None");
            // Position
            comboPosition.getItems().addAll("LW", "ST", "RW", "LF", "CF", "RF", "CAM", "LM", "CM", "RM", "CDM", "LWB", "LB", "CB", "RB", "RWB", "GK", "Attackers", "Midfielders", "Defenders", "None");
            comboPosition.setValue("LW");
            comboPosition.setValue("ST");
            comboPosition.setValue("RW");
            comboPosition.setValue("LF");
            comboPosition.setValue("CF");
            comboPosition.setValue("RF");
            comboPosition.setValue("CAM");
            comboPosition.setValue("LM");
            comboPosition.setValue("CM");
            comboPosition.setValue("RM");
            comboPosition.setValue("CDM");
            comboPosition.setValue("LWB");
            comboPosition.setValue("LB");
            comboPosition.setValue("CB");
            comboPosition.setValue("RB");
            comboPosition.setValue("RWB");
            comboPosition.setValue("GK");
            comboPosition.setValue("Attackers");
            comboPosition.setValue("Midfielders");
            comboPosition.setValue("Defenders");
            comboPosition.setValue("None");
            // Chemistry
            comboChemistry.getItems().addAll("GK Basic", "Glove", "Cat", "Shield", "Wall", "Shadow", "Catalyst", "Hunter", "Anchor", "Backbone", "Gladiator", "Guardian", "Sentinel", "Engine", "Maestro", "Powerhouse", "Architect", "Artist", "Hawk", "Marksman", "Deadeye", "Finisher", "Sniper", "Basic");
            comboChemistry.setValue("GK Basic");
            comboChemistry.setValue("Glove");
            comboChemistry.setValue("Cat");
            comboChemistry.setValue("Shield");
            comboChemistry.setValue("Wall");
            comboChemistry.setValue("Shadow");
            comboChemistry.setValue("Catalyst");
            comboChemistry.setValue("Hunter");
            comboChemistry.setValue("Anchor");
            comboChemistry.setValue("Backbone");
            comboChemistry.setValue("Gladiator");
            comboChemistry.setValue("Guardian");
            comboChemistry.setValue("Sentinel");
            comboChemistry.setValue("Engine");
            comboChemistry.setValue("Maestro");
            comboChemistry.setValue("Powerhouse");
            comboChemistry.setValue("Architect");
            comboChemistry.setValue("Artist");
            comboChemistry.setValue("Hawk");
            comboChemistry.setValue("Marksman");
            comboChemistry.setValue("Deadeye");
            comboChemistry.setValue("Finisher");
            comboChemistry.setValue("Sniper");
            comboChemistry.setValue("Basic");
            // Nations
            comboNationality.getItems().addAll("Argentina", "Austria", "Belgium", "Bosnia", "Brazil", "Cameroon", "Canada", "Chile", "China", "Colombia", "Congo", "Croatia", "Cyprus", "Czech Republic", "Denmark", "Dunai", "Guinea", "Egypt", "England", "Finland", "France", "Germany", "Ghana", "Greece", "Italy", "Ivory Coast", "Japan", "Mexico", "Netherlands", "Norway", "Portugal", "Rumania", "Russia", "Slovakia", "South Korea", "Spain", "Sweden", "Switzerland", "Turkey", "Ukraine", "Uruguay", "USA", "Wales", "None");
            comboNationality.setValue("Wales");
            comboNationality.setValue("USA");
            comboNationality.setValue("Uruguay");
            comboNationality.setValue("Ukraine");
            comboNationality.setValue("Turkey");
            comboNationality.setValue("Switzerland");
            comboNationality.setValue("Sweden");
            comboNationality.setValue("Spain");
            comboNationality.setValue("South Korea");
            comboNationality.setValue("Slovakia");
            comboNationality.setValue("Russia");
            comboNationality.setValue("Rumania");
            comboNationality.setValue("Portugal");
            comboNationality.setValue("Poland");
            comboNationality.setValue("Norway");
            comboNationality.setValue("Netherlands");
            comboNationality.setValue("Mexico");
            comboNationality.setValue("Japan");
            comboNationality.setValue("Ivory Coast");
            comboNationality.setValue("Italy");
            comboNationality.setValue("Greece");
            comboNationality.setValue("Ghana");
            comboNationality.setValue("Germany");
            comboNationality.setValue("France");
            comboNationality.setValue("Finland");
            comboNationality.setValue("England");
            comboNationality.setValue("Egypt");
            comboNationality.setValue("Guinea");
            comboNationality.setValue("Dunai");
            comboNationality.setValue("Denmark");
            comboNationality.setValue("Czech Republic");
            comboNationality.setValue("Cyprus");
            comboNationality.setValue("Croatia");
            comboNationality.setValue("Congo");
            comboNationality.setValue("Colombia");
            comboNationality.setValue("China");
            comboNationality.setValue("Chile");
            comboNationality.setValue("Canada");
            comboNationality.setValue("Cameroon");
            comboNationality.setValue("Brazil");
            comboNationality.setValue("Bosnia");
            comboNationality.setValue("Belgium");
            comboNationality.setValue("Austria");
            comboNationality.setValue("Argentina");
            comboNationality.setValue("None");
            // Clubs
            comboClub.getItems().addAll("None");
            comboClub.setValue("None");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SnipingFilterController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void createFiles() {

        try {

            username = System.getProperty("user.name");
            File directory = new File("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta");

            if (!directory.exists()) {
                directory.mkdir();
            }

            File file = new File("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filter1.txt");
            if (!file.exists()) {
                PrintWriter writer1 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filter1.txt", "UTF-8");
                PrintWriter writer2 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filter2.txt", "UTF-8");
                PrintWriter writer3 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filter3.txt", "UTF-8");
                PrintWriter writer4 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filteractive.txt", "UTF-8");
                PrintWriter writer5 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\playerlist1.txt", "UTF-8");
                PrintWriter writer6 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\playerlist2.txt", "UTF-8");
                PrintWriter writer7 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\playerlist3.txt", "UTF-8");
            }

            File fileActive = new File("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filteractive.txt");
            Scanner scannerActive = new Scanner(fileActive);

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals("")) {
                } else {
                    filterFilled = true;
                }
            }

            if (filterFilled == false) {
                try (PrintWriter writer = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filter1.txt", "UTF-8")) {
                    writer.println("Filter 1");
                    writer.println("None");
                    writer.println("None");
                    writer.println("Basic");
                    writer.println("None");
                    writer.println("None");
                    writer.println("200");
                    writer.close();
                }
                try (PrintWriter writer2 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filter2.txt", "UTF-8")) {
                    writer2.println("Filter 2");
                    writer2.println("None");
                    writer2.println("None");
                    writer2.println("Basic");
                    writer2.println("None");
                    writer2.println("None");
                    writer2.println("200");
                    writer2.close();
                }
                try (PrintWriter writer3 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filter3.txt", "UTF-8")) {
                    writer3.println("Filter 3");
                    writer3.println("None");
                    writer3.println("None");
                    writer3.println("Basic");
                    writer3.println("None");
                    writer3.println("None");
                    writer3.println("200");
                    writer3.close();
                }

                try (PrintWriter writer4 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\playerlist1.txt", "UTF-8")) {
                    writer4.println("PlayerList 1");
                    writer4.println("None");
                    writer4.println("0");
                    writer4.println("0");
                    writer4.println("No");
                    writer4.close();
                }

                try (PrintWriter writer5 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\playerlist2.txt", "UTF-8")) {
                    writer5.println("PlayerList 2");
                    writer5.println("None");
                    writer5.println("0");
                    writer5.println("0");
                    writer5.println("No");
                    writer5.close();
                }

                try (PrintWriter writer6 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\playerlist3.txt", "UTF-8")) {
                    writer6.println("PlayerList 3");
                    writer6.println("None");
                    writer6.println("0");
                    writer6.println("0");
                    writer6.println("No");
                    writer6.close();
                }
            }

        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(SnipingFilterController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static SnipingFilterController getInstance() {
        if (instance == null) {
            instance = new SnipingFilterController();
        }
        return instance;
    }

    @FXML
    private void autobuyerSelected(MouseEvent event) throws IOException {

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Autobuyer.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();

    }

    @FXML
    private void tradepileSelected(MouseEvent event) throws IOException {

        AutobuyerController autobuyer = AutobuyerController.getInstance();
        autobuyer.stopPressed = true;

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("TradePile.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    private void snipingfilterSelected(MouseEvent event) {
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

    @FXML
    private void changeQuality(ActionEvent event) {

        switch (comboQuality.getSelectionModel().getSelectedItem()) {
            case "Bronze":
                imgQuality.setVisible(true);
                imgQuality.setImage(new Image("FifaImages/bronze.png"));
                break;
            case "Silver":
                imgQuality.setVisible(true);
                imgQuality.setImage(new Image("FifaImages/silver.png"));
                break;
            case "Gold":
                imgQuality.setVisible(true);
                imgQuality.setImage(new Image("FifaImages/gold.png"));
                break;
            case "Special":
                imgQuality.setVisible(true);
                imgQuality.setImage(new Image("FifaImages/special.png"));
                break;
            default:
                imgQuality.setVisible(false);
                break;
        }
    }

    @FXML
    private void changePosition(ActionEvent event) {

        switch (comboPosition.getSelectionModel().getSelectedItem()) {
            case "Defenders":
                imgPosition.setVisible(true);
                imgPosition.setImage(new Image("FifaImages/Defenders.png"));
                break;
            case "Midfielders":
                imgPosition.setVisible(true);
                imgPosition.setImage(new Image("FifaImages/Midfielders.png"));
                break;
            case "Attackers":
                imgPosition.setVisible(true);
                imgPosition.setImage(new Image("FifaImages/Attackers.png"));
                break;
            case "GK":
                imgPosition.setVisible(true);
                imgPosition.setImage(new Image("FifaImages/GK.png"));
                break;
            case "RWB":
                imgPosition.setVisible(true);
                imgPosition.setImage(new Image("FifaImages/Defenders.png"));
                break;
            case "RB":
                imgPosition.setVisible(true);
                imgPosition.setImage(new Image("FifaImages/Defenders.png"));
                break;
            case "CB":
                imgPosition.setVisible(true);
                imgPosition.setImage(new Image("FifaImages/Defenders.png"));
                break;
            case "LB":
                imgPosition.setVisible(true);
                imgPosition.setImage(new Image("FifaImages/Defenders.png"));
                break;
            case "LWB":
                imgPosition.setVisible(true);
                imgPosition.setImage(new Image("FifaImages/Defenders.png"));
                break;
            case "CDM":
                imgPosition.setVisible(true);
                imgPosition.setImage(new Image("FifaImages/Midfielders.png"));
                break;
            case "RM":
                imgPosition.setVisible(true);
                imgPosition.setImage(new Image("FifaImages/Midfielders.png"));
                break;
            case "CM":
                imgPosition.setVisible(true);
                imgPosition.setImage(new Image("FifaImages/Midfielders.png"));
                break;
            case "LM":
                imgPosition.setVisible(true);
                imgPosition.setImage(new Image("FifaImages/Midfielders.png"));
                break;
            case "CAM":
                imgPosition.setVisible(true);
                imgPosition.setImage(new Image("FifaImages/Midfielders.png"));
                break;
            case "RF":
                imgPosition.setVisible(true);
                imgPosition.setImage(new Image("FifaImages/Attackers.png"));
                break;
            case "LW":
                imgPosition.setVisible(true);
                imgPosition.setImage(new Image("FifaImages/Attackers.png"));
                break;
            case "ST":
                imgPosition.setVisible(true);
                imgPosition.setImage(new Image("FifaImages/Attackers.png"));
                break;
            case "RW":
                imgPosition.setVisible(true);
                imgPosition.setImage(new Image("FifaImages/Attackers.png"));
                break;
            case "LF":
                imgPosition.setVisible(true);
                imgPosition.setImage(new Image("FifaImages/Attackers.png"));
                break;
            case "CF":
                imgPosition.setVisible(true);
                imgPosition.setImage(new Image("FifaImages/Attackers.png"));
                break;
            default:
                imgPosition.setVisible(false);
                break;
        }

    }

    @FXML
    private void changeChemistry(ActionEvent event) {

        switch (comboChemistry.getSelectionModel().getSelectedItem()) {
            case "Sniper":
                imgChemistry.setVisible(true);
                imgChemistry.setImage(new Image("FifaImages/chem2.png"));
                break;
            case "Finisher":
                imgChemistry.setVisible(true);
                imgChemistry.setImage(new Image("FifaImages/chem2.png"));
                break;
            case "Deadeye":
                imgChemistry.setVisible(true);
                imgChemistry.setImage(new Image("FifaImages/chem2.png"));
                break;
            case "Marksman":
                imgChemistry.setVisible(true);
                imgChemistry.setImage(new Image("FifaImages/chem2.png"));
                break;
            case "Hawk":
                imgChemistry.setVisible(true);
                imgChemistry.setImage(new Image("FifaImages/chem2.png"));
                break;
            case "Artist":
                imgChemistry.setVisible(true);
                imgChemistry.setImage(new Image("FifaImages/chem3.png"));
                break;
            case "Architect":
                imgChemistry.setVisible(true);
                imgChemistry.setImage(new Image("FifaImages/chem3.png"));
                break;
            case "Powerhouse":
                imgChemistry.setVisible(true);
                imgChemistry.setImage(new Image("FifaImages/chem3.png"));
                break;
            case "Maestro":
                imgChemistry.setVisible(true);
                imgChemistry.setImage(new Image("FifaImages/chem3.png"));
                break;
            case "Engine":
                imgChemistry.setVisible(true);
                imgChemistry.setImage(new Image("FifaImages/chem3.png"));
                break;
            case "Sentinel":
                imgChemistry.setVisible(true);
                imgChemistry.setImage(new Image("FifaImages/chem4.png"));
                break;
            case "Guardian":
                imgChemistry.setVisible(true);
                imgChemistry.setImage(new Image("FifaImages/chem4.png"));
                break;
            case "Gladiator":
                imgChemistry.setVisible(true);
                imgChemistry.setImage(new Image("FifaImages/chem4.png"));
                break;
            case "Backbone":
                imgChemistry.setVisible(true);
                imgChemistry.setImage(new Image("FifaImages/chem4.png"));
                break;
            case "Anchor":
                imgChemistry.setVisible(true);
                imgChemistry.setImage(new Image("FifaImages/chem4.png"));
                break;
            case "Hunter":
                imgChemistry.setVisible(true);
                imgChemistry.setImage(new Image("FifaImages/chem5.png"));
                break;
            case "Catalyst":
                imgChemistry.setVisible(true);
                imgChemistry.setImage(new Image("FifaImages/chem5.png"));
                break;
            case "Shadow":
                imgChemistry.setVisible(true);
                imgChemistry.setImage(new Image("FifaImages/chem5.png"));
                break;
            case "Wall":
                imgChemistry.setVisible(true);
                imgChemistry.setImage(new Image("FifaImages/chem6.png"));
                break;
            case "Shield":
                imgChemistry.setVisible(true);
                imgChemistry.setImage(new Image("FifaImages/chem6.png"));
                break;
            case "Cat":
                imgChemistry.setVisible(true);
                imgChemistry.setImage(new Image("FifaImages/chem6.png"));
                break;
            case "Glove":
                imgChemistry.setVisible(true);
                imgChemistry.setImage(new Image("FifaImages/chem6.png"));
                break;
            case "GK Basic":
                imgChemistry.setVisible(true);
                imgChemistry.setImage(new Image("FifaImages/chem6.png"));
                break;
            default:
                imgChemistry.setImage(new Image("FifaImages/chem1.png"));
                break;
        }
    }

    @FXML
    private void changeNationality(ActionEvent event) {

        System.out.println("komisch");
        System.out.println(txtNation.getText());

        switch (txtNation.getText()) {
            case "Argentina":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Argentina.png"));
                break;
            case "Austria":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Austria.png"));
                break;
            case "Belgium":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Belgium.png"));
                break;
            case "Bosnia":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Bosnia.png"));
                break;
            case "Brasilien":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Brazil.png"));
                break;
            case "Cameroon":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Cameroon.png"));
                break;
            case "Canada":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Canada.png"));
                break;
            case "Chile":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Chile.png"));
                break;
            case "China":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/China PR.png"));
                break;
            case "Colombia":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Colombia.png"));
                break;
            case "Congo":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Congo.png"));
                break;
            case "Croatia":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Croatia.png"));
                break;
            case "Cyprus":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Cyprus.png"));
                break;
            case "Czech Republic":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Czech Rep.png"));
                break;
            case "Denmark":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Denmark.png"));
                break;
            case "Dunai":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Dunai Barusslaman.png"));
                break;
            case "Guinea":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Guinea.png"));
                break;
            case "Egypt":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Egypt.png"));
                break;
            case "England":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/England.png"));
                break;
            case "Finland":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Finland.png"));
                break;
            case "France":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/France.png"));
                break;
            case "Germany":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/German.png"));
                break;
            case "Ghana":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Ghana.png"));
                break;
            case "Greece":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Greece.png"));
                break;
            case "Italy":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Italy.png"));
                break;
            case "Ivory Coast":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Ivory Cost.png"));
                break;
            case "Japan":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Japan.png"));
                break;
            case "Mexico":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Mexico.png"));
                break;
            case "Netherlands":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Netherlands.png"));
                break;
            case "Norway":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Norway.png"));
                break;
            case "Poland":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Poland.png"));
                break;
            case "Portugal":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Portugal.png"));
                break;
            case "Rumania":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Rumania.png"));
                break;
            case "Russia":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Russia.png"));
                break;
            case "Slovakia":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Slovakia.png"));
                break;
            case "South Korea":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/South Korea.png"));
                break;
            case "Ukraine":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Ukraine.png"));
                break;
            case "Spain":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Spain.png"));
                break;
            case "Sweden":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Sweden.png"));
                break;
            case "Switzerland":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Switzerland.png"));
                break;
            case "Turkey":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Turkey.png"));
                break;
            case "Uruguay":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Uruguay.png"));
                break;
            case "USA":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/USA.png"));
                break;
            case "Wales":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Wales.png"));
                break;
            default:
                imgNationality.setVisible(false);
                break;
        }
    }

    @FXML
    private void changeClub(ActionEvent event) {

        switch (comboNationality.getSelectionModel().getSelectedItem()) {
            case "None":
                // imgview invsibile
                break;
            default:
            // imgview invsibile
        }

    }

    @FXML
    private void saveFilter(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException, IOException {

        username = System.getProperty("user.name");

        if (radioFilter1.isSelected() == true) {
            try (PrintWriter writer1 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filter1.txt", "UTF-8")) {
                writer1.println("Filter 1");
                writer1.println(comboQuality.getSelectionModel().getSelectedItem());
                writer1.println(comboPosition.getSelectionModel().getSelectedItem());
                writer1.println(comboChemistry.getSelectionModel().getSelectedItem());
                writer1.println(txtNation.getText());
                writer1.println(comboClub.getSelectionModel().getSelectedItem());
                writer1.println(txtFilterPrize.getText());
                writer1.close();
            }
        } else if (radioFilter2.isSelected() == true) {
            try (PrintWriter writer2 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filter2.txt", "UTF-8")) {
                writer2.println("Filter 2");
                writer2.println(comboQuality.getSelectionModel().getSelectedItem());
                writer2.println(comboPosition.getSelectionModel().getSelectedItem());
                writer2.println(comboChemistry.getSelectionModel().getSelectedItem());
                writer2.println(txtNation.getText());
                writer2.println(comboClub.getSelectionModel().getSelectedItem());
                writer2.println(txtFilterPrize.getText());
                writer2.close();
            }
        } else if (radioFilter3.isSelected() == true) {
            try (PrintWriter writer3 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filter3.txt", "UTF-8")) {
                writer3.println("Filter 3");
                writer3.println(comboQuality.getSelectionModel().getSelectedItem());
                writer3.println(comboPosition.getSelectionModel().getSelectedItem());
                writer3.println(comboChemistry.getSelectionModel().getSelectedItem());
                writer3.println(txtNation.getText());
                writer3.println(comboClub.getSelectionModel().getSelectedItem());
                writer3.println(txtFilterPrize.getText());
                writer3.close();
            }
        }

        if (radioActive1.isSelected() == true) {
            try (PrintWriter writer1 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filteractive.txt", "UTF-8")) {
                lblActive1.setText("Active");
                lblActive2.setText("Disabled");
                lblActive3.setText("Disabled");
                writer1.println("Filter 1");
                writer1.close();
            }
        } else if (radioActive2.isSelected() == true) {
            try (PrintWriter writer2 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filteractive.txt", "UTF-8")) {
                lblActive1.setText("Disabled");
                lblActive2.setText("Active");
                lblActive3.setText("Disabled");
                writer2.println("Filter 2");
                writer2.close();
            }
        } else if (radioActive3.isSelected() == true) {
            try (PrintWriter writer3 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filteractive.txt", "UTF-8")) {
                lblActive1.setText("Disabled");
                lblActive2.setText("Disabled");
                lblActive3.setText("Active");
                writer3.println("Filter 3");
                writer3.close();
            }
        }

    }

    @FXML
    private void saveList(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {

        username = System.getProperty("user.name");

        if (txtSearch.getText().equals("") || txtBuyNow.getText().equals("") || txtSellPrize.getText().equals("") || radioUpdateYes.isSelected() == false && radioUpdateNo.isSelected() == false) {

            JOptionPane.showMessageDialog(null, "Please Fill Out All Fields", "Fail", JOptionPane.OK_CANCEL_OPTION);

        } else {

            calculate();
            if (Integer.valueOf(playerBuyPrize) < 300 || Integer.valueOf(playerBuyPrize) > Integer.valueOf(playerSellPrize)) {
                JOptionPane.showMessageDialog(null, "Buy Now Prize Should Be Higher Then 300 And Lower Then Sell Prize", "Fail", JOptionPane.OK_CANCEL_OPTION);
            } else {

                if (radioList1.isSelected() == true) {
                    try (PrintWriter writer1 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\playerlist1.txt", "UTF-8")) {
                        writer1.println("PlayerList 1");
                        writer1.println(txtSearch.getText());
                        writer1.println(txtBuyNow.getText());
                        writer1.println(txtSellPrize.getText());
                        if (radioUpdateYes.isSelected() == true) {
                            writer1.println("Yes");
                        } else {
                            writer1.println("No");
                        }
                        writer1.close();
                    }
                } else if (radioList2.isSelected() == true) {
                    try (PrintWriter writer2 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\playerlist2.txt", "UTF-8")) {
                        writer2.println("PlayerList 2");
                        writer2.println(txtSearch.getText());
                        writer2.println(txtBuyNow.getText());
                        writer2.println(txtSellPrize.getText());
                        if (radioUpdateYes.isSelected() == true) {
                            writer2.println("Yes");
                        } else {
                            writer2.println("No");
                        }
                        writer2.close();
                    }
                } else if (radioList3.isSelected() == true) {
                    try (PrintWriter writer3 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\playerlist3.txt", "UTF-8")) {
                        writer3.println("PlayerList 3");
                        writer3.println(txtSearch.getText());
                        writer3.println(txtBuyNow.getText());
                        writer3.println(txtSellPrize.getText());
                        if (radioUpdateYes.isSelected() == true) {
                            writer3.println("Yes");
                        } else {
                            writer3.println("No");
                        }
                        writer3.close();
                    }
                }

                if (radioActive4.isSelected() == true) {
                    try (PrintWriter writer1 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filteractive.txt", "UTF-8")) {
                        lblActive1.setText("Active");
                        lblActive2.setText("Disabled");
                        lblActive3.setText("Disabled");
                        writer1.println("PlayerList 1");
                        writer1.close();
                    }
                } else if (radioActive5.isSelected() == true) {
                    try (PrintWriter writer2 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filteractive.txt", "UTF-8")) {
                        lblActive1.setText("Disabled");
                        lblActive2.setText("Active");
                        lblActive3.setText("Disabled");
                        writer2.println("PlayerList 2");
                        writer2.close();
                    }
                } else if (radioActive6.isSelected() == true) {
                    try (PrintWriter writer3 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filteractive.txt", "UTF-8")) {
                        lblActive1.setText("Disabled");
                        lblActive2.setText("Disabled");
                        lblActive3.setText("Active");
                        writer3.println("PlayerList 3");
                        writer3.close();
                    }
                }
            }
        }

    }

    @FXML
    private void radioFilterSelect3(ActionEvent event) {
        radioFilter2.setSelected(false);
        radioFilter1.setSelected(false);
    }

    @FXML
    private void radioFilterSelect2(ActionEvent event) {
        radioFilter1.setSelected(false);
        radioFilter3.setSelected(false);
    }

    @FXML
    private void radioFilterSelect1(ActionEvent event) {
        radioFilter2.setSelected(false);
        radioFilter3.setSelected(false);
    }

    @FXML
    private void radioFilterActivate3(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {

        radioActive1.setSelected(false);
        radioActive2.setSelected(false);
        radioActive4.setSelected(false);
        radioActive5.setSelected(false);
        radioActive6.setSelected(false);
        try (PrintWriter writer3 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filteractive.txt", "UTF-8")) {
            lblActive1.setText("Disabled");
            lblActive2.setText("Disabled");
            lblActive3.setText("Active");
            lblActive4.setText("Disabled");
            lblActive5.setText("Disabled");
            lblActive6.setText("Disabled");
            writer3.println("Filter 3");
            writer3.close();
        }

    }

    @FXML
    private void radioFilterActivate2(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {

        radioActive1.setSelected(false);
        radioActive3.setSelected(false);
        radioActive4.setSelected(false);
        radioActive5.setSelected(false);
        radioActive6.setSelected(false);
        try (PrintWriter writer2 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filteractive.txt", "UTF-8")) {
            lblActive1.setText("Disabled");
            lblActive2.setText("Active");
            lblActive3.setText("Disabled");
            lblActive4.setText("Disabled");
            lblActive5.setText("Disabled");
            lblActive6.setText("Disabled");
            writer2.println("Filter 2");
            writer2.close();
        }

    }

    @FXML
    private void radioFilterActivate1(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {

        radioActive2.setSelected(false);
        radioActive3.setSelected(false);
        radioActive4.setSelected(false);
        radioActive5.setSelected(false);
        radioActive6.setSelected(false);
        try (PrintWriter writer1 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filteractive.txt", "UTF-8")) {
            lblActive1.setText("Active");
            lblActive2.setText("Disabled");
            lblActive3.setText("Disabled");
            lblActive4.setText("Disabled");
            lblActive5.setText("Disabled");
            lblActive6.setText("Disabled");
            writer1.println("Filter 1");
            writer1.close();
        }

    }

    @FXML
    private void radioPlayerListSelect3(ActionEvent event) {
        radioList1.setSelected(false);
        radioList2.setSelected(false);
    }

    @FXML
    private void radioPlayerListSelect2(ActionEvent event) {
        radioList1.setSelected(false);
        radioList3.setSelected(false);
    }

    @FXML
    private void radioPlayerListSelect1(ActionEvent event) {
        radioList2.setSelected(false);
        radioList3.setSelected(false);
    }

    @FXML
    private void radioPlayerListActivate3(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {

        radioActive1.setSelected(false);
        radioActive2.setSelected(false);
        radioActive3.setSelected(false);
        radioActive4.setSelected(false);
        radioActive5.setSelected(false);
        try (PrintWriter writer1 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filteractive.txt", "UTF-8")) {
            lblActive1.setText("Disabled");
            lblActive2.setText("Disabled");
            lblActive3.setText("Disabled");
            lblActive4.setText("Disabled");
            lblActive5.setText("Disabled");
            lblActive6.setText("Active");
            writer1.println("PlayerList 3");
            writer1.close();
        }

    }

    @FXML
    private void radioPlayerListActivate2(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {

        radioActive1.setSelected(false);
        radioActive2.setSelected(false);
        radioActive3.setSelected(false);
        radioActive4.setSelected(false);
        radioActive6.setSelected(false);
        try (PrintWriter writer1 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filteractive.txt", "UTF-8")) {
            lblActive1.setText("Disabled");
            lblActive2.setText("Disabled");
            lblActive3.setText("Disabled");
            lblActive4.setText("Disabled");
            lblActive5.setText("Active");
            lblActive6.setText("Disabled");
            writer1.println("PlayerList 2");
            writer1.close();
        }

    }

    @FXML
    private void radioPlayerListActivate1(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {

        radioActive1.setSelected(false);
        radioActive2.setSelected(false);
        radioActive3.setSelected(false);
        radioActive5.setSelected(false);
        radioActive6.setSelected(false);
        try (PrintWriter writer1 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filteractive.txt", "UTF-8")) {
            lblActive1.setText("Disabled");
            lblActive2.setText("Disabled");
            lblActive3.setText("Disabled");
            lblActive4.setText("Active");
            lblActive5.setText("Disabled");
            lblActive6.setText("Disabled");
            writer1.println("PlayerList 1");
            writer1.close();
        }

    }

    public void autoDataSniping() throws FileNotFoundException, FileNotFoundException {
        File fileActive = new File("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filteractive.txt");
        Scanner scannerActive = new Scanner(fileActive);
        while (scannerActive.hasNextLine()) {
            String line = scannerActive.nextLine();
            switch (line) {
                case "Filter 1":
                    File fileRead = new File("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filter1.txt");
                    try {
                        FileReader fr = new FileReader(fileRead);
                        BufferedReader br = new BufferedReader(fr);
                        filterLine1 = br.readLine();
                        filterLine2 = br.readLine();
                        filterLine3 = br.readLine();
                        filterLine4 = br.readLine();
                        filterLine5 = br.readLine();
                        filterLine6 = br.readLine();
                        filterLine7 = br.readLine();
                    } catch (IOException ex) {
                    }
                    break;
                case "Filter 2":
                    File fileRead2 = new File("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filter2.txt");
                    try {
                        FileReader fr = new FileReader(fileRead2);
                        BufferedReader br = new BufferedReader(fr);
                        filterLine1 = br.readLine();
                        filterLine2 = br.readLine();
                        filterLine3 = br.readLine();
                        filterLine4 = br.readLine();
                        filterLine5 = br.readLine();
                        filterLine6 = br.readLine();
                        filterLine7 = br.readLine();
                    } catch (IOException ex) {
                    }
                    break;
                case "Filter 3":
                    File fileRead3 = new File("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filter3.txt");
                    try {
                        FileReader fr = new FileReader(fileRead3);
                        BufferedReader br = new BufferedReader(fr);
                        filterLine1 = br.readLine();
                        filterLine2 = br.readLine();
                        filterLine3 = br.readLine();
                        filterLine4 = br.readLine();
                        filterLine5 = br.readLine();
                        filterLine6 = br.readLine();
                        filterLine7 = br.readLine();
                    } catch (IOException ex) {
                    }
                    break;
                case "PlayerList 1":
                    File fileRead4 = new File("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\playerlist1.txt");
                    try {
                        FileReader fr = new FileReader(fileRead4);
                        BufferedReader br = new BufferedReader(fr);
                        playerlistLine1 = br.readLine();
                        playerlistLine2 = br.readLine();
                        playerlistLine3 = br.readLine();
                        playerlistLine4 = br.readLine();
                        playerlistLine5 = br.readLine();
                    } catch (IOException ex) {
                    }
                    break;
                case "PlayerList 2":
                    File fileRead5 = new File("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\playerlist2.txt");
                    try {
                        FileReader fr = new FileReader(fileRead5);
                        BufferedReader br = new BufferedReader(fr);
                        playerlistLine1 = br.readLine();
                        playerlistLine2 = br.readLine();
                        playerlistLine3 = br.readLine();
                        playerlistLine4 = br.readLine();
                        playerlistLine5 = br.readLine();
                    } catch (IOException ex) {
                    }
                    break;
                case "PlayerList 3":
                    File fileRead6 = new File("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\playerlist3.txt");
                    try {
                        FileReader fr = new FileReader(fileRead6);
                        BufferedReader br = new BufferedReader(fr);
                        playerlistLine1 = br.readLine();
                        playerlistLine2 = br.readLine();
                        playerlistLine3 = br.readLine();
                        playerlistLine4 = br.readLine();
                        playerlistLine5 = br.readLine();
                    } catch (IOException ex) {
                    }
                    break;
            }
        }
    }

    private void testNation(KeyEvent event) {

        System.out.println("komisch");
        System.out.println(txtNation.getText());

        switch (txtNation.getText()) {
            case "Argentina":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Argentina.png"));
                break;
            case "Austria":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Austria.png"));
                break;
            case "Belgium":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Belgium.png"));
                break;
            case "Bosnia":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Bosnia.png"));
                break;
            case "Brasilien":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Brazil.png"));
                break;
            case "Cameroon":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Cameroon.png"));
                break;
            case "Canada":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Canada.png"));
                break;
            case "Chile":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Chile.png"));
                break;
            case "China":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/China PR.png"));
                break;
            case "Colombia":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Colombia.png"));
                break;
            case "Congo":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Congo.png"));
                break;
            case "Croatia":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Croatia.png"));
                break;
            case "Cyprus":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Cyprus.png"));
                break;
            case "Czech Republic":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Czech Rep.png"));
                break;
            case "Denmark":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Denmark.png"));
                break;
            case "Dunai":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Dunai Barusslaman.png"));
                break;
            case "Guinea":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Guinea.png"));
                break;
            case "Egypt":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Egypt.png"));
                break;
            case "England":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/England.png"));
                break;
            case "Finland":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Finland.png"));
                break;
            case "France":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/France.png"));
                break;
            case "Germany":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/German.png"));
                break;
            case "Ghana":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Ghana.png"));
                break;
            case "Greece":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Greece.png"));
                break;
            case "Italy":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Italy.png"));
                break;
            case "Ivory Coast":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Ivory Cost.png"));
                break;
            case "Japan":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Japan.png"));
                break;
            case "Mexico":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Mexico.png"));
                break;
            case "Netherlands":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Netherlands.png"));
                break;
            case "Norway":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Norway.png"));
                break;
            case "Poland":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Poland.png"));
                break;
            case "Portugal":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Portugal.png"));
                break;
            case "Rumania":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Rumania.png"));
                break;
            case "Russia":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Russia.png"));
                break;
            case "Slovakia":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Slovakia.png"));
                break;
            case "South Korea":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/South Korea.png"));
                break;
            case "Ukraine":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Ukraine.png"));
                break;
            case "Spain":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Spain.png"));
                break;
            case "Sweden":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Sweden.png"));
                break;
            case "Switzerland":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Switzerland.png"));
                break;
            case "Turkey":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Turkey.png"));
                break;
            case "Uruguay":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Uruguay.png"));
                break;
            case "USA":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/USA.png"));
                break;
            case "Wales":
                imgNationality.setVisible(true);
                imgNationality.setImage(new Image("Nationalities/Wales.png"));
                break;
            default:
                imgNationality.setVisible(false);
                break;
        }

    }

    private void calculate() {

        if (!txtBuyNow.getText().equals("") && !txtSellPrize.getText().equals("")) {

            playerBuyPrize = txtBuyNow.getText();
            playerSellPrize = txtSellPrize.getText();

            int parseBuyPrize = Integer.valueOf(playerBuyPrize);
            int parseSellPrize = Integer.valueOf(playerSellPrize);

            int profit = (parseSellPrize / 100) * 95 - parseBuyPrize;

            if (profit > 0) {
                lblProfitRed.setVisible(false);
                lblProfitGreen.setVisible(true);
                lblProfitGreen.setText(String.valueOf(profit));
            } else {
                lblProfitGreen.setVisible(false);
                lblProfitRed.setVisible(true);
                lblProfitRed.setText(String.valueOf(profit));
            }

        }

    }

    @FXML
    private void calculateProfit(ActionEvent event) {

        radioUpdateNo.setSelected(false);
        calculate();

    }

    @FXML
    private void calculateProfitNo(ActionEvent event) {

        radioUpdateYes.setSelected(false);
        calculate();

    }

}
