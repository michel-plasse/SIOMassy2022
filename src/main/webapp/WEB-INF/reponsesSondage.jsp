<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Réponses au sondage ${idSondage}"/>
<h1>${sondage.libelle} (sondage ${idSondage}), par ${sondage.createur.prenom}
  ${sondage.createur.nom}</h1>
  
<table>
  <c:forEach items="${sondage.reponses}" var="reponse">
    <tr>
      <td>${reponse.prenom}</td>
      <td>${reponse.nom}</td>
      <td>${reponse.nom}</td>
      <td>
        <c:if test="${reponse.libelle == null}">
          -
        </c:if>
        ${reponse.libelle}</td>
    </tr>
  </c:forEach>
</table>    
