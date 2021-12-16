<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" 
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>On a déménagé!</title>
</head>


<body class="bg-light">

	<%@include file="/header/header.jspf"%>
	
		<section class="container text-center mb-4">
		<h2>
			La page que vous demandez est introuvable.
		</h2>
	</section>
		<section class="container w-50">
		<div class="row justify-content-center">
			<div class="w-100 col-5">
				<a class="btn btn-sm btn-success w-100 mb-1"
					href=<c:url value = "/home.jsp"/>><small>Retour à la page
						d'accueil</small></a>
			</div>
		</div>
		<p class="mt-5 mb-3 text-muted">
			<small>&copy; 2021 - Les objets sont nos amis</small>
		</p>
	</section>
	</div>
</body>
</body>
</html>