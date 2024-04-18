<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>Aggiungi nuova ricetta</title>

</head>

<link href="./css/cookit.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@1,300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&display=swap" rel="stylesheet">

<style>
    /* nuovaRicetta- media query 320px */
    @media screen and (min-device-width: 320px){
    .box-sezione {
        text-align: center;
    }

    #sezione-photo {
        height: 180px;
        width: 180px;
        border: solid black 2px;
        -webkit-box-shadow: 5px 5px 0px 0px orange, 10px 10px 0px 0px rgb(255, 196, 86), 15px 15px 0px 0px rgb(255, 234, 196);
        box-shadow: 5px 5px 0px 0px orange, 10px 10px 0px 0px rgb(255, 196, 86), 15px 15px 0px 0px rgb(255, 234, 196);
        display: block;
        margin: 0px auto;
        margin-bottom: 15px;
    }

    #photo-ins {
        background-image: url('https://previews.123rf.com/images/latkun/latkun1712/latkun171200130/92172856-empty-transparent-background-seamless-pattern.jpg');
    }


    input[type=text] {
        outline: none;
        height: 40px;
        width: 350px;
        padding: 5px 5px 5px 5px;
        outline: none;
        border: solid black 2px;
        -webkit-box-shadow: 5px 5px 0px 0px orange, 10px 10px 0px 0px rgb(255, 196, 86), 15px 15px 0px 0px rgb(255, 234, 196);
        box-shadow: 5px 5px 0px 0px orange, 10px 10px 0px 0px rgb(255, 196, 86), 15px 15px 0px 0px rgb(255, 234, 196);

    }

    input[type=number] {
        outline: none;
        height: auto;
        width: 100px;
        padding: 5px 5px 5px 5px;
        outline: none;
        border: solid black 2px;
        -webkit-box-shadow: 5px 5px 0px 0px orange, 10px 10px 0px 0px rgb(255, 196, 86), 15px 15px 0px 0px rgb(255, 234, 196);
        box-shadow: 5px 5px 0px 0px orange, 10px 10px 0px 0px rgb(255, 196, 86), 15px 15px 0px 0px rgb(255, 234, 196);

    }

    input:focus {
        outline: none;
    }

    textarea {
        resize: none;
    }

    #txtProcedimento {
        padding: 5px 5px 5px 5px;
        outline: none;
        border: solid black 2px;
        -webkit-box-shadow: 5px 5px 0px 0px orange, 10px 10px 0px 0px rgb(255, 196, 86), 15px 15px 0px 0px rgb(255, 234, 196);
        box-shadow: 5px 5px 0px 0px orange, 10px 10px 0px 0px rgb(255, 196, 86), 15px 15px 0px 0px rgb(255, 234, 196);
    }

    #bottone-crea-nuova-ricetta {
        display: block;
        margin: 0px auto;
        margin-top: 25px;
        margin-bottom: 15px;
        background-color: orange;
        border-style: none;
        border-radius: 100px;
        font-family: 'Raleway', 'Calibri';
        font-weight: bold;
        font-size: 20px;
        padding: 3px 8px 3px 8px;
        cursor: pointer;
        width: 250px;
        height: 70px;
        box-shadow: 0px 0px 5px rgb(150, 150, 150);
        border-radius: 40px;
        transition: 0.1s;
    }

    #bottone-crea-nuova-ricetta:active {
        transform: scale(0.9);
    }


    /*the container must be positioned relative:*/
    .custom-select {
        position: relative;
        text-align: center;
        font-family: 'Raleway', 'Calibri';
        font-weight: bold;
        display: block;
        margin: 0px auto;
    }

    .custom-select select {
        display: none; /*hide original SELECT element:*/
    }

    .select-selected {
        background-color: orange;
    }

    /*style the arrow inside the select element:*/
    .select-selected:after {
        position: absolute;
        content: "";
        top: 14px;
        right: 10px;
        width: 0;
        height: 0;
        border: 6px solid transparent;
        border-color: #fff transparent transparent transparent;
    }

    /*point the arrow upwards when the select box is open (active):*/
    .select-selected.select-arrow-active:after {
        border-color: transparent transparent #fff transparent;
        top: 7px;
    }

    /*style the items (options), including the selected item:*/
    .select-items div, .select-selected {
        color: #ffffff;
        padding: 8px 16px;
        border: 1px solid transparent;
        border-color: transparent transparent rgba(0, 0, 0, 0.1) transparent;
        cursor: pointer;
        user-select: none;
    }

    /*style items (options):*/
    .select-items {
        position: absolute;
        background-color: orange;
        top: 100%;
        left: 0;
        right: 0;
        z-index: 99;
    }

    /*hide the items when the select box is closed:*/
    .select-hide {
        display: none;
    }

    .select-items div:hover, .same-as-selected {
        background-color: rgba(0, 0, 0, 0.1);
    }
    }
    /* nuovaRicetta- media query 481px */
    @media screen and (min-device-width: 481px){
        .box-sezione {
            text-align: center;
        }

        #sezione-photo {
            height: 180px;
            width: 180px;
            border: solid black 2px;
            -webkit-box-shadow: 5px 5px 0px 0px orange, 10px 10px 0px 0px rgb(255, 196, 86), 15px 15px 0px 0px rgb(255, 234, 196);
            box-shadow: 5px 5px 0px 0px orange, 10px 10px 0px 0px rgb(255, 196, 86), 15px 15px 0px 0px rgb(255, 234, 196);
            display: block;
            margin: 0px auto;
            margin-bottom: 15px;
        }

        #photo-ins {
            background-image: url('https://previews.123rf.com/images/latkun/latkun1712/latkun171200130/92172856-empty-transparent-background-seamless-pattern.jpg');
        }


        input[type=text] {
            outline: none;
            height: 40px;
            width: 350px;
            padding: 5px 5px 5px 5px;
            outline: none;
            border: solid black 2px;
            -webkit-box-shadow: 5px 5px 0px 0px orange, 10px 10px 0px 0px rgb(255, 196, 86), 15px 15px 0px 0px rgb(255, 234, 196);
            box-shadow: 5px 5px 0px 0px orange, 10px 10px 0px 0px rgb(255, 196, 86), 15px 15px 0px 0px rgb(255, 234, 196);

        }

        input[type=number] {
            outline: none;
            height: auto;
            width: 100px;
            padding: 5px 5px 5px 5px;
            outline: none;
            border: solid black 2px;
            -webkit-box-shadow: 5px 5px 0px 0px orange, 10px 10px 0px 0px rgb(255, 196, 86), 15px 15px 0px 0px rgb(255, 234, 196);
            box-shadow: 5px 5px 0px 0px orange, 10px 10px 0px 0px rgb(255, 196, 86), 15px 15px 0px 0px rgb(255, 234, 196);

        }

        input:focus {
            outline: none;
        }

        textarea {
            resize: none;
        }

        #txtProcedimento {
            padding: 5px 5px 5px 5px;
            outline: none;
            border: solid black 2px;
            -webkit-box-shadow: 5px 5px 0px 0px orange, 10px 10px 0px 0px rgb(255, 196, 86), 15px 15px 0px 0px rgb(255, 234, 196);
            box-shadow: 5px 5px 0px 0px orange, 10px 10px 0px 0px rgb(255, 196, 86), 15px 15px 0px 0px rgb(255, 234, 196);
        }

        #bottone-crea-nuova-ricetta {
            display: block;
            margin: 0px auto;
            margin-top: 25px;
            margin-bottom: 15px;
            background-color: orange;
            border-style: none;
            border-radius: 100px;
            font-family: 'Raleway', 'Calibri';
            font-weight: bold;
            font-size: 20px;
            padding: 3px 8px 3px 8px;
            cursor: pointer;
            width: 250px;
            height: 70px;
            box-shadow: 0px 0px 5px rgb(150, 150, 150);
            border-radius: 40px;
            transition: 0.1s;
        }

        #bottone-crea-nuova-ricetta:active {
            transform: scale(0.9);
        }


        /*the container must be positioned relative:*/
        .custom-select {
            position: relative;
            text-align: center;
            font-family: 'Raleway', 'Calibri';
            font-weight: bold;
            display: block;
            margin: 0px auto;
        }

        .custom-select select {
            display: none; /*hide original SELECT element:*/
        }

        .select-selected {
            background-color: orange;
        }

        /*style the arrow inside the select element:*/
        .select-selected:after {
            position: absolute;
            content: "";
            top: 14px;
            right: 10px;
            width: 0;
            height: 0;
            border: 6px solid transparent;
            border-color: #fff transparent transparent transparent;
        }

        /*point the arrow upwards when the select box is open (active):*/
        .select-selected.select-arrow-active:after {
            border-color: transparent transparent #fff transparent;
            top: 7px;
        }

        /*style the items (options), including the selected item:*/
        .select-items div, .select-selected {
            color: #ffffff;
            padding: 8px 16px;
            border: 1px solid transparent;
            border-color: transparent transparent rgba(0, 0, 0, 0.1) transparent;
            cursor: pointer;
            user-select: none;
        }

        /*style items (options):*/
        .select-items {
            position: absolute;
            background-color: orange;
            top: 100%;
            left: 0;
            right: 0;
            z-index: 99;
        }

        /*hide the items when the select box is closed:*/
        .select-hide {
            display: none;
        }

        .select-items div:hover, .same-as-selected {
            background-color: rgba(0, 0, 0, 0.1);
        }
    }
    /* nuovaRicetta- media query 769px */
    @media screen and (min-device-width: 769px){
        .box-sezione {
            text-align: center;
        }

        #sezione-photo {
            height: 180px;
            width: 180px;
            border: solid black 2px;
            -webkit-box-shadow: 5px 5px 0px 0px orange, 10px 10px 0px 0px rgb(255, 196, 86), 15px 15px 0px 0px rgb(255, 234, 196);
            box-shadow: 5px 5px 0px 0px orange, 10px 10px 0px 0px rgb(255, 196, 86), 15px 15px 0px 0px rgb(255, 234, 196);
            display: block;
            margin: 0px auto;
            margin-bottom: 15px;
        }

        #photo-ins {
            background-image: url('https://previews.123rf.com/images/latkun/latkun1712/latkun171200130/92172856-empty-transparent-background-seamless-pattern.jpg');
        }


        input[type=text] {
            outline: none;
            height: 40px;
            width: 350px;
            padding: 5px 5px 5px 5px;
            outline: none;
            border: solid black 2px;
            -webkit-box-shadow: 5px 5px 0px 0px orange, 10px 10px 0px 0px rgb(255, 196, 86), 15px 15px 0px 0px rgb(255, 234, 196);
            box-shadow: 5px 5px 0px 0px orange, 10px 10px 0px 0px rgb(255, 196, 86), 15px 15px 0px 0px rgb(255, 234, 196);

        }

        input[type=number] {
            outline: none;
            height: auto;
            width: 100px;
            padding: 5px 5px 5px 5px;
            outline: none;
            border: solid black 2px;
            -webkit-box-shadow: 5px 5px 0px 0px orange, 10px 10px 0px 0px rgb(255, 196, 86), 15px 15px 0px 0px rgb(255, 234, 196);
            box-shadow: 5px 5px 0px 0px orange, 10px 10px 0px 0px rgb(255, 196, 86), 15px 15px 0px 0px rgb(255, 234, 196);

        }

        input:focus {
            outline: none;
        }

        textarea {
            resize: none;
        }

        #txtProcedimento {
            padding: 5px 5px 5px 5px;
            outline: none;
            border: solid black 2px;
            -webkit-box-shadow: 5px 5px 0px 0px orange, 10px 10px 0px 0px rgb(255, 196, 86), 15px 15px 0px 0px rgb(255, 234, 196);
            box-shadow: 5px 5px 0px 0px orange, 10px 10px 0px 0px rgb(255, 196, 86), 15px 15px 0px 0px rgb(255, 234, 196);
        }

        #bottone-crea-nuova-ricetta {
            display: block;
            margin: 0px auto;
            margin-top: 25px;
            margin-bottom: 15px;
            background-color: orange;
            border-style: none;
            border-radius: 100px;
            font-family: 'Raleway', 'Calibri';
            font-weight: bold;
            font-size: 20px;
            padding: 3px 8px 3px 8px;
            cursor: pointer;
            width: 250px;
            height: 70px;
            box-shadow: 0px 0px 5px rgb(150, 150, 150);
            border-radius: 40px;
            transition: 0.1s;
        }

        #bottone-crea-nuova-ricetta:active {
            transform: scale(0.9);
        }


        /*the container must be positioned relative:*/
        .custom-select {
            position: relative;
            text-align: center;
            font-family: 'Raleway', 'Calibri';
            font-weight: bold;
            display: block;
            margin: 0px auto;
        }

        .custom-select select {
            display: none; /*hide original SELECT element:*/
        }

        .select-selected {
            background-color: orange;
        }

        /*style the arrow inside the select element:*/
        .select-selected:after {
            position: absolute;
            content: "";
            top: 14px;
            right: 10px;
            width: 0;
            height: 0;
            border: 6px solid transparent;
            border-color: #fff transparent transparent transparent;
        }

        /*point the arrow upwards when the select box is open (active):*/
        .select-selected.select-arrow-active:after {
            border-color: transparent transparent #fff transparent;
            top: 7px;
        }

        /*style the items (options), including the selected item:*/
        .select-items div, .select-selected {
            color: #ffffff;
            padding: 8px 16px;
            border: 1px solid transparent;
            border-color: transparent transparent rgba(0, 0, 0, 0.1) transparent;
            cursor: pointer;
            user-select: none;
        }

        /*style items (options):*/
        .select-items {
            position: absolute;
            background-color: orange;
            top: 100%;
            left: 0;
            right: 0;
            z-index: 99;
        }

        /*hide the items when the select box is closed:*/
        .select-hide {
            display: none;
        }

        .select-items div:hover, .same-as-selected {
            background-color: rgba(0, 0, 0, 0.1);
        }
    }
