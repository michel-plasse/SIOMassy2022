<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="EFG "/>
<h1>EFGs du canal ${param["idCanal"]}</h1>
<ol>
    <c:forEach items="${exercices}" var="efg">
        <li>  <a href="EFG?idEFG=${efg.idEfg}">${efg.intitule}, par ${efg.idEfg}</a> 
    </c:forEach>
</ol>