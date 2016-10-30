/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Database.DBConnection;
import Database.InterfaceHandler;
import Database.InterfaceHandlerLogin;
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
public class SelectedTour extends HttpServlet {
//InterfaceHandler ih = new InterfaceHandler();
    

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String temp=request.getParameter("ToursSelect");
  
        List<String> tourss = new TourDisplayDB().getTours(temp);
        String tours=tourss.get(0);
        request.setAttribute("tours", tours);

        List<String> tours_dates = new TourDisplayDB().getTourDate(temp);
        String tours_date=tours_dates.get(0);
        request.setAttribute("tours_date", tours_date);

        List<String> hotel_names = new TourDisplayDB().getHotelName(temp);
        String hotel_name=hotel_names.get(0);
        request.setAttribute("hotel_name", hotel_name);
        
        List<String> hotel_nums = new TourDisplayDB().getHotelNum(temp);
        String hotel_num=hotel_nums.get(0);
        request.setAttribute("hotel_num", hotel_num);
       // List<String> client_name = new TourDisplayDB().getClientName(temp);
       // request.setAttribute("client_name", client_name);
   // int noPass = (ih.getNoOfPassengers(Integer.parseInt(temp)));
    
      //  request.setAttribute("numPas ", noPass);

        RequestDispatcher view = request.getRequestDispatcher("hotelConfirmation.jsp");
        view.forward(request, response);
       
    }

}
