<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta content="text/html" charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1, user-scalable=yes">
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

<ejs-autocomplete #ddlChallanType #purchaseType floatLabelType="Always" [fields]="localFields" 
[ngClass]="{ 'asterix' : enableAsterix }" placeholder=" Choose challan type 
" showPopupButton="true" 
[dataSource]="countries"> 
</ejs-autocomplete> 

<section class="container">
	<div class="row" style="text-align:center">
		<div class="col"> 
			<a href="Home.jsp"><img class="mt-5 mb-4" src="images/Logo_encheres.svg" alt="Logo_encheres"/></a>
		</div>
	</div>
</section>

<section class="container">
	<div class="row" style="text-align:center">
		<div class="col-md-2 col-lg-2 col-xl-4 col-4">
		</div>
		<div class="col-auto mb-0"> 
			<h1 class="h6">Inscrivez-vous pour profiter des enchères !</h1>
			<p><small>Les champs marqués d'une <font class="ast">*</font> sont obligatoires</small></p>
		</div>
		<div class="col-md-2 col-lg-2 col-xl-4 col-4">
		</div>
	</div>
</section>

<section class="container">
	<div class="row">
		<div class="col-4">
		</div>
			<div class="col-xs-10 col-sm-8 col-md-8">
				<form action="<c:url value="/register/"/>" method="post">
				        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-4 col-xl-4 col-6 mb-0"> 
				            <input placeholder="Pseudo*" style="resize:none"  class="form-control form-control-sm mb-2" type="text" name="pseudo" required>

				            <input placeholder="Prénom*"  class="form-control form-control-sm" type="text" name="name" required>
				            <input placeholder="Nom*" class="form-control form-control-sm mb-2" type="text" name="surname"  required>

				            <input placeholder="Email*"  class="form-control form-control-sm" type="text" name="mail" required>
				      		<input placeholder="Téléphone*"  class="form-control form-control-sm" type="text" name="phone" maxlength=10 required>
				            <p class="mt-0 mb-1"><small><em>Format 0600000000</em></small></p>
				            <input placeholder="Rue*"  class="form-control form-control-sm" type="text" name="street"  required>
				            <input placeholder="Code Postal*"  class="form-control form-control-sm" type="text" name="cp" maxlength=5 required>
				            <input  placeholder="Ville*"  class="form-control form-control-sm mb-2" type="text" name="city"  required>

				            <input placeholder="Mot De Passe*"  class="form-control form-control-sm" type="password" name="password" required>
				            <input placeholder="Confirmer le mot de passe*"  class="form-control form-control-sm" type="password" name="PasswordConf" required>
					        <p class="mb-2">
					        <small>Le mot de passe doit :<br> - Comporter entre 5 et 25 caractères<br> - Contenir une miniscule et une majuscule<br> - Contenir au moins un chiffre
					        </small></p>
				     		<button class="btn btn-sm btn-success mb-2 justify-content-center w-100" type="submit">Valider l'inscription</button>
						</div>
			    </form>
		    </div>
		<div class="col-4">
		</div>
    </div>
</section>

<section class="container">
	<div class="row">
		<div class="col col-4">
		</div>
		<div class="col col-4">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-8 col-xl-8 col-8 mb-0"> 
		    	<a href="<c:url value="/web-inf/jsp/home" />"><button class="btn btn-sm btn-danger w-100">Annuler</button></a>
			</div>
		</div>
		<div class="col col-4">
		</div>
	</div>
</section>

</body>
</html>