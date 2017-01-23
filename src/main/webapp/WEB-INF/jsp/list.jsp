
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<html>
<head>
	<title>Autók</title>
</head>
<body>
<h1>Autók</h1>
<a href="newcar">Új autó felvétele</a>
<div>
	<ul>
		<c:forEach items="${cars}" var="car">
			<li>${car.type} - ${car.numberOfWheels} db kerék - <a href="modifycar?carid=${car.id}">Szerkesztés</a></li>
		</c:forEach>
	</ul>
</div>
</body>
</html>
