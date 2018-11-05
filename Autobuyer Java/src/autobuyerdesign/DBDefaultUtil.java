/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobuyerdesign;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Yannick
 */
public class DBDefaultUtil {

    private Connection connection;
    ArrayList<String> arrDB = new ArrayList();
    ArrayList<String> arrStatus = new ArrayList();

    private boolean createConnection() {

        try {

            if (connection != null && connection.isValid(1)) {
                System.out.println("VALID CONNECTION");
            } else {
                String url = DBConfig.getDatabaseURL();
                String user = DBConfig.getDatabaseUser();
                String pw = DBConfig.getDatabasePassword();
                connection = DriverManager.getConnection(url, user, pw);
            }

            return true;

        } catch (SQLException sqle) {
            System.out.println("---------------------------");
            System.out.println("SQLEXCEPTION: " + sqle);

            return false;
        }
    }

    public void addNewUser(String email, String userName, String password) {
        createConnection();

        // Create hash and salt for password
        byte[] salt = PasswordUtil.getNextSalt();
        byte[] hash = PasswordUtil.hashPassword(password.toCharArray(), salt);

        String query = "INSERT INTO accounts (Email, UserName, Password, Salt, IsActive) VALUES "
                + "(?, ?, ?, ?, ?)";

        try {

            PreparedStatement pst = connection.prepareStatement(query);

            pst.setString(1, email);
            pst.setString(2, userName);
            pst.setBytes(3, hash);
            pst.setBytes(4, salt);
            pst.setString(5, "Not Active");

            pst.execute();

            pst.close();
            connection.close();

        } catch (SQLException sqle) {
            System.out.println("---------------------------");
            System.out.println("SQLEXCEPTION: " + sqle);
        } catch (Exception e) {
            System.out.println("---------------------------");
            System.out.println("EXCEPTION: " + e);
        }
    }

    public boolean authenticateUser(String email, String password) {

        createConnection();

        String query = "SELECT * FROM accounts WHERE Email LIKE ?";
        byte[] salt = null;
        byte[] hash = null;

        try {

            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, email);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                salt = rs.getBytes("Salt");
                hash = rs.getBytes("Password");
            }

            pst.close();
            rs.close();
            connection.close();

            return PasswordUtil.checkPassword(password.toCharArray(), salt, hash);

        } catch (SQLException sqle) {
            System.out.println("---------------------------");
            System.out.println("SQLEXCEPTION: " + sqle);
            return false;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            System.out.println("---------------------------");
            System.out.println("EXCEPTION: " + e);
            return false;
        }
    }

    public Boolean getUser(String email) throws SQLException {

        ArrayList<String> arr = new ArrayList();

        createConnection();

        String query = "SELECT Email FROM accounts;";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);

        ResultSetMetaData metadata = rs.getMetaData();
        int columnCount = metadata.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
        }
        while (rs.next()) {
            String row = "";
            for (int i = 1; i <= columnCount; i++) {
                row += rs.getString(i);
                arr.add(row);
                this.arrDB = arr;
            }
        }

        return !arrDB.contains(email);

    }

    public Boolean checkActive(String email) throws SQLException {

        ArrayList<String> arr = new ArrayList();

        createConnection();

        String query = "SELECT IsActive FROM accounts WHERE Email LIKE '" + email + "'";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);

        ResultSetMetaData metadata = rs.getMetaData();
        int columnCount = metadata.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
        }
        while (rs.next()) {
            String row = "";
            for (int i = 1; i <= columnCount; i++) {
                row += rs.getString(i);
                arr.add(row);
                this.arrStatus = arr;
                System.out.println(arrStatus);
            }
        }

        return !arrStatus.contains("Not Active");

    }

}
