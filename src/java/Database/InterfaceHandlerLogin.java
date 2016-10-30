/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.SQLException;

public class InterfaceHandlerLogin {
    DBConnectionLogin db;
    public InterfaceHandlerLogin() {
        db = DBConnectionLogin.getInstance();
    }
    
    public boolean IsUserNameExist(String userName) throws SQLException{
        return db.IsUserNameExist(userName);
    }
     public boolean IsPasswordCorrect(String userName,String pass) throws SQLException{
         return db.IsPasswordCorrect(userName, pass);
     }
}
