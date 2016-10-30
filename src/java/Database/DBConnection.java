package Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Cassendra
 */
public class DBConnection {

    private static DBConnection instance = null;
      String DATABASE_URL;
      Connection connection ;
      Statement statement ;
     ResultSet resultSet;
      
      public DBConnection(){
          DATABASE_URL = "jdbc:mysql://localhost:3306/tourcomfinal3";
            connection = null;
            statement = null;
            resultSet = null;
            init();
      }
      private  void init( )
   {
             try {
                       Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection(DATABASE_URL, "root", "sri");
             statement = connection.createStatement();
                 System.out.println("Successfull");
                  } 
             catch (ClassNotFoundException ex) {
                 JOptionPane.showMessageDialog(null,ex.getMessage(),"E R R O R",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"E R R O R",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
           
        }
         
   }
       public static DBConnection getCon() {
      if(instance == null) {
         instance = new DBConnection();
      }
      return instance;
   }

    
     public String getDays(int trip_ID){
                   String query = "(SELECT end_Date FROM tourEntry WHERE tour_ID = '"+trip_ID+"')";
       String noOfDays=null;
        try {
            resultSet=statement.executeQuery(query);
             if(resultSet.first())
         noOfDays=(resultSet.getObject(1).toString());
         
            } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex); 
        } 
            return noOfDays;
                 
      }
      public String getStartDate(int trip_ID){
                   String query = "(SELECT start_Date FROM tourEntry WHERE tour_ID = '"+trip_ID+"')";
       String startDate=null;
        try {
            resultSet=statement.executeQuery(query);
            if(resultSet.next())
         startDate=(resultSet.getString("start_Date"));
         
            } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex); 
        } 
            return startDate;
                 
      }
     
     
                 public String getDriverName(int driver_ID){
                   String query = "(SELECT name FROM driver WHERE  driver_ID = '"+driver_ID+"')";
                 String driverName=null;
         try {
            resultSet=statement.executeQuery(query);
             if(resultSet.next())
         driverName=(resultSet.getString("name"));
        
            } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex); 
        } 
          return driverName;
                 
      }
                 public String getCustomerName(int individual_ID){
                   String query = "(SELECT name FROM individual WHERE individual_ID = '"+individual_ID+"')";
                  String customerName=null;
         try {
            resultSet=statement.executeQuery(query);
             if(resultSet.first())
         customerName=(resultSet.getObject(1).toString());
         
            } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex); 
        } 
          return customerName;
                 
      }
                 public String getHotelName(int town_ID){
                   String query = "(SELECT hotel_name FROM hotel WHERE town_ID = '"+town_ID+"')";
                  String hotelName=null;
         try {
            resultSet=statement.executeQuery(query);
            if(resultSet.first())
         hotelName=(resultSet.getObject(1).toString());
         
            } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex); 
        } 
          return hotelName;
                 
      }
                  public int getHotelID(int trip_ID){
                   String query = "(SELECT overnight_stop FROM tourForBooking WHERE tour_ID = '"+trip_ID+"')";
       int hotelID=0;
        try {
            resultSet=statement.executeQuery(query);
             if(resultSet.first())
         hotelID=Integer.parseInt(resultSet.getObject(1).toString());
         
            } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex); 
        } 
            return hotelID;
                 
      }
                 public int getDriverID(int trip_ID){
                   String query = "(SELECT driver_ID FROM tourForScheduling WHERE tour_ID = '"+trip_ID+"')";
       int driverID=0;
        try {
            resultSet=statement.executeQuery(query);
            if(resultSet.first())
         driverID=Integer.parseInt(resultSet.getObject(1).toString());
         
            } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex); 
        } 
            return driverID;
                 
      }
          public int getNoOfPassengers(int trip_ID){
                   String query = "(SELECT no_of_passengers FROM tourEntry WHERE tour_ID = '"+trip_ID+"')";
       int noOfPassengers=0;
        try {
            resultSet=statement.executeQuery(query);
            if( resultSet.first())
         noOfPassengers=Integer.parseInt(resultSet.getObject(1).toString());
         
            } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex); 
        } 
            return noOfPassengers;
                 
      }
          
            public String getCustomerEmail(int trip_ID){
                   String query = "(SELECT contactEmail FROM tourEntry WHERE tour_ID = '"+trip_ID+"')";
                  String emailAddress=null;
         try {
            resultSet=statement.executeQuery(query);
            while(resultSet.next()){
         emailAddress=(resultSet.getString("contactEmail"));}
         
            } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex); 
        } 
          return emailAddress;
                 
      }
           public String getHotelEmail(int town_ID){
                   String query = "(SELECT email FROM hotel WHERE town_ID = '"+town_ID+"')";
                  String emailAddress=null;
         try {
            resultSet=statement.executeQuery(query);
            if(resultSet.first())
         emailAddress=(resultSet.getObject(1).toString());
         
            } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex); 
        } 
          return emailAddress;
                 
      } 
           public List<String> getTours1() throws SQLException {

        String sql = "SELECT tour_ID FROM trip WHERE trip.shedulingConformed=1 and trip.bookingConformed=0";
             resultSet=statement.executeQuery(sql);
        ArrayList<String> list = new ArrayList<String>();

        try {
            while (resultSet.next()) {
                String str1 = resultSet.getString("tour_ID");
                list.add(str1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDisplayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
public List<String> getTourDate1() throws SQLException {

        String sql = "SELECT start_Date FROM trip WHERE trip.shedulingConformed=1 and trip.bookingConformed=0";

         resultSet=statement.executeQuery(sql);
        ArrayList<String> list = new ArrayList<String>();

        try {
            while (resultSet.next()) {
                String str1 = resultSet.getString("start_Date");
                list.add(str1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDisplayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
 public boolean setBill(String billRef,String billDate,String hotel_name,String email,int no_of_Dates,int noOfpersons,int amount) throws SQLException{
    try{
         statement.executeUpdate("INSERT INTO `hotelbill` (`billRef`, `billDate`, `hotelName`, `email`, `no_of_DatesUsed`, `noOfpersons`, `amount`) VALUES ('"+billRef+"', '"+billDate+"', '"+hotel_name+"', '"+email+"', '"+no_of_Dates+"', '"+noOfpersons+"', '"+amount+"')");    
         return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        } 
   
    }
}
