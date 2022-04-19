<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Sondages"/>
<h1>Sondages</h1>
<ol>
    <c:forEach items="${sondages}" var="sondage">
        <li>${sondage.libelle}, par ${sondage.createur.prenom}</li>
    </c:forEach>
</ol>