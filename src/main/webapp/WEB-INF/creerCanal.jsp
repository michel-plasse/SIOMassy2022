<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Créer un canal</title>
    </head>
    <body>
        
        <p:header title="SIO Massy 2022"/>
        
        <h1>Création d'un canal</h1>
        <form action="GererCanalServlet" method="post">
            <p>
                Nom du canal : 
                <input type="text" name="nom">
            </p>
            <button type="submit">Créer</button>
        </form>
               
        <p:footer />
    </body>
</html>