<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html" charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Modifier mon compte</title>

</head>

<body>

<section class="container">
	<div class="row">
		<p class="display-4"><c:out value="${sessionScope.user.pseudo }, gardez vos informations à jour"></c:out></p>
	</div>
	<div class="row">
		<p>Vous possédez : </p><p class="text-success"><c:out value="${sessionScope.user.credit } crédits"></c:out></p>
	</div>
</section>

<section class="container border">
	<form action="ModifyUser" method="post">
	 	<div class="form-group">
	    	<label for="pseudo">Pseudo</label>
	    	<input type="text" class="form-control" id="pseudo" name="pseudo" value="<c:out value="${sessionScope.user.pseudo}"></c:out>">
	  	</div>
	  	<div class="form-group">
	    	<label for="name">Nom</label>
	    	<input type="text" class="form-control" id="name" name="name" value="<c:out value="${sessionScope.user.name}"></c:out>">
	  	</div>
	  	<div class="form-group">
	    	<label for="surname">Prenom</label>
	    	<input type="text" class="form-control" id="surname" name="surname" value="<c:out value="${sessionScope.user.surname}"></c:out>">
	  	</div>
	  	<div class="form-group">
	    	<label for="street">Rue</label>
	    	<input type="text" class="form-control" id="street" name="street" value="<c:out value="${sessionScope.user.street}"></c:out>">
	  	</div>
	  	<div class="form-group">
	    	<label for="email">Adresse email</label>
	    	<input type="email" class="form-control" id="email" name="email" value="<c:out value="${sessionScope.user.mail}"></c:out>">
	  	</div>
	  	<div class="form-group">
	    	<label for="telephone">Téléphone</label>
	    	<input type="text" class="form-control" id="telephone" name="telephone" value="<c:out value="${sessionScope.user.phone}"></c:out>">
	  	</div>
	  	<div class="form-group">
	    	<label for="postalCode">Code postal</label>
	    	<input type="text" class="form-control" id="postalCode" name="postalCode" value="<c:out value="${sessionScope.user.postalCode}"></c:out>">
	  	</div>
	  	<div class="form-group">
	    	<label for="city">Ville</label>
	    	<input type="text" class="form-control" id="city" name="city" value="<c:out value="${sessionScope.user.city}"></c:out>">
	  	</div>
	
	  	<button type="submit" class="btn btn-success">Mettre à jour</button>
	</form>
</section>

<section class="container border">
	<form action="ModifyUser" method="post">
		<h3>Sécutité</h3>
		
		<div class="form-group">
	    	<label for="passwordCurrent">Mot de passe actuel</label>
	    	<input type="password" class="form-control" id="passwordCurrent" name="passwordCurrent">
	  	</div>
	  	<div class="form-group">
	    	<label for="passwordNew">Nouveau mot de passe</label>
	    	<input type="password" class="form-control" id="passwordNew" name="passwordNew" aria-describedby="passwordHelp">
	    	<small id="passwordHelp" class="form-text text-muted">
	    	Le mot de passe doit :<br>
	    	- Comporter entre 5 et 25 caractères<br>
	    	- Contenir une minuscule et une majuscule<br>
	    	- Contenir au moins un chiffre<br>
	    	</small>
	  	</div>
	  	<div class="form-group">
	    	<label for="passwordRewrite">Retaper le mot de passe</label>
	    	<input type="password" class="form-control" id="passwordRewrite" name="passwordRewrite">
	  	</div>
	  	<button type="submit" class="btn btn-success">Mettre à jour</button>
	 </form>

</section>




</body>
</html>