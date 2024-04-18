<%--
  Created by IntelliJ IDEA.
  User: KSB
  Date: 25/10/2021
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Pannello utenti</title>

</head>

<link href="./css/cookit.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@1,300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&display=swap" rel="stylesheet">

<%@include file="header.jsp" %>

<body>

<style>
    <%@ include file="/css/cookit.css"%>
</style>

<div class="box-sezione" id="box-banna">

    <h1 style="text-align: center; text-shadow: 0px 5px 5px #909090;">Banna/Sbanna un utente/creator</h1>

    <form action="ServletAdminDeleteUtente" method="post">

        <select name="utenti" id="utente">
            <option hidden disabled selected value name>Seleziona un utente</option>
            <c:forEach items="${listaUtenti}" var="listaUtenti">
                <option name="utente" value="${listaUtenti.email}">${listaUtenti.email}</option>
            </c:forEach>
        </select>

        <input type="submit" value="Ban">

    </form>

    <form action="ServletAdminDeleteCreators" method="post">

        <select name="creators" id="creators">
            <option hidden disabled selected value >Seleziona un creator</option>
            <c:forEach items="${listaUtentiCreators}" var="listaUtentiCreators">
                <option value="${listaUtentiCreators.email}" >${listaUtentiCreators.email}</option>
            </c:forEach>
        </select>

        <input type="submit" name="banCreator" value="Ban">

    </form>

    <form action="ServletAdminSbanUtente" method="post">

        <select name="utentiBan" id="utenteBan">
            <option hidden disabled selected value name>Seleziona un utente</option>
            <c:forEach items="${listaUtentiBannati}" var="listaUtentiBannati">
                <option name="utente" value="${listaUtentiBannati.email}">${listaUtentiBannati.email}</option>
            </c:forEach>
        </select>

        <input type="submit" value="Sbanna">

    </form>

    <form action="ServletAdminSbannaCreators" method="post">

        <select name="creatorsBan" id="creatorsBan">
            <option hidden disabled selected value name>Seleziona un creator</option>
            <c:forEach items="${listaUtentiCreatorsBannati}" var="listaUtentiCreatorsBannati">
                <option name="utente" value="${listaUtentiCreatorsBannati.email}">${listaUtentiCreatorsBannati.email}</option>
            </c:forEach>
        </select>

        <input type="submit" value="Sbanna">

    </form>

    <form action="ServletToAdminPanel" method="post">
        <input style="width: 150px; display: block; margin: 0px auto" type="submit" value="Torna indietro!">
    </form>

</div>

<div class="box-sezione" id="box-promuovi-declassa">

    <h1 style="text-align: center; text-shadow: 0px 5px 5px #909090;">Promuovi o declassa</h1>

    <form action="ServletAdminPromuoviUtente" method="post">

        <select name="utentiToPromote" id="utenteToPromote">

            <option hidden disabled selected value name>Selezionare un utente</option>
            <c:forEach items="${listaUtenti}" var="listaUtenti">
                <option value="${listaUtenti.email}" >${listaUtenti.email}</option>
            </c:forEach>

        </select>

        <input type="submit" value="Promuovi a creator">

    </form>


    <form action="ServletAdminDeclassaCreators" method="post">

        <select name="utentiToDemote" id="utenteToDemote">

            <option hidden disabled selected value name>Selezionare un creator</option>
            <c:forEach items="${listaUtentiCreators}" var="listaUtentiCreators">
                <option value="${listaUtentiCreators.email}">${listaUtentiCreators.email}</option>
            </c:forEach>
        </select>

        <input type="submit" value="Declassa ad utente">

    </form>

    <form action="ServletToAdminPanel" method="post">
        <input style="width: 150px; display: block; margin: 0px auto" type="submit" value="Torna indietro!">
    </form>

</div>

</body>

<%@include file="footer.jsp" %>

</html>
