<%--
  Created by IntelliJ IDEA.
  User: bbeag
  Date: 07/06/2023
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Patient ${patient.getId}</title>
</head>
<body>
<div>
  Nom : ${patient.getNom_patient()}
  Prenom : ${patient.getPrenom_patient()}
  Mail : ${patient.getMail_patient()}
  Téléphone : ${patient.getTel_patient()}
</div>
</body>
</html>