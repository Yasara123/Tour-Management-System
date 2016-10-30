/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Database.BillDB;
import Database.DBChecker;
import Database.DBConnection;
import Database.TourDisplayDB;
import com.exampleCustomer.EmailSessionBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nathie
 */
public class Bill extends HttpServlet {
private DBChecker dbc = new DBChecker();
private DBConnection db = new DBConnection();
@EJB
private EmailSessionBean emailBean;
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, MessagingException {
        
        String billRef=request.getParameter("tour_ID");
        dbc.emailInstance(Integer.parseInt(billRef));
        String billDate="2015.07.17";
        
        List<String> hot_name = new TourDisplayDB().getHotelName(billRef);
        String hotel_name=hot_name.get(0);
        
        String hote_name="\""+hotel_name+"\"";
        
        List<String> hot_email = new TourDisplayDB().getHotelEmail(hote_name);
        String email=hot_email.get(0);
       
         int noOfpersons=Integer.parseInt(request.getParameter("pas_no"));
         int no_of_Dates=1;
         int amount=Integer.parseInt( request.getParameter("bill"));
       
        
    //     db.setBill(billRef, billDate, hotel_name, email, no_of_Dates, noOfpersons, amount);
    
            request.setAttribute("bill_ref", billRef);
            request.setAttribute("bill_date", billDate);
            request.setAttribute("hotel_name", hotel_name);
            request.setAttribute("email", email);
            request.setAttribute("pas_no", noOfpersons);
            request.setAttribute("days", no_of_Dates);
            request.setAttribute("bill", amount);
            
            RequestDispatcher view = request.getRequestDispatcher("hotelBill.jsp");
        view.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        processRequest(request, response);
    } catch (SQLException ex) {
        Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);
    } catch (MessagingException ex) {
        Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        processRequest(request, response);
    } catch (SQLException ex) {
        Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);
    } catch (MessagingException ex) {
        Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
