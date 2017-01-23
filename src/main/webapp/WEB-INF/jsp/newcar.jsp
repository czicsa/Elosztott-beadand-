<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Új autó felvétele</title>
</head>
<body>
    <h1>Új autó felvétele</h1>
    <form action="/insertcar" method="post">
        <label>Típus</label>
        <input type="text" placeholder="Típus" name="type"> <br />
        <label>Kerekek száma</label>
        <input type="number" placeholder="Kerekek száma" name="numberOfWheels"> <br />
        <input type="submit">
    </form>
</body>
</html>
