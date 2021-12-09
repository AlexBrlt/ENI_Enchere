<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon compte</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>

<body>
 <!--  un get pour lire les informations du profil, pas de modifications de données sur cette page -->
 <div>
 	<div>
 		<h1>Mon compte</h1>
	</div>

  <form action="<%=request.getContextPath()%>/profil" method="get"></form> 


	<div>
		<label for="pseudo">Pseudo</label>
		<input value="${user.pseudo}" name="pseudo" type="text" disabled>
 	</div>
 	
 	<div>
 		<label for="nom">Nom</label>
 		<input value="${user.name}" name="name" type="text" disabled>
 	</div>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
</div>
</body>
</html>