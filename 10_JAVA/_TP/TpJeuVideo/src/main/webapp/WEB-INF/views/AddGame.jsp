<%--
  Created by IntelliJ IDEA.
  User: bbeag
  Date: 11/06/2023
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajout d'un jeu</title>
</head>
<body>
<form action="add" method="post">
    <label for="nom">Nom du jeu</label>
    <input type="text" name="nom" id="nom" required>
    <br>
    <label for="genre">Genre</label>
    <input type="text" name="genre" id="genre" required>
    <br>
    <label for="plateforme">Plateforme</label>
    <input type="text" name="plateforme" id="plateforme" required>
    <br>
    <label for="description">Description</label>
    <input type="text" name="description" id="description" required>
    <br>
    <label for="addedDate">Date d'ajout</label>
    <input type="date" name="addedDate" id="addedDate" required>
    <label for="image">Image</label>
    <input type="text" name="image" id="image" >
    <br>
    <label for="prix">Prix</label>
    <input type="number" name="prix" id="prix" required>
    <input type="submit" value="Ajouter">
</form>
</body>
</html>
