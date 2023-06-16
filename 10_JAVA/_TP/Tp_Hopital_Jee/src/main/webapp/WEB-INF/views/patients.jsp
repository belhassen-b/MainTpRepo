<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 06/06/2023
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Patients</title>
</head>
<body>
<h1> Liste des patients</h1>
<c:forEach items="${patients}" var="patient">
  <div>
    Nom : ${patient.getNom_patient()}
    Prenom : ${patient.getPrenom_patient()}
    Mail : ${patient.getMail_patient()}
    Téléphone : ${patient.getTel_patient()}
  </div>
</c:forEach>
</body>
</html>