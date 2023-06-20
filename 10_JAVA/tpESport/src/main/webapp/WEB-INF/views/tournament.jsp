<%--
  Created by IntelliJ IDEA.
  User: bbeag
  Date: 17/06/2023
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tournois</title>
</head>
<body>
<h1>Création d'un tournois</h1>

<form action="Tournois" method="post">
    <label for="nom">Nom du tournois</label>
    <input type="text" name="nom" id="nom" required>
    <br>
    <label for="date">Date du tournois</label>
    <input type="date" name="date" id="date" required>
    <br>

    <input type="submit" value="Créer">
</form>

</body>
</html>
