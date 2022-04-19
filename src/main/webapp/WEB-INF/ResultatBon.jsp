<%-- 
    Document   : Resultats
    Created on : 5 avr. 2022, 08:33:27
    Author     : ak
--%>

<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des EFGS</title>
    </head>
    <body>
          
        <p:header title="SIO Massy 2022"/>
        
        <h1>liste des EFGs:ok</h1>
        <h1>Vue appelée par la servlet ...</h1>
        <form action="EFGAfficheServlet" method="POST">
            <button type="submit">lister</button>
        </form>
        
         <p:footer />
    </body>
</html>
