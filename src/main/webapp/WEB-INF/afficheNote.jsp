<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Afficher Les Notes"/>
<style>
    
    .Design {
        color: blueviolet;
    }
    input {
        width: 6em;
    }
</style>
<h1>Evaluation n° ${idEvaluation}</h1>
<table>
    <tr>
        <th>Etudiant</th>
        <th>Note</th>
    </tr>
    <c:forEach items="${notes}" var="note">
        <tr>
            <td>${note.prenom} ${note.nom}</td>
            <td> ${note.note}</td>
        </tr>
    </c:forEach>
        
</table>
<form>
        <a href ="saisirNotes?idEvaluation=${note.idEvaluation}" class="Design">
            <i class="fa-solid fa-pen-to-square" > Saisir/Modifier les note</i> 
        </a>
</form>