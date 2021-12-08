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

		<div class="d-flex flex-row-reverse pr-4">
		
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
		
		</div>
		
		
	
	
	<div class="d-flex justify-content-center">
		<h1>Liste des enchères</h1>
	</div>
	
			<div class="container">
				<div class="row">
						<div class="col-4">
							<form action="">
								<div class="form-group">
									<label for="rechercheArticle">Filtres : </label>
									<input type="text" id="rechercheArticle" name="rechercheArticle">
								</div>
								
								<div class="dropdown">
									<button class="btn dropdown-toggle" type="button"
									id="dropdownMenuButton" data-toggle="dropdown" aria-expanded="false">Categorie :
									</button>
									
									  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
									    <a class="dropdown-item" href="#">Action</a>
									    <a class="dropdown-item" href="#">Another action</a>
									    <a class="dropdown-item" href="#">Something else here</a>
									  </div>
								
								
								</div>
								

									<!-- Pourrait être utile plus tard -->							
<!-- 								<div class="form-group">
								
									<label for="categories">Categorie : </label>
									
									<select id="categories" name="categories">
										<option></option>
									</select>
								</div>	 -->
									<c:if test="${!empty sessionScope}">
										<div class="form-group">
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
									
									
									<input type="submit" value="Rechercher">
									
								
							</form>
						</div>
					</div>
		<div>
		<div class="card mb-3 col-2" style="max-width: 540px;">
				  <div class="row no-gutters">
					 <div class="col-md-4">
						  <img src="/ENI_Enchere/images/imageDummy.png" alt="dummy image">
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
			
				
			  <div class="card mb-3 col-2" style="max-width: 540px;">
				  <div class="row no-gutters">
					 <div class="col-md-4">
						  <img src="/ENI_Enchere/images/imageDummy.png" alt="dummy image">
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
			
				
			  <div class="card mb-3 col-2" style="max-width: 540px;">
				  <div class="row no-gutters">
					 <div class="col-md-4">
						  <img src="/ENI_Enchere/images/imageDummy.png" alt="dummy image">
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
			
			
			  <div class="card mb-3 col-2" style="max-width: 540px;">
				  <div class="row no-gutters">
					 <div class="col-md-4">
						  <img src="/ENI_Enchere/images/imageDummy.png" alt="dummy image">
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
		</div>	
			  
				
			</div>
			
		

	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
	
</body>
</html>
