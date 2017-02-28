/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.entity.Customer;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Oliver
 */
@WebServlet(name = "RegControler", urlPatterns = {"/RegControler"})
public class RegControler extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CustomerMapper cm = new CustomerMapper();
        
        try {
            
            response.setContentType("text/html; charset=UTF-8");
            
            //Get data from JSP-form
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String cname = request.getParameter("cname");
            String email = request.getParameter("email");
            
            //Indsætte oplysniger i databasen
            cm.setCustomer(username, password, cname, email, 100);
            
            
            
            //Sender data
            request.getRequestDispatcher("view.jsp").forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
            processRequest(request, response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            processRequest(request, response);
        }

        @Override
        public String getServletInfo() {
            return "Short description";
        }
        
    }

