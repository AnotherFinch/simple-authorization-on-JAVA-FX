package sample.Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class DBHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName +
                "?serverTimezone=Europe/Moscow&useSSL=FALSE";

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void signUpUsers(User user){
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_LOGIN + "," + Const.USER_PASSWORD + "," + Const.USER_NAME
                + "," +Const.USER_SURNAME + "," + Const.USER_EMAIL + "," + Const.USER_PHONE_NUMBER + "," + Const.USER_GENDER
                + ")" + "VALUES(?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement prST = getDbConnection().prepareStatement(insert);
            prST.setString(1, user.getLogin());
            prST.setString(2, user.getPassword());
            prST.setString(3, user.getName());
            prST.setString(4, user.getSurname());
            prST.setString(5, user.getEmail());
            prST.setString(6, user.getPhonenumber());
            prST.setString(7, user.getGender());
            prST.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public ResultSet getUser(User user){
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_LOGIN + "=? AND " + Const.USER_PASSWORD
                + "=?";
        try {
            PreparedStatement prST = getDbConnection().prepareStatement(select);
            prST.setString(1, user.getLogin());
            prST.setString(2, user.getPassword());

            resSet = prST.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }


}

