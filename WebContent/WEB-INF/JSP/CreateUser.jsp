<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta content="text/html" charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

<title>Inscription</title>

<style type="text/css">
.ast { color: #FF030F; };
.asterix label.e-label-top::after { 
  content: "*"; 
  color: red; 
} 
</style>

</head>

<body>

<%@include file="/header/header.jspf" %>

<ejs-autocomplete #ddlChallanType #purchaseType floatLabelType="Always" [fields]="localFields" 
[ngClass]="{ 'asterix' : enableAsterix }" placeholder=" Choose challan type 
" showPopupButton="true" 
[dataSource]="countries"> 
</ejs-autocomplete> 

<section class="container justify-content-center">
	<div class="row" style="text-align:center">
		<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 col-12"> 
			<a href="Home.jsp"><img class="mt-5 mb-4 w-25 h-25" src="images/Logo_encheres.svg" alt="Logo_encheres"/></a>
		</div>
	</div>
</section>

<section class="container justify-content-center">
	<div class="row" style="text-align:center">
		<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 col-12">
			<h6>Inscrivez-vous pour profiter des enchères !</h6>
			<p><small>Les champs marqués d'une <font class="ast">*</font> sont obligatoires</small></p>
		</div>
	</div>
</section>

<section class="container">
	<form class="row justify-content-center" action="<c:url value="/register/"/>" method="post">
	        <div class=" col-xs-12 col-sm-12 col-md-9 col-lg-3 col-xl-3 col-3 mb-0"> 
	            <input placeholder="Pseudo*"  class="form-control" type="text" name="pseudo" required>
	       
	        	<br>
	         
	            <input placeholder="Prénom*"  class="form-control" type="text" name="name" required>
	       
	       
	            <input placeholder="Nom*" class="form-control" type="text" name="surname"  required>
	        
	        <br>
	      
	            <input placeholder="Téléphone*"  class="form-control" type="text" name="phone" maxlength=10 required>
	       
	      
	            <input placeholder="Email*"  class="form-control" type="text" name="mail" required>
	            <p><small>
	            Format 0600000000
	            </small></p>
	      
			
	            <input placeholder="Rue*"  class="form-control" type="text" name="street"  required>
	      
	       
	            <input placeholder="Code Postal*"  class="form-control" type="text" name="cp" maxlength=5 required>
	       
	        
	            <input  placeholder="Ville*"  class="form-control" type="text" name="city"  required>
	       
				<br>
	       
	            <input placeholder="Mot De Passe*"  class="form-control" type="password" name="password" required>
	        
	        
	            <input placeholder="Confirmer le mot de passe*"  class="form-control" type="password" name="PasswordConf" required>
	        
	        
		        <p class="mb-2" ><small>
		      	 	Le mot de passe doit :<br> - Comporter entre 5 et 25 caractères<br> - Contenir une miniscule et une majuscule<br> - Contenir au moins un chiffre
		        </small></p>
	        
	
			
	   			 <button class="btn btn-success mb-2 justify-content-center w-100" type="submit">Valider l'inscription</button>
			</div>
    </form>
</section>

<section class="container w-50 d-flex column justify-content-center">
	<form action="<c:url value="/home/"/>" method="post" class="w-25 mb-0">
		<div>
	    	<a href="<c:url value="/web-inf/jsp/home" />"><button class="form-control btn btn-danger w-100">Annuler</button></a>
		</div>
	</form>
</section>

</body>
</html>