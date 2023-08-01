
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html >
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="assets/bs/css/bootstrap.css" />
<link rel="stylesheet" href="assets/css/app.css">
<title>Login Page</title>

<style >

.content {
    width: 75%;
	box-shadow: 0px 4px 14px 0px black;
    padding-bottom: 3rem;
}
.monForm {
    width: 50%;
    margin-left: auto;
    margin-right: auto;
    margin-top :auto;
    margin-bottom: auto;
    
}
.header {
  background-color: #082e6f;
}
.titre{
  background-color: #082e6f;
}
.erreur{
  color: red;
  font-style: italic;
  padding-bottom: 1rem;
  padding-left: 2rem;
}
</style>
</head>
<body>
	<div class="content" >
		<div class="header" >JSP-FILTER-CRUD</div>
		<div class="monForm shadow mt-5">
			<div class="titre ">login form</div>
			<form method="post">
				<div class="mb-3">
					 <input
						type="email" class="form-control" id="login" name="email"
						placeholder="Saisir votre login au format @email">
				</div>
				<div class="mb-3">
					 <input
						type="password" class="form-control" id="mdp" name="mdp"
						placeholder="Saisir votre mot de passe">
				</div>
		<% 
			if(session.getAttribute("err") != null){
		%>
			<div class="erreur " ><li><%= session.getAttribute("err") %></li></div>
		<% } %>
		
				<div>
					<input type="submit" value="Valider" class="btn btn-primary" style="background-color:#082e6f; "/> <input
						type="reset" value="Reset" class="btn btn-secondary float-end" style="background-color:#b0bec; "/>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
