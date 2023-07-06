<%@page import="fr.inetum.formation.mvc.ConverterTemperature"%>
<%@page import="fr.inetum.formation.mvc.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	User user = (User) request.getSession().getAttribute("user");

	if (user == null) {
		response.sendRedirect("login");
	}
%>


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
		<div class="header">projet converter</div>
		<div class="monForm shadow mt-5">
			<div class="titre bg-primary">Converter</div>
			<form method="post">
				<div class="mb-3">
					<label for="login" class="form-label">Température </label> <input
						type="text" class="form-control" id="login"
						placeholder="Saisir la température en °C "  name ="tempu">
						
				</div>
				<div>
					<input type="submit" value="Valider" class="btn btn-primary" /> <input
						type="reset" value="Reset" class="btn btn-secondary float-end" />
				</div>
			</form>
			<div>	
			<%
                Double result = (Double) request.getAttribute("tempu");
                if(result != null) {
            %>
                <div class=" result alert alert-success"><%= result  %></div>
            <% } %>  
            <%
                String erreur = (String) request.getAttribute("erreur");
                if(erreur != null){
            %>
            <div class= "error alert alert-danger">${ erreur }</div>

            <% } %>	
            
			</div>
		</div>
	</div>
</body>
</html>






