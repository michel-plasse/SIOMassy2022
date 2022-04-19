<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Supprimer le canal</title>
    </head>
    <body>
        
        <p:header title="SIO Massy 2022"/>
        
        <h1>Suppression du canal</h1>
        <form action="GererCanalServlet" method="post">
            <p>Nom du canal : ${canal.nom}</p>
            <p>Êtes-vous sûr(e) de vouloir supprimer le canal ${canal.nom} ?</p>
            <button type="submit">Supprimer</button>
        </form>
               
        <p:footer />
    </body>
</html>