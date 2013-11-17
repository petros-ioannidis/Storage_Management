<%-- 
    Document   : supplierform
    Created on : Aug 29, 2013, 8:37:57 PM
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
<div class="bigBox" style="margin:0 auto;">
                              <form method="GET" action="AddSupplier">
                                <table border="1">
                                    <tr>
                                        <td>name</td>
                                        <td><input type="text" name="name" /></td>
                                    </tr>
                                    <tr>
                                        <td>surname</td>
                                        <td><input type="text" name="surname" /></td>
                                    </tr>
                                    <tr>
                                        <td>address</td>
                                        <td><input type="text" name="address" /></td>
                                    </tr>
                                    <tr>
                                        <td>SSN</td>
                                        <td><input type="text" name="SSN"/></td>
                                    </tr>
                                  </table>
                               <input type="submit" value="save" name="" />
                              </form>
                            </div> 
    </body>
</html>
