<%--
  Created by IntelliJ IDEA.
  User: bbeag
  Date: 11/06/2023
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Erreur</title>
</head>
<body>

<h1>Erreur</h1>

<p>Une erreur est survenue</p>

<p><%= exception.getMessage() %>
</p>

<p><%= exception.getStackTrace() %>
</p>

</body>
</html>
