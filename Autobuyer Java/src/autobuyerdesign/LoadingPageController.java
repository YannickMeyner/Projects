package autobuyerdesign;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoadingPageController implements Initializable {

    @FXML
    private ImageView img1;
    @FXML
    private Label lbl1;
    @FXML
    private ImageView img2;
    @FXML
    private Label lbl2;
    @FXML
    private ImageView img3;
    private ImageView img4;
    private ImageView img5;
    @FXML
    private Text text1;
    @FXML
    private Text text2;
    @FXML
    private Text text3;
    public RotateTransition rotateTransition1, rotateTransition2, rotateTransition3,
            rotateTransition4, rotateTransition5;
    @FXML
    private Text text21;
    static LoadingPageController instance;
    @FXML
    private ImageView img11;
    @FXML
    private ImageView img21;
    @FXML
    private ImageView img31;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        instance = this;
        // TODO
        img1.setImage(new Image("Images/syn.png"));
        rotateTransition1 = new RotateTransition(Duration.seconds(5), img1);
        rotateTransition2 = new RotateTransition(Duration.seconds(5), img2);
        rotateTransition3 = new RotateTransition(Duration.seconds(5), img3);
        rotateTransition4 = new RotateTransition(Duration.seconds(5), img4);
        rotateTransition5 = new RotateTransition(Duration.seconds(5), img5);
        RotateTransition transition[] = {rotateTransition1, rotateTransition2,
            rotateTransition3, rotateTransition4, rotateTransition5};
        for (RotateTransition rTransition : transition) {
            rTransition.setCycleCount(100);
            rTransition.setAutoReverse(false);
            rTransition.setFromAngle(720);
            rTransition.setToAngle(0);
        }
        rotateTransition1.play();
        rotateTransition1.setOnFinished((e) -> {
            eaLogin();
        });

        rotateTransition2.setOnFinished((e) -> {
            verification();
        });
        rotateTransition3.setOnFinished((e) -> {
            securityAnswer();
        });

    }

    public static LoadingPageController getInstance() {
        if (instance == null) {
            instance = new LoadingPageController();
        }
        return instance;
    }

    @FXML
    private void close_app(MouseEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("LoadingPage.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.close();
    }

    public void eaLogin() {
        img11.setImage(new Image("Images/ok.png"));
        img11.setVisible(true);
        lbl1.setStyle("-fx-background-color:#45A563");
        img2.setImage(new Image("Images/syn.png"));
        rotateTransition2.play();
    }

    public void verification() {
        img21.setImage(new Image("Images/ok.png"));
        img21.setVisible(true);
        lbl2.setStyle("-fx-background-color:#45A563");
        img3.setImage(new Image("Images/syn.png"));
        rotateTransition3.play();
    }

    public void securityAnswer() {
        img31.setImage(new Image("Images/ok.png"));
        img31.setVisible(true);
    }

}
