<%-- 
    Document   : EditStorage
    Created on : Aug 30, 2013, 1:25:42 AM
    Author     : zbs
--%>

<%@page import="storage.StorageUnit"%>
<%@page import="storage.products.ProductType"%>
<%@page import="java.util.List"%>
<%@page import="database.util.UserDatabase"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<jsp:include page="search.jsp"/>
<jsp:include page="sidebar.jsp"/>
<!DOCTYPE html>
<%
    String name = (String) request.getParameter("edit");
    List<ProductType> products = UserDatabase.getAllProducts(name);
    StorageUnit unit = UserDatabase.getStorage(name);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="storageWarsCss.css">

        <title>Edit Storage</title>
    </head>
    <body>

        <div class="bigBox" style="margin:0 auto;">
            <form method="GET" action="UpdateStorage">
                <table border="1">
                    <tr>
                        <td> Name </td>
                        <td> <%= unit.getName()%> </td>
                        <td>
                            <input type="hidden" name="name" value=" <%= unit.getName()%>"/>
                        </td>
                    <tr>
                        <td>description</td>
                        <td>  <%= unit.getDescription()%> </td>  
                        <td>
                            <input type="text" name="description" value="<%= unit.getDescription()%>"/>
                        </td>
                    </tr>
                    <tr>
                        <td>location</td>
                        <td>  <%= unit.getLocation()%> </td>  
                        <td>
                            <input type="text" name="location" value="<%= unit.getLocation()%>" />
                        </td>
                    </tr>
                    <td>open</td>
                    <td>  <%= unit.getOpen()%> </td>  
                    <td>
                        <input type="checkbox" name="open" <%= (unit.getOpen() == true ? "checked" : "")%>  />
                    </td>
                    </tr>
                </table>
                <input type="submit" value="save" />
            </form>
        </div>

        <div class="bigBox">
            <% for (int i = 0; i < products.size(); i++) {%>

            <table border="1">
                <tr>
                    <td>  <%= (i + 1)%>  </td>
                    <td>  <%= products.get(i).getName()%> </td>
                </tr>
            </table>
            <% }%>    
        </div>
    </body>
</html>
