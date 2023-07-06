
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!doctype html>
<html lang="fr">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="assets/bs/css/bootstrap.css" />
<link rel="stylesheet" href="assets/css/app.css">
<title>Login Page</title>
</head>
<body>
	<div class="content">
		<div class="header">Tirage aléatoire</div>
		<div class="monForm shadow mt-5">
			<div class="titre bg-primary">Recherche d'un nombre aléatoire compris entre 1 et 10</div>
			<form method="post">
				<div class="mb-3">
					<label for="accueil" class="form-label">Intoduisez votre nombre </label> <input
						type="text" class="form-control" id="accueil"
						placeholder=" "  name ="nombre">
						
				</div>
				
			<p> 
				Tentatives: fois 
			<p/>
			
				<div>
					<input type="submit" value="Valider votre choix" class="btn btn-primary" /> <input
						type="reset" value="Tout recommencer" class="btn btn-secondary float-end" />
				</div>
			</form>


			<div>
				<%
                String succes = (String)request.getAttribute("nombre");
                if(succes != null) {
            %>
				<div class=" result alert alert-success"><%= succes  %></div>
			<% 
				
                } %>
				
			</div>



		</div>
	</div>
</body>
</html>




