<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Mes évaluations"/>
<h1>Mes évaluations</h1>
<c:forEach items="${evaluations}" var="evaluation">
    <div>
        ${evaluation.intitule}
        ${evaluation.idCreateur}
    </div>
</c:forEach>
</body>
</html>
