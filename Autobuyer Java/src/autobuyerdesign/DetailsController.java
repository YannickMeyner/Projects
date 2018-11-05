/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobuyerdesign;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Yannick
 */
public class DetailsController implements Initializable {

    @FXML
    private Label lblPlayerName;
    @FXML
    private Label lblBuyPrice;
    @FXML
    private Label lblSellPrice;
    @FXML
    private Label lblPriceUpdate;
    @FXML
    private Label lblPlayer;
    @FXML
    private Label lblBuy;
    @FXML
    private Label lblSell;
    @FXML
    private Label lblUpdate;
    @FXML
    private Label lblClub;
    @FXML
    private Label lblFilterPrice;
    @FXML
    private Label lblFilterClub;
    @FXML
    private Label lblFilterPrice2;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        AutobuyerController autobuyer = AutobuyerController.getInstance();
        // TODO
        String state;
        String username = System.getProperty("user.name");
        String filterLine1;
        String filterLine2;
        String filterLine3;
        String filterLine4;
        String filterLine5;
        String filterLine6;
        String filterLine7;

        switch (autobuyer.lblFilterName.getText()) {
            case "PlayerList 1":
                state = "playerlist1";
                break;
            case "PlayerList 2":
                state = "playerlist2";
                break;
            case "PlayerList 3":
                state = "playerlist3";
                break;
            case "Filter 1":
                state = "filter1";
                break;
            case "Filter 2":
                state = "filter2";
                break;
            case "Filter 3":
                state = "filter3";
                break;
            default:
                state = "none";
                break;
        }

        if (state.contains("filter")) {

            lblClub.setVisible(true);
            lblFilterPrice.setVisible(true);
            lblFilterClub.setVisible(true);
            lblFilterPrice2.setVisible(true);

            try {
                String quality;
                String position;
                String chemistry;
                String nation;
                String club;
                String price;
                File fileRead = new File("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\" + state + ".txt");
                FileReader fr = new FileReader(fileRead);
                BufferedReader br = new BufferedReader(fr);
                filterLine1 = br.readLine();
                quality = br.readLine();
                position = br.readLine();
                chemistry = br.readLine();
                nation = br.readLine();
                club = br.readLine();
                price = br.readLine();
                lblPlayerName.setText(quality);
                lblBuyPrice.setText(position);
                lblSellPrice.setText(chemistry);
                lblPriceUpdate.setText(nation);
                lblFilterClub.setText(club);
                lblFilterPrice2.setText(price);
            } catch (IOException ex) {
            }

            lblPlayer.setText("Quality:");
            lblBuy.setText("Position:");
            lblSell.setText("Chemistry:");
            lblUpdate.setText("Nation:");
            lblClub.setText("Club:");
            lblFilterPrice.setText("Price:");

        } else if (state.contains("playerlist")) {

            lblClub.setVisible(false);
            lblFilterPrice.setVisible(false);
            lblFilterClub.setVisible(false);
            lblFilterPrice2.setVisible(false);

            File fileRead = new File("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\" + state + ".txt");
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
                lblPlayerName.setText(filterLine2);
                lblBuyPrice.setText(filterLine3);
                lblSellPrice.setText(filterLine4);
                lblPriceUpdate.setText(filterLine5);
            } catch (IOException ex) {
            }


        } else {
            System.out.println("rien");
        }

    }

}
