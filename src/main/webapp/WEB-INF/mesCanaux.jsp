<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Mes canaux"/>
<style>
    #canaux form {
        display: inline;
    }
    i {
        margin-left: 10px;
        text-shadow: 1px 1px 2px black;
    }
    .update {
        color: gold;
    }
    .delete {
        color: red;
    }
</style>
<h1>Mes canaux</h1>
<form  method="post">
<ul id="canaux">
    <c:forEach items="${canaux}" var="canal">
        <li>
            <a href="canal?idCanal=${canal.id}">${canal.nom} (#${canal.id})</a>
            <form action="modifierCanal" method="post">
                <input type="hidden" name="idCanal" value="${canal.id}"/>
                <a href="modifier-canal?idCanal=${canal.id}" class="update">
                    <i class="fa-solid fa-pen-to-square"> Modifier</i>
                </a>
            </form>
            <a href="supprimer-canal?idCanal=${canal.id}" class="delete">
                <i class="fa-solid fa-trash"> Supprimer</i>
            </a>
        </li>
        <br>
    </c:forEach>
</ul>
<p:footer />