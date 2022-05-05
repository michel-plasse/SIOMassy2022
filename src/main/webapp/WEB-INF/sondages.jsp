<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Sondages"/>
<h1>Sondages</h1>

<h4> Cliquez pour creer un sondage </h4>
<ol>
    <c:forEach items="${sondages}" var="sondage">
      <li><a href="reponsesSondage?idSondage=${sondage.idSondage}">${sondage.libelle}, par ${sondage.createur.prenom}</a></li>
    </c:forEach>
</ol>