<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<title>Mon compte</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>


<body class="bg-light">

	<%@include file="/header/header.jspf"%>

	<!--  un get pour lire les informations du profil, pas de modifications de données sur cette page -->
	<div>
		<div>
			<h1 class="container text-center">Mon compte</h1>
		</div>
		<section class="container border">
			<form action="<c:url value="/ModifyUser" />" method="get">

				<div class="form-group">
					<label for="pseudo">Pseudo</label> <input class="form-control"
						value="<c:out value="${sessionScope.user.pseudo}"></c:out>"
						name="pseudo" type="text" disabled>
				</div>
				</br>
				<div class="form-group">
					<label for="surname">Nom</label> <input class="form-control"
						value="<c:out value="${sessionScope.user.surname}"></c:out>"
						name="surname" type="text" disabled>
				</div>
				</br>
				<div class="form-group">
					<label for="name">Prénom</label> <input class="form-control"
						value="<c:out value="${sessionScope.user.name}"></c:out>"
						name="name" type="text" disabled>
				</div>
				</br>
				<div class="form-group">
					<label for="mail">Email</label> <input class="form-control"
						value="<c:out value="${sessionScope.user.mail}"></c:out>"
						name="mail" type="text" disabled>
				</div>
				</br>
				<div class="form-group">
					<label for="phone">Téléphone</label> <input class="form-control"
						value="<c:out value="${sessionScope.user.phone}"></c:out>"
						name="phone" type="text" disabled>
				</div>
				</br>
				<div class="form-group">
					<label for="street">Rue</label> <input class="form-control"
						value="<c:out value="${sessionScope.user.street}"></c:out>"
						name="street" type="text" disabled>
				</div>
				</br>
				<div class="form-group">
					<label for="postalCode">Code Postal</label> <input
						class="form-control"
						value="<c:out value="${sessionScope.user.postalCode}"></c:out>"
						name="postalCode" type="text" disabled>
				</div>
				</br>
				<div class="form-group">
					<label for="city">Ville </label> <input class="form-control"
						value="<c:out value="${sessionScope.user.city}"></c:out>"
						name="city" type="text" disabled>
				</div>
				</br>
				<div class="form-group">
					<button type="submit" class="w-25 btn btn-success">Modifier</button>
				</div>
		</section>
		</form>


	</div>
</body>
</html>