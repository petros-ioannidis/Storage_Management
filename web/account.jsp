<%-- 
    Document   : account
    Created on : Aug 24, 2013, 11:08:36 PM
    Author     : zbs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp" />
<jsp:include page="search.jsp"/>
<jsp:include page="sidebar.jsp"/>


<%
    String username = (String) request.getSession().getAttribute("username");
    String role = (String) request.getSession().getAttribute("role");
    Boolean storage_read = (Boolean) request.getSession().getAttribute("storage_read");
    Boolean storage_write = (Boolean) request.getSession().getAttribute("storage_write");
    Boolean product_read = (Boolean) request.getSession().getAttribute("product_read");
    Boolean product_write = (Boolean) request.getSession().getAttribute("product_write");
    Boolean supplier_read = (Boolean) request.getSession().getAttribute("supplier_read");
    Boolean supplier_write = (Boolean) request.getSession().getAttribute("supplier_write");
    String name = (String) request.getSession().getAttribute("name");
    String surname = (String) request.getSession().getAttribute("surname");
    String email = (String) request.getSession().getAttribute("email");
    Boolean full_user = (Boolean) request.getSession().getAttribute("full_user");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account</title>
    </head>
    <body>
        <div class="bigBox" style="margin:0 auto;">
            <table>
                <tr>
                    <td>Username</td>
                    <td><%= username%></td>
                </tr>
                <tr>
                    <td>Role</td>
                    <td><%= role%></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><%= name%></td>
                </tr>
                <tr>
                    <td>Surname</td>
                    <td><%= surname%></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><%= email%></td>
                </tr>
                <tr>
                    <td>Full User</td>
                    <td><%= full_user%></td>
                </tr>
            </table>
        </div>

    </body>
</html>
