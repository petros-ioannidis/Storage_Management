<%-- 
    Document   : index
    Created on : 19 Αυγ 2013, 6:03:23 μμ
    Author     : sofia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style>
            body
            {
                background-color:whitesmoke;
            }
            h2.pos_right
            {
                position:relative;
                left:20px;
            }
        </style>
    </head>
    <body>
        <form method="POST" name="Registration Form" action="Register">
            
            <h> Create your account </h>
            <br>
            username
            <input type="text" name="username" value="" />
            <br>
            password
            <input type="password" name="password" value="" />
            <br>
            confirm password
            <input type="password" name="Confirmed_Password" value="" />
            <br>
            name
            <input type="text" name="name" value="" />
            <br>
            surname
            <input type="text" name="surname" value="" />
            <br>
            email
            <input type="text" name="email" value="" />
            <br>
            <input type="submit" value="Sign me up" name="Sing up!" />
        </form>


    </body>
</html>