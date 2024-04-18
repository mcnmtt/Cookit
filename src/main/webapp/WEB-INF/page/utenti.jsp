<%--
  Created by IntelliJ IDEA.
  User: Mattia
  Date: 25/10/2021
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>Utenti</title>
</head>

<link href="./css/cookit.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@1,300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&display=swap" rel="stylesheet">

<%@include file="header.jsp" %>

<body>

<div class="box-sezione" id="mainframe-homepage" style="overflow-x: hidden">

    <h1 style="text-align: center; text-shadow: 0px 5px 5px #909090; border: none">PAGINA UTENTI</h1>

    <div class="slidebar-buttons">
        <button id="hp-most-rated-slide-left" type="button"><i class="fa fa-arrow-left" aria-hidden="true"></i></button>
        <button id="hp-most-rated-slide-right" type="button"><i class="fa fa-arrow-right" aria-hidden="true"></i></button>
    </div>

    <div class="slider-homepage" id="hp-container-most-rated">

        <c:forEach items="${ricettaUtenti}" var="ricetta">
            <div class="box-ricette">

                <a href="ServletShowRicetta?idRicetta=${ricetta.ID}" class="ricetta">
                    <img id="img-card-ricetta" src="${ricetta.foto}">
                    <div class="box-info-ricetta">
                        <div class="nome-ricetta">${ricetta.nome} <c:if test="${ricetta.utente.ruolo == 3 || ricetta.utente.ruolo == 2}">
                            <i class="fa fa-check-circle" aria-hidden="true" title="Ricetta utente verificato" style="color: blue; font-size: medium"></i></c:if></div>
                    </div>
                    <c:if test="${ricetta.voto == 0}">
                        <div class="rating-ricetta"><i class="fa fa-star" aria-hidden="true" id="0-rating-star-1" style="color: black"></i><i class="fa fa-star" aria-hidden="true" id="0-rating-star-2" style="color: black"></i><i class="fa fa-star" aria-hidden="true" id="0-rating-star-3" style="color: black"></i><i class="fa fa-star" aria-hidden="true" id="0-rating-star-4" style="color: black"></i><i class="fa fa-star" aria-hidden="true" id="0-rating-star-5" style="color: black"></i></div>
                    </c:if>
                    <c:if test="${ricetta.voto == 1}">
                        <div class="rating-ricetta"><i class="fa fa-star" aria-hidden="true" id="1-rating-star-1" style="color: orange"></i><i class="fa fa-star" aria-hidden="true" id="1-rating-star-2" style="color: black"></i><i class="fa fa-star" aria-hidden="true" id="1-rating-star-3" style="color: black"></i><i class="fa fa-star" aria-hidden="true" id="1-rating-star-4" style="color: black"></i><i class="fa fa-star" aria-hidden="true" id="1-rating-star-5" style="color: black"></i></div>
                    </c:if>
                    <c:if test="${ricetta.voto == 2}">
                        <div class="rating-ricetta"><i class="fa fa-star" aria-hidden="true" id="2-rating-star-1" style="color: orange"></i><i class="fa fa-star" aria-hidden="true" id="2-rating-star-2" style="color: orange"></i><i class="fa fa-star" aria-hidden="true" id="2-rating-star-3" style="color: black"></i><i class="fa fa-star" aria-hidden="true" id="2-rating-star-4" style="color: black"></i><i class="fa fa-star" aria-hidden="true" id="2-rating-star-5" style="color: black"></i></div>
                    </c:if>
                    <c:if test="${ricetta.voto == 3}">
                        <div class="rating-ricetta"><i class="fa fa-star" aria-hidden="true" id="3-rating-star-1" style="color: orange"></i><i class="fa fa-star" aria-hidden="true" id="3-rating-star-2" style="color: orange"></i><i class="fa fa-star" aria-hidden="true" id="3-rating-star-3" style="color: orange"></i><i class="fa fa-star" aria-hidden="true" id="3-rating-star-4" style="color: black"></i><i class="fa fa-star" aria-hidden="true" id="3-rating-star-5" style="color: black"></i></div>
                    </c:if>
                    <c:if test="${ricetta.voto == 4}">
                        <div class="rating-ricetta"><i class="fa fa-star" aria-hidden="true" id="4-rating-star-1" style="color: orange"></i><i class="fa fa-star" aria-hidden="true" id="4-rating-star-2" style="color: orange"></i><i class="fa fa-star" aria-hidden="true" id="4-rating-star-3" style="color: orange"></i><i class="fa fa-star" aria-hidden="true" id="4-rating-star-4" style="color: orange"></i><i class="fa fa-star" aria-hidden="true" id="4-rating-star-5" style="color: black"></i></div>
                    </c:if>
                    <c:if test="${ricetta.voto == 5}">
                        <div class="rating-ricetta"><i class="fa fa-star" aria-hidden="true" id="5-rating-star-1" style="color: orange"></i><i class="fa fa-star" aria-hidden="true" id="5-rating-star-2" style="color: orange"></i><i class="fa fa-star" aria-hidden="true" id="5-rating-star-3" style="color: orange"></i><i class="fa fa-star" aria-hidden="true" id="5-rating-star-4" style="color: orange"></i><i class="fa fa-star" aria-hidden="true" id="5-rating-star-5" style="color: orange"></i></div>
                    </c:if>
                </a>

            </div>
        </c:forEach>

    </div>

</div>

<script>
    const HPmr1ButtonRight = document.getElementById('hp-most-rated-slide-right');
    const HPmr1ButtonLeft = document.getElementById('hp-most-rated-slide-left');

    const HPmr2ButtonRight = document.getElementById('hp-most-recent-slide-right');
    const HPmr2ButtonLeft = document.getElementById('hp-most-recent-slide-left');

    HPmr1ButtonRight.onclick = function() {
        document.getElementById('hp-container-most-rated').scrollLeft += 500;
    };

    HPmr1ButtonLeft.onclick = function() {
        document.getElementById('hp-container-most-rated').scrollLeft -= 500;
    };

    HPmr2ButtonRight.onclick = function() {
        document.getElementById('hp-container-most-recent').scrollLeft += 500;
    };

    HPmr2ButtonLeft.onclick = function() {
        document.getElementById('hp-container-most-recent').scrollLeft -= 500;
    };
</script>

</body>

<%@include file="footer.jsp" %>

</html>
