<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" 
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<title>Votre ventte est terminée</title>
</head>
<body class="bg-light">

    <section class="container text-center mb-4">
        <h1> <c:out value="${requestScope.articlebuyerpseudo}"/><br> a remporté votre vente aux enchères !</h1>
    </section>

    <section class="container border bg-white p-4 mb-4 w-50">
    
    <p><strong><c:out value="${requestScope.article.nameArticle}"/></strong></p>
    
    <p><strong>Description :</strong> <c:out value="${requestScope.articledesciption}"/><p>
    
    <p><strong>Meilleure offre :</strong> <c:out value="${requestScope.encherefaite}"/> points, par <c:out value="${requestScope.articlebuyerpseudo}"/></p>
     
     <p> <strong>Mise à prix :</strong> <c:out value="${requestScope.articlesStartPrice}"/> points</p>  
     <p> <strong>Fin de l'enchère :</strong> <c:out value="${requestScope.articlefinenchere}"/></p>  
     <p> <strong>Retrait :</strong> <c:out value="${requestScope.articleretraitstreet}"/>, <c:out value="${requestScope.articleretraitpostal}"/> <c:out value="${requestScope.articleretraitCity}"/></p>  
     <p><strong>Vendeur :</strong> <c:out value="${requestScope.articleretraitpseudo}"/></p>  

    </section>

																<!-- A modifier si les informations de livraison ne sont pas les mêmes que celle du user -->
    <section class="container border bg-white p-5 w-50 ">
    	<form action="<c:url value = "/MySellingEnded"/>" method="post">
    	
 			<button type="submit" class="btn btn-success float-right">Retrait effectué</button>
 			
   		</form>
    </section>
    
    <div class = "container  w-50">
   <a  href="<c:url value = "Home"/>">retour a l'accueil</a>
	</div>
	
</body>
</html>