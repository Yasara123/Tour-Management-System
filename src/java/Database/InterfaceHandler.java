/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author Cassendra
 */
public class InterfaceHandler {
    DBConnection db;
    public InterfaceHandler() {
        db = DBConnection.getCon();
    }
       public String getDays(int trip_ID){
        return db.getDays(trip_ID);
    }
       public String getStartDate(int trip_ID){
           return db.getStartDate(trip_ID);
       }
        public String getDriverName(int driver_ID){
              return db.getDriverName(driver_ID);
        }
        public String getCustomerName(int trip_ID){
            return db.getCustomerName(trip_ID);
        }
        public String getHotelName(int town_ID){
            return  db.getHotelName(town_ID);
        }
        public int getHotelID(int trip_ID){
            return db.getHotelID(trip_ID);
        }
         public int getDriverID(int trip_ID){
             return db.getDriverID(trip_ID);
         }
         public int getNoOfPassengers(int trip_ID){
             return db.getNoOfPassengers(trip_ID);
         }
        
          public String getCustomerEmail(int trip_ID){
              return db.getCustomerEmail(trip_ID);
          }
          public String getHotelEmail(int town_ID){
              return db.getHotelEmail(town_ID);
          }
          
}
