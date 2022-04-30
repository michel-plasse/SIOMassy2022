<%-- 
    Document   : questionnaireSeance
    Created on : 26 avr. 2022, 09:17:35
    Author     : ak
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Questionnaire n° ${Questionnaire.id}"/>



<table id="questionDeSeance">
    
    s.getInt("id_seance"),
              rs.getInt("s.id_canal"),
              rs.getInt("q.id_questionnaire"),
              rs.getString("libelle"),
              rs.getTime("nb_minutes")
    <thead>
        
        <tr><th >Séance</th><th >Canal</th><th>Questionnaire</th><<th>Libellé</th><<th>Durée</th>
        </tr>
    </thead>
    <tbody > 
        <td>${id}</td>   <td>$idCanal}</td>   <td>idQuestionnaire</td>    <td>${libelle}</td>   <td>${nbMinute}</td>  
    </tbody>
</table>
<p:footer />
