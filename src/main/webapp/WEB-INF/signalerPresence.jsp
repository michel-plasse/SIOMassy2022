<%-- 
    Document   : signalerPresence
    Created on : 5 avr. 2022, 13:53:27
    Author     : SALL Mouhamadou
--%>
<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p:header title="SIO Massy 2022"/>
        <c:out value ="Ok"/>
        <h1>Je suis sur SignalerPresence.jsp</h1>
        <form action="/signalerPresence" method="post">
            
            <input type="submite" value="test">
        </form>
        

<p:footer />

    </body>
</html>
