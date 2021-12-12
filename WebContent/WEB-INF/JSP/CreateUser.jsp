<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta content="text/html" charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

<title>Créer votre compte utilisateur</title>

<style type="text/css">
.ast { color: #FF030F; };
.asterix label.e-label-top::after { 
  content: "*"; 
  color: red; 
} 
</style>

</head>

<body>

<ejs-autocomplete #ddlChallanType #purchaseType floatLabelType="Always" [fields]="localFields" 
[ngClass]="{ 'asterix' : enableAsterix }" placeholder=" Choose challan type 
" showPopupButton="true" 
[dataSource]="countries"> 
</ejs-autocomplete> 

<section class="container w-50 d-flex justify-content-center">
	<div> 
		<a href="Home.jsp"><img class="mt-5 mb-4 w-50 h-50" src="images/Logo_encheres.svg" alt="Logo_encheres"/></a>
	</div>
</section>

<section class="container w-50 d-flex justify-content-center">
	<div style="text-align:center">
		<h1 class="h3 fw-normal">Inscrivez-vous pour profiter des enchères !</h1>
		<p>Les champs marqués d'une <font class="ast">*</font> sont obligatoires</p>
	</div>
</section>

<section class="container w-50 d-flex justify-content-center">
	<form action="<c:url value="/register/"/>" method="post" class="w-25 mb-0">
	        <div> 
	            <input placeholder="Pseudo*"  class="form-control" type="text" name="pseudo" required>
	        </div>
	        	<br>
	        <div>    
	            <input placeholder="Prénom*"  class="form-control" type="text" name="name" required>
	        </div>
	        <div>
	            <input placeholder="Nom*" class="form-control" type="text" name="surname"  required>
	        </div>
	        <br>
	        <div>
	            <input placeholder="Téléphone*"  class="form-control" type="text" name="phone" maxlength=10 required>
	        </div>
	        <div>
	            <input placeholder="Email*"  class="form-control" type="text" name="mail" required>
	            <p><small>
	            Format 0600000000
	            </small></p>
	        </div>
			<div>
	            <input placeholder="Rue*"  class="form-control" type="text" name="street"  required>
	        </div>
	        <div>
	            <input placeholder="Code Postal*"  class="form-control" type="text" name="cp" maxlength=5 required>
	        </div>
	        <div>
	            <input  placeholder="Ville*"  class="form-control" type="text" name="city"  required>
	        </div>
				<br>
	        <div>
	            <input placeholder="Mot De Passe*"  class="form-control" type="password" name="password" required>
	        </div>
	        <div>
	            <input placeholder="Confirmer le mot de passe*"  class="form-control" type="password" name="PasswordConf" required>
	        </div>
	        <div>
		        <p class="mb-2"><small>
		      	 	Le mot de passe doit :<br> - Comporter entre 5 et 25 caractères<br> - Contenir une miniscule et une majuscule<br> - Contenir au moins un chiffre
		        </small></p>
	        </div>
	
			<div>
	   			 <button class="w-100 form-control btn btn-success mb-2" type="submit">Valider l'inscription</button>
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