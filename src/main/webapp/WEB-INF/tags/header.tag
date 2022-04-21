<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="En-tête des pages"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="title" required="true" description="titre de la page" %>
<!DOCTYPE html>
<html>
  <head>
    <title>${title}</title>
    <link rel="stylesheet" type="text/css" href="siomassy2022.css"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1">
  </head>
  <body>
    <c:set var="context" value="${pageContext.servletContext.contextPath}"/>
    <nav id="mainNav">
      <nav>
        <a href="${context}/.">Accueil</a>
        <a href="javascript: document.getElementById('resetDbForm').submit()">Réinitialiser
          la BD</a>
        <a href="${context}/canaux">Canaux</a>
        <a href="${context}/EFGs">Exercice à Faire en Groupe</a>
      </nav>
      <nav>
        <c:if test="${sessionScope['user'] != null}">
          <form action="${context}/connexion" method="post">
            <button type="submit">Déconnecter ${sessionScope['user'].email}</button>
            <input type="hidden" name="action" value="deconnecter"/>
          </form>
        </c:if>
        <c:if test="${sessionScope['user'] == null}">
          <a href="${context}/inscription">Inscription</a>
          <a href="${context}/connexion">Connexion</a>
        </c:if>
      <a href="${context}/readme.jsp">Readme</a>
      </nav>
    </nav>
    <form id="resetDbForm" action="${context}/resetDb" method="post">
    </form>