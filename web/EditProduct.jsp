<%-- 
    Document   : EditProduct
    Created on : Aug 30, 2013, 1:03:02 AM
    Author     : zbs
--%>

<%@page import="storage.products.ProductType"%>
<%@page import="database.util.UserDatabase"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<jsp:include page="search.jsp"/>
<jsp:include page="sidebar.jsp"/>
<!DOCTYPE html>
<%
    String name = (String) request.getParameter("edit");
    String SerialNum = (String) request.getParameter("serialNum");

    ProductType product = UserDatabase.getProduct(name,SerialNum);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit product</title>
    </head>
    <body>

        <div class="bigBox" style="margin:0 auto;">
            <form method="GET" action="UpdateProduct">
                <table border="1">
                    <tr>
                        <td>name</td>
                        <td> <%= product.getName()%> </td> 
                    <input type="hidden" name="name" value="<%= product.getName()%>"/>
                    </tr>
                    <tr>
                        <td>name</td>
                        <td> <%= product.getSerialNum()%> </td> 
                    <input type="hidden" name="serialNum" value="<%= product.getSerialNum()%>"/>
                    </tr>
                    <tr>
                        <td>description</td>
                        <td> <%= product.getDescription()%> </td>  
                        <td>
                            <input type="text" name="description" value="<%= product.getDescription()%>"/>
                        </td>
                    </tr>  
                    <tr>
                        <td>productType</td>
                        <td><%= product.getProductType()%> </td>  
                        <td>
                            <input type="text" name="description" value="<%= product.getProductType()%>"/>
                        </td>
                    </tr>
                    <tr>
                        <td>size</td>
                        <td><%= product.getSize()%></td> 
                        <td>
                            <input type="text" name="size" value="<%= product.getSize()%>" />
                        </td>
                    </tr>
                    <tr>
                        <td>price</td>
                        <td><%= product.getPrice()%></td> 
                        <td>
                            <input type="number" name="price" value="<%= product.getPrice()%>" />
                        </td>
                    </tr>
                    <tr>
                        <td>quantity</td>
                        <td><%= product.getQuantity()%></td> 
                        <td>
                            <input type="number" name="quantity" value="<%= product.getQuantity()%>" />
                        </td>
                    </tr>
                    <td>weight</td>
                    <td><%=  product.getWeight()%> </td> 
                    <td>
                        <input type="number" name="weight" value=" <%= product.getWeight()%>" />
                    </td>
                    </tr>
                    <td>availability</td>
                    <td><%=  product.getAvailability()%></td> 
                    <td>
                        <input type="checkbox" name="availability"  <%=(product.getAvailability() == true ? "checked" : "")%> />
                    </td>
                    </tr>
                    <td>nameOfUnit</td>
                    <td><%=  product.getNameOfUnit()%></td> 
                    <td>
                        <input type="text" name="nameOfUnit" value=" <%= product.getNameOfUnit()%> " />
                    </td>
                    </tr>
                    <td>supplierName</td>
                    <td> <%= product.getSupplierName()%></td> 
                    <td>
                        <input type="text" name="supplierName" value=" <%= product.getSupplierName()%> " />
                    </td>
                    </tr>
                    <td>supplierSurname</td>
                    <td><%=  product.getSupplierSurname()%> </td> 
                    <td>
                        <input type="text" name="supplierName" value=" <%= product.getSupplierSurname()%> " />
                    </td>
                    </tr>                    
                </table>
                <input type="submit" value="save" name="" />
            </form>
        </div>   
    </body>
</html>
