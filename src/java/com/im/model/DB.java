
package com.im.model;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Dulan
 */
public class DB {
    static String url="jdbc:mysql://localhost:3306/tourcomfinal3";
	static String user="root";
	static String pw="sri";
	static String driver="com.mysql.jdbc.Driver";
	
	static Connection con;
	
	public static Connection getCon() throws Exception{
		if(con==null){
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, pw);
		}
		return con;
			
		
	}
}
