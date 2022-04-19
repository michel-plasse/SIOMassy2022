<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="SIO Massy 2022"/>


${idSeance}



<form action="signalerPresence" method="post">
    <label>Seance</label
    <input type="text" name="idSeance" valeur="1" placeholder="numéro séance" required/>
    
    <button type="submit"> Présent</button>
</form>
<p:footer />