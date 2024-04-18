<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: KSB
  Date: 25/10/2021
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>

    <link href="./css/cookit.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@1,300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&display=swap" rel="stylesheet">

    <title>Pannello Ricette</title>

</head>

<%@include file="header.jsp" %>

<style>
    <%@ include file="/css/cookit.css"%>
</style>

<body>

<div class="box-sezione" id="box-rimuovi-ricetta">

    <h1 style="text-align: center; text-shadow: 0px 5px 5px #909090;">Rimuovi Ricette</h1>

    <div class="custom-select" style="width:200px;">

    <p>Ricette utenti</p>

        <form action="ServletAdminDeleteRicetta" method="post">

        <select name="ricettaUtenti" id="ricettaUtente">
            <option hidden disabled selected value>Selezionare una ricetta</option>
            <c:forEach items="${listaRicetteUtenti}" var="listaRicettaUtenti">
                <option value="${listaRicettaUtenti.nome}">${listaRicettaUtenti.nome}</option>
            </c:forEach>
        </select>

            <input type="submit" value="Rimuovi">

        </form>

        <p>Ricette creators</p>

        <form action="ServletAdminDeleteRicettaCreator" method="post">

        <select name="ricettaCreators" id="ricettaCreators">
            <option hidden disabled selected value>Selezionare una ricetta</option>
            <c:forEach items="${listaRicetteCreators}" var="listaRicettaCreators">
                <option value="${listaRicettaCreators.nome}">${listaRicettaCreators.nome}</option>
            </c:forEach>
        </select>

            <input type="submit" value="Rimuovi">

        </form>

        <p>Ricette admin</p>

        <form action="ServletAdminDeleteRicettaAdmin" method="post">

        <select name="ricettaAdmin" id="ricettaAdmin">
            <option hidden disabled selected value>Selezionare una ricetta</option>
            <c:forEach items="${listaRicetteAdmin}" var="listaRicettaAdmin">
                <option value="${listaRicettaAdmin.nome}">${listaRicettaAdmin.nome}</option>
            </c:forEach>
        </select>

            <input type="submit" value="Rimuovi">

        </form>

    </div>

    <form action="ServletToAdminPanel" method="post">
        <input style="width: 150px; display: block; margin: 0px auto" type="submit" value="Torna indietro!">
    </form>

</div>
</body>

<%@include file="footer.jsp" %>

</html>
