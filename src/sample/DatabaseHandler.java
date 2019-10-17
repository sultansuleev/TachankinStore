package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public void addGood(String goodsName, String goodsModel, String goodsCount, String goodsPrice) {
        String insert = "INSERT INTO " + Const.GOODS_TABLE + "(" + Const.GOODS_NAME + ", "
                + Const.GOODS_MODEL + ", " + Const.GOODS_COUNT + "," + Const.GOODS_PRICE + ")" + "Values(?, ?, ?, ?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, goodsName);
            prSt.setString(2, goodsModel);
            prSt.setString(3, goodsCount);
            prSt.setString(4, goodsPrice);

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
