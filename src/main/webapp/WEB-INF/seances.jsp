<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Participations"/>
<h1>Toutes les séances</h1>
<ul id="seances">
    <c:forEach items="${seances}" var="seance">
        <li>
            <a href="seance?idSeance=${seance.id}">${seance.id})</a>
        </li>
        <br>
    </c:forEach>
</ul>
<p:footer />