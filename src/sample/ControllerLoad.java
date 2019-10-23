package sample;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerLoad {
    @FXML private TableView<Good> tableView;

    @FXML private TableColumn<Good, Integer> idCol;
    @FXML private TableColumn<Good, String> nameCol;
    @FXML private TableColumn<Good, String> modelCol;
    @FXML private TableColumn<Good, Integer> priceCol;
    @FXML private TableColumn<Good, Integer> countCol;
    @FXML private TableColumn<Good, Integer> soldCol;

    @FXML private TextField resuplyInputID;

    @FXML private TextField resuplyInputCount;

    @FXML private JFXButton resuplyBtn;

    ObservableList<Good> good = FXCollections.observableArrayList();
    @FXML
    void initialize() {
        idCol.setCellValueFactory(new PropertyValueFactory<Good, Integer>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Good, String>("name"));
        modelCol.setCellValueFactory(new PropertyValueFactory<Good, String>("model"));
        priceCol.setCellValueFactory(new PropertyValueFactory<Good, Integer>("price"));
        countCol.setCellValueFactory(new PropertyValueFactory<Good, Integer>("count"));
        DatabaseHandler dbHandler = new DatabaseHandler();
        String sql = "SELECT * FROM " + Const.GOODS_TABLE;

        try {
            PreparedStatement prSt = dbHandler.getDbConnection().prepareStatement(sql);
            ResultSet resultSet = prSt.executeQuery(sql);

            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String model = resultSet.getString(3);
                String price = resultSet.getString(4);
                String count = resultSet.getString(5);
                tableView.setItems(getGoods(id, name, model, price, count));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Good> getGoods(String id, String name, String model, String price, String count) {
        good.add(new Good(id, name, model, price, count));

        return good;
    }
}
