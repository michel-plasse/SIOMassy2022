<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Mes questionnaires (formateur)"/>
<h1>Mes questionnaires (formateur)</h1>
<ul>
    <c:forEach items="${questionnaires}" var="questionnaire">
        <li>${questionnaire.libelle} (${questionnaire.nbMinutes} mn),
            ${questionnaire.nbQuestions} questions
            <form action="creerEntrainement">
                <input type="hidden" name="idQuestionnaire" value="${questionnaire.id}"/>
                <button type="submit">Lancer</button>
            </form>
        </li>
        </c:forEach>
</ul>