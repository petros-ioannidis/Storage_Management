<%-- 
    Document   : storages
    Created on : Aug 30, 2013, 12:38:53 AM
    Author     : zbs
--%>

<%@page import="storage.StorageUnit"%>
<%@page import="java.util.List"%>
<%@page import="database.util.UserDatabase"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<jsp:include page="search.jsp"/>
<jsp:include page="sidebar.jsp"/>
<!DOCTYPE html>
<%
    String username = (String) session.getAttribute("username");
    List<StorageUnit> units = UserDatabase.getAllStorages();
    StorageUnit unit = null;
    String html_output = null;
    String error_message = null;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Storages</title>
    </head>

    <body>
        <div class="bigBox">
        <table border="1">

            <%
                for (int i = 0; i < units.size(); i++) { //!!!!!!
            %>
            <tr>
                <td> <%= (i + 1)%> </td>
                <td><%= units.get(i).getName()%></td>
                <td>
                    <form method="GET" action="EditStorage.jsp">
                        <button type=submit value="<%= units.get(i).getName()%>" name="edit">
                            edit
                        </button>
                    </form>
                </td>
                <td>
                    <form method="GET" action="DeleteStorage">
                    <button type=submit value="<%= units.get(i).getName()%>" name="delete">
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
