<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta content="text/html" charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<title>Créer votre compte utilisateur</title>
</head>

<body>

<div> <a href="Home.jsp">Eni_Enchères</a></div>

<h1>Créer votre compte client</h1>

<form action="<c:url value="/register" />" method="post">
  <div class="row">
    <div class="col-lg-6">
        <div>
            <label>Pseudo : </label> 
            <input type="text" name="pseudo" required>
        </div>

        <div>
            <label>Prénom : </label> 
            <input type="text" name="name" >
        </div>

        <div>
            <label>Téléphone : </label> 
            <input type="text" name="phone" maxlenght=10 >
        </div>

        <div>
            <label>Code postal : </label> 
            <input type="text" name="cp" maxlength=5  >
        </div>

        <div>
            <label>Mot de passe : </label> 
            <input type="password" name="password" required>
        </div>
  </div>

  <div class="col-lg-6">
        <div>
            <label>Nom : </label> 
            <input type="text" name="surname"  required>
        </div>

        <div>
            <label>Email : </label> 
            <input type="text" name="mail" required>
        </div>

        <div>
            <label>Rue : </label> 
            <input type="text" name="street"  required>
        </div>

        <div>
            <label>Ville : </label> 
            <input type="text" name="city"  required>
        </div>

        <div>
            <label>Confirmation : </label> 
            <input type="text" name="PasswordConf" required>
        </div>

  </div>
</div>
<div>
    <button type="submit">Créer</button>
</div>

</form>

<div>
    <a href="<c:url value="/web-inf/jsp/login" />"><button>Annuler</button></a>
</div>


</body>
</html>