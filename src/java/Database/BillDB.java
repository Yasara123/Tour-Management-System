/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.orm.jpa.vendor.Database;

/**
 *
 * @author Nathie
 */
public class BillDB {
  DBConnection db = DBConnection.getCon();
    public boolean setBill(String billRef,String billDate,String hotel_name,String email,int no_of_Dates,int noOfpersons,int amount) throws SQLException{
    try{
         db.statement.executeUpdate("INSERT INTO `hotelbill` (`billRef`, `billDate`, `hotel_name`, `email`, `no_of_DatesUsed`, `noOfpersons`, `amount`) VALUES ('\"+billRef+\"', '\"+billDate+\"', '\"+hotel_name+\"', '\"+email+\"')\"', '\"+no_of_Dates+\"', '\"+noOfpersons+\"', '\"+amount+\"')");    
         return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        } 
   
    }
}
    
    
    
    

