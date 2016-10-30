
package com.im.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.im.model.DriverManipulation;

public class DriverAssignment extends HttpServlet {

   
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<String> drivers = new DriverManipulation().getDriver(request.getParameter("tourCode"));
        List<String> coaches = new DriverManipulation().getCoach();
        request.setAttribute("drivers", drivers);
        request.setAttribute("Reg",coaches);
        RequestDispatcher view = request.getRequestDispatcher("driver.jsp");
        view.forward(request, response);
    }
}