<%--
  Created by IntelliJ IDEA.
  User: MattiaM
  Date: 17/04/2021
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<html>

<head>
    <title>Pagina ricetta</title>
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

<div class="box-sezione" id="profilo-ricetta" style="overflow-x: hidden">

    <h4 style="text-align: center">di <a href="ServletGetUtente?email=${utente.email}">${utente.nome} ${utente.cognome}</a></h4>

    <h1 id="titolo-ricetta" style="border: none">${ricetta.nome}</h1>

    <img id="img-ricetta" src="${ricetta.foto}">

    <div class="show-rating">

        <c:if test="${ricetta.voto == 0}">
            <i class="fa fa-star" aria-hidden="true" id="0-rating-star-1" style="color: black"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="0-rating-star-2" style="color: black"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="0-rating-star-3" style="color: black"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="0-rating-star-4" style="color: black"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="0-rating-star-5" style="color: black"></i>
        </c:if>
        <c:if test="${ricetta.voto == 1}">
            <i class="fa fa-star" aria-hidden="true" id="1-rating-star-1" style="color: orange"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="1-rating-star-2" style="color: black"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="1-rating-star-3" style="color: black"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="1-rating-star-4" style="color: black"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="1-rating-star-5" style="color: black"></i>
        </c:if>
        <c:if test="${ricetta.voto == 2}">
            <i class="fa fa-star" aria-hidden="true" id="2-rating-star-1" style="color: orange"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="2-rating-star-2" style="color: orange"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="2-rating-star-3" style="color: black"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="2-rating-star-4" style="color: black"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="2-rating-star-5" style="color: black"></i>
        </c:if>
        <c:if test="${ricetta.voto == 3}">
            <i class="fa fa-star" aria-hidden="true" id="3-rating-star-1" style="color: orange"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="3-rating-star-2" style="color: orange"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="3-rating-star-3" style="color: orange"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="3-rating-star-4" style="color: black"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="3-rating-star-5" style="color: black"></i>
        </c:if>
        <c:if test="${ricetta.voto == 4}">
            <i class="fa fa-star" aria-hidden="true" id="4-rating-star-1" style="color: orange"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="4-rating-star-2" style="color: orange"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="4-rating-star-3" style="color: orange"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="4-rating-star-4" style="color: orange"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="4-rating-star-5" style="color: black"></i>
        </c:if>
        <c:if test="${ricetta.voto == 5}">
            <i class="fa fa-star" aria-hidden="true" id="5-rating-star-1" style="color: orange"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="5-rating-star-2" style="color: orange"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="5-rating-star-3" style="color: orange"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="5-rating-star-4" style="color: orange"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="5-rating-star-5" style="color: orange"></i>
        </c:if>

        <c:if test="${isLogged == true}">
            <c:if test="${isPreferred == false}">
            <a title="Aggiungi ai preferiti" id="add-preferiti" href="ServletAddPreferiti?idRicetta=${ricetta.ID}"><i class="fa fa-heart" aria-hidden="true"></i></a>
            </c:if>
            <c:if test="${isPreferred == true}">
                <a title="Rimuovi dai preferiti" id="remove-preferiti" href="ServletRemoveFavourite?idRicetta=${ricetta.ID}"><i class="fa fa-times" aria-hidden="true"></i></a>
            </c:if>
        </c:if>

    </div>

    <div class="info-ricetta">

        <b><i class="fa fa-clock-o" aria-hidden="true"></i> Tempo preparazione:</b> ${ricetta.tempoPrep}m<br>
        <b><i class="fa fa-fire" aria-hidden="true"></i> Tempo cottura:</b> ${ricetta.tempoCott}m<br>
        <b><i class="fa fa-cutlery" aria-hidden="true"></i> Dosi per:</b> ${ricetta.dosi}<br>

    </div>

</div>

<div class="box-sezione" id="preparazione-ricetta">

    <h3>INGREDIENTI</h3>

    <ul>
        <c:forEach items="${listaIngredienti}" var="ingrediente">
            <li>
                    ${ingrediente.ingrediente.nome}: ${ingrediente.quantita}g
            </li>
        </c:forEach>
    </ul>

    <h3><i class="fa fa-cutlery" aria-hidden="true"></i> PREPARAZIONE</h3>

    <p>${ricetta.proc}</p>
</div>

