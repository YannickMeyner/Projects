/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobuyerdesign;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Yannick
 */
public class Sniping {

    Data data = Data.getInstance();
    WebDriver driver;
    WebDriver returnDriver;
    Integer startTime = 0;
    Integer seconds = startTime;
    final Timeline timer = new Timeline();
    Boolean loggedIn = false;
    String cheapestPrice;
    String searchPlayer = "Willian";
    Boolean findPrice;
    Boolean findPrice2;
    String finalSnipingPrice;
    String sellPrice;
    Boolean timeOut = false;
    static Sniping instance;
    String line;
    SnipingFilterController snipingcontroller = SnipingFilterController.getInstance();
    AutobuyerController autobuyer = AutobuyerController.getInstance();
    StatsController stats = StatsController.getInstance();
    public int counter = 1;
    int aktuellesGebotConverted;
    int eigeneCoinsConverted;
    int endgebot = 0;
    boolean biddingPossible = false;
    int anzahlSpieler = 0;
    boolean höchstbietender = false;
    Integer countdownGameInt = 480;
    Integer countdownGameInt2 = 480;
    final Timeline countdown = new Timeline();
    final Timeline countdown2 = new Timeline();
    public Boolean pause = false;

    public static Sniping getInstance() {
        if (instance == null) {
            instance = new Sniping();
        }
        return instance;
    }

