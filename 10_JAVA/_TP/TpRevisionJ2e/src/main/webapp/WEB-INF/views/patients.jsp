<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 07/06/2023
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Jeux Video</title>
  <jsp:include page="../includes/head.jsp" ></jsp:include>
</head>
<body>
<jsp:include page="../includes/header.jsp" ></jsp:include>
<div class="container">
  <h1 class="row">
    Liste des patients
  </h1>
    <table class="table table-striped">
        <thead>
        <tr>
        <th scope="col">Nom</th>
        <th scope="col">Prénom</th>
        <th scope="col">Date de naissance</th>
        <th scope="col">Adresse</th>
        <th scope="col">Numéro de téléphone</th>
        <th scope="col">Email</th>
        <th scope="col">Modifier</th>
        <th scope="col">Supprimer</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${patients}" var="patient">
        <tr>
            <td>${patient.getName()}</td>
            <td>${patient.prenom}</td>
            <td>${patient.dateNaissance}</td>
            <td>${patient.adresse}</td>
            <td>${patient.numeroTelephone}</td>
            <td>${patient.email}</td>
            <td><a href="patient?id=${patient.id}">Modifier</a></td>
            <td><a href="delete?id=${patient.id}">Supprimer</a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>