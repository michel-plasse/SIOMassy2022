<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="SIO Massy 2022"/>
<form action="signalerPresence" method="post">
    séance : <input type="text" name="idSeance" value="1"/>
    <button type="submit"> +</button>
</form>
<p:footer />