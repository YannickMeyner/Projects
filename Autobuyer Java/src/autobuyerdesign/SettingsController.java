/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobuyerdesign;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Yannick
 */
public class SettingsController implements Initializable {

    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXTextField txtSecurityAnswer;
    @FXML
    private JFXPasswordField txtPassword;
    @FXML
    private JFXTextField txtConfirmEmail;
    @FXML
    private Button btnSave;
    String username = System.getProperty("user.name");

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
    private void save(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {

        try (PrintWriter writer = new PrintWriter("C:\\Users\\" + username + "\\Documents\\AutobuyerBeta\\account1.txt", "UTF-8")) {
            writer.println(txtEmail.getText());
            writer.println(txtConfirmEmail.getText());
            writer.println(txtPassword.getText());
            writer.println(txtSecurityAnswer.getText());
        }

    }

}
