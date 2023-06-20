<%--
  Created by IntelliJ IDEA.
  User: bbeag
  Date: 18/06/2023
  Time: 00:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Joueur</title>
</head>
<body>
<h1>Création d'un joueur</h1>
<form action="/player" method="post">
    <label for="nom">Nom</label>
    <input type="text" name="nom" id="nom" required>
    <label for="equipe">Equipe</label>
    <select name="equipe" id="equipe">
        <c:forEach items="${equipes}" var="equipe">
            <option value="${equipe.id}">${equipe.nom}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Créer">
</form>
</body>
</html>
