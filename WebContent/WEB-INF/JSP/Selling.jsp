<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Selling</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">

</head>
<body>

	<%@include file="/header/header.jspf"%>

	//TODO Vérifier que les var sont bien en pageScope

	<c:if test="sessionScope.user==requestScope.article.winner" var="win">
		Dans le cas où l'utilisateur connecté est celui qui a remporté l'enchère
		
		<div class="d-flex justify-content-center">
			<h1>Vous avez remporté la vente !</h1>
		</div>
	</c:if>

	<c:if
		test="sessionScope.user==requestScope.article.seller && !empty requestScope.article.dateEndAuction"
		var="bought">
		Dans le cas où l'utilisateur connecté est le vendeur et qu'il n'y ait une date de fin
		
		<div class="d-flex justify-content-center">
			<h1>
				<c:out value="${requestScope.article.seller }" />
				a remporté la victoire !
			</h1>
		</div>
	</c:if>

	<c:if
		test="sessionScope.user==requestScope.article.seller && empty requestScope.article.dateEndAuction"
		var="selling">
		Dans le cas où l'utilisateur connecté est le vendeur et qu'il n'y ait pas de date de fin (en cours de vente)
		
		<div class="d-flex justify-content-center">
			<h1>Détail de la vente</h1>
		</div>
	</c:if>






	<div class="container">

		<p>
			<c:out value="${requestScope.article.nameArticle }"></c:out>
		<p>
			Description :
			<c:out value="${requestScope.article.description }" />
		</p>

		<p>
			Catégorie :
			<c:out value="${requestScope.article.categorie }" />
		</p>

		<c:if test="${bought}">

		</c:if>

		<c:choose>

			<c:when test="${win}">
				<p>
					Meilleur offre :
					<c:out value="${requestScope.article.priceSold }" />
					par vous
				</p>
			</c:when>

			<c:when test="${!win }">
				<p>
					Meilleur offre :
					<c:out value="${requestScope.article.priceSold }" />
					par
					<c:out value="${requestScope.article.buyer }" />
				</p>
			</c:when>
		</c:choose>


		<p>
			Mise à prix :
			<c:out value="${requestScope.article.priceStart }" />
		</p>

		<p>
			Fin de l'enchère :
			<c:out value="${requestScope.article.dateEndAuction }" />
		</p>

		<p>
			Retrait :
			<c:out value="${requestScope.article.withdrawalPoint }" />
		</p>

		<p>
			Vendeur :
			<c:out value="${requestScope.article.seller }" />
		</p>

		<!-- La fin de la page change pour chaque cas -->
		<c:choose>
			<c:when test="${win}">
				<p>
					Tel :
					<c:out value="${requestScope.article.seller.telephone}" />
				</p>

				<a class="btn" href="<c:url value = "/home"/>">Retour</a>

			</c:when>

			<c:when test="${bought}">
				<a class="btn" href="<c:url value = "/home"/>">Retrait effectué</a>
			</c:when>

			<c:when test="${selling}">
				<form>
					<div class="form-group">
						<label for="bid">Ma proposition</label> <input type="number"
							class="form-control" id="bid" placeholder="">

					</div>
					<button type="submit" class="btn">Enchérir</button>
				</form>
			</c:when>
		</c:choose>









	</div>

</body>
</html>