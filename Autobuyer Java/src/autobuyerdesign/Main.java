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
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Yannick
 */
public class Main extends Application {

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
    static Main instance;
    Boolean showDesign = false;
    String textfile;
    String emailTextFile;
    String confirmEmailTextFile;
    String passwordTextFile;
    String securityAnswerTextFile;
    String username = System.getProperty("user.name");

    @Override
    public void start(Stage primaryStage) throws IOException, InterruptedException {

        instance = this;
        readTextFile();
        Parent root = FXMLLoader.load(getClass().getResource("Accounts.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void readTextFile() throws FileNotFoundException, IOException {
        File file = new File("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\account1.txt");
        if (!file.exists()) {
            PrintWriter writer1 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\account1.txt", "UTF-8");
            PrintWriter writer2 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\account2.txt", "UTF-8");
            PrintWriter writer3 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\account3.txt", "UTF-8");
            PrintWriter writer4 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\account4.txt", "UTF-8");
            PrintWriter writer5 = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\account5.txt", "UTF-8");
        }
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\account1.txt"))) {
            StringBuilder sb = new StringBuilder();

            emailTextFile = br.readLine();
            sb.append(emailTextFile);
            sb.append(System.lineSeparator());
            confirmEmailTextFile = br.readLine();
            sb.append(confirmEmailTextFile);
            sb.append(System.lineSeparator());
            passwordTextFile = br.readLine();
            sb.append(passwordTextFile);
            sb.append(System.lineSeparator());
            securityAnswerTextFile = br.readLine();
            sb.append(securityAnswerTextFile);
            sb.append(System.lineSeparator());
            textfile = sb.toString();
        }
    }

    public String emailTextFile() {
        return emailTextFile;
    }

    public String passwordTextFile() {
        return passwordTextFile;
    }

    public String securityAnswerTextFile() {
        return securityAnswerTextFile;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static Main getInstance() {
        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }

}
