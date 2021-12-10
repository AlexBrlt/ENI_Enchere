<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" 
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<title>Mon compte</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>

<body>
<body class="bg-light">

	<div class="d-flex flex-row-reverse pr-4">
		<c:choose>
			<c:when test="${!empty sessionScope}">
				
			
					<ul class="nav">
					  <li class="nav-item">
					    <a class="nav-link active" href="<c:url value = "/addArticle"/>">Vendre un article</a>
					  </li>
					  <li class="nav-item">
					    <a class="nav-link" href="<c:url value = "/profil"/>">Mon profil</a>
					  </li>
					  <li class="nav-item">
					    <a class="nav-link" href="<c:url value = "/deconnexion"/>">Déconnexion</a>
					  </li>
			
					</ul>
				
			</c:when>
			
			<c:when test="${empty sessionScope}">
				<a class="btn btn-success" href="<c:url value = "/login"/>">S'inscrire/Se connecter</a>
			
			</c:when>
		</c:choose>
	</div>
 <!--  un get pour lire les informations du profil, pas de modifications de données sur cette page -->
 <div>
 	<div>
 		<h1 class="container text-center">Mon compte</h1>
	</div>
<section class="container border">
  <form action="<%=request.getContextPath()%>/profil" method="get"> 

	<div class="form-group">
		<label for="pseudo">Pseudo</label>
		<input class="form-control" value="${user.pseudo}" name="pseudo" type="text" disabled>
 	</div>
 		</br>
 	<div class="form-group">
 		<label for="surname">Nom</label>
 		<input class="form-control" value="${user.surname}" name="surname" type="text" disabled>
 	</div>
  		</br>
	<div class="form-group">
 		<label for="name">Prénom</label>
 		<input class="form-control" value="${user.name}" name="name" type="text" disabled>
 	</div>
 	 	</br>
 	<div class="form-group">
 		<label for="mail">Email</label>
 		<input class="form-control" value="${user.mail}" name="mail" type="text" disabled>
 	</div>
 	 	</br>
 	<div class="form-group">
 		<label for="phone">Téléphone</label>
 		<input class="form-control" value="${user.phone}" name="phone" type="text" disabled>
 	</div>
 		</br>
 	<div class="form-group">
 		<label for="street">Rue</label>
 		<input class="form-control" value="${user.street}" name="street" type="text" disabled>
 	</div>
 		</br>
 	<div class="form-group">
 		<label for="postalCode">Code Postal</label>
 		<input class="form-control" value="${user.postalCode}" name="postalCode" type="text" disabled>
 	</div>
 		</br>
 	<div class="form-group">
 		<label for="city">Ville </label>
 		<input class="form-control" value="${user.city}" name="city" type="text" disabled>
 	</div>
 	 	</br>
 	<div  class="form-group">
 	<button type="submit" class="w-25 btn btn-success">Modifier</button>
 	</div>
 </section>
 </form>

 
</div>
</body>
</html>