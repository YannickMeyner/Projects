/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobuyerdesign;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Yannick
 */
public class Data {

    static Data instance;
    Main main = Main.getInstance();
    Integer startTime = 0;
    Integer seconds = startTime;
    final Timeline timer = new Timeline();
    Boolean loggedIn = false;
    WebDriver test;
    WebDriver driver;
    String cheapestPrice;
    String searchPlayer = "Eoin Doyle";
    Boolean findPrice;
    Boolean findPrice2;
    String finalSnipingPrice;
    String sellPrice;
    Boolean showDesign = false;
    String textfile;
    String emailTextFile;
    String confirmEmailTextFile;
    String passwordTextFile;
    String securityAnswerTextFile;
    public Boolean qeue = true;

    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }

    public String coins() {
        String coins = driver().findElement(By.xpath("/html/body/section/section/section/div[1]/div[1]/div[1]")).getText();
        return coins;
    }

    public String fifaPoints() {
        String fifaPoints = driver().findElement(By.xpath("/html/body/section/section/section/div[1]/div[1]/div[2]")).getText();
        return fifaPoints;
    }

    public String clubName() {
        String club = driver().findElement(By.xpath("/html/body/section/section/section/div[1]/div[2]/div/span[2]")).getText();
        return club;
    }

    private WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yannick\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(-2000, 0));
        return driver;
    }

    public WebDriver driver() {
        this.test = driver;
        return test;
    }

    public void loginEA(ActionEvent event) throws InterruptedException, IOException {

        SnipingFilterController snipingcontroller = SnipingFilterController.getInstance();
        snipingcontroller.autoDataSniping();

        EventQueue.invokeLater(() -> {
            try {
                //Your GUI code here
                createDriver().get("https://signin.ea.com/p/web2/login?execution=e2036290639s1&initref=https%3A%2F%2Faccounts.ea.com%3A443%2Fconnect%2Fauth%3Fprompt%3Dlogin%26accessToken%3Dnull%26client_id%3DFIFA-18-WEBCLIENT%26response_type%3Dtoken%26display%3Dweb2%252Flogin%26locale%3Den_US%26redirect_uri%3Dhttps%253A%252F%252Fwww.easports.com%252Ffifa%252Fultimate-team%252Fweb-app%252Fauth.html%26scope%3Dbasic.identity%2Boffline%2Bsignin");
                while (!driver().getTitle().equals("Log In")) {
                }
                driver().findElement(By.id("email")).sendKeys(main.emailTextFile());
                driver().findElement(By.id("password")).sendKeys(main.passwordTextFile());
                driver().findElement(By.id("btnLogin")).click();
                LoadingPageController loading = LoadingPageController.getInstance();
//                progress.imgLogin.setVisible(true);
                loading.rotateTransition1.stop();
                loading.eaLogin();
                try {
                    WebDriverWait wait = new WebDriverWait(driver(), 3600);
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"btnSendCode\"]")));
                    // Sicherheitscode an Email senden
                    driver().findElement(By.id("btnSendCode")).click();
                    wait.until(ExpectedConditions.elementToBeClickable(By.id("oneTimeCode")));
                    JFrame frameWrong = new JFrame("Verify Account");
                    String code = JOptionPane.showInputDialog(frameWrong, "Enter Verification Code!");
                    // Sicehrheitscode Eingabe
                    driver().findElement(By.id("oneTimeCode")).sendKeys(code);
                    // Sicehrheitscode Absenden
                    driver().findElement(By.id("btnSubmit")).click();
                    try {

                        while (driver().findElement(By.xpath("//*[@id=\"origin-tfa-container\"]/div/span[3]")).isDisplayed() == true) {
                            frameWrong = new JFrame("Code Was Wrong");
                            code = JOptionPane.showInputDialog(frameWrong, "Please Enter The Correct Verification Code!");
                            wait.until(ExpectedConditions.elementToBeClickable(By.id("oneTimeCode")));
                            wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSubmit")));
                            // Sicherheitscode Eingabe
                            driver().findElement(By.id("oneTimeCode")).sendKeys(code);
                            // Sicherheitscode Absenden
                            driver().findElement(By.id("btnSubmit")).click();
//                            progress.imgVerificationWrong.setVisible(true);
                        }
                    } catch (org.openqa.selenium.NoSuchElementException e) {
//                        progress.imgVerificationWrong.setVisible(false);
//                        progress.imgVerification.setVisible(true);
                        loading.rotateTransition2.stop();
                        loading.verification();
                        try {
                            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Login\"]/div/div/button[1]")));
                            // Login Button
                            driver().findElement(By.xpath("//*[@id=\"Login\"]/div/div/button[1]")).click();
                            // Sicherheitsfrage eingeben
                            //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/article/div/div/div[2]/div[2]/div/input")));
                            //loadingScreenLogin();
                            //driver().findElement(By.xpath("/html/body/section/article/div/div/div[2]/div[2]/div/input")).click();
                            //Thread.sleep(1000);
                            //driver().findElement(By.xpath("/html/body/section/article/div/div/div[2]/div[2]/div/input")).sendKeys(main.securityAnswerTextFile());
                            // Sicherheitsfrage Absenden
//                            progress.imgSecurity.setVisible(true);
                            //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/article/div/div/div[2]/div[2]/div/button")));
                            // driver().findElement(By.xpath("/html/body/section/article/div/div/div[2]/div[2]/div/button")).click();
                            // Accept Button
                            //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/div/div/div/div/div[2]/div/button[2]")));
                            loadingScreenLogin();
                            //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/div/div/div/div/div[2]/div/button[2]")));
                            //driver().findElement(By.xpath("/html/body/section/div/div/div/div/div[2]/div/button[2]")).click();
                            Tradepile tr = new Tradepile();
                            transfermarket();
                            loading.rotateTransition3.stop();
                            loading.securityAnswer();
                            Thread.sleep(3000);
//                            closeProgressBar(event);
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        switchView(event);
                                    } catch (IOException ex) {
                                        Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            });

                        } catch (org.openqa.selenium.TimeoutException ex) {
                            System.out.println(ex);
                        }
                    }
                } catch (org.openqa.selenium.TimeoutException e) {
                    System.out.println("neustart");
//            loginEA();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    private void switchView(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AccountOverview.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    public void transfermarket() throws InterruptedException {

        try {

            WebDriverWait exceptionWait = new WebDriverWait(driver(), 10);
            exceptionWait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div[2]/button")));
            driver().findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/button")).click();

        } catch (org.openqa.selenium.TimeoutException e) {

        }

        WebDriverWait wait = new WebDriverWait(driver(), 3600);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/nav/button[3]")));
        loadingScreenIngame();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/nav/button[3]")));
        driver().findElement(By.xpath("/html/body/section/section/nav/button[3]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/div/div/div[2]")));
        loadingScreenLogin();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/section/section/div[2]/div/div/div[2]")));
        driver().findElement(By.xpath("/html/body/section/section/section/div[2]/div/div/div[2]")).click();
        coins();
        clubName();
        //fifaPoints();

    }

    private void loadingScreenLogin() throws InterruptedException {

        Boolean ladeBildschirm = true;
        Thread.sleep(1000);
        while (ladeBildschirm == true) {
            try {
                if (driver().findElement(By.xpath("//*[@id=\"ClickShield\"]/img")).isDisplayed() == true) {
//                    System.out.println("wird azeigt");
                } else {
//                    System.out.println("verschwunde");
                    Thread.sleep(1500);
                    break;
                }
            } catch (org.openqa.selenium.NoSuchElementException e) {
                System.out.println(e);
            }
        }

    }

    private void loadingScreenIngame() throws InterruptedException {

        Boolean ladeBildschirm = true;
        while (ladeBildschirm == true) {
            try {
                if (driver().findElement(By.xpath("//*[@id=\"ClickShield\"]/img")).isDisplayed() == true) {
//                    System.out.println("wird azeigt");
                } else {
//                    System.out.println("verschwunde");
                    Thread.sleep(5000);
                    break;
                }
            } catch (org.openqa.selenium.NoSuchElementException e) {
                System.out.println(e);
            }
        }

    }

    public void progressBar() throws IOException {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Stage stage;
                    Parent root;
                    root = FXMLLoader.load(getClass().getResource("LoadingPage.fxml"));
                    stage = new Stage();
                    stage.setTitle("Autobuyer");
                    Scene scene = new Scene(root);
                    scene.setFill(Color.TRANSPARENT);
                    stage.initStyle(StageStyle.TRANSPARENT);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void closeProgressBar(ActionEvent event) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Parent tableViewParent = FXMLLoader.load(getClass().getResource("LoadingPage.fxml"));
                    Scene tableViewScene = new Scene(tableViewParent);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(tableViewScene);
                    window.close();
                } catch (IOException ex) {
                    Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

}
