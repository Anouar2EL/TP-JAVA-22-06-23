<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Page de Autre Servlet </h1>
<h2> Mon prenom est : ${prenom}  et  J'ai ${age} ans </h2>

<%! String ville = "Paris"; %>
<h2 style ="color:red">  
<%=ville %>
</h2>

</body>
</html>