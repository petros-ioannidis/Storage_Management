<%-- 
    Document   : productform
    Created on : Aug 29, 2013, 6:39:45 PM
    Author     : zbs
--%>

<%@page import="database.util.UserDatabase"%>
<%@page import="java.util.List"%>
<%@page import="storage.Supplier"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<jsp:include page="search.jsp"/>
<jsp:include page="sidebar.jsp"/>

<!DOCTYPE html>
<%
    List<Supplier> suppliers = UserDatabase.getAllSuppliers();
    
    String list_output = "<select>";
    
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="bigBox" style="margin:0 auto;">
            <form method="GET" action="AddProduct">
                <table border="1">
                    <tr>
                        <td>name</td>
                        <td><input type="text" name="name"/></td>
                    </tr>
                    <tr>
                        <td>serialNum</td>
                        <td><input type="text" name="serialNum"/></td>
                    </tr>
                    <tr>
                        <td>description</td>
                        <td><input type="text" name="description"/>
                    </tr>  
                    <tr>
                        <td>productType</td>
                        <td><input type="text" name="productType"/></td>
                    </tr>
                    <tr>
                        <td>size</td>
                        <td><input type="text" name="size"/></td>
                    </tr>
                    <tr>
                        <td>price</td>
                        <td><input type="number" name="price"/></td>
                    </tr>
                    <tr>
                        <td>quantity</td>
                        <td><input type="number" name="quantity"/></td>
                    </tr>
                    <td>weight</td>
                    <td><input type="number" name="weight"</td>
                    </tr>
                    <td>availability</td>
                    <td><input type="checkbox" name="availability"/></td>
                    </tr>
                    <td>nameOfUnit</td>
                    <td><input type="text" name="nameOfUnit"/></td>
                    </tr>
                    <td>supplierName</td>
                    <td><input type="text" name="supplierName"/></td>
                    </tr>
                    <td>supplierSurname</td>
                    <td><input type="text" name="supplierSurname"/></td>
                    </tr>                    
                    <tr>
                        <td>Supplier</td>
                        <td></td>
                    </tr>
                </table>
                <input type="submit" value="save" name="" />
            </form>
        </div>    
    </body>
</html>
