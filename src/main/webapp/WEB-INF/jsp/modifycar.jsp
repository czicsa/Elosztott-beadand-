<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Autó módosítása</title>
</head>
<body>
<h1>Autó módosítása</h1>
<form action="/modifycar" method="post">
    <label>Típus</label>
    <input type="text" placeholder="Típus" name="type" value="${car.type}"> <br />
    <label>Kerekek száma</label>
    <input type="number" placeholder="Kerekek száma" name="numberOfWheels" value="${car.numberOfWheels}"> <br />
    <input type="submit">
</form>
</body>
</html>
