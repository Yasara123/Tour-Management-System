/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import com.exampleCustomer.EmailSessionBean;
import java.sql.SQLException;
import javax.ejb.SessionBean;
import javax.mail.MessagingException;

/**
 *
 * @author Cassendra
 */
public class DBChecker {

    /**
     * @param args the command line arguments
     */
    InterfaceHandler db = new InterfaceHandler();
    EmailSessionBean sessionBean=new EmailSessionBean();;
    
    public void emailInstance(int trip_ID) throws SQLException, MessagingException{
        //db.test();
         String to = db.getCustomerEmail(trip_ID);
String subject = "Regarding the trip " + trip_ID ;
String heading = "Dear Customer,";
String customerName =db.getCustomerName(trip_ID);
int driverID = db.getDriverID(trip_ID);
String driverName = db.getDriverName(driverID);
int noOfPassengers = db.getNoOfPassengers(trip_ID);
String duration = db.getDays(trip_ID);
String startDate = db.getStartDate(trip_ID);
String hotelName = db.getHotelName(db.getHotelID(trip_ID));
String rest ="\n" + "Mr. "+ customerName+", we are happy to inform you that the tour you waited so eagerly is finally ready and following are the information regarding the tour that you will need.\n Driver ID : "+driverID+ "\n DriverName : " + driverName + "\n No. of passngers : "+noOfPassengers+"\n Duration of Tour : "+duration+"\n Start Date : "+startDate+"\n Overnight Stop : "+hotelName+"\n\n Thank You.\n\n DreamTours (PVT) LTD.";
String body = heading + rest;
System.out.println(to);
System.out.println(subject);
System.out.println(body);

sessionBean.sendEmail(to, subject, body);
      //   System.out.println(to);
    }
    
    
    
}
