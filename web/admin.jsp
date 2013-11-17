<%-- 
    Document   : admin
    Created on : Aug 30, 2013, 5:43:26 AM
    Author     : zbs
--%>

<%@page import="storage.users.UserRole"%>
<%@page import="java.util.List"%>
<%@page import="database.util.UserDatabase"%>
<%@page import="storage.users.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<jsp:include page="search.jsp"/>
<jsp:include page="sidebar.jsp"/>
<!DOCTYPE html>
<%
    String username = (String) session.getAttribute("username");
    User user = null;
    String edit = (String) request.getParameter("edit");
    String error_message = null;
    String dlist;

    List<User> users = UserDatabase.getAllUsers();
    List<UserRole> roles = UserDatabase.getAllRoles();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Panel</title>
    </head>
    <body>


        <% if (username.equals("admin")) {%>


    
        <div class="bigBox">
            <table border="1">

                <% for (int i = 0; i < users.size(); i++) {%>

                <tr>
                    <td> <%= i + 1%> </td>
                    <td> <%= users.get(i).getUsername()%> </td>
                    <td>
                        <form method="GET" action="EditUser">
                            <button type=submit value="<%= users.get(i).getUsername()%>" name="edit">edit</button>
                        </form>
                    </td>
                </tr>
                <% }%>

            </table>
        </div>


    <br><br>
    
        <div class="bigBox">

            <table border="1">

                <% for (int i = 0; i < roles.size(); i++) {%>

                <tr>
                    <td> <%= i + 1%> </td>
                    <td> <%= roles.get(i).getName()%> </td>
                    <td>
                        <form id="manageUserForm" method="GET" action="EditRole.jsp">
                            <button type=submit value="<%=roles.get(i).getName()%>" name="edit">
                                edit
                            </button>
                        </form>
                    </td>
                    <td>
                        <form method="GET" action="DeleteRole">
                            <button type=submit  value="<%=roles.get(i).getName()%>" name="delete">
                                delete
                            </button>
                        </form>
                    </td>
                </tr>
                <% }%>

            </table>
        </div>
   
    <center>
        <form method="GET" action="roleform.jsp">
            <input type="submit" value="add role">
        </form>
    </center>

    <% }%>
</body>
</html>
