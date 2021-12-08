<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" 
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	li {
		list-style : none;
		
	}
</style>

<meta charset="UTF-8">
<title>Home</title>
</head>
<body>

	<c:if test="${empty sessionScope}">
		<div>
			<a href="<c:url value = "/login"/>">S'inscrire - se connecter</a>
		</div>
	</c:if>
	
	<c:if test="${!empty sessionScope}">
		<div>
			<a href="<c:url value = "/addArticle"/>">Vendre un article</a>
			<a href="<c:url value = "/profil"/>">Mon profil</a>
			<a href="<c:url value = "/deconnexion"/>">Déconnexion</a>
		</div>
	</c:if>
	
	<div>
		<h1>Liste des enchères</h1>
	</div>
	
	<div>
		<form action="">
			
			<label for="rechercheArticle">Filtres : </label>
			<input type="text" id="rechercheArticle" name="rechercheArticle">
			
			<label for="categories">Categorie : </label>
			
			<select id="categories" name="categories">
				<option></option>
			</select>	
			<c:if test="${!empty sessionScope}">
			<div class="container">
			  <ul>
			    <li>
			      <input type="radio" id="achat" name="achatetvente"><label for="achat"> Achats</label>
			      <ul>
			        <li><label><input type="checkbox" class="checkAchat"> Enchéres ouvertes</label></li>
			        <li><label><input type="checkbox" class="checkAchat"> Mes enchéres</label></li>
			        <li><label><input type="checkbox" class="checkAchat"> Mes enchéres remportées</label></li>
			      </ul>
				  <input type="radio" id="vente" name="achatetvente"><label for="vente"> Mes ventes</label>
			      <ul>
			        <li><label><input type="checkbox" class="checkVente"> Mes ventes en cours</label></li>
			        <li><label><input type="checkbox" class="checkVente"> Ventes non débutées</label></li>
			        <li><label><input type="checkbox" class="checkVente"> Ventes terminées</label></li>
			      </ul>  
			      
			    </li>
			  </ul>
			</div>
			</c:if>
			
			<div>
			<input type="submit" value="Rechercher">
			</div>
		</form>
	</div>
	
  <div class="card mb-3" style="max-width: 540px;">
	  <div class="row no-gutters">
		 <div class="col-md-4">
			  <img src="/ENI_Encheres/images/imageDummy.png" alt="dummy image">
		</div>
		  <div class="col-md-8 pl-2">
		      <div class="card-body pl-4 p-0">
		        <h5 class="card-title">Fauteuil</h5>
		        <p class="card-text">Prix : 310 points</p>
		        <p class="card-text">Fin de l'enchère : 01/09/2018</p>
		        <p class="card-text">Vendeur: NineJea</p>
		        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
		      </div>
		  </div>
	  </div>
</div>
</body>
</html>