/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 *
 * @author Yas
 */
public class ReceptionManipulation {
     static String   CustomerNIC, ContactNo,Email,Name;   
     Date Date2,StartDate;
     static int No_People,duration_days,TourRef,Route;
     public String setCustomer(Date Date,int TourRef,String CustomerNIC,String ContactNo,String Email,int Route,Date StartDate,int No_People,int duration_days,String name){
         this.Date2=Date;
         this.TourRef=TourRef;
         this.CustomerNIC=CustomerNIC;        
         this.ContactNo=ContactNo;        
         this.Email =Email;       
         this.Route =Route;       
         this.StartDate=StartDate;                  
         this.No_People=No_People;
          this.duration_days=duration_days;  
          this.Name=name;
         String sql = "INSERT INTO tourentry(tour_ID,Start_Date,Duration,individualNIC,no_of_passengers,Enter_Date,Route_ID) VALUES(?,?,?,?,?,?,?)";     	
	 String sql1= "INSERT INTO individual(individualNIC,ContactNo,contactEmail,CustomerName) VALUES (?,?,?,?)" ; 		
         try{
                
		Connection con=null;
                con=ReceptionDB.getCon();
                
                PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);                                 	
                ps.setInt(1,this.TourRef);   
                ps.setDate(2, (java.sql.Date) this.StartDate);                 
                ps.setInt(3,this.duration_days);   
                ps.setString(4,this.CustomerNIC);
                ps.setInt(5,this.No_People);                        
		ps.setDate(6, (java.sql.Date) this.Date2);     
                ps.setInt(7,this.Route);
                int i= ps.executeUpdate(); 
                ps.close();  
                
                PreparedStatement ps1=(PreparedStatement) con.prepareStatement(sql1); 
                ps1.setString(1,this.CustomerNIC);
                ps1.setString(2,this.ContactNo); 
                ps1.setString(3,this.Email); 
                ps1.setString(4,this.Name);
                ps1.executeUpdate(); 
                ps1.close();
                con.close();
                if(i!=0){
                   return "success"; 
                }else{
                     return "error"; 
                }                             
                } catch(SQLException se){
                }catch(Exception e){               
                 e.printStackTrace(); 
                } 
                return "";
    }
}