<div class="box-sezione" id="commenti-ricetta">

    <h3><i class="fa fa-comments" aria-hidden="true"></i> COMMENTI</h3>

    <c:forEach items="${listaCommenti}" var="commento">

        <c:if test="${loggedUtente.email == commento.utente.email}">
        <a href="ServletDeleteCommento?idCommento=${commento.ID}"><i class="fa fa-times" aria-hidden="true" style="color: red"></i></a>
        </c:if>
        <div class="box-commento">

            <a href="ServletGetUtente?email=${commento.utente.email}" id="profile">

                <div class="box-info-utente">

                    <img src="${commento.utente.foto}" width="40px" height="40px">

                    <h4>${commento.utente.nome} ${commento.utente.cognome}
                        <c:if test="${commento.utente.ruolo == 3 || commento.utente.ruolo == 2}">
                            <i class="fa fa-check-circle" aria-hidden="true" title="Utente verificato" style="color: blue; font-size: small"></i></c:if>&nbsp;&nbsp;&nbsp;<c:if test="${commento.voto == NULL}">&nbsp;</c:if>
                        <c:if test="${commento.voto == 0}">
                            <i class="fa fa-star" aria-hidden="true" id="0-rating-star-1" style="color: black"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="0-rating-star-2" style="color: black"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="0-rating-star-3" style="color: black"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="0-rating-star-4" style="color: black"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="0-rating-star-5" style="color: black"></i>
                        </c:if>
                        <c:if test="${commento.voto == 1}">
                            <i class="fa fa-star" aria-hidden="true" id="1-rating-star-1" style="color: #ffff66"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="1-rating-star-2" style="color: black"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="1-rating-star-3" style="color: black"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="1-rating-star-4" style="color: black"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="1-rating-star-5" style="color: black"></i>
                        </c:if>
                        <c:if test="${commento.voto == 2}">
                            <i class="fa fa-star" aria-hidden="true" id="2-rating-star-1" style="color: #ffff66"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="2-rating-star-2" style="color: #ffff66"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="2-rating-star-3" style="color: black"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="2-rating-star-4" style="color: black"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="2-rating-star-5" style="color: black"></i>
                        </c:if>
                        <c:if test="${commento.voto == 3}">
                            <i class="fa fa-star" aria-hidden="true" id="3-rating-star-1" style="color: #ffff66"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="3-rating-star-2" style="color: #ffff66"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="3-rating-star-3" style="color: #ffff66"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="3-rating-star-4" style="color: black"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="3-rating-star-5" style="color: black"></i>
                        </c:if>
                        <c:if test="${commento.voto == 4}">
                            <i class="fa fa-star" aria-hidden="true" id="4-rating-star-1" style="color: #ffff66"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="4-rating-star-2" style="color: #ffff66"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="4-rating-star-3" style="color: #ffff66"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="4-rating-star-4" style="color: #ffff66"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="4-rating-star-5" style="color: black"></i>
                        </c:if>
                        <c:if test="${commento.voto == 5}">
                            <i class="fa fa-star" aria-hidden="true" id="5-rating-star-1" style="color: #ffff66"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="5-rating-star-2" style="color: #ffff66"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="5-rating-star-3" style="color: #ffff66"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="5-rating-star-4" style="color: #ffff66"></i>&nbsp;<i class="fa fa-star" aria-hidden="true" id="5-rating-star-5" style="color: #ffff66"></i>
                        </c:if></h4>

                </div>

            </a>

            <p id="commento">${commento.testo}</p>

        </div>

    </c:forEach>

</div>

