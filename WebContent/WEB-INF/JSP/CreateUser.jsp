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

<div> <a href="Home.jsp">Eni_Enchères</a></div>
<section class="container border">
<div style="text-align:center">
<h1>Inscrivez-vous pour profiter des enchères !</h1>
<p>Les champs marqués d'une <font class="ast">*</font> sont obligatoires</p>


<form action="<c:url value="/register" />" method="post">
  <div>
        <div class="form-group"> 
            <input placeholder="Pseudo*"  class="w-50 form-control" type="text" name="pseudo" required>
        </div>
			<br>	
        <div class="form-group">
 
            <input placeholder="Prénom*"  class="w-50 form-control" type="text" name="name" required >
        </div>
			<br>
        <div class="form-group">
            <input placeholder="Téléphone*"  class="w-50 form-control" type="text" name="phone" maxlenght=10 required>
        </div>
			<br>
        <div class="form-group">
            <input placeholder="Code Postal*"  class="w-50 form-control" type="text" name="cp" maxlength=5 required>
        </div>
			<br>
        <div class="form-group">

            <input placeholder="Mot De Passe*"  class="w-50 form-control" type="password" name="password" required>
        </div>
			<br>
        <div class="form-group">
            <input placeholder="Nom*" class="w-50 form-control" type="text" name="surname"  required>
        </div>
			<br>
        <div class="form-group">
            <input placeholder="Email*"  class="w-50 form-control" type="text" name="mail" required>
        </div>
			<br>
        <div class="form-group">
            <input placeholder="Rue*"  class="w-50 form-control" type="text" name="street"  required>
        </div>
			<br>
        <div class="form-group">
            <input  placeholder="Ville*"  class="w-50 form-control" type="text" name="city"  required>
        </div>
			<br>
        <div class="form-group">
            <input placeholder="Confirmer le mot de passe*"  class="w-50 form-control" type="password" name="PasswordConf" required>
        </div>
        <div>
	        <p>
	      	  Le mot de passe doit :<br> - Comporter entre 5 et 25 caractères<br> - Contenir une miniscule et une majuscule<br> - Contenir au moins un chiffre
	        </p>
        </div>

  </div>
<div class="form-group">
    <button class="w-50 form-control btn btn-success" type="submit">Valider l'inscription</button>
</div>

</form>

<div class="form-group">
    <a href="<c:url value="/web-inf/jsp/login" />"><button class="w-50 form-control btn btn-danger">Annuler</button></a>
</div>
</div>
</section>

</body>
</html>