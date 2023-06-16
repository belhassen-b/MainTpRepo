<%--
  Created by IntelliJ IDEA.
  User: bbeag
  Date: 11/06/2023
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des jeux</title>
    <jsp:include page="../includes/head.jsp" ></jsp:include>

</head>
<body>
<jsp:include page="../includes/header.jsp" ></jsp:include>

<div class="container">
    <h1 class="row">Liste des jeux</h1>
<table class="table table-striped">
    <thead>
<tr>
        <th scope="col">Nom</th>
        <th scope="col">Genre</th>
        <th scope="col">Plateforme</th>
        <th scope="col">Description</th>
        <th scope="col">Date d'ajout</th>
        <th scope="col">Jacquette</th>
        <th scope="col">Prix</th>
</tr>
    </thead>
        <tbody>
    <c:forEach items="${jeux}" var="jeu">
        <tr>
        <td>${jeu.nom}</td>
        <td>${jeu.genre}</td>
        <td>${jeu.plateforme}</td>
        <td>${jeu.description}</td>
        <td>${jeu.dateAjout}</td>
        <td>${jeu.jacquette}</td>
        <td>${jeu.prix}</td>
            <td ><a href="AddGame.jsp">Ajouter un jeu</a></td>
            <td ><a href="delete?id=${jeu.id}">Supprimer</a></td>
            <td ><a href="update?id=${jeu.id}">Modifier</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>

