<%--
  Created by IntelliJ IDEA.
  User: bbeag
  Date: 15/06/2023
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bataille Navale</title>
    <jsp:include page="../includes/head.jsp"/>
</head>
<body>
<jsp:include page="../includes/header.jsp"/>
<div class="grille">
    <h3>Bienvenue sur le site de la bataille navale</h3>
    <form action="tirer" method="post">
        <h4>Tirer</h4>
        <label for="x">X</label>
        <input type="number" name="x" id="x" min="0" max="9" required/>
        <label for="y">Y</label>
        <input type="number" name="y" id="y" min="0" max="9" required/>
        <input type="submit" value="Tirer"/>
    </form>
    <table>
        <tr>
            <td></td>
            <c:forEach var="i" begin="0" end="9">
                <td>${i}</td>
            </c:forEach>
        </tr>
        <c:forEach var="row" items="${grille.cellules}" varStatus="status">
            <tr>
                <td>${status.index}</td> <!-- Row number -->
                <c:forEach var="cell" items="${row}">
                    <td>
                        <c:choose>
                            <c:when test="${cellule.statut=='TOUCHE'}">
                                <img src="../images/bomb.png" alt="touche"/>
                            </c:when>
                            <c:when test="${cellule.status == 'RATE'}">
                                <img src="../images/missed.png" alt="rate"/> </c:when>
                            <c:otherwise>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
</div>
<c:if test="${gameOver}">
    <div class="gagne">
        <h3>Vous avez gagné !</h3>
        <a href="nouvellePartie">Nouvelle partie</a>
    </div>
</c:if>

</body>
</html>
