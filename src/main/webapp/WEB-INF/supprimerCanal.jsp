<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Canal ${canal.nom}"/>
        
<h1>Suppression du canal</h1>
<form method="POST">
    <p>Nom du canal : ${canal.nom}</p>
    <p>Êtes-vous sûr(e) de vouloir supprimer le canal "${canal.nom}" ?</p>
    <button type="submit">Supprimer</button>
    <br>
    <br>
    <c:if test="${canalMsg != null}">
        <div class="erreur">${canalMsg}</div>
    </c:if>
</form>