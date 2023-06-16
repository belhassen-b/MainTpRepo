<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h2><%= " Enregistrement d'un patient" %>
</h2>
<br/>
<div>
    <form action ="patients" method="post">
        <div><label>Nom</label><input type="text" name="nom_patient" /></div>
        <br/>
        <div><label>Prénom</label><input type="text" name="prenom_patient" /></div>
        <br/>
        <div><label>Mail</label><input type="text" name="mail_patient" /></div>
        <br/>
        <div><label>Téléphone</label><input type="text" name="tel_patient" /></div>
        <div><button type="submit" >Valider</button></div>
    </form>
</div>
</body>
</html>