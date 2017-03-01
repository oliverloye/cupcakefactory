<%-- 
    Document   : view
    Created on : Feb 28, 2017, 2:17:49 PM
    Author     : Oliver
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <link href= "css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href= "login.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Anton|Lobster" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Abril+Fatface|Anton" rel="stylesheet"> 
        <meta charset="utf-8">
        <title>Cupcake Factory</title>
    </head>
    <body>
        <div id="container">
        <img src="">
        <form name="login" action="LoginContoler" method="POST">
            <div id="form-input">
                <input type="text" name="username" placeholder="Enter username">
            </div>

            <div id="form-input">
                <input type="text" name="password" placeholder="Enter password">	
            </div>
            <div id="form-input">
                <input type="submit" name="submit" value="SIGN IN" id="btn-login"><br>
            </div>
                <a href="#">Forgot Password?</a>
        </form>

    </body>

</html>
