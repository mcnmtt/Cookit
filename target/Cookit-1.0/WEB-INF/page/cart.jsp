<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aphzm
  Date: 08/11/2021
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Carrello</title>
</head>

<link href="./css/cookit.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@1,300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&display=swap" rel="stylesheet">

<style>
    <%@ include file="/css/cookit.css"%>
</style>

<%@include file="header.jsp" %>

<body>

<div class="box-sezione" id="box-carrello" style="overflow-x: hidden">
<h1 style="text-align: center; border-bottom: solid 2px orange; padding-bottom: 5px; margin-bottom: 60px">Riepilogo Carrello</h1>

<c:forEach items="${carrelloIngredienti}" var="nameValue">

    <div class="ingrediente-carrello" id="1${nameValue.ingrediente.nome}"><p style="font-weight: bolder">${nameValue.ingrediente.nome}</p></div>
    <div class="quantita-carrello" id="2${nameValue.ingrediente.nome}"><p style="font-weight: bold">x ${nameValue.quantita}</p></div>
    <i class="fa fa-times" id="${nameValue.ingrediente.nome}" aria-hidden="true" onclick="eliminaIngrediente(this.id)"></i>

</c:forEach>


    <h1 style="text-align: center; border-bottom: solid 2px orange; padding-bottom: 5px; margin-bottom: 60px; margin-top: 50px">Informazioni Spedizione</h1>

    <form method="get" action="ServletShowRiepilogo">
    <input type="text" name="stato" placeholder="Inserisci stato">
    <input type="text" name="via" placeholder="Inserisci indirizzo">
    <input type="number" name="cap" placeholder="Inserisci CAP">
    <input type="text" name="citta" placeholder="Inserisci città">
    <input type="text" name="provincia" placeholder="Inserisci provincia">

    <a href="ServletListaSpesa" style="text-decoration: none"><button type="button">Torna indietro!</button></a>
    <input type="submit" value="Completa acquisto!">
    </form>

</div>

<script>

    function eliminaIngrediente(str){

        var xmlhttp = new XMLHttpRequest();

        xmlhttp.onreadystatechange=function() {
            if (this.readyState==4 && this.status==200) {

                document.getElementById("1"+str).style.display = "none";
                document.getElementById("2"+str).style.display = "none";
                document.getElementById(str).style.display = "none";
            }
        }

        xmlhttp.open("POST","ServletRemoveIngrediente?nomeIngrediente="+str,true);
        xmlhttp.send();
    }
</script>

</body>

<%@include file="footer.jsp" %>

</html>
