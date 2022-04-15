<%-- 
    Document   : ListerLesEfgs
    Created on : 15 avr. 2022, 12:40:31
    Author     : ak
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des EFGS</title>
    </head>
    <body>
          
        <p:header title="SIO Massy 2022"/>
        
        <h1>Vue appelée par la servlet ...</h1>
        <form action="GererCanalServlet" method="POST">
            <button type="submit">lister</button>
        </form>
        
         <p:footer />
    </body>
</html>
