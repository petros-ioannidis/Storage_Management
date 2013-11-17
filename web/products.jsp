<%-- 
    Document   : Products
    Created on : Aug 25, 2013, 7:18:05 PM
    Author     : sofia
--%>

<%@page import="storage.products.ProductType"%>
<%@page import="java.util.List"%>
<%@page import="database.util.UserDatabase"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<jsp:include page="search.jsp"/>
<jsp:include page="sidebar.jsp"/>
<!DOCTYPE html>
<%
    String username = (String) session.getAttribute("username");
    List<ProductType> products = UserDatabase.getAllProducts();
    ProductType product = null;
    String html_output = null;
    String error_message = null;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
    </head>

    <body>
    
        <div class="bigBox">
        <table border="1">

            <%
                for (int i = 0; i < products.size(); i++) {
            %>
            <tr>
                <td><%= (i + 1)%></td>
                <td> <%= products.get(i).getName()%></td>
                <td>
                    <form method="GET" action="EditProduct.jsp">
                        <input type="hidden" value="<%= products.get(i).getSerialNum()%>" name="serialNum" />
                        <button type=submit value="<%= products.get(i).getName()%>" name="edit">
                            edit
                        </button>
                    </form>
                </td>
                <td>
                    <form method="GET" action="DeleteProduct">
                        <input type="hidden" value="<%= products.get(i).getSerialNum()%>" name="serialNum" />
                        <button type=submit value="<%= products.get(i).getName()%>" name="delete">
                            delete
                        </button>
                    </form>
                </td>
            </tr>
            <%  }%>
        </table>
        </div>
    
</body>
</html>
