/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobuyerdesign;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Yannick
 */
public class Tradepile {

    int players = 0;
    int listedPlayers = 0;
    Data data = Data.getInstance();
    static Tradepile instance;
    ArrayList<String> ratings = new ArrayList();

    public static Tradepile getInstance() {
        if (instance == null) {
            instance = new Tradepile();
        }
        return instance;
    }

    public void checkItems() throws InterruptedException, IOException {

        TradePileController tradecontroller = TradePileController.getInstance();
        EventQueue.invokeLater(() -> {
            Platform.runLater(() -> {
                try {
                    availablePlayers();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Tradepile.class.getName()).log(Level.SEVERE, null, ex);
                } catch (org.openqa.selenium.TimeoutException ex) {
                    tradecontroller.lblNumberPlayers.setText(String.valueOf(players));
                    try {
                        listedPlayers();
                    } catch (org.openqa.selenium.TimeoutException e) {
                        WebDriverWait wait = new WebDriverWait(data.driver(), 10);
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"header\"]/div[1]/a[1]")));
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex1) {
                            Logger.getLogger(Tradepile.class.getName()).log(Level.SEVERE, null, ex1);
                        }
                        data.driver().findElement(By.xpath("//*[@id=\"header\"]/div[1]/a[1]")).click();
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/article/div[1]")));
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex1) {
                            Logger.getLogger(Tradepile.class.getName()).log(Level.SEVERE, null, ex1);
                        }
                        data.driver().findElement(By.xpath("/html/body/section/article/div[1]")).click();
                        tradecontroller.lblListedPlayers.setText(String.valueOf(listedPlayers));
                    }
                    listedPlayers = 0;
                    players = 0;
                }
            });
        });

    }

    private void availablePlayers() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(data.driver(), (long) 0.001);
        WebDriverWait waitLong = new WebDriverWait(data.driver(), 10);
        //Your GUI code here
        waitLong.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"footer\"]/button[5]")));
        Thread.sleep(500);
        data.driver().findElement(By.xpath("//*[@id=\"footer\"]/button[5]")).click();
        waitLong.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/article/div[2]")));
        Thread.sleep(500);
        data.driver().findElement(By.xpath("/html/body/section/article/div[2]")).click();
        Thread.sleep(1000);
        // 1
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[2]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[3]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[4]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[5]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[6]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[7]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[8]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[9]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[10]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[11]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[12]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[13]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[14]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[15]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[16]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[17]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[18]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[19]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[20]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[21]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[22]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[23]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[24]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[25]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[26]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[27]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[28]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[29]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[30]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[31]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[32]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[33]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[34]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[35]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[36]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[37]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[38]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[39]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[40]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[41]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[42]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[43]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[44]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[45]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[46]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[47]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[48]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[49]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[50]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[51]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[52]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[53]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[54]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[55]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[56]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[57]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[58]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[59]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[60]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[61]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[62]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[63]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[64]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[65]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[66]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[67]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[68]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[69]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[70]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[71]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[72]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[73]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[74]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[75]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[76]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[77]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[78]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[79]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[80]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[81]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[82]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[83]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[84]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[85]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[86]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[87]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[88]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[89]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[90]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[91]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[92]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[93]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[94]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[95]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[96]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[97]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[98]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[99]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[100]")));
        players++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[3]/ul/li[101]")));
        players++;

    }

    private void listedPlayers() {

        TradePileController tradecontroller = TradePileController.getInstance();
        WebDriverWait wait = new WebDriverWait(data.driver(), (long) 0.001);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li")));
        listedPlayers++;
        tradecontroller.lblPlayer1.setVisible(true);
        tradecontroller.lblPrice1.setVisible(true);
        tradecontroller.lblPlayerPrize1.setVisible(true);
        tradecontroller.lblPlayer1.setText(data.driver().findElement(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[1]/div/div[1]/div[2]")).getText());
        tradecontroller.lblPrice1.setText(data.driver().findElement(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[1]/div/div[2]/div[3]/span[2]")).getText());
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[2]")));
        listedPlayers++;
        tradecontroller.lblPlayer2.setVisible(true);
        tradecontroller.lblPrice2.setVisible(true);
        tradecontroller.lblPlayerPrize2.setVisible(true);
        tradecontroller.lblPlayer2.setText(data.driver().findElement(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[2]/div/div[1]/div[2]")).getText());
        tradecontroller.lblPrice2.setText(data.driver().findElement(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[2]/div/div[2]/div[3]/span[2]")).getText());
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[3]")));
        listedPlayers++;
        tradecontroller.lblPlayer3.setVisible(true);
        tradecontroller.lblPrice3.setVisible(true);
        tradecontroller.lblPlayerPrize3.setVisible(true);
        tradecontroller.lblPlayer3.setText(data.driver().findElement(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[3]/div/div[1]/div[2]")).getText());
        tradecontroller.lblPrice3.setText(data.driver().findElement(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[3]/div/div[2]/div[3]/span[2]")).getText());
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[4]")));
        listedPlayers++;
        tradecontroller.lblPlayer4.setVisible(true);
        tradecontroller.lblPrice4.setVisible(true);
        tradecontroller.lblPlayerPrize4.setVisible(true);
        tradecontroller.lblPlayer4.setText(data.driver().findElement(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[4]/div/div[1]/div[2]")).getText());
        tradecontroller.lblPrice4.setText(data.driver().findElement(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[4]/div/div[2]/div[3]/span[2]")).getText());
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[5]")));
        listedPlayers++;
        tradecontroller.lblPlayer5.setVisible(true);
        tradecontroller.lblPrice5.setVisible(true);
        tradecontroller.lblPlayerPrize5.setVisible(true);
        tradecontroller.lblPlayer5.setText(data.driver().findElement(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[5]/div/div[1]/div[2]")).getText());
        tradecontroller.lblPrice5.setText(data.driver().findElement(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[5]/div/div[2]/div[3]/span[2]")).getText());
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[6]")));
        listedPlayers++;
        tradecontroller.lblPlayer6.setVisible(true);
        tradecontroller.lblPrice6.setVisible(true);
        tradecontroller.lblPlayerPrize6.setVisible(true);
        tradecontroller.lblPlayer6.setText(data.driver().findElement(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[6]/div/div[1]/div[2]")).getText());
        tradecontroller.lblPrice6.setText(data.driver().findElement(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[6]/div/div[2]/div[3]/span[2]")).getText());
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[7]")));
        listedPlayers++;
        tradecontroller.lblPlayer7.setVisible(true);
        tradecontroller.lblPrice7.setVisible(true);
        tradecontroller.lblPlayerPrize7.setVisible(true);
        tradecontroller.lblPlayer7.setText(data.driver().findElement(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[7]/div/div[1]/div[2]")).getText());
        tradecontroller.lblPrice7.setText(data.driver().findElement(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[7]/div/div[2]/div[3]/span[2]")).getText());
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[8]")));
        listedPlayers++;
        tradecontroller.lblPlayer8.setVisible(true);
        tradecontroller.lblPrice8.setVisible(true);
        tradecontroller.lblPlayerPrize8.setVisible(true);
        tradecontroller.lblPlayer8.setText(data.driver().findElement(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[8]/div/div[1]/div[2]")).getText());
        tradecontroller.lblPrice8.setText(data.driver().findElement(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[8]/div/div[2]/div[3]/span[2]")).getText());
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[9]")));
        listedPlayers++;
        tradecontroller.lblPlayer9.setVisible(true);
        tradecontroller.lblPrice9.setVisible(true);
        tradecontroller.lblPlayerPrize9.setVisible(true);
        tradecontroller.lblPlayer9.setText(data.driver().findElement(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[9]/div/div[1]/div[2]")).getText());
        tradecontroller.lblPrice9.setText(data.driver().findElement(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[9]/div/div[2]/div[3]/span[2]")).getText());
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[10]")));
        tradecontroller.lblPlayer10.setVisible(true);
        tradecontroller.lblPrice10.setVisible(true);
        tradecontroller.lblPlayerPrize10.setVisible(true);
        listedPlayers++;
        tradecontroller.lblPlayer10.setText(data.driver().findElement(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[10]/div/div[1]/div[2]")).getText());
        tradecontroller.lblPrice10.setText(data.driver().findElement(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[10]/div/div[2]/div[3]/span[2]")).getText());
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[11]")));
        tradecontroller.lblPlayer11.setVisible(true);
        tradecontroller.lblPrice11.setVisible(true);
        tradecontroller.lblPlayerPrize11.setVisible(true);
        listedPlayers++;
        tradecontroller.lblPlayer11.setText(data.driver().findElement(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[11]/div/div[1]/div[2]")).getText());
        tradecontroller.lblPrice11.setText(data.driver().findElement(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[11]/div/div[2]/div[3]/span[2]")).getText());
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[12]")));
        tradecontroller.lblPlayer12.setVisible(true);
        tradecontroller.lblPrice12.setVisible(true);
        tradecontroller.lblPlayerPrize12.setVisible(true);
        listedPlayers++;
        tradecontroller.lblPlayer12.setText(data.driver().findElement(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[12]/div/div[1]/div[2]")).getText());
        tradecontroller.lblPrice12.setText(data.driver().findElement(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[12]/div/div[2]/div[3]/span[2]")).getText());
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[13]")));
        tradecontroller.lblPlayer13.setVisible(true);
        tradecontroller.lblPrice13.setVisible(true);
        tradecontroller.lblPlayerPrize13.setVisible(true);
        listedPlayers++;
        tradecontroller.lblPlayer13.setText(data.driver().findElement(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[13]/div/div[1]/div[2]")).getText());
        tradecontroller.lblPrice13.setText(data.driver().findElement(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[13]/div/div[2]/div[3]/span[2]")).getText());
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[14]")));
        tradecontroller.lblPlayer14.setVisible(true);
        tradecontroller.lblPrice14.setVisible(true);
        tradecontroller.lblPlayerPrize14.setVisible(true);
        listedPlayers++;
        tradecontroller.lblPlayer14.setText(data.driver().findElement(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[14]/div/div[1]/div[2]")).getText());
        tradecontroller.lblPrice14.setText(data.driver().findElement(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[14]/div/div[2]/div[3]/span[2]")).getText());
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[15]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[16]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[17]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[18]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[19]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[20]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[21]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[22]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[23]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[24]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[25]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[26]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[27]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[28]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[29]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[30]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[31]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[32]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[33]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[34]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[35]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[36]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[37]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[38]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[39]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[40]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[41]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[42]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[43]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[44]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[45]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[46]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[47]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[48]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[49]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[50]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[51]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[52]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[53]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[54]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[55]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[56]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[57]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[58]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[59]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[60]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[61]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[62]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[63]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[64]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[65]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[66]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[67]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[68]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[69]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[70]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[71]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[72]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[73]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[74]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[75]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[76]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[77]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[78]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[79]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[80]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[81]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[82]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[83]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[84]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[85]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[86]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[87]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[88]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[89]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[90]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[91]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[92]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[93]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[94]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[95]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[96]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[97]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[98]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[99]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[100]")));
        listedPlayers++;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"TradePile\"]/section[4]/ul/li[101]")));
        listedPlayers++;

    }

}