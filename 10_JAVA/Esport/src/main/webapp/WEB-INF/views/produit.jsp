<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 06/06/2023
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Produit ${videogame.getId()}</title>
    <jsp:include page="../includes/head.jsp" />
</head>
<body>
<jsp:include page="../includes/header.jsp" />
<div>
    Marque : ${videogame.getMarque()}
    Réference : ${videogame.getReference()}
    Prix : ${videogame.getPrix()} €
    Stock : ${videogame.getStock()}
    Date Achat : ${videogame.getDateAchat()}
    <c:forEach items="${videogame.getImages()}" var="image">
        <img src="${videogame.getUrl()}">
    </c:forEach>
</div>
</body>
</html>
