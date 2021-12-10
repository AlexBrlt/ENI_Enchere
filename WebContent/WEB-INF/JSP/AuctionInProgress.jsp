<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" 
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<title>Modification d'un article</title>
</head>
<body class="bg-light">

    <section class="container text-center mb-4">
        <h1> Nom utilisateur,<br> voici quelques détails du produit !</h1>
    </section>

    <section class="container border bg-white p-4 mb-4 w-50">
    
    <p><strong>Description :</strong> Un PC que même la Nasa ne possède pas. Fais tourner GuildWars 2 en low à 12 FPS.
		Avec option RGB.<p>
		
    <strong>Description :</strong>
    
    
    
    <p><strong>Meilleure offre :</strong> 230 points, par RobertRPZ</p>
     
     <p> <strong>Mise à prix :</strong> 210 points</p>  
     <p> <strong>Fin de l'enchère :</strong> 08/12/2021</p>  
     <p> <strong>Retrait :</strong> 11 avenue des licornes, 44444 DreamLand</p>  
     <p><strong>Vendeur :</strong> LiliDeliceGamerz</p>  
		

    </section>


																<!-- A modifier si les informations de livraison ne sont pas les mêmes que celle du user -->
    <section class="container border bg-white p-5 w-50 ">
    <form action="<c:url value = "/achatArticle"/>" method="post">
        <h2>Ma Proposition</h2>
        <div class="mb-3 form-group">
           <p> Proposition d'enchère (Meilleure offre : ###### points)</p>
            <input type="text" class="form-control" id="rue" name="rue" value="${sessionScope.user.street }">  
        </div>
        <button type="submit" class="btn btn-success float-right">Enchérir</button>
     </form>   
    </section>
    
    <div class = "container  w-50">
    <p> retour à l'acceuil</p>
	</div>
	
</body>
</html>