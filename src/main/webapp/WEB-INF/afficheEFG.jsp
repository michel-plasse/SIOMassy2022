<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="modele.EFG" %>
<%@ page import="modele.QuestionnaireEntrainement" %>

<!DOCTYPE html>


<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" media="screen" type="text/css" href="text.css"/>

<title>R�sultats</title>
</head>
<body>

<header >Vous �tes � l'entrainement<br><img src=''/>
</header>
<table >
<caption>Tableau d'entrainements</caption>
    <thead>
        <tr>
            <th >N�efg</th><th >cr�ateur</th><th>intitul�</th>
        </tr>
    </thead>
    <tbody >
<% 
    EFG efg1= new EFG();
       request.setAttribute("efg",efg1);
    
    
 session.getAttribute("controleurAfficheEfg");
 	out.println("<tr><td>"+getId_efg()+"</td><td>"+getId_createur()+"</td><td>"+getIntitule()+"</td></tr>");%>
</tbody>
</table>
</body>
</html>
