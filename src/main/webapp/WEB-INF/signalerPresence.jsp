<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="SIO Massy 2022"/>


 La personne numero ${idPersonne} dans la seance ${idSeance}



<form action="signalerPresence" method="post">
    <label>Seance</label></br>
    <input type="hidden" name="idSeance" value="1" /></br>
    <button type="submit"> Présent</button>
</form>
<p:footer />