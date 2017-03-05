<%-- 
    Document   : shop
    Created on : Mar 2, 2017, 1:05:40 PM
    Author     : Oliver
--%>

<%@page import="domain.entity.Customer"%>
<%@page import="domain.entity.Bottom"%>
<%@page import="data.CakeMapper"%>
<%@page import="java.util.List"%>
<%@page import="domain.entity.Topping"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link href= "shop.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Abril+Fatface|Dancing+Script" rel="stylesheet"> 
        <link href="https://fonts.googleapis.com/css?family=Abril+Fatface|Acme|Dancing+Script" rel="stylesheet"> 
        <link href="https://fonts.googleapis.com/css?family=Taviraj|Yellowtail" rel="stylesheet"> 
        <link href="https://fonts.googleapis.com/css?family=Bevan|Pattaya" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
        <script src="info.js"></script>
        <title>Cupcake Factory</title>
    </head>
    <body>
    <header>
        <div id ="nav">
            <u1>
                <div id="nav2">
                    <h1>Cupcake Factory</h1>
                </div>
                <li>
                    <form method="get" action="LogoutController">
                        <button type="sumit">Logout</button>
                    </form></li>	
            </u1>
        </div>
    </header>
        <center>
            <h2>Shop</h2>
        </center>
        <% CakeMapper cakem = new CakeMapper(); %>
        
        <form name="shop" action="CakeController" method="POST">
            <h3>Toppings</h3>
            <div id="toppings">
                <%
                    List<Topping> theTops = cakem.getToppings();
                    
                    for(Topping topping : theTops) {
                        out.print("<div>");
                        out.print("<img width=\"100\"" + topping.getName() + ".png\">");
                        out.print("<p>" + topping.getName() + "</p>");
                        out.print("<p>" + topping.getPrice() + "</p>");
                        out.print("<input name=\"Top\" class=\"cakepart\" type=\"radio\">");
                        out.print("<input type=\"hidden\" value=\"" + topping.getTopid()+ "\">");
                        out.print("</div>");
                    }
                %>
            </div>
            
            <h3>Bottoms</h3>
            <div id="bottoms">
                <%
                    List<Bottom> theBottoms = cakem.getBottoms();
                    for(Bottom bottom : theBottoms) {
                        out.print("<div>");
                        out.print("<img width=\"100\"" + bottom.getName() + ".png\">");
                        out.print("<p>" + bottom.getName() + "</p>");
                        out.print("<p>" + bottom.getPrice() + "</p>");
                        out.print("<input name=\"Bottom\" class=\"cakepart\" type=\"radio\">");
                        out.print("<input type=\"hidden\" value=\"" + bottom.getBotid()+ "\">");
                        out.print("</div>");
                    }
                %>
            </div>
            
            <p>Price: <span id="CakePrice">0</span>$    </p>
            <label>Quantity</label><input type="text" id="quantity">
            
            <br>
            
            <input id="ButtonAddCakes" type="button" value="Add cakes">
            
            
            <br>
            
            <table>
                <thead>
                    <tr>
                        <th>Top</th>
                        <th>Bottom</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>SubTotal</th>
                    </tr>
                </thead>
                <tbody id="orderlines">                    
                </tbody>
            </table>            
            
            <div id="cakes">
            </div>
            
            <p>Total: <span id="total"></span></p>
            
            <input id="ButtonOrderCakes" type="submit" value="Order" disabled="disabled">
        </form>
    </body>
    
    <div id="copy">	
        <p>&copy; 2017 CupcakeFactory.dk</p>
    </div>	
</html>
