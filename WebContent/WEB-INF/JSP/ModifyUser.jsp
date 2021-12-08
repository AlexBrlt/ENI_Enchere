<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html" charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Modifier mon compte</title>

</head>

<body>

<div> <a href="Home.jsp">Eni_Enchères</a></div>

<h1>Modifier mon compte</h1>

<form action="<%=getServletContext().getContextPath()%>/login" method="post">
  <div class="row">
    <div class="col-lg-6">
        <div>
            <label>Pseudo : </label> 
            <c:out value="${sessionScope.user.pseudo}"></c:out>
        </div>

        <div>
            <label>Prénom : </label> 
            <input type="text" name="name" value="<c:out value="${sessionScope.user.name}"></c:out>" >
        </div>

        <div>
            <label>Téléphone : </label> 
            <input type="text" name="phone" maxlenght=10 value="<c:out value="${sessionScope.user.telephone}"></c:out>">
        </div>

        <div>
            <label>Code postal : </label> 
            <input type="text" name="cp" maxlength=5 value="<c:out value="${sessionScope.user.code_postal}"></c:out>" >
        </div>

        <div>
            <label>Mot de passe : </label> 
            <input type="password" name="password" value="<c:out value="${sessionScope.user.mot_de_passe}"></c:out>" required>
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
    <button type="submit">Modifier</button>
</div>

<div>
</div>


</body>
</html>