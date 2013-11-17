<%-- 
    Document   : sidebar
    Created on : Aug 26, 2013, 11:51:12 PM
    Author     : zbs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="storageWarsCss.css">
    </head>
    <%
        String role = (String) request.getSession().getAttribute("role");
        Boolean storage_read = (Boolean) request.getSession().getAttribute("storage_read");
        Boolean storage_write = (Boolean) request.getSession().getAttribute("storage_write");
        Boolean product_read = (Boolean) request.getSession().getAttribute("product_read");
        Boolean product_write = (Boolean) request.getSession().getAttribute("product_write");
        Boolean supplier_read = (Boolean) request.getSession().getAttribute("supplier_read");
        Boolean supplier_write = (Boolean) request.getSession().getAttribute("supplier_write");
    %>
    <body>
        <div id="sidebar">
            <% if (role.equals("admin")) {%>

            <div id="smallsidebox">
                <a href="admin.jsp">Admin Control Panel</a>
            </div>
            <% }%>
            <% if (storage_read) {%>
            <div id="smallsidebox">
                <a href="storages.jsp">storages</a>
            </div>
            <% }%>

            <% if (storage_write) {%>
            <div id="smallsidebox">
                <a href="storageform.jsp">add storage</a>

            </div>
            <% }%>

            <% if (product_read) {%>
            <div id="smallsidebox">
                <a href="products.jsp">products</a>

            </div>
            <% }%>

            <% if (product_write) {%>
            <div id="smallsidebox">
                <a href="productform.jsp">add product</a>

            </div>
            <% }%>

            <% if (supplier_read) {%>
            <div id="smallsidebox">
                <a href="suppliers.jsp">suppliers</a>

            </div>
            <% }%>

            <% if (supplier_write) {%>
            <div id="smallsidebox">
                <a href="supplierform.jsp">add supplier</a>

            </div>
            <% }%>
            </div>
    </body>
</html>
