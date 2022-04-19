<<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Inscription"/>
<h1> inscription.jsp</h1>
<form method="POST">
    Nom :
    <input type="text" name="nom" value="${param['nom']}"/>
    ${nomMsg}
    <br/>
    Prénom :
    <input type="text" name="prenom" value="${param['prenom']}"/>      
    ${prenomMsg}
    <br/>
    Mot de passe :
    <input type="password" name="pwd"/>
    ${pwdMsg}
    <br/>
    Confirmation de Mot de passe :
    <input type="password" name="confPwd"/>
    ${confPwdMsg}
    <br/>
    Email :
    <input type="text" name="email" value="${param['email']}"/>
    ${emailMsg}
    <br/>
    Confirmation de email :
    <input type="text" name="confEmail" value="${param['confEmail']}"/>
    ${confEmailMsg}
    <br/>
    <button type="submit">S'inscrire</button>
    <br/>
    <c:if test="${inscriptionMsg != null}">
        <div class="erreur">${inscriptionMsg}</div>
    </c:if>

</form>
<p:footer/>