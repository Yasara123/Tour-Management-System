/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.im.model;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yas
 */
public class DriverManipulation {
    
    static String driverCode;
    static String coachID;
    static String tourCode;
    public List<String> getDriver(String tourCode){
        
        this.tourCode=tourCode;

        
        String sql="SELECT driver_ID FROM driver_route WHERE route_ID IN (SELECT route_ID FROM tourentry WHERE tour_ID="+tourCode+")";
        
        
        
	try{
		Connection con=DB.getCon();
                
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		
		ResultSet rs=(ResultSet) ps.executeQuery();
                
                List<String> list = new ArrayList<String>();
                
                while(rs.next()){
                    String str1=rs.getString("driver_ID");
			list.add(str1);
		}
                 return list;
                
		}
		catch(Exception e){
		return null;
                }   
    }
    
    public List<String> getCoach(){
      String sql="SELECT * FROM coach WHERE isAvailable=1";
		
		try{
		Connection con=DB.getCon();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		
		ResultSet rs=(ResultSet) ps.executeQuery();
                
                List<String> list = new ArrayList<String>();
                
                while(rs.next()){
			String str1=rs.getString("Coach_ID");
                        System.out.println(str1);
			list.add(str1);
		}
                 return list;
                
		}
		catch(Exception e){
		return null;
                }   
    }
    
    public void confirmTour(){
        
       String sql="UPDATE tourforscheduling SET shedulingConformed=true WHERE trip_ID="+tourCode;
		try{
		Connection con=DB.getCon();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		
		ps.executeUpdate();
		}
		catch(Exception e){
                }   
        
    }
    
    
     public List<String> getTour(){
      String sql="SELECT newentryforschedulig FROM Trip WHERE bookingconformed=false";
		
		try{
		Connection con=DB.getCon();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		
		ResultSet rs=(ResultSet) ps.executeQuery();
                
                List<String> list = new ArrayList<String>();
                
                while(rs.next()){
			String str1=rs.getString("trip_ID");
			list.add(str1);
		}
                 return list;
                
		}
		catch(Exception e){
		return null;
                }   
    }
     
     public void assignDriver(String driverC){
        driverCode=driverC;
         System.out.println("driverCode="+driverCode);
     }
     
     public void assignCoach(String coachC){
         coachID=coachC;
         System.out.println("coachID="+coachID);
     }
     
     public void reserveAll(){
         String sql="INSERT INTO tourforscheduling(tour_ID,driver_ID,coach_ID,shedulingConformed) VALUES ("+this.tourCode+","+this.driverCode+","+this.coachID+","+1+")";
		try{
		Connection con=DB.getCon();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
		
		ps.executeUpdate();
		}
		catch(Exception e){
                }
     }
}
