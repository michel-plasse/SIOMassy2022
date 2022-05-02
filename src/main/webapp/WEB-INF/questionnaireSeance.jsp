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

<p:header title="Questionnaire n° ${Questionnaire.id}"/>
<table id="questionDeSeance">
    
   <thead>
        <tr><th>Séance</th><th>Canal</th><th>Questionnaire</th><th>Libellé</th><th>Durée</th>
        </tr>
    </thead>
    <tbody > 
        <td>${questionDeSeance.id}</td>   <td>${questionDeSeance.idCanal}</td>   <td>${questionDeSeance.idQuestionnaire}</td>    <td>${questionDeSeance.libelle}</td>   <td>${questionDeSeance.nbMinute}</td>  
    </tbody>
</table>
        <td>La séance débute du:${questionDeSeance.debuteA}</td>
        <br>
        <td>La séance finit à:${questionDeSeance.finitA}</td>
        <br>
        
        Compteur:
     
    <script type="text/javascript">                               
        $(document).ready(function() {
            //time to count down
            hoursToGo = 0;
            minutesToGo = 27;
            secondsToGo = 43;

            var startTime = new Date();              
            var endTime = new Date();
            endTime.setHours(
                startTime.getHours() + hoursToGo,
                startTime.getMinutes() + minutesToGo, 
                startTime.getSeconds() + secondsToGo, 
                startTime.getMilliseconds()
            );

            //function to update counter
            function update(){
                var currentTime = new Date();

                var remainingTime = new Date();
                remainingTime.setTime(endTime.getTime()-currentTime.getTime());

                $("#countdown").text(remainingTime.getHours()+":"+remainingTime.getMinutes()+":"+remainingTime.getSeconds());

                //call itself every second
                setTimeout(update,1000);
            }

            //start the countdown
            update();                
        });
    </script>
${countdown}
<div id='countdown'></div>

  
<p:footer />
