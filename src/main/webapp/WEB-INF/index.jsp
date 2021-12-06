<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contexte et cookies</title>
<link rel="stylesheet" href="index.css">
</head>
<body>
<h1>Contexte et cookies</h1>

<a href="<%=request.getContextPath()%>/ContextServlet">Obtenir les contextes et cookies</a>

<%
//Contexte application
String appData = (String) application.getAttribute("app");
//Contexte session
String sessionData = (String)session.getAttribute("session");
//Contexte requête
String requestData = (String)request.getAttribute("req");
//Cookie
Cookie cookiePerso = (Cookie)request.getAttribute("cookiePerso");

%>

<h3>Données du contexte 'application' :</h3>
<p><%=appData %></p>
<h3>Données du contexte 'session' :</h3>
<p><%=sessionData %></p>
<h3>Données du contexte 'requête' :</h3>
<p><%=requestData %></p>
<h3>Données du cookies :</h3>
<p><%=cookiePerso.getValue() %></p>
</body>
</html>