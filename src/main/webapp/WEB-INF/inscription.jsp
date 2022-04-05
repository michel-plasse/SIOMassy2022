<%-- 
    Document   : inscription
    Created on : 31 mars 2022, 19:01:00
    Author     : Abdillahi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>OK</h1>
        <form method="POST">
      <c:if test="${sessionScope['user'] == null}">
        Nom :
        <input type="text" name="nom" value="${param['nom']}"/>
        ${nomMsg}
        <br/>
        Prénom :
        <input type="text" name="prenom" value="${param['prenom']}"/>
        Mot de passe :
        ${prenomMsg}
        <br/>
        <input type="password" name="pwd"/>
        ${pwdMsg}
        <br/>
        Confirmation de Mot de passe :
        <input type="password" name="pwd"/>
        ${pwdMsg}
        <br/>
        Email :
        <input type="text" name="email" value="${param['email']}"/>
        Mot de passe :
        ${emailMsg}
        <br/>
        Confirmation de email :
        <input type="text" name="email" value="${param['email']}"/>
        Mot de passe :
        ${emailMsg}
        <br/>
        <button type="submit">S'inscrire</button>
        <br/>
        <c:if test="${inscrireMsg != null}">
          <div class="erreur">${inscririreMsg}</div>
        </c:if>
      </c:if>
      <c:if test="${sessionScope['user'] != null}">
        <button name="action" value="deconnecter">
          Déconnecter ${sessionScope["user"].getLogin()}
        </button>
      </c:if>
    </form>
       
       
      
    </body>
</html>
