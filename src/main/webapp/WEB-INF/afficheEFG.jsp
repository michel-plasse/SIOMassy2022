<%@page import="modele.Groupe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page import="modele.EFG" %>
<%@ page import="modele.QuestionnaireEntrainement" %>

<!DOCTYPE html>


<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" media="screen" type="text/css" href="text.css"/>

<title>Résultats</title>
</head>
<body>
  <p:header title="SIO Massy 2022"/>

<table >
<caption>Tableau d'entrainements</caption>
    <thead>
        <tr>
            <th >N°efg</th><th >créateur</th><th>intitulé</th>
        </tr>
    </thead>
    <tbody >
<% 
    EFG efg1= new EFG();
       request.setAttribute("efg",efg1);
     List<Groupe> groupes = efg1.getGroupes();
for( Groupe nouveauGroupe: groupes )
     
 	out.println("<tr><td>"+nouveauGroupe.getIdEFG()+"</td><td>"+nouveauGroupe.getCreateur()+"</td><td>"+nouveauGroupe.getMembres()+"</td></tr>");%>
       session.getAttribute("controleurAfficheEfg");
       
</tbody>
</table>
 <p:footer />
</body>
</html>
