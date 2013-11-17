<%-- 
    Document   : EditSupplier
    Created on : Aug 30, 2013, 1:50:52 AM
    Author     : zbs
--%>

<%@page import="storage.Supplier"%>
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
    String surname = (String) request.getParameter("suredit");
    List<ProductType> products = UserDatabase.getAllProducts(name, surname);
    Supplier supplier = UserDatabase.getSupplier(name, surname);
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="storageWarsCss.css">

        <title>Edit Supplier</title>
    </head>
    <body>

        <div class="bigBox" style="margin:0 auto;">
            <form method="GET" action="UpdateSupplier">
                <table border="1">
                    <tr>
                        <td>name</td>
                        <td>  <%= supplier.getName()%></td>  
                        <td>
                            <input type="hidden" name="name" value="  <%= supplier.getName()%> "/>
                        </td>
                    </tr>
                    <tr>            
                        <td>surname</td>
                        <td>  <%= supplier.getSurname()%> </td>  
                        <td>
                            <input type="hidden" name="surname" value="  <%= supplier.getSurname()%> "/>
                        </td>
                    </tr>
                    <tr>
                        <td>description</td>
                        <td>  <%= supplier.getAddress()%> </td>  
                        <td>
                            <input type="text" name="address" value="  <%= supplier.getAddress()%> "/>
                        </td>
                    </tr>
                    <tr>
                        <td>size</td>
                        <td>  <%= supplier.getSSN()%> </td>
                        <td>
                            <input type="text" name="SSN" value="  <%= supplier.getSSN()%> " />
                        </td>
                    </tr>
                </table>
                <input type="submit" value="save" />
            </form>
        </div>
        <div class="bigBox">
            <table border="1">

                <%  for (int i = 0; i < products.size(); i++) {%>

                <tr>
                    <td>  <%= (i + 1)%> </td>
                    <td>  <%= products.get(i).getName()%> </td>
                </tr>
                <% }%>   
            </table>

        </div>

    </body>
</html>
