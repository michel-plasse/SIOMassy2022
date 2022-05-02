<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Saisir Les Notes"/>
<style>
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
            <td>
                <form method="POST">
                    <input type="hidden" name="idEvaluation" value="note.idEvaluation}"/>
                    <input type="hidden" name="idEtudiant" value="note.idEtudiant}"/>
                    <input type="text" size="6" name="note" value="${note.note}"/>
                    <button type="submit">OK</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>