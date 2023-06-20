<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%--<h1><%= "Gestion E Sport" %>--%>
<%--</h1>--%>
<%--<br/>--%>
<%--<a href="tournois.jsp">Tournois</a>--%>
<%--<br/>--%>
<%--<a href="equipes.jsp">Equipes</a>--%>
<%--<br/>--%>
<%--<a href="joueurs.jsp">Joueurs</a>--%>
<%--<br/>--%>
<div class ="container">


<%--    <form action="AjoutUtilisateurServlet" method="post">--%>
<%--        <div>--%>
<%--            <label for="username">Nom utilisateur</label>--%>
<%--            <input type="text" id="username" name="username"/>--%>
<%--        </div>--%>
<%--        <div>--%>
<%--            <label for="password">Mot de passe</label>--%>
<%--            <input type="password" id="password" name="password"/>--%>
<%--        </div>--%>
<%--        <div>--%>
<%--            <button type="submit">Ajouter l'utilisateur</button>--%>
<%--        </div>--%>
<%--    </form>--%>

    <div>
        <h1>Se connecter</h1>
        <c:if test="${messageError != null}">
            <div>${messageError}</div>
        </c:if>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <input type="hidden" name="action" value="login">
            <div>
                <label>username</label>
                <input type="text" name="username">
            </div>
            <div>
                <label>Password</label>
                <input type="password" name="password">
            </div>
            <div>
                <button type="submit">Valider</button>
            </div>
        </form>
    </div></body>
</html>