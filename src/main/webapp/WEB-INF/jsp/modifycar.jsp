<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Autó módosítása</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<h1>Autó módosítása</h1>
<form:form action="/modifycar" method="post" modelAttribute="car">
    <spring:bind path="type">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:label path="type">Típus</form:label>
            <form:input id="type" type="text" placeholder="Típus" path="type" class="form-control"/> <br />
        </div>
    </spring:bind>
    <spring:bind path="type">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:label path="numberOfWheels">Kerekek száma</form:label>
            <form:input type="number" placeholder="Kerekek száma" path="numberOfWheels" class="form-control"/>
        </div>
    </spring:bind>
    <div class="checkbox">
        <form:label path="new"><form:checkbox path="new"/>Új</form:label>
    </div>
    <spring:bind path="vehicleType">
        <div class="radio ${status.error ? 'has-error' : ''}">
            <form:label path="vehicleType"><form:radiobutton path="vehicleType" value="car"/>Autó</form:label>
        </div>
        <div class="radio ${status.error ? 'has-error' : ''}">
            <form:label path="vehicleType"><form:radiobutton path="vehicleType" value="truck"/>Kamion</form:label>
        </div>
    </spring:bind>
    <input type="submit">
</form:form>
</body>
</html>
