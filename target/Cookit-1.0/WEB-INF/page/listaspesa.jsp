<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>Lista della spesa</title>
</head>

<link href="./css/cookit.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@1,300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&display=swap" rel="stylesheet">

<style>
    /* listaspesa- media query 320px */

        body {
            margin-left: 0px;
            margin-top: 0px;
            margin-right: 0px;
        }

        .box-sezione {
            text-align: left;
            background-color: white;
            padding: 1px 0px 1px 15px;
            margin-top: 2%;
            overflow-x: auto;
        }

        .box-sezione>p {
            font-family: 'Raleway', 'Calibri';
            font-size: 14px;
            color: #333;
            line-height: 20px;
        }

        .box-sezione>h1 {
            font-family: 'Kaushan Script', cursive;
        }

        .box-sezione>h2 {
            font-family: 'Kaushan Script', cursive;
            font-size: 18px;
        }

        .box-sezione>h3

            /*TITOLO SEZIONE*/
        {
            font-family: 'Kaushan Script', cursive;
            color: #805765;
            font-size: 16px;
        }

        .box-sezione>h4 {
            font-family: 'Kaushan Script', cursive;
            color: #141414;
            font-size: 14px;
        }

        .box-sezione>ol {
            font-family: 'Raleway', 'Calibri';
            font-weight: bold;
            font-size: 12px;
        }

        .box-sezione>ul {
            font-family: 'Raleway', 'Calibri';
            font-weight: bold;
            font-size: 12px;
        }

    /* listaspesa- media query 481px */
    @media screen and (min-device-width: 481px) {


        body {
            margin-left: 0px;
            margin-top: 0px;
        }

        .box-sezione {
            text-align: left;
            background-color: white;
            padding: 1px 0px 1px 15px;
            margin-right: 10%;
            margin-top: 2%;
            overflow-x: auto;
        }

        .box-sezione>p {
            font-family: 'Raleway', 'Calibri';
            font-size: 14px;
            color: #333;
            line-height: 20px;
        }

        .box-sezione>h1 {
            font-family: 'Kaushan Script', cursive;
        }

        .box-sezione>h2 {
            font-family: 'Kaushan Script', cursive;
            font-size: 18px;
        }

        .box-sezione>h3

            /*TITOLO SEZIONE*/
        {
            font-family: 'Kaushan Script', cursive;
            color: #805765;
        }

        .box-sezione>h4 {
            font-family: 'Kaushan Script', cursive;
            color: #141414;
            font-size: 14px;
        }

        .box-sezione>ol {
            font-family: 'Raleway', 'Calibri';
            font-weight: bold;
            font-size: 12px;
        }

        .box-sezione>ul {
            font-family: 'Raleway', 'Calibri';
            font-weight: bold;
            font-size: 12px;
        }
    }
    /* listaspesa- media query 769px */
    @media screen and (min-device-width: 796px) {
        html {
            background-color: #f6f5f2;
        }

        body {
            margin-left: 0px;
            margin-top: 0px;
        }

        .box-sezione {
            text-align: left;
            background-color: white;
            padding: 1px 15px 1px 15px;
            margin-right: 30%;
            margin-top: 2%;
            overflow-x: auto;
        }

        .box-sezione #img-ricetta-lds {
            display: block;
            margin: 0px auto;
            height: 250px;
            width: 250px;
            box-shadow: 0px 0px 5px #909090;
            margin-bottom: 15px;
        }

        .box-sezione>p {
            font-family: 'Raleway', 'Calibri';
            font-size: 18px;
            color: #333;
            line-height: 20px;
        }

        .box-sezione>h1 {
            font-family: 'Kaushan Script', cursive;
            border-bottom-style: solid;
            border-color: orange;
        }

        .box-sezione h1 #titolo-lds {
            text-decoration: none;
            color: black;
            transition: 0.5s;
        }

        .box-sezione h1 #titolo-lds:hover {
            color: orange;
        }

        .box-sezione>h2 {
            font-family: 'Kaushan Script', cursive;
        }

        .box-sezione>h3

            /*TITOLO SEZIONE*/
        {
            font-family: 'Kaushan Script', cursive;
            color: #805765;
        }

        .box-sezione>h4 {
            font-family: 'Kaushan Script', cursive;
            color: #141414;
        }

        .box-sezione>ol {
            font-family: 'Raleway', 'Calibri';
            font-weight: bold;
        }

        #lista-ingredienti {
            font-family: 'Raleway', 'Calibri';
            font-weight: bold;
            list-style-type: none;
        }

        #lista-ingredienti li {
            text-align: center;
            line-height: 25px;
            margin-left: -40px;
        }

        .box-sezione input[type="submit"] {
            position: relative;
            display: block;
            background-color: orange;
            border-style: none;
            border-radius: 100px;
            font-family: 'Raleway', 'Calibri';
            font-weight: bold;
            padding: 3px 8px 3px 8px;
            margin: 0px auto;
            margin-top: 5px;
            cursor: pointer;
            top: -5px;
            transition: 0.5s;
        }

        #form-lds input[type="submit"]:hover {
            box-shadow: 0px 0px 5px black;
        }

        .slide-bar-profilo {
            position: relative;
            margin-top: 15px;
            background: rgb(201, 107, 70);
            background: linear-gradient(90deg, rgba(201, 107, 70, 1) 0%, rgba(147, 74, 136, 1) 67%);
            padding-bottom: 15px;
            padding-right: 10px;
            padding-left: 10px;
            border-radius: 150px;
            display: flex;
            box-shadow: 0px 0px 5px #909090;
            overflow-x: auto;
        }

        .slide-bar-profilo::-webkit-scrollbar {
            display: none;
        }

        .bookmarked-ricetta {
            position: relative;
            border-radius: 100px;
            background-image: url(https://www.maniboo.it/wp-content/uploads/2019/11/no-image.jpg);
            background-size: cover;
            background-repeat: no-repeat;
            display: block;
            margin-left: 5px;
            margin-right: 5px;
            margin-top: 15px;
            border-style: solid;
            border-width: 4px;
            border-color: orange;
            line-height: 95px;
            height: 85px;
            min-width: 85px;
            box-shadow: 0px 5px 10px rgb(30, 30, 30);
            transition: 0.25s;
        }

        .bookmarked-ricetta:hover {
            transform: scale(1.1);
            border-color: orange;
        }

        .bookmarked-ricetta:active {
            transform: scale(1.0);
        }

        .slidebar-buttons {
            display: block;
            text-align: center;
            position: relative;
            margin-top: 5px;
        }

        #slide-right {
            font-size: 40px;
            color: orange;
            border-style: none;
            border-radius: 100px;
            background: transparent;
            padding-bottom: 5px;
            text-shadow: 0px 0px 5px #909090;
            cursor: pointer;
            transition: 0.5s;
        }

        #slide-right:hover {
            color: orange;
            transition: 0.1s;
        }

        #slide-right:active {
            text-shadow: 0px 0px 0px black;
            color: orange;
        }

        #slide-left {
            font-size: 40px;
            color: orange;
            border-style: none;
            border-radius: 100px;
            background: transparent;
            padding-bottom: 5px;
            text-shadow: 0px 0px 5px #909090;
            cursor: pointer;
            transition: 0.5s;
        }

        #slide-left:hover {
            color: orange;
            transition: 0.1s;
        }

        #slide-left:active {
            text-shadow: 0px 0px 0px black;
            color: orange;
        }
    }
