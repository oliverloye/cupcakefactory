/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.entity.Customer;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Oliver
 */
@WebServlet(name = "Controller", urlPatterns ={"/Controller"})
public class Controller extends HttpServlet
{
    CustomerMapper cm = new CustomerMapper();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String origin = request.getParameter("origin");
        HttpSession session = request.getSession();

        Customer customer;
        String username, password, cname, email;
        
        switch (origin)
        {
            case "login":

                session = request.getSession();
                username = request.getParameter("name");
                password = request.getParameter("password");
                customer = cm.validateCustomer(username, password);

                if (customer == null)
                {
                    response.sendRedirect("errorLogin.jsp");

                }
                else
                {
                    session.setAttribute("customer", customer);
                    response.sendRedirect("shop.jsp");
                }

                break;
                
            case "logout":

                if (session.getAttribute("customer") != null)
                {
                    session.setAttribute("customer", null);
                    response.sendRedirect("index.jsp");
                }

                break;
                
                
            case "registration":
                
                try {
                    username = request.getParameter("username");
                    password = request.getParameter("password");
                    cname = request.getParameter("cname");
                    email = request.getParameter("email");

                    if(cm.checkUsernameExsist(username) == false) {
                        if(cm.checkEmailExists(email) == false) {
                            cm.setCustomer(username, password, cname, email, 100);
                            request.getRequestDispatcher("login.jsp").forward(request, response);

                        } else {

                        request.getRequestDispatcher("error.jsp").forward(request, response);
                        }
                    } else {
                    request.getRequestDispatcher("errorUsername.jsp").forward(request, response);
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                break;
                
//            case "order":
//
//                String[] topids = request.getParameterValues("cakestopid");
//                String[] bottomids = request.getParameterValues("cakesbottomid");
//                String[] quantities = request.getParameterValues("cakesquantity");
//                
//                for(int i = 0; i < topids.length; i++)
//                {
//                    System.out.println(topids[i] + bottomids[i] + quantities[i]);
//                }
//
//                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }
}