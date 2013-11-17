<%-- 
    Document   : EditRole
    Created on : Aug 30, 2013, 6:04:51 AM
    Author     : zbs
--%>

<%@page import="storage.users.UserRole"%>
<%@page import="database.util.UserDatabase"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<jsp:include page="search.jsp"/>
<jsp:include page="sidebar.jsp"/>
<%
    String name = request.getParameter("edit");
    UserRole role = UserDatabase.getRole(name);
    String html_output;

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="storageWarsCss.css">

        <title>Edit Role</title>
    </head>
    <body>

        <div class="bigBox" style="margin:0 auto">
            <form method="GET" action="UpdateRole">
                <table border="1">
                    <tr>
                        <td>Role Name</td>
                        <td>  <%= role.getName()%> </td> 
                    <input type="hidden" name="name" value="<%= role.getName()%>"/>
                    </tr>
                    <tr>
                        <td>storage read access</td>
                        <td>  <%= role.getStorage_read()%> </td>
                        <td>
                            <input type="checkbox" name="storage_read"  <%= ((role.getStorage_read() == true) ? "checked" : "")%> />
                            Storage read
                        </td>
                    </tr>
                    <tr>
                        <td>storage write access</td>
                        <td>  <%= role.getStorage_write()%> </td> 
                        <td>
                            <input type="checkbox" name="storage_write"  <%= ((role.getStorage_write() == true) ? "checked" : "")%> />
                            Storage write
                        </td>
                    </tr>
                    <tr>
                        <td>product read access</td>
                        <td>  <%= role.getProduct_read()%> </td> 
                        <td>
                            <input type="checkbox" name="product_read" <%= ((role.getProduct_read() == true) ? "checked" : "")%> />
                            Product read
                        </td>
                    </tr>
                    <tr>
                        <td>product write access</td>
                        <td>  <%= role.getProduct_write()%> </td> 
                        <td>
                            <input type="checkbox" name="product_write"  <%= ((role.getProduct_write() == true) ? "checked" : "")%> />
                            Product write
                        </td>
                    </tr>
                    <tr>
                        <td>supplier read access</td>
                        <td>  <%= role.getSupplier_read()%> </td>
                        <td>
                            <input type="checkbox" name="supplier_read"  <%= ((role.getSupplier_read() == true) ? "checked" : "")%> />
                            Supplier read
                        </td>
                    </tr>
                    <tr>
                        <td>supplier write access</td>
                        <td>  <%= role.getSupplier_write()%> </td>
                        <td>
                            <input type="checkbox" name="supplier_write"  <%= ((role.getSupplier_write() == true) ? "checked" : "")%> />
                            Supplier write
                        </td>
                    </tr>
                </table>
                <input type="submit" value="save" />
            </form>
        </div>
    </body>
</html>
