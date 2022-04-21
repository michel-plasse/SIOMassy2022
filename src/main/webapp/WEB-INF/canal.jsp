<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Canal ${canal.nom}"/>
<h1>${canal.nom} (#${canal.id})</h1>
<nav id="navCanal">
    <c:if test="${estPresent}">
        <div style="color: red">Présent</div>
    </c:if>
    <c:if test="${!estPresent}">
          <form action="signalerPresence" method="post">
        <input type="hidden" name="idSeance" value="${seance.id}"/>
        <input type="hidden" name="idCanal" value="${param["idCanal"]}"/>
        <button type="submit">Je suis présent</button>
    </form>
</c:if>
<hr/>
<a href="sondages?idCanal=${canal.id}">Sondages</a>
<div><a href="reponsesSondage?idSondage=1">Réponses au sondage 1</a> (lien temporaire)</div>
<a href="EFGs?idCanal=${canal.id}">EFGs</a>
<div><a href="EFG?idEFG=1">EFG 1</a> (lien temporaire)</div>
</nav>