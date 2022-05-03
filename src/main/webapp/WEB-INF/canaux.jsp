<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Canal ${canal.nom}"/>
<style>
  #canaux form {
    display: inline;
  }
</style>
<h1>Canaux</h1>
<form  method="post">
  <input type="text" name="nom"/>
  <button type="submit">Créer canal</button>
</form>
<ul id="canaux">
  <c:forEach items="${canaux}" var="canal">
    <li>
      <a href="canal?idCanal=${canal.id}">${canal.nom} (#${canal.id})</a>
      <form action="modifierCanal" method="get">
        <input type="hidden" name="idCanal" value="${canal.id}"/>
        <button type="submit">Modifier</button>
      </form>
        <a  href="supprimer-canal?idCanal=${canal.id}">Supprimer</a>

    </li>
  </c:forEach>
</ul>