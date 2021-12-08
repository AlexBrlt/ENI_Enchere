<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<div>
<h1> ENI-Enchères</h1>
</div>

<div>
	<form name="loginForm" method="post" action="<%=getServletContext().getContextPath()%>/login">
  <div class="container">
    <label for="userID"><b>Identifiant :</b></label>
    <input type="text" name="userID" required>
	<br>
    <br>
    <label for="password"><b>Mot de passe :</b></label>
    <input type="password" name="password" required>
	<br>
    <br>
    <br>
   	<input type="submit" value="Connexion" />
      <input type="checkbox" name="remember"> Se souvenir de moi
      <br>
      <a href="#">Mot de passe oublié?</a>
  </div>
    </form>
    <div class="container">
      <br>
   	<a href="<c:url value="/register" />"><input type="button" value="Créer un compte"/></a>
  </div>

  </div>
</body>
</html>