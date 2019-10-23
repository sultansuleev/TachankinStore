package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passField;

    @FXML
    private Button signInBtn;

    @FXML
    private Button customerBtn;

    @FXML
    void initialize() {
        signInBtn.setOnAction(event -> {
            String loginText = loginField.getText().trim();
            String passText = passField.getText().trim();

            if (!loginText.equals("") && !passText.equals("")){
                loginUser(loginText, passText);
            } else {
                System.out.println("Login or password are empty");
            }
        });
    }

    private void loginUser(String loginText, String passText) {
        if (loginText.equals("admin") && passText.equals("admin")) {
            Platform.setImplicitExit(false);
            signInBtn.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/app.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } else {
            Shake loginAnim = new Shake(loginField);
            Shake passAnim = new Shake(passField);

            loginAnim.playAnim();
            passAnim.playAnim();
        }
    }
}
