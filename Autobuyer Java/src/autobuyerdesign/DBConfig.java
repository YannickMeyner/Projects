/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autobuyerdesign;

/**
 *
 * @author Yannick
 */
public class DBConfig {

    final private static String DATABASE = "mysql";

    final private static String SERVER = "localhost";
    //final private static String PORT = "PORT";
    final private static String DATABASE_NAME = "autobuyer";
    final private static String USERNAME = "root";
    final private static String PASSWORD = "";

    public static String getDatabaseURL() {
        return "jdbc:" + DATABASE + "://" + SERVER + "/" + DATABASE_NAME;
    }

    public static String getDatabaseUser() {
        return USERNAME;
    }

    public static String getDatabasePassword() {
        return PASSWORD;
    }

}
