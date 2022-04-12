
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="SIO Massy 2022"/>
${membres.size()} membres
<c:forEach items="${membres}" var="membre" > 
    <tr>  
        <td>${membre.prenom}</td> 
        <td>${membre.nom}</td> 
        <td>${membre.email}</td>
    </tr>
</c:forEach>
<h1>OK</h1>
<form action="Membre" method="post">
<input type="submit" name="" value="test" />
</form>
<p:footer />
 
