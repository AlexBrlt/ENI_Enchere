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
<title>Détails du compte</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>


<body class="bg-light">

	<%@include file="/header/header.jspf"%>

	<!--  un get pour lire les informations du profil, pas de modifications de données sur cette page -->
	<div>
		<section class="container border p-4">
			<form action="<c:url value="/AuctionInProgress" />" method="get">

				<div class="form-group">
					<label for="pseudo">Pseudo</label> <input class="form-control"
						value="<c:out value="${requestScope.pseudo}"></c:out>"
						name="pseudo" type="text" disabled>
				</div>
				<div class="form-group">
					<label for="surname">Nom</label> <input class="form-control"
						value="<c:out value="${requestScope.surname}"></c:out>"
						name="surname" type="text" disabled>
				</div>
				<div class="form-group">
					<label for="name">Prénom</label> <input class="form-control"
						value="<c:out value="${requestScope.name}"></c:out>"
						name="name" type="text" disabled>
				</div>
				<div class="form-group">
					<label for="mail">Email</label> <input class="form-control"
						value="<c:out value="${requestScope.mail}"></c:out>"
						name="mail" type="text" disabled>
				</div>
				<div class="form-group">
					<label for="phone">Téléphone</label> <input class="form-control"
						value="<c:out value="${requestScope.phone}"></c:out>"
						name="phone" type="text" disabled>
				</div>
				<div class="form-group">
					<label for="street">Rue</label> <input class="form-control"
						value="<c:out value="${requestScope.street}"></c:out>"
						name="street" type="text" disabled>
				</div>
				<div class="form-group">
					<label for="postalCode">Code Postal</label> <input
						class="form-control"
						value="<c:out value="${requestScope.postalCode}"></c:out>"
						name="postalCode" type="text" disabled>
				</div>
				<div class="form-group">
					<label for="city">Ville </label> <input class="form-control"
						value="<c:out value="${requestScope.city}"></c:out>"
						name="city" type="text" disabled>
				</div>
				<div class="form-group mt-5 d-flex justify-content-end">
					<a href="<c:url value = "/home"/>" class="btn btn-success w-25">Retour</a>
				</div>
		</section>
	</form>
</div>
</body>
</html>