    private void checkActive() throws FileNotFoundException {
        String username = System.getProperty("user.name");
        File fileActive = new File("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\filteractive.txt");
        Scanner scanner = new Scanner(fileActive);
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
        }
    }

    private void loadingScreenLogin() throws InterruptedException {

        Boolean ladeBildschirm = true;
        while (ladeBildschirm == true) {
            try {
                if (data.driver().findElement(By.xpath("//*[@id=\"ClickShield\"]/img")).isDisplayed() == true) {
                } else {
                    Thread.sleep(1500);
                    break;
                }
            } catch (org.openqa.selenium.NoSuchElementException e) {
                System.out.println(e);
            }
        }

    }

    public void searchPlayer() throws InterruptedException, FileNotFoundException {

        snipingcontroller.autoDataSniping();

        WebDriverWait wait = new WebDriverWait(data.driver(), 20);
        loadingScreenLogin();
        try {
            // Spielernameeingabe anklicken
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[1]/div/input")));
            data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[1]/div/input")).click();
            // Spielernamen eingeben
            Thread.sleep(100);
            data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[1]/div/input")).sendKeys(snipingcontroller.playerlistLine2);
            // Warten bis Spieler angezeigt wird
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[1]/div/div/ul/button[1]")));
            data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[1]/div/div/ul/button[1]")).click();
            snipePlayer();
        } catch (org.openqa.selenium.TimeoutException ex) {
            System.out.println(ex);
        }

    }

    public void searchPlayerBidding() throws InterruptedException, FileNotFoundException {

        snipingcontroller.autoDataSniping();

        WebDriverWait wait = new WebDriverWait(data.driver(), 20);
        loadingScreenLogin();
        try {
            // Spielernameeingabe anklicken
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[1]/div/input")));
            data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[1]/div/input")).click();
            // Spielernamen eingeben
            Thread.sleep(100);
            data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[1]/div/input")).sendKeys(snipingcontroller.playerlistLine2);
            // Warten bis Spieler angezeigt wird
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[1]/div/div/ul/button[1]")));
            data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[1]/div/div/ul/button[1]")).click();
            bidding();
        } catch (org.openqa.selenium.TimeoutException ex) {
            System.out.println(ex);
        }

    }

    public void searchFilter() throws InterruptedException, FileNotFoundException {

        WebDriverWait wait = new WebDriverWait(data.driver(), 20);
        loadingScreenLogin();
        try {
            Thread.sleep(1000);
            // Quality anklicken
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[2]")));
            data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[2]")).click();
            Thread.sleep(200);
            // Quality auswählen
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[2]/div/ul/li[4]")));
            data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[2]/div/ul/li[4]")).click();
            Thread.sleep(200);
            // Position anklicken
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[3]")));
            data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[3]")).click();
            Thread.sleep(200);
            // Position auswählen
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[3]/div/ul/li[20]")));
            data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[3]/div/ul/li[20]")).click();
            Thread.sleep(200);
            // Chemistry anklicken
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[4]")));
            data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[4]")).click();
            Thread.sleep(200);
            // Chemistry auswählen
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[4]/div/ul/li[18]")));
            data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[4]/div/ul/li[18]")).click();
            Thread.sleep(200);
            // Liga Button klicken
            //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[6]/div")));
            //data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[6]/div")).click();
            // Liga eingeben
            //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/article/div[1]/div[2]/div/div[2]/div[1]/div[6]/div/ul/li[39]")));
            //data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[6]/div/ul/li[10]")).click();
            // Club Button klicken
            //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[7]/div/div")));
            //data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[7]/div/div")).click();
            // Klub eingeben
            //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[7]/div/ul/li[7]")));
            //data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[7]/div/ul/li[7]")).click();
            loadingScreenLogin();
            // Nation eingeben
            snipingcontroller.autoDataSniping();
            String nation = snipingcontroller.filterLine5;

            switch (nation) {
                case "Argentinien":
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/article/div[1]/div[2]/div/div[2]/div[1]/div[5]/div")));
                    data.driver().findElement(By.xpath("/html/body/section/article/div[1]/div[2]/div/div[2]/div[1]/div[7]/div/ul/li[2]")).click();
                    break;
                case "Brasilien":
                    break;
                case "England":
                    break;
                case "Frankreich":
                    break;
                case "Deutschland":
                    break;
                case "Niederlande":
                    break;
                case "Italien":
                    break;
                case "Portugal":
                    break;
                case "Spanien":
                    break;
                case "Ä Guinea":
                    break;
                case "Afghanistan":
                    break;
                case "Ägypten":
                    break;
                case "Albanien":
                    break;
                case "Algerien":
                    break;
                case "Angola":
                    break;
                case "Antig & B":
                    break;
                case "Armenien":
                    break;
                case "Aserbaid":
                    break;
                case "Äthiopien":
                    break;
                case "Australien":
                    break;
                case "Barbados":
                    break;
                case "Belgien":
                    break;
                case "Belize":
                    break;
                case "Benin":
                    break;
                case "Bermuda":
                    break;
                case "Bolivien":
                    break;
                case "Bosnien H":
                    break;
                case "Brunei D":
                    break;
                case "Bulgarien":
                    break;
                case "Burk Faso":
                    break;
                case "Burundi":
                    break;
                case "Chile":
                    break;
                case "China VR":
                    break;
                case "Costa Rica":
                    break;
                case "CTA":
                    break;
                case "Dänemark":
                    break;
                case "Dom Rep":
                    break;
                case "DR Kongo":
                    break;
                case "Ecuador":
                    break;
                case "Elfenbeinküste":
                    break;
                case "Eritrea":
                    break;
                case "Estland":
                    break;
                case "Färöer":
                    break;
                case "Fidschi":
                    break;
                case "Finnland":
                    break;
                case "Gabun":
                    break;
                case "Gambia":
                    break;
                case "Georgien":
                    break;
                case "Ghana":
                    break;
                case "Gibraltar":
                    break;
                case "Greneda":
                    break;
                case "Griechenland":
                    break;
                case "Guam":
                    break;
                case "Guatamale":
                    break;
                case "Guinea":
                    break;
                case "Guinea B":
                    break;
                case "Guyana":
                    break;
                case "Haiti":
                    break;
                case "Honduras":
                    break;
                case "Hongkong":
                    break;
                case "Irak":
                    break;
                case "Irland":
                    break;
                case "Island":
                    break;
                case "Israel":
                    break;
                case "Jamaika":
                    break;
                case "Japan":
                    break;
                case "Kamerun":
                    break;
                case "Kanada":
                    break;
                case "Kap Verde":
                    break;
                case "Kasachstan":
                    break;
                case "Katar":
                    break;
                case "Kenia":
                    break;
                case "Kirgisistan":
                    break;
                case "Kolumbien":
                    break;
                case "Komoren":
                    break;
                case "Kongo":
                    break;
                case "Korea DVR":
                    break;
                case "Korea Rep":
                    break;
                case "Kosovo":
                    break;
                case "Kroatien":
                    break;
                case "Kuba":
                    break;
                case "Kuwait":
                    break;
                case "Lettland":
                    break;
                case "Libanon":
                    break;
                case "Liberia":
                    break;
                case "Libyen":
                    break;
                case "Liechtenstein":
                    break;
                case "Litauen":
                    break;
                case "Luxemburg":
                    break;
                case "Madagaskar":
                    break;
                case "Mali":
                    break;
                case "Malta":
                    break;
                case "Marokko":
                    break;
                case "Mauretanien":
                    break;
                case "Mauritius":
                    break;
                case "Mazedonien":
                    break;
                case "Mexiko":
                    break;
                case "Moldawien":
                    break;
                case "Montenegro":
                    break;
                case "Montserrat":
                    break;
                case "Mosambik":
                    break;
                case "N. Antillen":
                    break;
                case "Namibia":
                    break;
                case "Neukaled":
                    break;
                case "Neuseeland":
                    break;
                case "Niger":
                    break;
                case "Nigeria":
                    break;
                case "Nordirland":
                    break;
                case "Norwegen":
                    break;
                case "Oman":
                    break;
                case "Österreich":
                    break;
                case "Palästina":
                    break;
                case "Panama":
                    break;
                case "Paraguay":
                    break;
                case "Peru":
                    break;
                case "Philippinen":
                    break;
                case "Polen":
                    break;
                case "Puerto Rico":
                    break;
                case "Rumänien":
                    break;
                case "Russland":
                    break;
                case "S.-Afrika":
                    break;
                case "Sambia":
                    break;
                case "San Marino":
                    break;
                case "Saudi-.A":
                    break;
                case "Schottland":
                    break;
                case "Schweden":
                    break;
                case "Schweiz":
                    break;
                case "Senegal":
                    break;
                case "Serbien":
                    break;
                case "Sierra L.":
                    break;
                case "Simbabwe":
                    break;
                case "Slowakei":
                    break;
                case "Slowenien":
                    break;
                case "Somalia":
                    break;
                case "Sri Lanka":
                    break;
                case "St. Kittis":
                    break;
                case "St. Lucia":
                    break;
                case "Sudan":
                    break;
                case "Suriname":
                    break;
                case "Syrien":
                    break;
                case "Tansania":
                    break;
                case "Thailand":
                    break;
                case "Togo":
                    break;
                case "Trinidad":
                    break;
                case "Tschad":
                    break;
                case "Tschechien":
                    break;
                case "Tunesien":
                    break;
                case "Türkei":
                    break;
                case "Turkmenistan":
                    break;
                case "Uganda":
                    break;
                case "Ukraine":
                    break;
                case "Ungarn":
                    break;
                case "Uruguay":
                    break;
                case "USA":
                    break;
                case "Usbekistan":
                    break;
                case "Venezuela":
                    break;
                case "Vietnam":
                    break;
                case "Wales":
                    break;
                case "Weissrussland":
                    break;
                case "Zypern":
                    break;
                default:
                    break;
            }

            snipePlayer();
        } catch (org.openqa.selenium.TimeoutException ex) {
            System.out.println(ex);
        }

    }

    public void timer() {

        countdownGameInt2 = 20;

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                // Timer CountDown
                KeyFrame countdownGame = new KeyFrame(javafx.util.Duration.seconds(1), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        countdownGameInt--;

                        final int min = countdownGameInt / 60;
                        final int sec = countdownGameInt - (min * 60);

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                autobuyer.lblTimer.setText(String.valueOf(min) + " Minutes" + " " + String.valueOf(sec) + " Seconds");
                            }
                        });

                        if (countdownGameInt == 0) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    pause = true;
                                    //timer2();
                                    autobuyer.lblStatus.setText("Break");
                                    countdown.stop();
                                }
                            });
                        }

                    }
                });

                countdown.setCycleCount(Timeline.INDEFINITE);
                countdown.getKeyFrames().add(countdownGame);
                countdown.play();

            }
        });

    }

    private void timer2() {

        countdownGameInt = 20;

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                // Timer CountDown
                KeyFrame countdownGame2 = new KeyFrame(javafx.util.Duration.seconds(1), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        countdownGameInt2--;

                        final int min2 = countdownGameInt2 / 60;
                        final int sec2 = countdownGameInt2 - (min2 * 60);

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                autobuyer.lblTimerStatus.setText("Time till start: ");
                                autobuyer.lblTimer.setText(String.valueOf(min2) + " Minutes" + " " + String.valueOf(sec2) + " Seconds");
                            }
                        });

                        if (countdownGameInt2 == 0) {

                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    pause = false;
                                    timer();
                                    try {
                                        snipePlayer();
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(Sniping.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (FileNotFoundException ex) {
                                        Logger.getLogger(Sniping.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    autobuyer.lblStatus.setText("Running");

                                }

                            });

                        }
                    }
                });

                countdown2.setCycleCount(Timeline.INDEFINITE);
                countdown2.getKeyFrames().add(countdownGame2);
                countdown2.play();

            }
        });

    }

    private void snipePlayer() throws InterruptedException, FileNotFoundException {

        checkActive();

        WebDriverWait wait = new WebDriverWait(data.driver(), 3600);

        // Test Spezial einstellen
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[2]/div")));
        data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[2]/div/div")).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[2]/div/ul/li[5]")));
        data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[2]/div/ul/li[5]")).click();
        Thread.sleep(500);
        // Preiseingabe Sofortkauf Max
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[2]/div[6]/div[2]/div/input")));
        data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[2]/div[6]/div[2]/div/input")).click();
        if (line.equals("Filter 1") || line.equals("Filter 2") || line.equals("Filter 3")) {
            Thread.sleep(200);
            // Sofortkauf eingabe
            data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[2]/div[6]/div[2]/div/input")).sendKeys(snipingcontroller.filterLine7);
            Thread.sleep(500);
        } else {
            Thread.sleep(200);
            // Sofortkauf eingabe
            data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[2]/div[6]/div[2]/div/input")).sendKeys(snipingcontroller.playerlistLine3);
            Thread.sleep(500);
        }

        final Boolean textAreaStart = true;
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                Boolean sniping = true;
                while (sniping == true) {

                    if (pause == true) {
                        return;
                    }

                    if (autobuyer.stopPressed == true) {
                        return;
                    }

                    try {

                        counter++;
                        if (counter % 2 == 0) {
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[2]/div[2]/div[2]/button[2]")));
                            data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[2]/div[2]/div[2]/button[2]")).click();
                        } else {
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[2]/div[2]/div[2]/button[1]")));
                            data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[2]/div[2]/div[2]/button[1]")).click();
                        }

                        // Search Button
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[2]/button[2]")));
                        data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[2]/button[2]")).click();
                        // Überprüfen ob Spieler gefunden oder nicht, oben = nicht gefunden, unten = nicht gefunden
                        wait.until(ExpectedConditions.or(
                                ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/section/section/div[2]/section/div/section/div/div[3]/div/h2")),
                                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li")),
                                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[1]"))));
                        if (data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section/div/div[3]/div/h2")).isDisplayed() == true) {
                            System.out.println("no player found");
                            autobuyer.test.setText(autobuyer.test.getText() + "\n" + "No Player Found");
                            autobuyer.test.appendText("");
                            autobuyer.test.setScrollTop(Double.MAX_VALUE);
                            // Zurück zum Transfermarket Button
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[1]/button[1]")));
                            data.driver().findElement(By.xpath("/html/body/section/section/section/div[1]/button[1]")).click();
                            Thread.sleep(500);
                        } else {
                            System.out.println("spieler gfunde 1");
                            autobuyer.test.setText(autobuyer.test.getText() + "\n" + "Player Found");
                            autobuyer.test.appendText("");
                            autobuyer.test.setScrollTop(Double.MAX_VALUE);
                        }
                    } catch (org.openqa.selenium.NoSuchElementException e) {
                        System.out.println("spieler gfunde 2");
                        autobuyer.test.setText(autobuyer.test.getText() + "\n" + "Player Found");
                        autobuyer.test.appendText("");
                        autobuyer.test.setScrollTop(Double.MAX_VALUE);

                        try {
                            // Buy Now Button
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[2]/button[2]")));
                            data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[2]/button[2]")).click();
                            // Buy Now OK Button
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section/div/footer/button[2]")));
                            data.driver().findElement(By.xpath("/html/body/div[1]/section/div/footer/button[2]")).click();

                            // Überprüefe ob Spieler kauft --> mit quick sell button (wenn de innerhalb vo 2 sekunde azeigt wird isch er kauft wurde sust ned)
                            Thread.sleep(2000);
                            if (data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[3]/button[9]")).isDisplayed() == true) {
                                System.out.println("spieler kauft");
                                //int playerboughtFor = Integer.valueOf(data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[1]/div/div/span[2]")).getText());
                                //stats.profit -= playerboughtFor;
                                autobuyer.test.setText(autobuyer.test.getText() + "\n" + "Player " + data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[1]/div/div[1]/div[2]")).getText() + " Bought for " + data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[1]/div/div[2]/div[3]/span[2]")).getText() + " coins");
                                autobuyer.test.appendText("");
                                autobuyer.test.setScrollTop(Double.MAX_VALUE);
                                //sellPlayer();
                                Thread.sleep(1000);
                                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[3]/button[7]")));
                                data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[3]/button[7]")).click();
                                Thread.sleep(500);
                                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[1]/button[1]")));
                                data.driver().findElement(By.xpath("/html/body/section/section/section/div[1]/button[1]")).click();
                                Thread.sleep(10000);
                            }

                        } catch (org.openqa.selenium.NoSuchElementException ex) {
                            System.out.println("spieler het öber anders gsnipet");
                            System.out.println("Player Got Sniped By Someone Else 1");
                            autobuyer.test.setText(autobuyer.test.getText() + "\n" + "Player " + data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[1]/div/div[1]/div[2]")).getText() + " Got Sniped By Someone Else for " + data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[1]/div/div[2]/div[3]/span[2]")).getText() + " coins");
                            autobuyer.test.appendText("");
                            autobuyer.test.setScrollTop(Double.MAX_VALUE);
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException ex1) {
                                Logger.getLogger(Sniping.class.getName()).log(Level.SEVERE, null, ex1);
                            }
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[1]/button[1]")));
                            data.driver().findElement(By.xpath("/html/body/section/section/section/div[1]/button[1]")).click();
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException ex1) {
                                Logger.getLogger(Sniping.class.getName()).log(Level.SEVERE, null, ex1);
                            }

                        } catch (InterruptedException ex) {
                            Logger.getLogger(Sniping.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } catch (InterruptedException ex) {
                        Logger.getLogger(Sniping.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        });

    }

    private void bidding() throws FileNotFoundException {

        checkActive();
        WebDriverWait wait = new WebDriverWait(data.driver(), 3600);
        final Boolean textAreaStart = true;
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                Boolean sniping = true;
                Boolean bidDone = false;
                while (sniping == true) {

                    if (autobuyer.stopPressed == true) {
                        return;
                    }

                    try {
                        // Preiseingabe Gebot Max
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[2]/div[3]/div[2]/div/input")));
                        data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[2]/div[3]/div[2]/div/input")).click();
                        if (line.equals("Filter 1") || line.equals("Filter 2") || line.equals("Filter 3")) {
                            Thread.sleep(100);
                            // Max Gebot eingabe
                            data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[2]/div[3]/div[2]/div/input")).sendKeys(snipingcontroller.filterLine7);
                        } else {
                            Thread.sleep(100);
                            // Max Gebot eingabe
                            data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[2]/div[3]/div[2]/div/input")).sendKeys(snipingcontroller.playerlistLine3);
                        }
                        // Search Button
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[2]/button[2]")));
                        data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[2]/button[2]")).click();
                        // Überprüfen ob Spieler gefunden oder nicht, oben = nicht gefunden, unten = nicht gefunden
                        wait.until(ExpectedConditions.or(
                                ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/section/section/div[2]/section/div/section/div/div[3]/div/h2")),
                                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li")),
                                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[1]"))));
                        if (data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section/div/div[3]/div/h2")).isDisplayed() == true) {
                            autobuyer.test.setText(autobuyer.test.getText() + "\n" + "No Player Found");
                            autobuyer.test.appendText("");
                            autobuyer.test.setScrollTop(Double.MAX_VALUE);
                            // Zurück zum Transfermarket Button
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[1]/button[1]")));
                            data.driver().findElement(By.xpath("/html/body/section/section/section/div[1]/button[1]")).click();
                            Thread.sleep(1000);
                        }
                    } catch (org.openqa.selenium.NoSuchElementException e) {
//                        autobuyer.test.setText(autobuyer.test.getText() + "\n" + "Player Found");
//                        autobuyer.test.appendText("");
//                        autobuyer.test.setScrollTop(Double.MAX_VALUE);

                        try {

                            // Luege wie vill spieler azeigt werdet
                            WebDriverWait waitShort = new WebDriverWait(data.driver(), (long) 0.001);
                            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[1]")));
                            anzahlSpieler++;
                            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[2]")));
                            anzahlSpieler++;
                            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[3]")));
                            anzahlSpieler++;
                            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[4]")));
                            anzahlSpieler++;
                            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[5]")));
                            anzahlSpieler++;
                            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[6]")));
                            anzahlSpieler++;
                            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[7]")));
                            anzahlSpieler++;
                            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[8]")));
                            anzahlSpieler++;
                            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[9]")));
                            anzahlSpieler++;
                            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[10]")));
                            anzahlSpieler++;
                            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[11]")));
                            anzahlSpieler++;
                            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[12]")));
                            anzahlSpieler++;
                            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[13]")));
                            anzahlSpieler++;
                            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[14]")));
                            anzahlSpieler++;
                            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[15]")));
                            anzahlSpieler++;
                            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[16]")));
                            anzahlSpieler++;
                            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[17]")));
                            anzahlSpieler++;
                            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[18]")));
                            anzahlSpieler++;
                            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[19]")));
                            anzahlSpieler++;
                            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[20]")));
                            anzahlSpieler++;
                            // Random Stuff zum usegoh
                            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("Lelek")));

                        } catch (org.openqa.selenium.TimeoutException ex) {
                            try {

                                int liNumber = 0;
                                for (int i = 0; i < anzahlSpieler; i++) {
                                    liNumber++;

                                    String liString = "/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[" + liNumber + "]";
                                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(liString)));
                                    data.driver().findElement(By.xpath(liString)).click();

                                    // Gebotspreis Input
                                    String aktuellesGebot;
                                    String eigeneCoins;
                                    // Gebotspreis Input
                                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[2]/div/div")));
                                    aktuellesGebot = data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[1]/div/div[2]/span[2]")).getText();
                                    eigeneCoins = data.driver().findElement(By.xpath("/html/body/section/section/section/div[1]/div[1]/div[1]")).getText();
                                    aktuellesGebotConverted = Integer.valueOf(aktuellesGebot.replaceAll("[,]", ""));
                                    eigeneCoinsConverted = Integer.valueOf(eigeneCoins.replaceAll("[,]", ""));
                                    System.out.println("Aktuelles Gebot: " + aktuellesGebotConverted);
                                    System.out.println("Eigene Coins: " + eigeneCoinsConverted);

                                    calculationBidding();

                                    if (biddingPossible == true) {
                                        System.out.println("jetzt büte");
                                        try {

                                            String timeleft = data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[1]/div/div[1]/span[2]")).getText();
                                            String endtime = timeleft.replaceAll("[Minutes\\s]", "");
                                            int endtimeInt = Integer.valueOf(endtime);
                                            int maxgeboterlaubt = Integer.valueOf(snipingcontroller.playerlistLine3);
                                            if (endgebot > maxgeboterlaubt) {
                                                System.out.println("zu tür");
                                                // Überprüfen wie viele Minuten bis zum Ablauf
                                            } else if (endtimeInt <= 55) {
                                                // Make Bid Button
                                                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[2]/button[1]")));
                                                data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[2]/button[1]")).click();
                                            } else {
                                                autobuyer.test.setText(autobuyer.test.getText() + "\n" + "No more Players Found with this timelimit, try a different player or timelimit");
                                                autobuyer.test.appendText("");
                                                autobuyer.test.setScrollTop(Double.MAX_VALUE);
                                                Thread.sleep(2000);
                                                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/nav/button[3]")));
                                                data.driver().findElement(By.xpath("/html/body/section/section/nav/button[3]")).click();
                                                Thread.sleep(3000);
                                                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/div/div/div[4]")));
                                                data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/div/div/div[4]")).click();
                                                Platform.runLater(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        autobuyer.lblStatus.setText("Not Running");
                                                    }
                                                });
                                                return;
                                            }

                                            // Überprüefe ob bereits höchste büter
                                            try {
                                                if (data.driver().findElement(By.xpath("/html/body/div[1]/section/div/footer/button[1]")).isDisplayed() == true) {
                                                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section/div/footer/button[1]")));
                                                    data.driver().findElement(By.xpath("/html/body/div[1]/section/div/footer/button[1]")).click();
                                                    höchstbietender = true;
                                                }
                                            } catch (org.openqa.selenium.NoSuchElementException exx) {
                                                System.out.println("ned höchstbütende");
                                            }

                                            Thread.sleep(500);
                                            int check = eigeneCoinsConverted - endgebot;
                                            String checkConvert = String.valueOf(check);
                                            String getCurrentCoins = data.driver().findElement(By.xpath("/html/body/section/section/section/div[1]/div[1]/div[1]")).getText();
                                            int getCurrentCoinsConverted = Integer.valueOf(getCurrentCoins.replaceAll("[,]", ""));
                                            String getCurrentCoinsOriginal = String.valueOf(getCurrentCoinsConverted);

                                            try {
                                                if (höchstbietender == true) {
                                                    autobuyer.test.setText(autobuyer.test.getText() + "\n" + "Already highest bidder");
                                                    autobuyer.test.appendText("");
                                                    autobuyer.test.setScrollTop(Double.MAX_VALUE);
                                                    höchstbietender = false;
                                                } else if (data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[1]/div/div[3]")).getText().equals("Unwatch")) {
                                                    autobuyer.test.setText(autobuyer.test.getText() + "\n" + "Bid successful");
                                                    autobuyer.test.appendText("");
                                                    autobuyer.test.setScrollTop(Double.MAX_VALUE);
                                                    bidDone = true;
                                                    Thread.sleep(500);
                                                } else {
                                                    autobuyer.test.setText(autobuyer.test.getText() + "\n" + "Bid not successful");
                                                    autobuyer.test.appendText("");
                                                    autobuyer.test.setScrollTop(Double.MAX_VALUE);
                                                }
                                            } catch (org.openqa.selenium.NoSuchElementException exx) {
                                                System.out.println("fehler");
                                            }

                                        } catch (org.openqa.selenium.NoSuchElementException exx) {
                                            System.out.println("fehler");
                                        }

                                    } else {
                                        autobuyer.test.setText(autobuyer.test.getText() + "\n" + "Not enough coins");
                                        autobuyer.test.appendText("");
                                        autobuyer.test.setScrollTop(Double.MAX_VALUE);
                                        anzahlSpieler = 0;
                                        checkBiddingStatus();
                                        return;

//                                        Thread.sleep(3000);
//                                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/nav/button[3]")));
//                                        data.driver().findElement(By.xpath("/html/body/section/section/nav/button[3]")).click();
//                                        Thread.sleep(3000);
//                                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/div/div/div[4]")));
//                                        data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/div/div/div[4]")).click();
                                    }

                                }

                                checkBiddingStatus();

                            } catch (org.openqa.selenium.NoSuchElementException exx) {

                            } catch (InterruptedException ey) {
                                Logger.getLogger(Sniping.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }

                    } catch (InterruptedException ex) {
                        Logger.getLogger(Sniping.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        });

    }

    private void checkBiddingStatus() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(data.driver(), 3600);
        System.out.println("bidding status");
        int anzahlBiddings = 0;
        try {

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/nav/button[3]")));
            Thread.sleep(2000);
            data.driver().findElement(By.xpath("/html/body/section/section/nav/button[3]")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/div/div/div[4]")));
            Thread.sleep(3000);
            data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/div/div/div[4]")).click();

            WebDriverWait waitShort = new WebDriverWait(data.driver(), (long) 0.001);
            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/div/section[1]/ul/li[1]")));
            anzahlBiddings++;
            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/div/section[1]/ul/li[2]")));
            anzahlBiddings++;
            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/div/section[1]/ul/li[3]")));
            anzahlBiddings++;
            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/div/section[1]/ul/li[4]")));
            anzahlBiddings++;
            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/div/section[1]/ul/li[5]")));
            anzahlBiddings++;
            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/div/section[1]/ul/li[6]")));
            anzahlBiddings++;
            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/div/section[1]/ul/li[7]")));
            anzahlBiddings++;
            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/div/section[1]/ul/li[8]")));
            anzahlBiddings++;
            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/div/section[1]/ul/li[9]")));
            anzahlBiddings++;
            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/div/section[1]/ul/li[10]")));
            anzahlBiddings++;
            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/div/section[1]/ul/li[11]")));
            anzahlBiddings++;
            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/div/section[1]/ul/li[12]")));
            anzahlBiddings++;
            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/div/section[1]/ul/li[13]")));
            anzahlBiddings++;
            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/div/section[1]/ul/li[14]")));
            anzahlBiddings++;
            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/div/section[1]/ul/li[15]")));
            anzahlBiddings++;
            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/div/section[1]/ul/li[16]")));
            anzahlBiddings++;
            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/div/section[1]/ul/li[17]")));
            anzahlBiddings++;
            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/div/section[1]/ul/li[18]")));
            anzahlBiddings++;
            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/div/section[1]/ul/li[19]")));
            anzahlBiddings++;
            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/div/section[1]/ul/li[20]")));
            anzahlBiddings++;
            waitShort.until(ExpectedConditions.elementToBeClickable(By.xpath("Lelek")));

        } catch (org.openqa.selenium.TimeoutException ex) {

            try {

                int liNumber = 0;
                boolean test = false;

                while (test == false) {
                    for (int i = 0; i < anzahlBiddings; i++) {
                        liNumber++;
                        String liString = "/html/body/section/section/section/div[2]/section/div/div/section[1]/ul/li[" + liNumber + "]";
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(liString)));
                        data.driver().findElement(By.xpath(liString)).click();

                    }

                    liNumber = 0;

                }

            } catch (org.openqa.selenium.NoSuchElementException e) {

            }

        }

    }

    private void calculationBidding() {

        int differenz = 0;

        if (aktuellesGebotConverted > 300 && aktuellesGebotConverted <= 1000) {
            differenz += 50;
        }

        if (aktuellesGebotConverted > 1000 && aktuellesGebotConverted <= 10000) {
            differenz += 100;
        }

        if (aktuellesGebotConverted > 10000 && aktuellesGebotConverted <= 50000) {
            differenz += 250;
        }

        if (aktuellesGebotConverted > 50000 && aktuellesGebotConverted <= 100000) {
            differenz += 500;
        }

        if (aktuellesGebotConverted > 100000 && aktuellesGebotConverted <= 200000) {
            differenz += 1000;
        }

        endgebot = aktuellesGebotConverted += differenz;

        if (eigeneCoinsConverted > endgebot) {
            biddingPossible = true;
        } else {
            biddingPossible = false;
        }

    }

    public void snipePosition() throws InterruptedException, FileNotFoundException {

        WebDriverWait wait = new WebDriverWait(data.driver(), 3600);
        // Zu consumables wechseln
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[1]/div/a[4]")));
        Thread.sleep(1000);
        data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[1]/div/a[4]")).click();
        Thread.sleep(500);
        // Auf verschieden consumables drücken
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[2]")));
        data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[2]")).click();
        // Auswahl Position Change
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[2]/div/ul/li[3]")));
        Thread.sleep(500);
        data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[2]/div/ul/li[3]")).click();
        // Auswahl spezifische Position
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[4]")));
        Thread.sleep(500);
        data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[4]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[4]/div/ul/li[15]")));
        Thread.sleep(500);
        data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[4]/div/ul/li[15]")).click();
        // Preiseingabe Sofortkauf Max
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[2]/div[6]/div[2]/div/input")));
        Thread.sleep(500);
        data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[2]/div[6]/div[2]/div/input")).click();
        data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[2]/div[6]/div[2]/div/input")).sendKeys("1400");

        final Boolean textAreaStart = true;
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                Boolean sniping = true;
                while (sniping == true) {

                    if (autobuyer.stopPressed == true) {
                        return;
                    }

                    try {

                        counter++;
                        if (counter % 2 == 0) {
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[2]/div[2]/div[2]/button[2]")));
                            data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[2]/div[2]/div[2]/button[2]")).click();
                        } else {
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[2]/div[2]/div[2]/button[1]")));
                            data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[2]/div[2]/div[2]/button[1]")).click();
                        }

                        // Search Button
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[2]/button[2]")));
                        data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[2]/button[2]")).click();
                        // Überprüfen ob Spieler gefunden oder nicht, oben = nicht gefunden, unten = nicht gefunden
                        wait.until(ExpectedConditions.or(
                                ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/section/section/div[2]/section/div/section/div/div[3]/div/h2")),
                                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li")),
                                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[1]"))));
                        if (data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section/div/div[3]/div/h2")).isDisplayed() == true) {
                            System.out.println("no player found");
                            autobuyer.test.setText(autobuyer.test.getText() + "\n" + "No Player Found");
                            autobuyer.test.appendText("");
                            autobuyer.test.setScrollTop(Double.MAX_VALUE);
                            // Zurück zum Transfermarket Button
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[1]/button[1]")));
                            data.driver().findElement(By.xpath("/html/body/section/section/section/div[1]/button[1]")).click();
                            Thread.sleep(800);
                        } else {
                            System.out.println("spieler gfunde 1");
                            autobuyer.test.setText(autobuyer.test.getText() + "\n" + "Player Found");
                            autobuyer.test.appendText("");
                            autobuyer.test.setScrollTop(Double.MAX_VALUE);
                        }
                    } catch (org.openqa.selenium.NoSuchElementException e) {
                        System.out.println("spieler gfunde 2");
                        autobuyer.test.setText(autobuyer.test.getText() + "\n" + "Player Found");
                        autobuyer.test.appendText("");
                        autobuyer.test.setScrollTop(Double.MAX_VALUE);

                        try {
                            // Buy Now Button
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[2]/button[2]")));
                            data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[2]/button[2]")).click();
                            // Buy Now OK Button
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section/div/footer/button[2]")));
                            data.driver().findElement(By.xpath("/html/body/div[1]/section/div/footer/button[2]")).click();

                            // Überprüefe ob Spieler kauft --> mit quick sell button (wenn de innerhalb vo 2 sekunde azeigt wird isch er kauft wurde sust ned)
                            Thread.sleep(2000);
                            if (data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[3]/button[9]")).isDisplayed() == true) {
                                System.out.println("spieler kauft");
                                //int playerboughtFor = Integer.valueOf(data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[1]/div/div/span[2]")).getText());
                                //stats.profit -= playerboughtFor;
                                autobuyer.test.setText(autobuyer.test.getText() + "\n" + "Player Bought");
                                autobuyer.test.appendText("");
                                autobuyer.test.setScrollTop(Double.MAX_VALUE);
                                //sellPlayer();
                            }

                        } catch (org.openqa.selenium.NoSuchElementException ex) {
                            System.out.println("spieler het öber anders gsnipet");
                            System.out.println("Player Got Sniped By Someone Else 1");
                            autobuyer.test.setText(autobuyer.test.getText() + "\n" + "Player Got Sniped By Someone Else");
                            autobuyer.test.appendText("");
                            autobuyer.test.setScrollTop(Double.MAX_VALUE);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex1) {
                                Logger.getLogger(Sniping.class.getName()).log(Level.SEVERE, null, ex1);
                            }
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[1]/button[1]")));
                            data.driver().findElement(By.xpath("/html/body/section/section/section/div[1]/button[1]")).click();
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException ex1) {
                                Logger.getLogger(Sniping.class.getName()).log(Level.SEVERE, null, ex1);
                            }

                        } catch (InterruptedException ex) {
                            Logger.getLogger(Sniping.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } catch (InterruptedException ex) {
                        Logger.getLogger(Sniping.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        });

    }

    public void snipeIcon() throws InterruptedException, FileNotFoundException {

        WebDriverWait wait = new WebDriverWait(data.driver(), 3600);
        // Liga anklicken
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[6]")));
        Thread.sleep(500);
        data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[6]")).click();
        Thread.sleep(500);
        // Liga Icons auswählen
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[6]/div/ul/li[24]")));
        data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[1]/div[6]/div/ul/li[24]")).click();
        // Preiseingabe Sofortkauf Max
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[2]/div[6]/div[2]/div/input")));
        Thread.sleep(500);
        data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[2]/div[6]/div[2]/div/input")).click();
        Thread.sleep(500);
        data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[2]/div[6]/div[2]/div/input")).sendKeys("400000");

        final Boolean textAreaStart = true;
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                Boolean sniping = true;
                while (sniping == true) {

                    if (autobuyer.stopPressed == true) {
                        return;
                    }

                    try {

                        counter++;
                        if (counter % 2 == 0) {
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[2]/div[2]/div[2]/button[2]")));
                            data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[2]/div[2]/div[2]/button[2]")).click();
                        } else {
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[2]/div[2]/div[2]/button[1]")));
                            data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[1]/div[2]/div[2]/div[2]/button[1]")).click();
                        }

                        // Search Button
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[2]/button[2]")));
                        data.driver().findElement(By.xpath("//*[@id=\"ut-search-wrapper\"]/div[2]/div/div[2]/button[2]")).click();
                        // Überprüfen ob Spieler gefunden oder nicht, oben = nicht gefunden, unten = nicht gefunden
                        wait.until(ExpectedConditions.or(
                                ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/section/section/div[2]/section/div/section/div/div[3]/div/h2")),
                                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li")),
                                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[1]"))));
                        if (data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section/div/div[3]/div/h2")).isDisplayed() == true) {
                            System.out.println("no player found");
                            autobuyer.test.setText(autobuyer.test.getText() + "\n" + "No Player Found");
                            autobuyer.test.appendText("");
                            autobuyer.test.setScrollTop(Double.MAX_VALUE);
                            // Zurück zum Transfermarket Button
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[1]/button[1]")));
                            data.driver().findElement(By.xpath("/html/body/section/section/section/div[1]/button[1]")).click();
                            Thread.sleep(800);
                        } else {
                            System.out.println("spieler gfunde 1");
                            autobuyer.test.setText(autobuyer.test.getText() + "\n" + "Player Found");
                            autobuyer.test.appendText("");
                            autobuyer.test.setScrollTop(Double.MAX_VALUE);
                        }
                    } catch (org.openqa.selenium.NoSuchElementException e) {
                        System.out.println("spieler gfunde 2");
                        autobuyer.test.setText(autobuyer.test.getText() + "\n" + "Player Found");
                        autobuyer.test.appendText("");
                        autobuyer.test.setScrollTop(Double.MAX_VALUE);

                        try {
                            // Buy Now Button
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[2]/button[2]")));
                            data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[2]/button[2]")).click();
                            // Buy Now OK Button
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section/div/footer/button[2]")));
                            data.driver().findElement(By.xpath("/html/body/div[1]/section/div/footer/button[2]")).click();

                            // Überprüefe ob Spieler kauft --> mit quick sell button (wenn de innerhalb vo 2 sekunde azeigt wird isch er kauft wurde sust ned)
                            Thread.sleep(2000);
                            if (data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[3]/button[9]")).isDisplayed() == true) {
                                System.out.println("spieler kauft");
                                //int playerboughtFor = Integer.valueOf(data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[1]/div/div/span[2]")).getText());
                                //stats.profit -= playerboughtFor;
                                autobuyer.test.setText(autobuyer.test.getText() + "\n" + "Player " + data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[1]/div/div[1]/div[2]")).getText() + " Bought for " + data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[1]/div/div[2]/div[3]/span[2]")).getText() + " coins");
                                autobuyer.test.appendText("");
                                autobuyer.test.setScrollTop(Double.MAX_VALUE);
                                //sellPlayer();
                            }

                        } catch (org.openqa.selenium.NoSuchElementException ex) {
                            System.out.println("spieler het öber anders gsnipet");
                            System.out.println("Player Got Sniped By Someone Else 1");
                            autobuyer.test.setText(autobuyer.test.getText() + "\n" + "Player " + data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[1]/div/div[1]/div[2]")).getText() + " Got Sniped By Someone Else for " + data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section[1]/div/ul/li[1]/div/div[2]/div[3]/span[2]")).getText() + " coins");
                            autobuyer.test.appendText("");
                            autobuyer.test.setScrollTop(Double.MAX_VALUE);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex1) {
                                Logger.getLogger(Sniping.class.getName()).log(Level.SEVERE, null, ex1);
                            }
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[1]/button[1]")));
                            data.driver().findElement(By.xpath("/html/body/section/section/section/div[1]/button[1]")).click();
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException ex1) {
                                Logger.getLogger(Sniping.class.getName()).log(Level.SEVERE, null, ex1);
                            }

                        } catch (InterruptedException ex) {
                            Logger.getLogger(Sniping.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } catch (InterruptedException ex) {
                        Logger.getLogger(Sniping.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        });

    }

    private void sellPlayer() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(data.driver(), 3600);
        try {
            Thread.sleep(1000);
            // List On Transfermarket
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[2]/div[1]/button")));
            data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[2]/div[1]/button")).click();
            // Buy Now Price
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/input")));
            data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/input")).click();
            Thread.sleep(500);
            data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[2]/div/input")).sendKeys(snipingcontroller.playerlistLine4);
            // Start Price
            int convertnowprice = Integer.valueOf(snipingcontroller.playerlistLine4);
            int startprice = convertnowprice - 100;
            String startpriceString = String.valueOf(startprice);
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/input")));
            data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/input")).click();
            Thread.sleep(500);
            data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/input")).sendKeys(startpriceString);
            // List Item Button
            Thread.sleep(500);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[2]/div[2]/button")));
            data.driver().findElement(By.xpath("/html/body/section/section/section/div[2]/section/div/section[2]/div/div/div[2]/div[2]/div[2]/button")).click();

            try {

                if (data.driver().findElement(By.xpath("/html/body/div[1]/section/div/footer/button")).isDisplayed() == true) {
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section/div/footer/button")));
                    data.driver().findElement(By.xpath("/html/body/div[1]/section/div/footer/button")).click();
                    Thread.sleep(1000);
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[1]/button[1]")));
                    data.driver().findElement(By.xpath("/html/body/section/section/section/div[1]/button[1]")).click();
                    Thread.sleep(10000);
                }

            } catch (org.openqa.selenium.NoSuchElementException ex) {

                Thread.sleep(500);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[1]/button[1]")));
                data.driver().findElement(By.xpath("/html/body/section/section/section/div[1]/button[1]")).click();
                Thread.sleep(10000);

            }

        } catch (org.openqa.selenium.NoSuchElementException ex) {
            System.out.println("fehler");
        }
    }

}
