<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Riepilogo Ordine</title>
</head>

<link href="./css/cookit.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@1,300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&display=swap" rel="stylesheet">

<%@include file="header.jsp" %>

<style>
    <%@ include file="/css/cookit.css"%>
</style>

<body>

<div class="box-sezione" id="box-riepilogoOrdine">
    <h1 style="text-align: center; border-bottom: solid 2px orange; padding-bottom: 5px; margin-bottom: 60px">Riepilogo Carrello</h1>

<c:forEach items="${carrelloIngredienti}" var="nameValue">

    <p style="font-weight: bolder">${nameValue.ingrediente.nome}</p>
    <p style="font-weight: bold" id="quantita">x ${nameValue.quantita}</p>

</c:forEach>

    <h1 style="text-align: center; border-bottom: solid 2px orange; padding-bottom: 5px; margin-bottom: 60px">Spedito a</h1>

    <div class="info-spedizione">

    <p>${loggedUtente.nome} ${loggedUtente.cognome}</p>
        <p>${via}</p>
        <p>${citta}, ${cap}, ${provincia}</p>
        <p>${stato}</p>
    <p>${loggedUtente.email}</p>

    </div>

    <a href="ServletGenerateOrder" style="text-decoration: none"><button>Paga e concludi acquisto!</button></a>

</div>

</body>

<%@include file="footer.jsp" %>

</html>
