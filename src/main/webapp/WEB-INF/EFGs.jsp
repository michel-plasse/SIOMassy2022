<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="EFG "/>
<h1>EFGs du canal ${param["idCanal"]}</h1>
<ol>
    <c:forEach items="${exercices}" var="efg">
        <li>${efg.intitule}, par ${efg.idEfg}</li>
    </c:forEach>
        <form method="GET">
             <input type="text" name="idEFG" value="${param['idEFG']}"/>
            <button type="submit">Choisir</button>
        </form>
</ol>