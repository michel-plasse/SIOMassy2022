<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modifier un canal</title>
    </head>
    <body>
        
        <p:header title="SIO Massy 2022"/>
        
        <h1>Modification du canal</h1>
        <form method="POST">
            <p>Nom du canal : ${canal.nom}</p>
            <p>
                Nouveau nom du canal : 
                <input type="text" name="nom">
            </p>
            <p>Êtes-vous sûr(e) de vouloir modifier le canal ${canal.nom} ?</p>
            <button type="submit">Modifier</button>
            <br>
            <br>
            <c:if test="${canalMsg != null}">
                <div class="erreur">${canalMsg}</div>
            </c:if>
        </form>
               
        <p:footer />
    </body>
</html>