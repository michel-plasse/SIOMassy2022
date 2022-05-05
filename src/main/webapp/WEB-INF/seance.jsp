<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Participations"/>

<style>
    li {
        text-decoration: underline;
        color: blue;
    }
</style>

<h1>Toutes les participations de la séance ${seance.id}</h1>
<ul>
<li>${personne.prenom} ${personne.nom}</li>
<p>- Nombre de participation :  
<c:choose>
    <c:when test="${param.niveau_participation=='1'}">
        Peu (niveau 1)
    </c:when>
    <c:when test="${param.niveau_participation=='2'}">
        Beaucoup (niveau 2)
    </c:when>      
    <c:otherwise>
        Absent
    </c:otherwise>
</c:choose>
<br />
</p>
</ul>
<br>
<p:footer />