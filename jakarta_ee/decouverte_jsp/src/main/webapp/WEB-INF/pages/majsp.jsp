<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Ma premiere JSP </h1>
<h2>${msg }</h2>
<h2> Mon prenom est : ${prenom} </h2>
<h2> J'ai ${age} ans </h2>
<h2> Nous somme le : ${date}</h2>
<h2> il est : ${heure}</h2>
<hr/>

<form action="autre" method="post" >
	<p>
		prenom : <input type="text" name="prenom"/>
	<p/>
	<p>
		age : <input type="text" name ="age" />
	<p/>
	<p>
		<button>Valider</button>
	<p/>
</form>
</body>
</html>