</style>

<%@include file="header.jsp" %>

<body>

<div class="box-sezione" style="overflow-x: hidden">

    <form action="ServletNuovaRicetta">

        <h1 style="text-align: center; font-family: 'Kaushan Script', cursive;">Titolo ricetta</h1>

        <input type="text" name="titolo" id="title" style="font-family: 'Raleway', 'Calibri'; font-size: 20px; font-weight: bold; display: block; margin: 0px auto"><br>

        <h1 style="text-align: center; font-family: 'Kaushan Script', cursive;">URL Foto</h1>

        <input type="text" name="foto" id="foto" style="font-family: 'Raleway', 'Calibri'; font-size: 20px; font-weight: bold; display: block; margin: 0px auto"><br>

        <h2 style="text-align: center; font-family: 'Kaushan Script', cursive;">KCAL:</h2>
        <input type="number" name="nKcal" style="font-family: 'Raleway', 'Calibri'; font-size: 20px; font-weight: bold; display: block; margin: 0px auto"><br><br>

        <h2 style="text-align: center; font-family: 'Kaushan Script', cursive;">Tempo preparazione:</h2>
        <input type="number" name="nTempoPrep" style="font-family: 'Raleway', 'Calibri'; font-size: 20px; font-weight: bold; display: block; margin: 0px auto"><br>

        <h2 style="text-align: center; font-family: 'Kaushan Script', cursive;">Tempo cottura:</h2>
        <input type="number" name ="nTempoCott" style="font-family: 'Raleway', 'Calibri'; font-size: 20px; font-weight: bold; display: block; margin: 0px auto"/><br>

        <h2 style="text-align: center; font-family: 'Kaushan Script', cursive;">Dosi:</h2>
        <input type="number" name ="nDosi" style="font-family: 'Raleway', 'Calibri'; font-size: 20px; font-weight: bold; display: block; margin: 0px auto"><br>


        <h1 style="text-align: center; font-family: 'Kaushan Script', cursive;">Procedimento:</h1><textarea id="txtProcedimento" name="procedimento" rows="20" cols="70" style="font-family: 'Raleway', 'Calibri'; font-size: 20px; font-weight: bold; display: block; margin: 0px auto"></textarea><br>

        <h2 style="margin-top: 35px; text-align: center; font-family: 'Kaushan Script', cursive;">Etnia:</h2>

        <div class="custom-select" style="width:200px;">

            <select name="etnie" id="etnia">
                <option hidden disabled selected value>Selezionare una Etnia</option>
                <c:forEach items="${etnie}" var="listaEtnie">
                <option value="${listaEtnie.nome}">${listaEtnie.nome}</option>
                </c:forEach>
            </select>

        </div>

        <h2 style="text-align: center; font-family: 'Kaushan Script', cursive;">Categoria:</h2>

        <div class="custom-select" style="width:200px;">

            <select name="categorie" id="categoria">
                <option hidden disabled selected value>Selezionare una Categoria</option>
                <c:forEach items="${categorie}" var="listaCategorie">
                <option value="${listaCategorie.nome}">${listaCategorie.nome}</option>
                </c:forEach>
            </select>

        </div>

        <input type="submit" value="Conferma" id="bottone-crea-nuova-ricetta">
    </form>
