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
    <title>Produits</title>
    <jsp:include page="../includes/head.jsp" />
</head>
<body>
    <jsp:include page="../includes/header.jsp" />
    <h1>Liste des produits</h1>

    <div>
        <form action="add" method="post" enctype="multipart/form-data">
            <div><label>Nom</label><input type="text" name="name" /></div>
            <div><label>Description</label><input type="text" name="description" /></div>
            <div><label>Genre</label><input type="text" name="genre" /></div>
            <div><label>Plateforme</label><input type="text" name="plateforme" /></div>
            <div><label>Prix</label><input type="text" name="prix" /></div>
            <div><input type="file" name="image" multiple="false" /></div>
            <div><button type="submit" >Valider</button></div>
        </form>
    </div>
/
<%--   <c:if test="${produits != null}">
        <c:forEach items="${produits}" var="produit">
            <div>
                Marque : ${produit.getMarque()}
                Réference : ${produit.getReference()}
                Prix : ${produit.getPrix()} €
                Stock : ${produit.getStock()}
                Date Achat : ${produit.getDateAchat()}
                <a href="produits?id=${produit.getId()}">Detail</a>
            </div>
        </c:forEach>
    </c:if>--%>

</body>
</html>
