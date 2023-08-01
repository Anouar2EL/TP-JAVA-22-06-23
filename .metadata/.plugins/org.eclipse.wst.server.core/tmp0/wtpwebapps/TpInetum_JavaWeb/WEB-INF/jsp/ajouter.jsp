<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Page Ajouter</h1>

		<form method="post">

			<div class="mb-3">
				<label for="prenom" class="form-label">Prénom</label> 
				<div>
					<input type="text" name="prenom" id="prenom" placeholder="Saisir ici votre prenom" />
				</div>
			</div>
			<div class="mb-3">
				<label for="email" class="form-label">Email</label>
				<div>
					<input type="email" name="email" id="email" placeholder="Saisir ici votre email de connexion" />
				</div> 
			</div>
			<div class="mb-3">
				<label for="mdp" class="form-label">Mot de passe</label>
				<div>
					<input type="password" name="mdp" id="mdp" placeholder="Saisir ici votre mot de passe" />
				</div> 
			</div>
			<div class="mb-3">
				<label for="mdp" class="form-label">adresse Id</label>
				<div>
					<input type="text" name="adresseId" id="adresseId" placeholder="Saisir ici votre id d'adresse" />
				</div> 
			</div>
			
			<div class="mb-3">
				<label for="ddn" class="form-label">Date de naissance</label>
				<div>
					<input type="date" name="ddn" id="ddn" />
				</div> 
			</div>
			
				<div class="mb-3">
				<label for="role" class="form-label">Role</label>
				<div>
					<input type="text" name="role" id="role"   placeholder="Saisir ici votre role"/>
				</div> 
			</div>
			<div class="mb-3">
				<label for="id" class="form-label">Identifiant</label>
				<div>
					<input type="text" name="id" id="id" placeholder="Saisir ici votre identifiant " />
				</div> 
			</div>
			
			
			
		   <div class="mb-3">
				<label for="nomVoie" class="form-label">nom de la Voie</label>
				<div>
					<input type="text" name="nomVoie" id="nomVoie" placeholder="Saisir ici votre nom de voie " />
				</div> 
			</div>
						<div class="mb-3">
				<label for="codePostal" class="form-label">Code Postale</label>
				<div>
					<input type="text" name="codePostal" id="codePostal" placeholder="Saisir ici votre code postale " />
				</div> 
			</div>
						<div class="mb-3">
				<label for="ville" class="form-label">ville</label>
				<div>
					<input type="text" name="ville" id="ville" placeholder="Saisir ici votre ville " />
				</div> 
			</div>
			
			<input class="btn btn-primary" type="submit" value="Valider">
		</form>
	</div>
</body>
</html>