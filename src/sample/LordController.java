package sample;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LordController implements Initializable {
    @FXML
    private Button goodsAdd;

    @FXML
    private TextField goodName;

    @FXML
    private TextField goodPrice;

    @FXML
    private TextField goodModel;

    @FXML
    private TextField goodCount;

    @FXML
    private BorderPane bp;

    @FXML
    private AnchorPane ap;

    @FXML
    private JFXButton showGoods;

    @FXML
    void add(MouseEvent event) {
            bp.setCenter(ap);
    }

    @FXML
    void remove(MouseEvent event) {
        loadPage("remove");
    }

    @FXML
    void resuply(MouseEvent event) {
        loadPage("resuply");
    }

    @FXML
    void stats(MouseEvent event) {
        loadPage("stats");
    }

    @FXML
    void goods(MouseEvent event) {
        loadPage("goods");
    }

    private void loadPage(String page) {
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        bp.setCenter(root);
    }

    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        goodsAdd.setOnAction(event -> {
            dbHandler.addGood(goodName.getText(), goodModel.getText(), goodCount.getText(), goodPrice.getText());
            System.out.println("Added!");
        });
    }

    @FXML
    private void button(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