</style>

<%@include file="header.jsp" %>

<body>

    <div class="box-sezione" id="slider-profilo">

        <c:if test="${carrelloIngredienti.size() != 0}">
            <c:if test="${carrelloIngredienti.size() == 1}">
                <p style="text-align: center; font-weight: bold"><a href="ServletShowCart" style="text-decoration: none; color: #333"><i class="fa fa-shopping-cart" aria-hidden="true"></i> <span style="color: red">1</span> elemento nel carrello</a></p>
            </c:if>
            <c:if test="${carrelloIngredienti.size() >= 2}">
                <p style="text-align: center; font-weight: bold"><a href="ServletShowCart" style="text-decoration: none; color: #333"><i class="fa fa-shopping-cart" aria-hidden="true"></i> <span style="color: red">${carrelloIngredienti.size()}</span> elementi nel carrello</a></p>
            </c:if>
        </c:if>
        
        <h3 style="text-align: center; border-bottom-style: none;">SELEZIONA RICETTA</h3>

        <c:if test="${loggedUtente.listaPreferite.size() < 1}">
            <p>Non sono presenti ricette nella lista delle ricette preferite.</p>
        </c:if>

        <c:if test="${loggedUtente.listaPreferite.size() >= 1}">

            <div class="slide-bar-profilo" id="container">
                <c:forEach items="${loggedUtente.listaPreferite}" var="preferita">
                    <a title="${preferita.ricetta.nome}" class="bookmarked-ricetta" href="ServletClickedListaSpesa?idRicetta=${preferita.ricetta.ID}"><img src="${preferita.ricetta.foto}" width="85px"></a>
                </c:forEach>
            </div>

        </c:if>

        <div class="slidebar-buttons">
            <button id="slide-left" type="button"><i class="fa fa-arrow-left" aria-hidden="true"></i></button>
            <button id="slide-right" type="button"><i class="fa fa-arrow-right" aria-hidden="true"></i></button>
        </div>

    </div>

    <script>

        const buttonRight = document.getElementById('slide-right');
        const buttonLeft = document.getElementById('slide-left');

        buttonRight.onclick = function () {
            document.getElementById('container').scrollLeft += 100;
        };

        buttonLeft.onclick = function () {
            document.getElementById('container').scrollLeft -= 100;
        };

    </script>

<div class="box-sezione" id="main-box" style="overflow-x: hidden">
    <h1 style="text-align: center;"><a href="ServletShowRicetta?idRicetta=${ricetta.ID}" id="titolo-lds">${ricetta.nome}</a></h1>

    <img id="img-ricetta-lds" src="${ricetta.foto}">


    <p style="text-align: center; font-weight: bold">Seleziona gli ingredienti da aggiungere al carrello</p>

    <form id="ServletCart" action="ServletCart" method="post">

        <ul id="lista-ingredienti">

            <c:forEach items = "${listaIngredienti}" var="ingrediente">
                <li><input type="checkbox" name="${ingrediente.ingrediente.nome}" value="${ingrediente.quantita}"><b>${ingrediente.ingrediente.nome}:</b><i> ${ingrediente.quantita}</i> g</li>
            </c:forEach>

        </ul>

        <input type="submit" value="Aggiungi al carrello">

    </form>

</div>

</body>

<%@include file="footer.jsp" %>

</html>