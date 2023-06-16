<%--
  Created by IntelliJ IDEA.
  User: bbeag
  Date: 11/06/2023
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Jeu Vidéo</title>
    <jsp:include page="../includes/head.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../includes/header.jsp"></jsp:include>
<div>
    <form>
    Titre : <input type="text" name="titre" value="<%=request.getParameter("titre")%>"><br>
    Genre : <input type="text" name="genre" value="<%=request.getParameter("genre")%>"><br>
    Editeur : <input type="text" name="editeur" value="<%=request.getParameter("editeur")%>"><br>
    Plateforme : <input type="text" name="plateforme" value="<%=request.getParameter("plateforme")%>"><br>
    <input type="submit" value="Rechercher">
    </form>
    <table>
        <tr>
            <th>Titre</th>
            <th>Genre</th>
            <th>Editeur</th>
            <th>Plateforme</th>
        </tr>
        <%
            for (JeuVideo jeuVideo : jeuVideos) {
        %>
        <tr>
            <td><%=jeuVideo.getTitre()%></td>
            <td><%=jeuVideo.getGenre()%></td>
            <td><%=jeuVideo.getEditeur()%></td>
            <td><%=jeuVideo.getPlateforme()%></td>
        </tr>
        <%
            }
        %>

</div>

</body>
</html>
