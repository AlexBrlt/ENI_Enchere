<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html" charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<title>Créer votre compte utilisateur</title>
</head>

<body>

<div> <a href="Home.jsp">Eni_Enchères</a></div>

<h1>Créer votre compte client</h1>

<form action="<%=getServletContext().getContextPath()%>/login" method="post">
  <div class="row">
    <div class="col-lg-6">
        <div>
            <label>Pseudo : </label> 
            <input type="text" name="pseudo" required>
        </div>

        <div>
            <label>Prénom : </label> 
            <input type="text" name="name" >
        </div>

        <div>
            <label>Téléphone : </label> 
            <input type="text" name="phone" maxlenght=10 >
        </div>

        <div>
            <label>Code postal : </label> 
            <input type="text" name="cp" maxlength=5  >
        </div>

        <div>
            <label>Mot de passe : </label> 
            <input type="password" name="password" required>
        </div>
  </div>

  <div class="col-lg-6">
        <div>
            <label>Nom : </label> 
            <input type="text" name="surname"  required>
        </div>

        <div>
            <label>Email : </label> 
            <input type="text" name="mail" required>
        </div>

        <div>
            <label>Rue : </label> 
            <input type="text" name="street"  required>
        </div>

        <div>
            <label>Ville : </label> 
            <input type="text" name="city"  required>
        </div>

        <div>
            <label>Confirmation : </label> 
            <input type="text" name="PasswordConf" required>
        </div>

  </div>
</div>

</form>

<div>
    <button type="submit">Créer</button>
</div>

<div>
    <a href="<%=getServletContext().getContextPath()%>/web-inf/jsp/login"><button>Annuler</button></a>
</div>


</body>
</html>