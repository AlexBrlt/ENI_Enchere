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
	          			<div>
				          	 <form method="post" action="home">
				          	 <div>
					          	 <div>
					                <div class="mb-3 form-group">
					                    <label for="nameArticle" class="form-label">Rechercher</label>
					                    <input type="text" class="form-control" id="nameArticle" name="recherche">
					                    <div id="helpNameArticle" class="form-text text-secondary">Un large choix d'objets</div>
					                </div>
					             </div>
					             
						            <div class="w-25">
						                <div class="form-group">
						                    <label for="categories">Choisir une catégorie</label>
						                    <select class="form-control" id="categories" name="categories">
						                    	<option value="">Choisir une catégorie</option>
						                        <option value="Ameublement">Ameublement</option>
						                        <option value="Informatique">Informatique</option>
						                        <option value="Vêtements">Vêtements</option>
						                        <option value="Sport&Loisirs">Sport&Loisirs</option>
						                    </select>
						                </div>
						            </div> 
				               </div>
				               
				               
					                <div class ="d-flex">
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
						                <div>
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
					       			<div>
					       				<input type="submit" value="Recherche" class="btn btn-success mb-4">
					       			</div> 			
			                	</form>
		       		 		</div>
	   					</div>
	   			
	        	</c:when>
	        	  	<c:when test="${empty sessionScope}">
	    			 <form method="post" action="home">
	    			 	<div class ="d-flex justify-content-around">
					          	 <div>
					                <div class="mb-3 form-group">
					                    <label for="nameArticle" class="form-label">Rechercher</label>
					                    <input type="text" class="form-control" id="nameArticle" name="recherche">
					                    <div id="helpNameArticle" class="form-text text-secondary">Un large choix d'objets</div>
					                </div>
					             </div>
					             
						            <div class="col-6">
						                <div class="form-group">
						                    <label for="categories">Choisir une catégorie</label>
						                    <select class="form-control" id="categories" name="categories">
						                    	<option value="">Choisir une catégorie</option>
						                        <option value="Ameublement">Ameublement</option>
						                        <option value="Informatique">Informatique</option>
						                        <option value="Vêtements">Vêtements</option>
						                        <option value="Sport&Loisirs">Sport&Loisirs</option>
						                    </select>
						                </div>
						            </div> 
				               </div>
				            	<div>
					       			<input type="submit" value="Recherche" class="btn btn-success mb-4">
					       		</div>        
	                 </form>
	    			</c:when>
	        </c:choose>
           </div>
    </section>


	<section class="container pt-3 mt-4">
	<h2>Propositions</h2>
		<div class="row">
			<c:forEach items="${requestScope.listArticle}" var="article">
	            <div class="col-4">
	                <div class="card">
	                    <img src="https://picsum.photos/430/225" class="card-img-top" alt="randomImage">
	                    <div class="card-body">
	                        <h5 class="card-title"><c:out value="${article.nameArticle}"></c:out></h5>
	                        <p class="card-text">
	                            Prix : <c:out value="${article.priceStart }"></c:out><br>
	                            Fin de l'enchère : <c:out value="${article.dateEndAuction}"></c:out><br>
	                            Vendeur : <a href="${pageContext.request.contextPath}/SellerDisplay?pseudo=${article.seller.pseudo}"><c:out value="${article.seller.pseudo}"></c:out></a></p>
	                            <c:choose>
	                            	<c:when test="${empty sessionScope}">
	                            		<a href="<c:url value = "/login"/>" class="btn btn-success">Voir l'enchère</a>
	                            	</c:when>
	                            	<c:when test="${!empty sessionScope}">
	                            		<c:if test="${sessionScope.user.pseudo == article.seller.pseudo}">
	                            			<a href="<c:url value = "/ModifyArticle?noArticle=${article.noArticle}&noCategorie=${article.noCategorie}"/>" class="btn btn-success">Voir l'enchère</a>
	                            		</c:if>

	                            		<c:if test="${sessionScope.user.pseudo != article.seller.pseudo }">

	                            			<a href="<c:url value = "/achatArticle?noArticle=${article.noArticle}"/>" class="btn btn-success">Voir l'enchère</a>
	                            		</c:if>
	                            	</c:when>
	                            </c:choose>
	                    </div>
	                </div>
	            </div>
    		</c:forEach>
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
