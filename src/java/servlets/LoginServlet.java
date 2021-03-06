/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Database.DBConnection;
import Database.InterfaceHandlerLogin;
import Database.TourDisplayDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.validator.internal.util.Version;

/**
 *
 * @author Cassendra
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
            InterfaceHandlerLogin ih = new InterfaceHandlerLogin();
            String userName = (req.getParameter("userName"));
            String pass = (req.getParameter("pass"));
            
        try {
            if(ih.IsUserNameExist(userName)){
                if(ih.IsPasswordCorrect(userName,pass)){
                    List<String> tours;
                    tours = new TourDisplayDB().getTours1();
                    req.setAttribute("tours", tours);
                    List<String> tours_date = new TourDisplayDB().getTourDate1();
                    req.setAttribute("tours_date", tours_date);
                    RequestDispatcher view = req.getRequestDispatcher("indexBooking.jsp");
                    view.forward(req, resp);
                    
                }
                else {
                    
                    RequestDispatcher view = req.getRequestDispatcher("loginUser.jsp");
                    view.forward(req, resp);
                    
                }
            }
            else{
                
                RequestDispatcher view = req.getRequestDispatcher("loginUser.jsp");
                view.forward(req, resp);
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
           }
         
    
    

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