<div class="box-sezione" id="aggiungi-commento">

    <h3>DI' LA TUA</h3>

    <c:if test="${isLogged == true}">
    <form action="ServletAddCommento" id="form-commento" METHOD="post">

        <textarea name="textarea-commento" rows="5"></textarea>

        <input type="hidden" name="email" value="${loggedUtente.email}">

        <b>Esprimi votazione:</b>

        <div class="rating">

            <input type="radio" name="star" id="star_1" value="1"><label for="star_1" id="star1" onmouseover="starHover(1)" onmouseout="starOut()" onclick="starClick(1)"><i class="fa fa-star" aria-hidden="true"></i>
        </label>
            <input type="radio" name="star" id="star_2" value="2"><label for="star_2" id="star2" onmouseover="starHover(2)" onmouseout="starOut()" onclick="starClick(2)"><i class="fa fa-star" aria-hidden="true"></i>
        </label>
            <input type="radio" name="star" id="star_3" value="3"><label for="star_3" id="star3" onmouseover="starHover(3)" onmouseout="starOut()" onclick="starClick(3)"><i class="fa fa-star" aria-hidden="true"></i>
        </label>
            <input type="radio" name="star" id="star_4" value="4"><label for="star_4" id="star4" onmouseover="starHover(4)" onmouseout="starOut()" onclick="starClick(4)"><i class="fa fa-star" aria-hidden="true"></i>
        </label>
            <input type="radio" name="star" id="star_5" value="5"><label for="star_5" id="star5" onmouseover="starHover(5)" onmouseout="starOut()" onclick="starClick(5)"><i class="fa fa-star" aria-hidden="true"></i>
        </label>

        </div>

        <script>
            const star1 = document.getElementById("star1");
            const input1 = document.getElementById("star_1");
            const star2 = document.getElementById("star2");
            const input2 = document.getElementById("star_2");
            const star3 = document.getElementById("star3");
            const input3 = document.getElementById("star_3");
            const star4 = document.getElementById("star4");
            const input4 = document.getElementById("star_4");
            const star5 = document.getElementById("star5");
            const input5 = document.getElementById("star_5");

            function starHover(c) {

                if (c == 1) {
                    star1.style.color = "orange";
                }
                if (c == 2) {
                    star1.style.color = "orange";
                    star2.style.color = "orange";
                }
                if (c == 3) {
                    star1.style.color = "orange";
                    star2.style.color = "orange";
                    star3.style.color = "orange";
                }
                if (c == 4) {
                    star1.style.color = "orange";
                    star2.style.color = "orange";
                    star3.style.color = "orange";
                    star4.style.color = "orange";
                }
                if (c == 5) {
                    star1.style.color = "orange";
                    star2.style.color = "orange";
                    star3.style.color = "orange";
                    star4.style.color = "orange";
                    star5.style.color = "orange";
                }
            }

            function starOut() {

                if (input1.checked == true) {
                    star2.style.color = "black";
                    star3.style.color = "black";
                    star4.style.color = "black";
                    star5.style.color = "black";
                }
                if (input1.checked == false && input2.checked == false && input3.checked == false && input4.checked == false && input5.checked == false) {
                    star1.style.color = "black";
                }
                if (input2.checked == true) {
                    star1.style.color = "orange";
                    star3.style.color = "black";
                    star4.style.color = "black";
                    star5.style.color = "black";
                }
                if (input2.checked == false && input3.checked == false && input4.checked == false && input5.checked == false) {
                    star2.style.color = "black";
                }
                if (input3.checked == true) {
                    star1.style.color = "orange";
                    star2.style.color = "orange";
                    star4.style.color = "black";
                    star5.style.color = "black";
                }
                if (input3.checked == false && input4.checked == false && input5.checked == false) {
                    star3.style.color = "black";
                }
                if (input4.checked == true) {
                    star1.style.color = "orange";
                    star2.style.color = "orange";
                    star3.style.color = "orange";
                    star5.style.color = "black";
                }
                if (input4.checked == false && input5.checked == false) {
                    star4.style.color = "black";
                }
                if (input5.checked == true) {
                    star1.style.color = "orange";
                    star2.style.color = "orange";
                    star3.style.color = "orange";
                    star4.style.color = "orange";
                }
                if (input5.checked == false) {
                    star5.style.color = "black";
                }
            }

            function starClick(c) {

                if (c == 1) {
                    star1.style.color = "orange";
                }
                if (c == 2) {
                    star1.style.color = "orange";
                    star2.style.color = "orange";
                }
                if (c == 3) {
                    star1.style.color = "orange";
                    star2.style.color = "orange";
                    star3.style.color = "orange";
                }
                if (c == 4) {
                    star1.style.color = "orange";
                    star2.style.color = "orange";
                    star3.style.color = "orange";
                    star4.style.color = "orange";
                }
                if (c == 5) {
                    star1.style.color = "orange";
                    star2.style.color = "orange";
                    star3.style.color = "orange";
                    star4.style.color = "orange";
                    star5.style.color = "orange";
                }
            }
        </script>

        <input type="hidden" name="ricettaID" value="${ricetta.ID}">

        <input type="submit" name="submitCommento" value="Invia commento!">

    </form>
    </c:if>
    <c:if test="${isLogged == null}">
        <p style="color: red; font-weight: bold">Per poter commentare devi effettuare il login.</p>
    </c:if>


</div>

</body>

<%@include file="footer.jsp" %>

</html>