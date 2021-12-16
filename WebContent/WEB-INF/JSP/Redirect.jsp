<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" 
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>On a déménagé !</title>
</head>


<body>
	<div class="d-flex flex-row-reverse pr-4">
		<div>
			<img alt="" src="/images/imageDummy.png">
		</div>
		<c:choose>
			<c:when test="${!empty sessionScope}">

				<ul class="nav">
					<li class="nav-item"><a class="nav-link active"
						href="<c:url value = "/AddArticle"/>">Vendre un article</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value = "/profil"/>">Mon profil</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value = "/deconnexion"/>">Déconnexion</a></li>
				</ul>

			</c:when>
			
			<c:when test="${empty sessionScope}">
				<a class="btn btn-success" href="<c:url value = "/login"/>">S'inscrire/Se
					connecter</a>
			</c:when>
			
		</c:choose>
		
		
		<div>
			<a href="<c:url value="/web-inf/jsp/home" />"><button class="btn btn-sm btn-danger w-100">Accueil</button></a>
		</div>
		
	</div>
</body>
</body>
</html>