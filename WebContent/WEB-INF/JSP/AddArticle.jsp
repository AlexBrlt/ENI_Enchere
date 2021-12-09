<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nouvelle vente</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body class="bg-light">
    <section class="container text-center mb-4">
        <h1> Nom utilisateur,<br> souhaitez-vous déposer un nouvel article ? </h1>
    </section>

    <section class="container border bg-white p-4 mb-4 w-50">
        <h2>Informations article</h2>
        <form>
            <div class="mb-3 form-group">
                <label for="nameArticle" class="form-label">Nom de l'article</label>
                <input type="text" class="form-control" id="nameArticle" name="nameArticle">
                <div id="helpNameArticle" class="form-text text-secondary">Soyez concis dans votre titre</div>
            </div>
            <div class="mb-3 form-group">
                <label for="description" class="form-label">Description</label>
                <textarea class="form-control" id="description" rows="3" name="description"></textarea>
                <div id="helpDescription" class="form-text text-secondary">Une bonne description augmente vos chances de vente</div>
            </div>
            <div class="form-group">
                <label for="categories">Choisir une catégorie</label>
                <select class="form-control" id="categories" name="categories">
                    <option>Ameublement</option>
                    <option>Informatique</option>
                    <option>Vêtements</option>
                    <option>Sport&Loisirs</option>
                </select>
            </div>
            <div class="mb-3">
                <label for="formFile" class="form-label">Photo de l'article</label>
                <input class="form-control" type="file" id="formFile" name="formFile">
            </div>
            <div class="input-group mb-3 form-group">
                <input type="text" class="form-control" aria-label="Recipient's username" aria-describedby="points" name="points">
                <span class="input-group-text" id="points">points</span>
            </div>
            <div class="mb-3 form-group">
                <label for="StartAuction" class="form-label">Début de l'enchère</label>
                <input type="date" class="form-control" id="StartAuction" name="StartAuction">
                <div id="helpAuctionStart" class="form-text text-secondary">Format DD/MM/YYYY</div>
            </div>
            <div class="mb-3 form-group">
                <label for="EndAuction" class="form-label">Fin de l'enchère</label>
                <input type="date" class="form-control" id="EndAuction" name="EndAuction" >
                <div id="helpAuctionEnd" class="form-text text-secondary">Format DD/MM/YYYY</div>
            </div>
        </form>
    </section>


    <section class="container border bg-white p-4 w-50">
        <h2>Informations retrait</h2>
        <div class="mb-3 form-group">
            <label for="rue" class="form-label">Rue</label>
            <input type="text" class="form-control" id="rue" name="rue">
        </div>
        <div class="mb-3 form-group">
            <label for="codePostal" class="form-label">Code postal</label>
            <input type="text" class="form-control" id="codePostal" name="codePostal">
        </div>
        <div class="mb-3 form-group">
            <label for="ville" class="form-label">Ville</label>
            <input type="text" class="form-control" id="ville" name="ville">
        </div>
    </section>
    <section class="container d-flex justify-content-between mt-3 mb-5 pr-0 pl-0 w-50">
        <button type="button" class="btn btn-danger">Annuler</button>
        <button type="button" class="btn btn-success">Mettre en ligne</button>
    </section>
</body>
</html>