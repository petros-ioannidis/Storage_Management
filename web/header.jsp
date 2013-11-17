<%-- 
    Document   : header
    Created on : Aug 23, 2013, 12:03:05 PM
    Author     : zbs
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String username = (String) request.getSession().getAttribute("username");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="storageWarsCss.css">
    </head>
    <body>
        <div class="box" style="position:absolute; left:80%;" >
            <% if (username == null) {%>
            <p> Not a user ? <a href="register.jsp">Register Now </a></p>   
            <form method="POST" name="Name Input Form" action="LogIn">
                username
                <input type="text" name="username">
                <br>
                password 
                <input type="password" name="password">
                <br>
                <br>
                <input type="submit" value="Sign me in" name="Sign me in" />
            </form>
            <%} else {%>
            <h2>
                Hello, <%= username%>!
            </h2>
            <br>
            <div class="smallBox" style="float:left;">
                <p4>
                    <a href="account.jsp">Account</a>
                </p4>
            </div>
            <div class="smallBox" style="float:right;">
                <p4>
                    <a href="logout.jsp">Sign out</a>
                </p4>

            </div>
            <%}%>
        </div>
    </body>
</html>
