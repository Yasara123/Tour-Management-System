/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class customerConfirmDB {
    
    public void update(String tour_ID,int book) throws Exception
    {
     String sql1="UPDATE newentryforbooking set bookingconformed=1 WHERE tour_ID="+tour_ID;
    // String sql2="UPDATE hotel,tourentry,tourforbooking SET bookings="+book+" WHERE  hotel.town_ID=tourforbooking.overnight_stop and tourentry.tour_ID="+tour_ID+" and tourentry.tour_ID=tourforbooking.tour_ID";
     String sql2="INSERT INTO tourbookentryupdate(bookings,tour_ID) VALUES ("+book+","+tour_ID+")";
    
     try {
            Connection con = DBBasic.getCon();
          //  PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(sql1);
            PreparedStatement ps2 = (PreparedStatement) con.prepareStatement(sql2);
            
            ps2.executeUpdate();
          //  ps.executeUpdate();
            ps1.executeUpdate();
		}
		catch(SQLException e){
                    Logger.getLogger(TourDisplayDB.class.getName()).log(Level.SEVERE, null, e);
                }   
     
    }
    
    
}
