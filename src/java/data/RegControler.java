/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.entity.Customer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Oliver
 */
public class RegControler {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        response.setContentType("text/html; charset=UTF-8");
        
        //Get data from JSP-form
        String cname = request.getParameter("cname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        
        //Indsætte oplysniger i databasen
        
        
        //Set data
        
        request.getSession().setAttribute("cname", cname);
        request.getSession().setAttribute("username", username);
        request.getSession().setAttribute("password", password);
        request.getSession().setAttribute("email", email);
        
        //Sender data
        request.getRequestDispatcher("view.jsp").forward(request, response);
        
    }
}
