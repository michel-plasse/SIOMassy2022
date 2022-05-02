<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Canal ${canal.nom}"/>
<h1>${canal.nom} (#${canal.id})</h1>
<nav id="navCanal">
  <c:if test="${seance != null}">
    <form action="signalerPresence" method="post">
      <input type="hidden" name="idSeance" value="${seance.id}"/>
      <button type="submit">Je suis présent</button>
    </form>
  </c:if>
  <hr/>
  <a href="sondages?idCanal=${canal.id}">Sondages</a>
  <a href="EFGs?idCanal=${canal.id}">EFGs</a>
</nav>