</div>

<script>
    var x, i, j, l, ll, selElmnt, a, b, c;
    /*look for any elements with the class "custom-select":*/
    x = document.getElementsByClassName("custom-select");
    l = x.length;
    for (i = 0; i < l; i++) {
        selElmnt = x[i].getElementsByTagName("select")[0];
        ll = selElmnt.length;
        /*for each element, create a new DIV that will act as the selected item:*/
        a = document.createElement("DIV");
        a.setAttribute("class", "select-selected");
        a.innerHTML = selElmnt.options[selElmnt.selectedIndex].innerHTML;
        x[i].appendChild(a);
        /*for each element, create a new DIV that will contain the option list:*/
        b = document.createElement("DIV");
        b.setAttribute("class", "select-items select-hide");
        for (j = 1; j < ll; j++) {
            /*for each option in the original select element,
            create a new DIV that will act as an option item:*/
            c = document.createElement("DIV");
            c.innerHTML = selElmnt.options[j].innerHTML;
            c.addEventListener("click", function(e) {
                /*when an item is clicked, update the original select box,
                and the selected item:*/
                var y, i, k, s, h, sl, yl;
                s = this.parentNode.parentNode.getElementsByTagName("select")[0];
                sl = s.length;
                h = this.parentNode.previousSibling;
                for (i = 0; i < sl; i++) {
                    if (s.options[i].innerHTML == this.innerHTML) {
                        s.selectedIndex = i;
                        h.innerHTML = this.innerHTML;
                        y = this.parentNode.getElementsByClassName("same-as-selected");
                        yl = y.length;
                        for (k = 0; k < yl; k++) {
                            y[k].removeAttribute("class");
                        }
                        this.setAttribute("class", "same-as-selected");
                        break;
                    }
                }
                h.click();
            });
            b.appendChild(c);
        }
        x[i].appendChild(b);
        a.addEventListener("click", function(e) {
            /*when the select box is clicked, close any other select boxes,
            and open/close the current select box:*/
            e.stopPropagation();
            closeAllSelect(this);
            this.nextSibling.classList.toggle("select-hide");
            this.classList.toggle("select-arrow-active");
        });
    }
    function closeAllSelect(elmnt) {
        /*a function that will close all select boxes in the document,
        except the current select box:*/
        var x, y, i, xl, yl, arrNo = [];
        x = document.getElementsByClassName("select-items");
        y = document.getElementsByClassName("select-selected");
        xl = x.length;
        yl = y.length;
        for (i = 0; i < yl; i++) {
            if (elmnt == y[i]) {
                arrNo.push(i)
            } else {
                y[i].classList.remove("select-arrow-active");
            }
        }
        for (i = 0; i < xl; i++) {
            if (arrNo.indexOf(i)) {
                x[i].classList.add("select-hide");
            }
        }
    }
    /*if the user clicks anywhere outside the select box,
    then close all select boxes:*/
    document.addEventListener("click", closeAllSelect);
</script>

</body>

<%@include file="footer.jsp" %>

</html>
