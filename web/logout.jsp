<%-- 
    Document   : logout
    Created on : Aug 24, 2013, 9:43:31 PM
    Author     : zbs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession Session = request.getSession();
    Session.invalidate();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <% response.sendRedirect("index.jsp");%>
    </body>
</html>
