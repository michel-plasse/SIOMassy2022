<%-- 
    Document   : questionnaireSeance
    Created on : 26 avr. 2022, 09:17:35
    Author     : ak
--%>

<%@page import="javax.management.Query"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="./libs/jquery/1.10.1/jquery.min.js"></script>

<p:header title="Questionnaire n° "/>
Ici on crée un entrainement

<h1>Questionaires du canal ${param["idQuestionnaire"]}</h1>
la ou se trouve l'attendu

<div>${param[idQuestionnaire].idQuestionnaire.id}</div>
           <div> ${param[idQuestionnaire]}</div>  <div> ${param[idQuestionnaire.IdCanal]}</div>
            Fin de l'attendu
          <br><br><br>  
            
         <br>   id questionnaire: 1     
       <br>id Créateur: 1
      <br> Libellé: Base de Java
      <br> Nombre de mnutes: 10
      <br> Créé le 2022-05-02 17:20:03
    

<p:footer />


