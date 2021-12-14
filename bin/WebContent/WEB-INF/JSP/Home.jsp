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

	 	<%@include file="/header/header.jspf" %>

		
    <section class="container text-center">
  <c:choose>
    	<c:when test="${!empty sessionScope}">
    		<h1>Bon retour, <c:out value="${sessionScope.user.pseudo}"/><br> que cherchez-vous aujourd'hui ? </h1>
    	</c:when>
    	<c:when test="${empty sessionScope}">
    		<h1>Que cherchez-vous aujourd'hui ? </h1>
    	</c:when>
    </c:choose>
    </section>

    <section class="container border bg-white pt-3 mt-4 w-50">
        <div class="row justify-content-center">
        <c:choose>
        	<c:when test="${!empty sessionScope}">
        		<div class="container">
          	<div class="row justify-content-center">
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
	                <div class="col-6">
	                    <ul class="p-0">
	                        <li  class="form-check p-0">
	                           <input type="radio" id="ventes" name="choices">
	                            <label for="ventes">Mes ventes</label>
	                        </li>
	                        <ul class="p-0">
	                            <li  class="form-check">
	                                <input type="checkbox" id="ventesCours" class="ventes">
	                                <label for="name"> Mes ventes en cours </label>
	                            </li>
	                            <li  class="form-check">
	                                <input type="checkbox" id="ventesNonDebute" class="ventes">
	                                <label for="name">Ventes non débutées</label>
	                            </li>
	                            <li  class="form-check">
	                                <input type="checkbox" id="ventesTermine" class="ventes">
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
	                                <input type="checkbox" id="encheresOuverte" class="achat">
	                                <label for="name"> Enchères ouvertes </label>
	                            </li>
	                            <li  class="form-check">
	                                <input type="checkbox" id="mesEncheres" class="achat">
	                                <label for="name">Mes enchères</label>
	                            </li>
	                            <li  class="form-check">
	                                <input type="checkbox" id="encheresRemporte" class="achat">
	                                <label for="name">Mes enchères remportées</label>
	                            </li>
	                        </ul>
	                    </ul>
	                </div>
	       		 </div>
   			</div>
        	</c:when>
        	  	<c:when test="${empty sessionScope}">
    				 <form class=" col-6">
                <div class="mb-3 form-group">
                    <label for="nameArticle" class="form-label">Rechercher</label>
                    <input type="text" class="form-control" id="nameArticle">
                    <div id="helpNameArticle" class="form-text text-secondary">Un large choix d'objets</div>
                </div>
                <button type="button" class="btn btn-success mb-4">Rechercher</button>
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
    			</c:when>
        </c:choose>
           </div>
    </section>

    <section class="container pt-3 mt-4">
    	<h2>Propositions</h2>
    </section>

    <section class="container pt-3 mt-4">
        <div class="row">
            <div class="col-4">
                <div class="card">
                    <img src="https://picsum.photos/430/225" class="card-img-top" alt="randomImage">
                    <div class="card-body">
                        <h5 class="card-title">PC Gamer pour travailler</h5>
                        <p class="card-text">
                            Prix : 210 points <br>
                            Fin de l'enchère : 24/12/2021<br>
                            Vendeur : LiliDeliceGamerz</p>
                            <c:choose>
                            	<c:when test="${empty sessionScope}">
                            		<a href="<c:url value = "/register"/>" class="btn btn-success">Voir l'enchère</a>
                            	</c:when>
                            	<c:when test="${!empty sessionScope}">
                            		<a href="<c:url value = "/selling"/>" class="btn btn-success">Voir l'enchère</a>
                            	</c:when>
                            </c:choose>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <div class="card">
                    <img src="https://picsum.photos/430/225" class="card-img-top" alt="randomImage">
                    <div class="card-body">
                        <h5 class="card-title">PC Gamer pour travailler</h5>
                        <p class="card-text">
                            Prix : 210 points <br>
                            Fin de l'enchère : 24/12/2021<br>
                            Vendeur : LiliDeliceGamerz</p>
                        <c:choose>
                            	<c:when test="${empty sessionScope}">
                            		<a href="<c:url value = "/register"/>" class="btn btn-success">Voir l'enchère</a>
                            	</c:when>
                            	<c:when test="${!empty sessionScope}">
                            		<a href="<c:url value = "/selling"/>" class="btn btn-success">Voir l'enchère</a>
                            	</c:when>
                            </c:choose>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <div class="card">
                    <img src="https://picsum.photos/430/225" class="card-img-top" alt="randomImage">
                    <div class="card-body">
                        <h5 class="card-title">PC Gamer pour travailler</h5>
                        <p class="card-text">
                            Prix : 210 points <br>
                            Fin de l'enchère : 24/12/2021<br>
                            Vendeur : LiliDeliceGamerz</p>
                        <c:choose>
                            	<c:when test="${empty sessionScope}">
                            		<a href="<c:url value = "/register"/>" class="btn btn-success">Voir l'enchère</a>
                            	</c:when>
                            	<c:when test="${!empty sessionScope}">
                            		<a href="<c:url value = "/selling"/>" class="btn btn-success">Voir l'enchère</a>
                            	</c:when>
                            </c:choose>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>
			
			
		

	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
	<script>
            //Récupérer l'id des radios
          let ventes =  document.getElementById("achat").onclick = function(){
              document.getElementById("ventesCours").disabled=true;
              document.getElementById("ventesNonDebute").disabled=true;
              document.getElementById("ventesTermine").disabled=true;
              document.getElementById("encheresOuverte").disabled=false;
              document.getElementById("mesEncheres").disabled=false;
              document.getElementById("encheresRemporte").disabled=false;
              document.getElementById("ventesCours").checked = false;
              document.getElementById("ventesNonDebute").checked = false;
              document.getElementById("ventesTermine").checked = false; 
              document.getElementById("ventes").checked=false;
/*               document.getElementsByClassName("ventes").disabled=true;
              document.getElementsByClassName("achat").disabled=false;
              document.getElementsByClassName("ventes").checked=false; */
              
            }
            let achats =  document.getElementById("ventes").onclick = function(){
                document.getElementById("encheresOuverte").disabled=true;
                document.getElementById("mesEncheres").disabled=true;
                document.getElementById("encheresRemporte").disabled=true;
                document.getElementById("ventesCours").disabled=false;
                document.getElementById("ventesNonDebute").disabled=false;
                document.getElementById("ventesTermine").disabled=false;
                document.getElementById("encheresOuverte").checked = false;
                document.getElementById("mesEncheres").checked = false;
                document.getElementById("encheresRemporte").checked = false;
                document.getElementById("achat").checked=false;
/*                 document.getElementsByClassName("achat").disabled=true;
                document.getElementsByClassName("ventes").disabled=false;
                document.getElementsByClassName("achat").checked=false; */
            }
        </script>
</body>
</html>
