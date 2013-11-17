<%-- 
    Document   : storageform
    Created on : Aug 29, 2013, 5:02:45 PM
    Author     : zbs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<jsp:include page="search.jsp"/>
<jsp:include page="sidebar.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="bigBox" style="margin:0 auto">
            <form method="GET" action="AddStorage">
                <table border="1">
                    <tr>
                        <td> Name </td>
                        <td><input type="text" name="name"/></td>
                    <tr>
                        <td>description</td>
                        <td><input type="text" name="description"/></td>
                    </tr>
                    <tr>
                        <td>location</td>
                        <td><input type="text" name="location"/></td>
                    </tr>
                    <td>open</td>
                    <td><input type="checkbox" name="open"/></td>
                    </tr>
                </table>
                <input type="submit" value="save"  />
            </form>
        </div>    </body>
</html>
