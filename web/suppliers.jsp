<%-- 
    Document   : supplier
    Created on : Aug 30, 2013, 12:55:31 AM
    Author     : zbs
--%>

<%@page import="storage.Supplier"%>
<%@page import="java.util.List"%>
<%@page import="database.util.UserDatabase"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp" />
<jsp:include page="search.jsp"/>
<jsp:include page="sidebar.jsp"/>
<%
    String username = (String) session.getAttribute("username");
    List<Supplier> suppliers = UserDatabase.getAllSuppliers();
    String html_output = null;
    String error_message = null;
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Suppliers</title>
    </head>
    <body>
    <div class="bigBox">
        <table border="1">

            <%
                for (int i = 0; i < suppliers.size(); i++) {
            %>
            <tr>
                <td>  <%=(i + 1)%>  </td>
                <td>  <%= suppliers.get(i).getName()%> <%= suppliers.get(i).getSurname()%> </td>
                <td><form method="GET" action="EditSupplier.jsp">
                        <button type=submit value="<%= suppliers.get(i).getName()%>" name="edit">edit</button>
                        <input type="hidden" name="suredit" value="<%= suppliers.get(i).getSurname()%>" >
                    </form>
                </td>
                <td><form method="GET" action="DeleteSupplier">
                        <button type=submit value="<%= suppliers.get(i).getName()%>" name="delete">delete</button>
                        <input type="hidden" name="surdelete" value="<%= suppliers.get(i).getSurname()%>" >
                    </form>
                </td>
            </tr>
            <% }%>
        </table>
    </div>
</body>
</html>
