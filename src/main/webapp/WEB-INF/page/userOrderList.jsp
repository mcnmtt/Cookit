<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mattia
  Date: 03/09/2021
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <title>Registro ordini</title>

    <link href="./css/cookit.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@1,300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&display=swap" rel="stylesheet">

</head>

<style>
    <%@ include file="/css/cookit.css"%>
</style>

<%@include file="header.jsp" %>

<body>

<div class="box-sezione" id="box-storico-ordini">

    <h2 style="border-bottom: solid orange; padding-bottom: 10px;">Riepilogo Ordini</h2>

    <c:forEach items="${listaOrdini}" var="ordine">
    <div class="box-singolo-ordine">
        <p><b><i class="fa fa-eercast" aria-hidden="true"></i> Ordine #0000${ordine.id}</b></p>
        <p><b>spedito a:</b> ${loggedUtente.nome} ${loggedUtente.cognome} <b>presso</b> ${ordine.spedizione}</p>
        <p><b>Contenuto:</b> ${ordine.composta.ingrediente.nome}  (${ordine.composta.quantita})</p>
    </div>
    </c:forEach>
    <c:if test="${listaOrdini.size() == 0}">
        <div class="box-singolo-ordine">
            <p>Non sono stati effettuati ordini.</p>
        </div>
    </c:if>

    <form action="ServletGetUtente" method="get">
        <input type="hidden" name="email" value="${loggedUtente.email}">
        <input type="submit" value="Torna al profilo!">
    </form>

</div>

</body>

<%@include file="footer.jsp" %>

</html>
