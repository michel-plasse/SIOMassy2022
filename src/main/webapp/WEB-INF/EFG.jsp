<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="EFG n° ${efg.id}"/>
<style>
    #efg ul {
        list-style-type: none;
    }
    #efg li {}
</Style>


<table id="efg">
    
    
    <thead>
        <tr><th colspan="4">${efg.intitule} (n° ${efg.id}), créé le ${efg.creeA} par ${efg.createur.prenom} ${efg.createur.nom}</th></tr>
        <tr><th >Groupes</th><th >Membres</th><th>créateur</th>
        </tr>
    </thead>
    <tbody > 
        <c:forEach var="groupe"  items="${efg.groupes}" >
            <tr>
                <td>Groupe n° ${groupe.idEFG}  </td>
                <td>
                    <ul>
                        <c:forEach items="${groupe.membres}" var="membre" >
                            <li>${membre.prenom} ${membre.nom}</li>
                            </c:forEach>
                    </ul>
                </td>
                <<td>"en attente d'attribution"</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<p:footer />