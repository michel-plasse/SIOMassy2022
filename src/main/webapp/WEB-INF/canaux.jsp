<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Canal ${canal.nom}"/>
<style>
  #canaux form {
    display: inline;
  }
</style>
<h1>${canal.nom} (#${canal.id})</h1>
<h1>Gestion des canaux</h1>
<form action="creerCanal" method="post">
  <input type="text" name="nom"/>
  <button type="submit">Créer canal</button>
</form>
<ul id="canaux">
  <c:forEach items="${canaux}" var="canal">
    <li>
      ${canal.nom} (#${canal.id})
      <form action="modifierCanal" method="get">
        <input type="hidden" name="idCanal" value="${canal.id}"/>
        <button type="submit">Modifier</button>
      </form>
      <form action="supprimerCanal" method="get">
        <input type="hidden" name="idCanal" value="${canal.id}"/>
        <button type="submit">Supprimer</button>
      </form>
    </li>
  </c:forEach>
</ul>