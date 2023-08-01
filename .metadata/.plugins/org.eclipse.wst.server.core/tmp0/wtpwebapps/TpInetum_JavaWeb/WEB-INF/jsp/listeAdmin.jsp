<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="assets/bs/css/bootstrap.css" />
	<link rel="stylesheet" href="assets/css/app.css">

<title>Page Liste</title>
<style >
.content {
    width: 75%;
	box-shadow: 0px 4px 14px 0px black;
    padding-bottom: 1rem;
}
.container {

	box-shadow: 0px 4px 20px 0px grey;
    padding-bottom: 0.5rem;
    margin-top: 1rem;
    padding-left: 0;
    padding-right: 0;
    
}
    h1 {    
    background-color: #0a58ca;
    color: white;
    text-align: center;
    font-size: 2rem;
    }
.header {
  background-color: #082e6f;
}
p {
    display: flex;
    justify-content: space-between;
}
.tab{
padding-left: var(--bs-gutter-x, 0.75rem);
padding-right: var(--bs-gutter-x, 0.75rem);
}
.en-tete{
background-color: #0d6efd;
color: white;
}
</style>
</head>
<body>
<div class="content" >
		<div class="header" >JSP-FILTER-CRUD</div>
		
	<div class="container">

		<h1>LISTE DES STAGIAIRES</h1>
		<div class="tab">
		<p>
		<a href="ajouter" class="btn btn-primary">
		<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-plus-fill" viewBox="0 0 16 16">
  		<path d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
 		 <path fill-rule="evenodd" d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z"/>
		</svg>
		</a>
		<a href="login?action=deconnexion" class="btn btn-primary" style="background-color:grey;border-color: grey; ">Deconnexion</a>
		</p>
		<table class="table table-hover table-bordered">
    <thead class=" text-center text-uppercase " style>
        <tr class ="en-tete">
            <td >Id</td>
            <td>Version</td>
            <td>Prénom</td>
            <td>Email</td>
            <td>Date de naissance</td>
            <td>Age</td>
            <td>Role</td>
            <td>Voie</td>
            <td>Ville</td>
            <td colspan="2">Actions</td>
        </tr>
    </thead>
    <tbody class="text-center">
        <c:forEach var="stagiaire" items="${listeStagiaires}" varStatus="stagiaireStatus">
            <tr>
                <td>${stagiaire.id}</td>
                 <td>${1}</td>
                <td>${stagiaire.prenom}</td>
                <td>${stagiaire.email}</td>
                <td>${stagiaire.ddn}</td>
                <td>${ stagiaire.age} ans</td>
                <td>${stagiaire.role}</td>
                <c:forEach var="adresse" items="${listeAdresses}" varStatus="adresseStatus">
                    <c:if test="${stagiaire.adresseId == adresse.id}">
                        <td>${adresse.nomVoie}</td>
                        <td>${adresse.ville}</td>
                    </c:if>
                </c:forEach>
                <td><a href="liste?action=supprimer&&id=${stagiaire.id}" class="btn btn-danger">Supprimer</a></td>
                <td><a href="liste?action=modifier&&id=${stagiaire.id}" class="btn btn-warning">Modifier</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</div>
	</div>
	</div>
</body>
</html>







