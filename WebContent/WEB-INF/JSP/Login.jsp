<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
  <head> 
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" 
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
  </head>
  <body class="text-center mt-5 pt-5">
  	<section class="container w-50 pt-5">
  		<div>
    		<a href="Home.jsp"><img class="mt-5 mb-4 w-50 h-50" src="images/Logo_encheres.svg" alt="Logo_encheres"/></a>
    	</div>
    	<h1 class="h3 mb-4 fw-normal">Veuillez vous connecter</h1>
    </section>

    <section class="container w-25" >
		<div class="row justify-content-center">
			<form class="w-100 col-6" name="loginForm" method="post" action="<c:url value = "/login"/>">
				<div class="form-floating mb-2">
		     		 <input name = "userID" type="text" class="form-control" id="floatingInput" placeholder="Identifiant" required>
		    	</div>
		   
		    	<div class="form-floating mb-1">
		      		<input name ="password" type="password" class="form-control" id="floatingPassword" placeholder="Mot de passe" required>
		    	</div>
		    	
		    	<div class="checkbox mb-1">
			    	<label>
			        	<input type="checkbox" value="remember-me"> Se souvenir de moi
			        <br>
			        	<a href="#">Mot de passe oublié</a>
			      	</label>
			    </div>
		    		
		    	<div>
			        <button type="submit" class="btn btn-success w-100 mb-2">Connexion</button>
			   </div>
		   </form>
		</div>
	</section>

	<section class="container w-25">
		<div class="row justify-content-center">
   			<div class="w-100 col-6">
   				<a class="btn btn-primary w-100 mb-1" href="<c:url value = "/register"/>">Créer un compte</a>
   	        <br>
				<a href="/WEB-INF/Home.jsp">Retour à la page d'accueil</a>
			</div>
		</div>
   		<p class="mt-5 mb-3 text-muted">&copy; 2021 - Les objets sont nos amis</p>
	</section>
  </body>
</html>