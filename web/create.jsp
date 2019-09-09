<%-- 
    Document   : create
    Created on : Aug 26, 2019, 7:49:52 PM
    Author     : Tipu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>Hello World!</h1>
        <form action="CreateServlet">
            <input type="text" name="id"><br> <br>
            <input type="text" name="name"><br> <br>
            <input type="text" name="email"><br> <br>
            <input type="text" name="phone"><br> <br>
            <input type="submit" value="Save">
        </form>
    </center>
    </body>
</html>
