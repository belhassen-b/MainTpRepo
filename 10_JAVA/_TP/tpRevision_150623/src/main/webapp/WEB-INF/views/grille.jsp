<%--
  Created by IntelliJ IDEA.
  User: bbeag
  Date: 15/06/2023
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <title>Bataille Navale</title>
    <style>
        table {
            border-collapse: collapse;
        }
        td {
            border: 1px solid black;
            width: 20px;
            height: 20px;
        }
        td.empty {
            background-color: white;
        }
    </style>
</head>
<body>
<jsp:include page="../includes/header.jsp" />
    <h3>Bienvenue sur le site de la bataille navale</h3>
    <form action="tirer" method="post">
        <h4>Tirer</h4>
        <label for="x">X</label>
        <input type="number" name="x" id="x" min="0" max="9" required/>
        <label for="y">Y</label>
        <input type="number" name="y" id="y" min="0" max="9" required/>
        <input type="submit" value="Tirer"/>
    </form>
<div>
<h5>Nombre de bateaux restants :  </h5>

    </div>
    <table>
        <th scope="col" colspan="10">Grille</th>
        <tr>
            <td></td>
            <c:forEach var="i" begin="0" end="9">
                <td>${i}</td>
            </c:forEach>
        </tr>
        <c:forEach var="row" items="${grille.cellules}" varStatus="status">
            <tr>
                <td>${status.index}</td>
                <c:forEach var="cell" items="${row}">
                    <td>
                        <c:choose>
                            <c:when test="${cell.statut.name()=='TOUCHE'}">
<%--                                <img src="${pageContext.request.contextPath}/images/bomb.png" alt="Touché">--%>
                                Touché
                                    </c:when>
                            <c:when test="${cell.statut.name() == 'RATE'}">
<%--                                <img src="${pageContext.request.contextPath}/images/missed.png" alt="Raté">--%>
                                Raté
                            </c:when>
                            <c:otherwise>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>

<c:if test="${gameOver}">
    <h2>Vous avez gagné !</h2>

</c:if>

</body>
</html>
