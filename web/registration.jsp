<%-- 
    Document   : index
    Created on : Feb 27, 2017, 11:14:17 AM
    Author     : Oliver
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <link href= "index.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Anton|Lobster" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Abril+Fatface|Anton" rel="stylesheet"> 
        <link href= "../Websites/Website2/css/font-awesome.min.css" rel="stylesheet" type="text/css">	
        <meta charset="utf-8">
        <title>Cupcake Factory</title>
    </head>
    <body>
        <div id="container">
        <img src="2.jpg">	
            <form name="registration" action="RegControler" method="POST">
                <div id="form-input">
                    <input type="text" name="cname" placeholder="Enter full name">
                </div>

                <div id="form-input">
                    <input type="text" name="username" placeholder="Enter username">
                </div>

                <div id="form-input">
                    <input type="text" name="password" placeholder="Enter password">
                </div>

                <div id="form-input">
                    <input type="text" name="email" placeholder="Enter email">
                </div>

                <div id="form-input">
                    <input type="submit" name="submit" value="REGISTER NOW" id="btn-login"><br>
                </div>
            </form>
    </body>
</html>
