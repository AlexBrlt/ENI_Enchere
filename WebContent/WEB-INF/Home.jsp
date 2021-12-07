<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="Home.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>

	<div>
		<h1>Liste des enchères</h1>
	</div>
	
	
	<div>
		<form action="">
		
			<input type="text" id="rechercheArticle" name="rechercheArticle">
			
			<label for="categories">Categorie : </label>
			
			<select id="categories" name="categories">
				<option></option>
			</select>	
			
			<input type="radio" name="achatetvente" id="achat">
			
			<div class="container">
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
			<div>
			<input type="submit" value="Rechercher">
			</div>
		</form>
	</div>
</body>
</html>