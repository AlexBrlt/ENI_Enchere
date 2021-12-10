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
<body class="bg-light">


	<div class="d-flex flex-row-reverse pr-4">
		<c:choose>
			<c:when test="${!empty sessionScope}">
				
			
					<ul class="nav">
					  <li class="nav-item">
					    <a class="nav-link active" href="<c:url value = "/AddArticle"/>">Vendre un article</a>
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
		
    <section class="container text-center">
    <h1>Bon retour nom utilisateur,<br> que cherchez-vous aujourd'hui ? </h1>
</section>
    <section class="container border bg-white pt-3 mt-4 w-50">
            <section class="container">
                <div class="row">
                    <form class=" col-6">
                        <div class="mb-3 form-group">
                            <label for="nameArticle" class="form-label">Rechercher</label>
                            <input type="text" class="form-control" id="nameArticle">
                            <div id="helpNameArticle" class="form-text text-secondary">Un large choix d'objets</div>
                        </div>
                    </form>
                    <form class=" col-6">
                        <div class="form-group">
                            <label for="categories">Choisir une catégorie</label>
                            <select class="form-control" id="categories">
                                <option>Ameublement</option>
                                <option>Informatique</option>
                                <option>Vêtements</option>
                                <option>Sport&Loisirs</option>
                            </select>
                        </div>
                    </form>
                </div>
            </section>
        <section class="container">
            <div class="row">
                <div class="col-6">
                    <ul class="p-0">
                        <li  class="form-check p-0">
                            <input type="radio" id="ventes" name="choices">
                            <label for="ventes">Mes ventes</label>
                        </li>
                        <ul class="p-0">
                            <li  class="form-check">
                                <input type="checkbox" id="name">
                                <label for="name"> Mes ventes en cours </label>
                            </li>
                            <li  class="form-check">
                                <input type="checkbox" id="name">
                                <label for="name">Ventes non débutées</label>
                            </li>
                            <li  class="form-check">
                                <input type="checkbox" id="name">
                                <label for="name">Ventes terminées</label>
                            </li>
                        </ul>
                    </ul>
                    <button type="button" class="btn btn-success mb-4">Rechercher</button>
                </div>
                <div class="col-6">
                    <ul class="p-0">
                        <li  class="form-check p-0">
                            <input type="radio" id="achat" name="choices">
                            <label for="achat">Achat</label>
                        </li>
                        <ul class="p-0">
                            <li  class="form-check">
                                <input type="checkbox" id="name">
                                <label for="name"> Enchères ouvertes </label>
                            </li>
                            <li  class="form-check">
                                <input type="checkbox" id="name">
                                <label for="name">Mes enchères</label>
                            </li>
                            <li  class="form-check">
                                <input type="checkbox" id="name">
                                <label for="name">Mes enchères remportées</label>
                            </li>
                        </ul>
                    </ul>
                </div>
            </div>
        </section>
    </section>
    <section class="container pt-3 mt-4">
        <h2>Résultats</h2>
    </section>
    <section class="container pt-3 mt-4">
        <div class="row">
            <div class="card col-4 p-0" style="width: 18rem;">
                <img src="https://picsum.photos/430/225" class="card-img-top" alt="randomImage">
                <div class="card-body">
                    <h5 class="card-title">PC Gamer pour travailler</h5>
                    <p class="card-text">
                        Prix : 210 points <br>
                        Fin de l'enchère : 24/12/2021<br>
                        Vendeur : LiliDeliceGamerz</p>
                    <a href="#" class="btn btn-success">Voir l'enchère</a>
                </div>
            </div>
            <div class="card col-4 p-0" style="width: 18rem;">
                <img src="https://picsum.photos/430/225" class="card-img-top" alt="randomImage">
                <div class="card-body">
                    <h5 class="card-title">PC Gamer pour travailler</h5>
                    <p class="card-text">
                        Prix : 210 points <br>
                        Fin de l'enchère : 24/12/2021<br>
                        Vendeur : LiliDeliceGamerz</p>
                    <a href="#" class="btn btn-success">Voir l'enchère</a>
                </div>
            </div>
            <div class="card col-4 p-0" style="width: 18rem;">
                <img src="https://picsum.photos/430/225" class="card-img-top" alt="randomImage">
                <div class="card-body">
                    <h5 class="card-title">PC Gamer pour travailler</h5>
                    <p class="card-text">
                        Prix : 210 points <br>
                        Fin de l'enchère : 24/12/2021<br>
                        Vendeur : LiliDeliceGamerz</p>
                    <a href="#" class="btn btn-success">Voir l'enchère</a>
                </div>
            </div>
        </div>
    </section>
</body>
			
			
		

	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
	
</body>
</html>
