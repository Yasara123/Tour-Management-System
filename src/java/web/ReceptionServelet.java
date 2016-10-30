/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ReceptionManipulation;
/**
 *
 * @author Yas
 */
public class ReceptionServelet extends HttpServlet{
    /**
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // date should be fill like this "7-Jun-2015"
       SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date datet, dates;
        datet= dates= null;
        java.sql.Date sdatet, sdates;
        sdatet= sdates=null;
        //for tour table
       String duration_days=request.getParameter("duration_days"); 
       String Route = request.getParameter("Route");
       String TourRef = request.getParameter("TourRef");   //trip_ID  
       //for trip table
       String Date =request.getParameter("Date");//	Enter_Date  
       String CustomerNIC = request.getParameter("CustomerNIC");
       String ContactNo = request.getParameter("ContactNo");
       String Email = request.getParameter("Email");    
       String StartDate = request.getParameter("StartDate");//	start_Date        
       String No_People = request.getParameter("No_People"); 
       String name=request.getParameter("name");
       
       String error= null;

        try {
             datet = (Date) formatter.parse(Date);
             dates = (Date) formatter.parse(StartDate);
             
             sdatet=new java.sql.Date(datet.getTime());
             sdates=new java.sql.Date(dates.getTime());
             
        } catch (java.text.ParseException ex) {
  ;
        }
		
       error=new DataValidate().Validate(CustomerNIC, ContactNo,Email,dates,datet); 
       if(error==null){
         int tourR,Rt,people,days;  
       try{  
        try{          
            tourR=Integer.parseInt(TourRef);
            Rt=Integer.parseInt(Route);
            people=Integer.parseInt(No_People);
            days=Integer.parseInt(duration_days);
       } catch (NumberFormatException e) {
        tourR=1;
        Rt=10;
        people=1;
        days=1;
    }
        String status = new ReceptionManipulation().setCustomer(sdatet, tourR,CustomerNIC, ContactNo,Email, Rt,sdates,people,days,name);
       if(status=="success"){  
        response.sendRedirect("success.jsp"); 
       }else if (status.equals("error")){     
        response.sendRedirect("Error.jsp"); 
       }
      }catch(Exception e){
        e.printStackTrace();
	
       } 
       }else{
          response.sendRedirect("Error.jsp");  
          
       }  
    }
    
}
