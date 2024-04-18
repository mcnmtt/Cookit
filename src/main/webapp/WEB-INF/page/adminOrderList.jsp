<%--
  Created by IntelliJ IDEA.
  User: Mattia
  Date: 03/09/2021
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>RIEPILOGO ORDINI</title>

</head>
<body>
<div class="div-lista-ordini">
    <div class="div-ricerca">
        <input type="text" id="searchField" placeholder="Ricerca per Cognome">
        <input type="submit" value="CERCA" id="cerca">
    </div>

    <table class="list-order">
        <tr>
            <th>Genere</th>
            <th>Nome</th>
            <th>Cognome</th>
            <th>Num. Ordini</th>
            <th>Data ultimo ordine</th>
        </tr>
        <tr>
            <td><img src="https://image.flaticon.com/icons/png/32/2922/2922566.png"></td>
            <td>Maria</td>
            <td>Verdi</td>
            <td>23</td>
            <td>12/04/2021</td>
            <td><button class="button-order" type="submit"></button></td>

        </tr>
        <tr>
            <td><img src="https://image.flaticon.com/icons/png/32/2922/2922506.png"></td>
            <td>Giuseppe</td>
            <td>Bianchi</td>
            <td>62</td>
            <td>9/01/2021</td>
            <td><button class="button-order" type="submit"></button></td>

        </tr>
        <tr>
            <td><img src="https://image.flaticon.com/icons/png/32/2922/2922506.png"></td>
            <td>Mario</td>
            <td>Rossi</td>
            <td>5</td>
            <td>23/06/2020</td>
            <td><button class="button-order" type="submit"></button></td>

        </tr>
        <tr>
            <td><img src="https://image.flaticon.com/icons/png/32/2922/2922566.png"></td>
            <td>Rosaria</td>
            <td>Vergine</td>
            <td>320</td>
            <td>30/07/2021</td>
            <td><button class="button-order" type="submit"></button></td>

        </tr>
    </table>
</div>



</body>
</html>
