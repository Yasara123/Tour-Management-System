/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Database.TourDisplayDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nathie
 */
public class checkAvailability extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       
        String hotel_name=request.getParameter("hotname");
        int no_of_rooms=Integer.parseInt(request.getParameter("roomNo"));
       
        String para2="\""+hotel_name+"\"";
        
        System.out.println(para2);
        List<String> bookings = new TourDisplayDB().getBookings(para2);
        int booking=Integer.parseInt(bookings.get(0));
        
        List<String> capacity = new TourDisplayDB().getCapacity(para2);
        int cap=Integer.parseInt(capacity.get(0));
        
        List<String> email = new TourDisplayDB().getHotelEmail(para2);
        String email2=email.get(0);
        
        List<String> room_p = new TourDisplayDB().getPrice(para2);
        String room_price=room_p.get(0);
        
        
     if ((booking+no_of_rooms)<=6)
            
        {
            String message="The requested number of rooms are available";
            request.setAttribute("message", message);
            request.setAttribute("tours_date", request.getParameter("date"));
            request.setAttribute("tours", request.getParameter("tour_ID"));
            request.setAttribute("hotel_name", hotel_name);
            request.setAttribute("hotemail", email2);
            request.setAttribute("room_price", room_price);
            request.setAttribute("roomNo", request.getParameter("roomNo"));
            RequestDispatcher view = request.getRequestDispatcher("hotelConfirmation3.jsp");
            view.forward(request, response);
            
        }
        else 
        {
                 String message="The requested number of rooms are NOT available";
            request.setAttribute("message", message);
            request.setAttribute("tours_date", request.getParameter("date"));
            request.setAttribute("tours", request.getParameter("tour_ID"));
            request.setAttribute("hotel_name", hotel_name);
            request.setAttribute("hotemail", email2);
            request.setAttribute("room_price", room_price);
            request.setAttribute("roomNo", request.getParameter("roomNo"));
            RequestDispatcher view = request.getRequestDispatcher("hotelConfirmation2.jsp");
            view.forward(request, response);
        }
        
        
      
        
      
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
        processRequest(request, response);
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
        processRequest(request, response);
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
