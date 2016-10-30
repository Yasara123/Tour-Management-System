package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TourDisplayDB {

    public ResultSet getCon(String sql) {

        try {
            Connection con = DBBasic.getCon();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

            ResultSet rs = (ResultSet) ps.executeQuery();

            return rs;

        } catch (Exception e) {
            return null;
        }

    }

    public List<String> getClientEmail(String para) {

        String sql = "SELECT email FROM tourentry,individual WHERE tourentry.tour_ID=" + para + " and tourentry.tour_ID=individual.tour_ID";

        ResultSet rs = getCon(sql);
        ArrayList<String> list = new ArrayList<String>();

        try {
            while (rs.next()) {
                String str1 = rs.getString("email");
                list.add(str1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDisplayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public List<String> getClientName(String para) {

        String sql = "SELECT customerName FROM tourentry,individual WHERE tourentry.tour_ID=" + para + " and tourentry.individualNIC=individual.individualNIC";

        ResultSet rs = getCon(sql);
        ArrayList<String> list = new ArrayList<String>();

        try {
            while (rs.next()) {
                String str1 = rs.getString("name");
                list.add(str1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDisplayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public List<String> getTripPrice(String para) {

        String sql = "SELECT Price FROM route,tourentry WHERE tourentry.tour_ID=" + para + " and tourentry.route_ID=route.route_ID";

        ResultSet rs = getCon(sql);
        ArrayList<String> list = new ArrayList<String>();

        try {
            while (rs.next()) {
                String str1 = rs.getString("Price");
                list.add(str1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDisplayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public List<String> getPackageNo(String para) {

        String sql = "SELECT route_ID FROM tourentry WHERE tourentry.tour_ID=" + para;

        ResultSet rs = getCon(sql);
        ArrayList<String> list = new ArrayList<String>();

        try {
            while (rs.next()) {
                String str1 = rs.getString("route_ID");
                list.add(str1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDisplayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public List<String> getTours(String para) {

        String sql = "SELECT tour_ID FROM tourentry WHERE tourentry.tour_ID=" + para;

        ResultSet rs = getCon(sql);
        ArrayList<String> list = new ArrayList<String>();

        try {
            while (rs.next()) {
                String str1 = rs.getString("tour_ID");
                list.add(str1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDisplayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public List<String> getTours1() {

        String sql = "SELECT tour_ID FROM newentryforbooking where bookingconformed=0";

        ResultSet rs = getCon(sql);
        ArrayList<String> list = new ArrayList<String>();

        try {
            while (rs.next()) {
                String str1 = rs.getString("tour_ID");
                list.add(str1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDisplayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public List<String> getTourDate(String para) {

        String sql = "SELECT start_Date FROM tourentry WHERE tourentry.tour_ID=" + para;

        ResultSet rs = getCon(sql);
        ArrayList<String> list = new ArrayList<String>();

        try {
            while (rs.next()) {
                String str1 = rs.getString("start_Date");
                list.add(str1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDisplayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public List<String> getTourDate1() {

        String sql = "SELECT start_Date FROM tourentry,newentryforbooking WHERE tourentry.tour_ID=newentryforbooking.tour_ID";

        ResultSet rs = getCon(sql);
        ArrayList<String> list = new ArrayList<String>();

        try {
            while (rs.next()) {
                String str1 = rs.getString("start_Date");
                list.add(str1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDisplayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public List<String> getEmail(String para) {

        String sql = "SELECT contactEmail FROM trip WHERE trip.tour_ID+" + para;

        ResultSet rs = getCon(sql);
        ArrayList<String> list = new ArrayList<String>();

        try {
            while (rs.next()) {
                String str1 = rs.getString("contactEmail");
                list.add(str1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDisplayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public List<String> getPassenger(String para) {

        String sql = "SELECT no_of_passengers FROM tourentry WHERE tourentry.tour_ID=" + para;

        ResultSet rs = getCon(sql);
        ArrayList<String> list = new ArrayList<String>();

        try {
            while (rs.next()) {
                String str1 = rs.getString("no_of_passengers");
                list.add(str1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDisplayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public List<String> getHotelName(String para) {

        String sql = "SELECT DISTINCT hotel_name FROM hotel_possible_tour WHERE tour_ID="+para+")" ;

        ResultSet rs = getCon(sql);
        ArrayList<String> list = new ArrayList<String>();

        try {
            while (rs.next()) {
                String str1 = rs.getString("hotel_name");
                list.add(str1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDisplayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public List<String> getHotelNum(String para) {
                       
        String sql ="SELECT DISTINCT hotel_num FROM hotel_possible_tour WHERE tour_ID="+para+")" ;

        ResultSet rs = getCon(sql);
        ArrayList<String> list = new ArrayList<String>();

        try {
            while (rs.next()) {
                String str1 = rs.getString("hotel_num");
                list.add(str1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDisplayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public List<String> getBookings(String para) {

        String sql = "SELECT bookings FROM hotel WHERE hotel_name=" + para;

        ResultSet rs = getCon(sql);
        ArrayList<String> list = new ArrayList<String>();

        try {
            while (rs.next()) {
                String str1 = rs.getString("bookings");
                list.add(str1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDisplayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public List<String> getHotelEmail(String para) {

        String sql = "SELECT email FROM hotel WHERE hotel_name=" + para;

        ResultSet rs = getCon(sql);
        ArrayList<String> list = new ArrayList<String>();

        try {
            while (rs.next()) {
                String str1 = rs.getString("email");
                list.add(str1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDisplayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public List<String> getCapacity(String hotel_name) {
        String sql = "SELECT available_capacity FROM hotel WHERE hotel_name=" + hotel_name;

        ResultSet rs = getCon(sql);
        ArrayList<String> list = new ArrayList<String>();

        try {
            while (rs.next()) {
                String str1 = rs.getString("available_capacity");
                list.add(str1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDisplayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<String> getPrice(String para2) {
        String sql = "SELECT ChargePerDay FROM hotel WHERE hotel_name=" + para2;

        ResultSet rs = getCon(sql);
        ArrayList<String> list = new ArrayList<String>();

        try {
            while (rs.next()) {
                String str1 = rs.getString("ChargePerDay");
                list.add(str1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDisplayDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
              
    public List<String> getHotelID(String trip_ID) throws SQLException{
                   String query = "(SELECT overnight_stop FROM tour WHERE trip_ID = '"+trip_ID+"')";
        ResultSet rs = getCon(query);
        ArrayList<String> list = new ArrayList<String>();

        try {
            while (rs.next()) {
                String str1 = rs.getString("price");
                list.add(str1);
            }}
            catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex); 
        } 
        return list;
                 
      }
         
}
