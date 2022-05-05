<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<p:header title="Niveau de participation"/>

<h1>Modification du niveau</h1>
<form method="POST">
  <p>id de l'étudiant <input type='number' name='idPersonne' value="3"/></p>
  <p>id séance <input type='number' name='idSeance' value="1"/></p>
  <p>Niveau du participation : 
    <input type="number" name="niveau" min="0" max="2" value="${participation.niveau}"/></p>
  <p>Êtes-vous sûr(e) de vouloir modifier le niveau ${participation.niveau} ?</p>
  <button type="submit">Modifier</button>
  <c:if test="${niveauMsg != null}">
    <div class="erreur">${niveauMsg}</div>
  </c:if>
</form>

<p:footer />