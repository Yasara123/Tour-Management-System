/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.im.web;

import com.im.model.DriverManipulation;
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
 * @author Dulan
 */
public class TourConfirm extends HttpServlet {
@Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        DriverManipulation dm=new DriverManipulation();
        dm.assignDriver(request.getParameter("driverCode"));
        dm.assignCoach(request.getParameter("coach"));
        dm.reserveAll();
        dm.confirmTour();
        response.sendRedirect("booking.jsp");
    }
}

