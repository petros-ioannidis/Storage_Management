<%-- 
    Document   : searchResults
    Created on : Aug 30, 2013, 3:47:43 AM
    Author     : zbs
--%>

<%@page import="storage.products.ProductType"%>
<%@page import="java.util.List"%>
<%@page import="database.util.UserDatabase"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp" />
<jsp:include page="search.jsp"/>
<jsp:include page="sidebar.jsp"/>
<%
    String search = (String) request.getParameter("search");
    List<ProductType> related_products = UserDatabase.searchProduct(search);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search results</title>
    </head>
    <body>
        <div class="bigBox" style="background-color: aquamarine">
            <table border="1">

                <% for (int i = 0; i < related_products.size(); i++) {%>

                <tr>
                    <td><%= (i + 1)%></td>
                    <td> <%= related_products.get(i).getName()%></td>
                    <td>
                        <form method="GET" action="EditProduct.jsp">
                            <input type="hidden" value="<%= related_products.get(i).getSerialNum()%>" name="serialNum" />
                            <button type=submit value="<%= related_products.get(i).getName()%>" name="edit">
                                edit
                            </button>
                        </form>
                    </td>
                    <td>
                        <form method="GET" action="DeleteProduct">
                            <input type="hidden" value="<%= related_products.get(i).getSerialNum()%>" name="serialNum" />
                            <button type=submit value="<%= related_products.get(i).getName()%>" name="delete">
                                delete
                            </button>
                        </form>
                    </td>
                </tr>

                <% }%>        
            </table>
        </div>
    </body>
</html>
