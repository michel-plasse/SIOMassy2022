<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Modifier le canal ${canal.nom}"/>
        
<h1>Modification du canal</h1>
<form method="post">
    <p>Nom du canal : ${canal.nom}</p>
    <input type="text" name="nom"/>
    <br>
    <br>
    <p>Êtes-vous sûr(e) de vouloir modifier le canal "${canal.nom}" ?</p>
    <button type="submit">Modifier</button>
    <br>
    <br>
    <c:if test="${canalMsg != null}">
        <div class="erreur">${canalMsg}</div>
    </c:if>
</form>