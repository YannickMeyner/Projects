/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobuyerdesign;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Yannick
 */
public class SignUpController implements Initializable {

    @FXML
    private JFXTextField txtFn;
    @FXML
    private JFXTextField txtLn;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXPasswordField txtPw;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void signup(ActionEvent event) throws SQLException {

        String userName = txtFn.getText();
        String email = txtEmail.getText();
        String pw = txtPw.getText();

        DBDefaultUtil db = new DBDefaultUtil();

        if (db.getUser(email) == false) {
            System.out.println("user already exists");
        } else {

            // Create user in db
            db.addNewUser(email, userName, pw);

        }

    }

}
