/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;
 import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Cassendra
 */
public class DBBasic {
  

    static String url = "jdbc:mysql://localhost:3306/tourcomfinal3";
    static String user = "root";
    static String pw = "sri";
    static String driver = "com.mysql.jdbc.Driver";

    static Connection con;

    public static Connection getCon() throws Exception {
        if (con == null) {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pw);

        }
        return con;

    }

}

