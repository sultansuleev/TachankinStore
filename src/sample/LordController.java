package sample;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LordController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnResuply;

    @FXML
    private JFXButton btnRemove;

    @FXML
    private JFXButton btnStats;

    @FXML
    private Pane pnlAdd;

    @FXML
    private Button goodsAdd;

    @FXML
    private Pane pnlResuply;

    @FXML
    private Pane pnlRemove;

    @FXML
    private Pane pnlStats;

    @FXML
    private TextField goodName;

    @FXML
    private TextField goodPrice;

    @FXML
    private TextField goodModel;

    @FXML
    private TextField goodCount;


    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btnAdd) {
            pnlAdd.toFront();
        } else if (event.getSource() == btnResuply) {
            pnlResuply.toFront();
            pnlAdd.toBack();
        } else if (event.getSource() == btnRemove) {
            pnlRemove.toFront();
        } else if (event.getSource() == btnStats) {
            pnlStats.toFront();
        }
    }

    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        goodsAdd.setOnAction(event -> {
            dbHandler.addGood(goodName.getText(), goodModel.getText(), goodCount.getText(), goodPrice.getText());
            System.out.println("Added!");
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
