<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Créer canal</title>
    </head>
    <body>
        
        <p:header title="SIO Massy 2022"/>
        
        <h1>Création d'un canal</h1>
        <form action="GererCanalServlet" method="post">
            <p>
                Nom du canal : 
                <div style="padding: 5px 0px 0px 0px;">
                <input type="text" name="nom">
            </p>
            
            <div style="padding: 10px 0px 0px 0px;">
            <input type="submit" value="Valider">
        </form>
        
        <div style="padding: 10px 0px 0px 0px;">
               
        <p:footer />
    </body>
</html>