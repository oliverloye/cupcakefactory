/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Oliver
 */
@WebServlet(name = "LoginControler", urlPatterns = {"/LoginControler"})
public class LoginControler extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CustomerMapper cm = new CustomerMapper();
        
        response.setContentType("text/html; charset=UTF-8");
        
        //Get data from login.jsp
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        
        
        if(cm.checkCustomerLogin(username, password) == false) {
            request.getRequestDispatcher("errorLogin.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
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
