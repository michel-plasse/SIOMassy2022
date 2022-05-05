<%-- 
    Document   : questionnaireSeance
    Created on : 26 avr. 2022, 09:17:35
    Author     : ak
--%>

<%@page import="modele.Entrainement"%>
<%@page import="modele.Questionnaire"%>
<%@page import="javax.management.Query"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="./libs/jquery/1.10.1/jquery.min.js"></script>

<p:header title="Questionnaire n° "/>
Ici on crée un entrainement

<h1>Questionnaires du canal ${param["idQuestionnaire"]}</h1>
la ou se trouve l'attendu

<div>${q.id}</div>
           <div> ${q.idQuestionnaire}</div> 
           
       <td><FORM>
<select name="questionnaire">
    <c:forEach items="${q}" var="questionnaire">
        <option value="${questionnaire.id}"><c:out value="${questionnaire.libelle}" /></option>
        <option value="${questionnaire.idQuestionnaire}"><c:out value="${questionnaire.libelle}" /></option>
   <option value="${idQuestionnaire.id}"><c:out value="${idQuestionnaire.libelle}" /></option>
   <option value="${q.id}"><c:out value="${q.libelle}" /></option> 
    <option value="${idQ.id}"><c:out value="${idQ.libelle}" /></option> 
    
    </c:forEach>
</select>
</SELECT>
</FORM>
</td>    <div> ${q.libelle}</div>
           
            ${q.idQuestionnaire}
           ${idQ.id}
           ${param[id]}
            ${idQuestionnaire.idQuestionnaire}
            ${q.idCanal}
            ${q.libelle}
           
           <div> ${idQ.dQuestionnaire}</div>
           Fin de l'attendu
          <br><br><br>  
            
         <br>   id questionnaire: 1     
       <br>id Créateur: 1
      <br> Libellé: Base de Java
      <br> Nombre de mnutes: 10
      <br> Créé le 2022-05-02 17:20:03
    

<p:footer />


