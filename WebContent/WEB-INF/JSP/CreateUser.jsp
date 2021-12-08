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

<h1> Mon profil</h1>

<form action="<%request.getContextPath()%>/login" method="post">
  <div class="row">
    <div class="col-lg-6">
        <div>
            <label>Pseudo : </label> 
            <input type="text" name="pseudo" value="<%user.getPseudo()%>" required>
        </div>

        <div>
            <label>Prénom : </label> 
            <input type="text" name="name" value="<%user.getName()%>">
        </div>

        <div>
            <label>Téléphone : </label> 
            <input type="text" name="phone" maxlenght=10 value="<%user.getPhone()%>">
        </div>

        <div>
            <label>Code postal : </label> 
            <input type="text" name="cp" maxlength=5 value="<%user.getCP()%>" >
        </div>

        <div>
            <label>Mot de passe : </label> 
            <input type="password" name="password" value="<%user.getPassword()%>" required>
        </div>
  </div>

  <div class="col-lg-6">
        <div>
            <label>Nom : </label> 
            <input type="text" name="surname" value="<%user.getSurname()%>" required>
        </div>

        <div>
            <label>Email : </label> 
            <input type="text" name="mail" value="<%user.getMail()%>" required>
        </div>

        <div>
            <label>Rue : </label> 
            <input type="text" name="street" value="<%user.getStreet()%>" required>
        </div>

        <div>
            <label>Ville : </label> 
            <input type="text" name="city" value="<%user.getCity()%>" required>
        </div>

        <div>
            <label>Confirmation : </label> 
            <input type="text" name="PasswordConf" value="<%user.getPasswordConf()%>" required>
        </div>

  </div>
</div>

</form>

<div>
    <button type="submit">Créer</button>
</div>

<div>
    <a href="<%=request.getContextPath()%>/login.jsp"><button>Annuler</button></a>
</div>


</body>
</html>