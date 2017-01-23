<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Új autó felvétele</title>
</head>
<body>
    <h1>Új autó felvétele</h1>
    <form:form method="POST" modelAttribute="car" action="/insertcar">
        <form:label path="type">Típus</form:label>
        <form:input type="text" placeholder="Típus" path="type"/> <br />
        <form:label path="numberOfWheels">Kerekek száma</form:label>
        <form:input type="number" placeholder="Kerekek száma" path="numberOfWheels"/> <br />
        <form:label path="new">Új</form:label>
        <form:checkbox path="new"/> <br />
        <form:radiobutton path="vehicleType" value="car"/>Autó
        <form:radiobutton path="vehicleType" value="truck"/>Kamion
        <input type="submit">
    </form:form>
</body>
</html>
