/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobuyerdesign;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yannick
 */
public class LoginController implements Initializable {

    @FXML
    private JFXTextField txtUser;
    @FXML
    private JFXPasswordField txtPassword;
    ArrayList<String> arr = new ArrayList();
    DBDefaultUtil db = new DBDefaultUtil();
    @FXML
    private Label btnProblem;
    @FXML
    private Label btnProblem1;

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
    private void login(ActionEvent event) throws IOException, SQLException {

        String email = txtUser.getText();
        String password = txtPassword.getText();

        boolean auth = db.authenticateUser(email, password);
        boolean checkStatus = db.checkActive(email);

        if (!auth) {
            System.out.println("password or mail wrong");

        } else {

            System.out.println("korrekt");

            if (checkStatus == false) {
                System.out.println("license not active");
            } else {

                Parent tableViewParent = FXMLLoader.load(getClass().getResource("Accounts.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(tableViewScene);
                window.show();

            }

        }

    }

    @FXML
    private void clickedForgotPassword(MouseEvent event) {
    }

    @FXML
    private void signup(MouseEvent event) throws IOException {

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();

    }

}
