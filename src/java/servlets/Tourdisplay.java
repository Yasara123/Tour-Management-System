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
public class Tourdisplay extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<String> tours = new TourDisplayDB().getTours1();
        request.setAttribute("tours", tours);
        List<String> tours_date = new TourDisplayDB().getTourDate1();
        request.setAttribute("tours_date", tours_date);
        RequestDispatcher view = request.getRequestDispatcher("indexBooking.jsp");
        view.forward(request, response);
    }

}
