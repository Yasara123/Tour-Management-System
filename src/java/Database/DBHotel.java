/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import com.exampleHotel.HotelEmailSessionBean;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Formatter;
import javax.ejb.SessionBean;
import javax.mail.MessagingException;
/**
 *
 * @author Cassendra
 */
public class DBHotel {
     
    InterfaceHandlerHotel db = new InterfaceHandlerHotel();
    HotelEmailSessionBean sessionBean=new HotelEmailSessionBean();;
    
    public void emailInstance(int town_ID,int trip_ID) throws SQLException, MessagingException{
        //db.test();
         String to = db.getHotelEmail(town_ID);
String subject = "Regarding booking the hotel for a trip ";
int noOfPassengers = db.getNoOfPassengers(trip_ID);
long noOfdays= (Date.valueOf(db.getDays(trip_ID))).getTime()-(Date.valueOf(db.getStartDate(trip_ID))).getTime();
String duration = String.valueOf(noOfdays);      
String startDate = db.getStartDate(trip_ID);
String hotelName = db.getHotelName(town_ID);
String heading = "Manager of" +hotelName+ "\n" + "Dear Sir/Madam,";
String rest ="\n" + "We are happy to inform you that one of our customers who has booked a tour will reach your town and we are glad to inform that we would like to book your hotel for them."+"\n" +"Following are the information regarding the tour.\n No. of passngers : "+noOfPassengers+"\n Duration of Tour : "+duration+"\n Start Date : "+startDate+"\n Please check the availability of your hotel and return back to us as soon as possible.\n Thank You.\n DreamTours (PVT) LTD.";
String body = heading + rest;
System.out.println(to);
System.out.println(subject);
System.out.println(body);

sessionBean.sendEmail(to, subject, body);
      //   System.out.println(to);
    }
    
}
