<%-- 
    Document   : inscription
    Created on : 31 mars 2022, 19:01:00
    Author     : Abdillahi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>OK</h1>
        <form action="/InscriptionServlet.java" method="POST">
            Nom <input type="text" name="nom"> <br>
            Prenom <input type="text" name="prenom"> <br>
            Password <input type="password" name="psw"> <br>
            Confirmation de Mot de passe <input type="password" name="psw"> <br>
            Email <input type="email" name="email"> <br>
            Confirmation de Email <input type="email" name="email"> <br>
        </form> 
       
       
      
    </body>
</html>
