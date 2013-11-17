<%-- 
    Document   : roleform
    Created on : Aug 27, 2013, 7:46:40 PM
    Author     : zbs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp" />
<jsp:include page="search.jsp"/>
<jsp:include page="sidebar.jsp"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Role Form</title>
    </head>
    <body>
        <div class="bigBox" style="margin:0 auto;">
            <form method="POST" name="Role Form" action="AddRole">
                <table border="1">

                    <tr>
                        <td>
                            name
                        </td>

                        <td> 
                            <input type="text" name="name" value="" /> 
                        </td> 
                    </tr>

                    <tr>
                        <td>
                            storage read access:
                        </td>
                        <td> 
                            <input type="checkbox" name="storage_read"/> 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            storage write access:
                        </td>


                        <td>

                            <input type="checkbox" name="storage_write"/> 
                        </td>

                    </tr> 
                    
                    <tr>
                    <td>

                        product read access:
                    </td>

                    <td> 
                    <input type="checkbox" name="product_read"/> 
                    </td> 
                    </tr>
                    <tr>
                    <td>

                        product write access:
                    </td>

                    <td> 
                    <input type="checkbox" name="product_write"/> 
                    </td> 
                    </tr>
                    <tr>
                        <td>
                        supplies read access:
                        </td>
                    <td>
                    <input type="checkbox" name="supplier_read"/> 
                    </td> 
                    </tr>
                    <tr>
                    <td>

                        supplier write access:
                    </td>

                    <td> 
                    <input type="checkbox" name="supplier_write"/>
                    </td> 
                    </tr>

                </table>
                <input type="submit" value="save" />


            </form>
        </div>
    </body>
</html>
