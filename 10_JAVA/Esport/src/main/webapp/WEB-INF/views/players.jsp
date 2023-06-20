<%--
  Created by IntelliJ IDEA.
  User: bbeag
  Date: 18/06/2023
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Joueurs</title>
  <jsp:include page="../includes/head.jsp" />
</head>
<body>
<jsp:include page="../includes/header.jsp" />
<div class="container">
    <h1>Liste des joueurs</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Nom</th>
            <th>Modifier</th>
            <th>Supprimer</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${joueurs}" var="joueur">
            <tr>
                <td>${joueur.nom}</td>

                <td><a href="modifier?id=${joueur.id}">Modifier</a></td>
                <td><a href="supprimer?id=${joueur.id}">Supprimer</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="ajouter">Ajouter un joueur</a>
</div>
</body>
</html>
