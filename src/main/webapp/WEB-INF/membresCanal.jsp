
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="SIO Massy 2022"/>


<table>
    <th colspan="3">${membres.size()} membres</th>
    <tr>
        <th>Prenom</th>
        <th>Nom</th>
        <th>E-mail</th>
    </tr>
    <c:forEach items="${membres}" var="membre" > 
        <tr>  

            <td>${membre.prenom}</td> 
            <td>${membre.nom}</td> 
            <td>${membre.email}</td>
        </tr>
    </c:forEach>
</table>
<h1>OK</h1>
<form action="membres" method="post">
    <input type="submit" name="" value="test" />
</form>
<p:footer />

