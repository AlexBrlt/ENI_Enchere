<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
  <head> 
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" 
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
  </head>
  <body class="text-center">
  
    <section class="container">
    <img class="mb-4" src="/WEB-INF/images/Logo_encheres.svg" alt="" width="75" height="75">
    	<h1 class="h3 mb-3 fw-normal">Veuillez vous connecter</h1>
    </section>
    <section class="container">
    	<div class="form-signin">
    	</div>
    </section>
    
    <section class="container w-25">
    
    <form name="loginForm" method="post" action="<%=getServletContext().getContextPath()%>/login">
	<div class="form-floating">
      <input type="email" class="form-control" id="floatingInput" placeholder="Identifiant" required>
    </div>
    
    <div class="form-floating">
      <input type="password" class="form-control" id="floatingPassword" placeholder="Mot de passe" required>
    </div>
    
    <div class="checkbox mb-3">
      <label>
        <input type="checkbox" value="remember-me"> Se souvenir de moi
        <br>
        <a href="#">Mot de passe oublié</a>
      </label>
    </div>
    	
   <div>
        <button type="submit" class="btn btn-success w-100">Connexion</button>
   </div>
   </form>
   
   <div>
   <form name="loginForm" method="post" action="<%=getServletContext().getContextPath()%>/register">
   	<button type="button" class="btn btn-primary w-100">Créer un compte</button>
   	</form>
   	
   	        <br>
	<a href="/WEB-INF/Home.jsp">Retour à la page d'accueil</a>
   </div>
   <p class="mt-5 mb-3 text-muted">&copy; 2021</p>
</section>
  </body>
</html>