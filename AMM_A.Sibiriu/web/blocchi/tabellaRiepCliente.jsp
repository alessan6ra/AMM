<%-- 
    Document   : tabellaRiepCliente
    Created on : 5-set-2016, 18.59.53
    Author     : Alessandra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


    <table> <!--Inizio riepilogo oggetto comprato-->
            <tr> 
                <th> Nome </th>
                <th> Foto </th>
                <th> N°Pezzi </th>
                <th> Prezzo </th>
            </tr>
               
            <tr class="dispari">
                <td> ${oggetto.nome} </td>
                <td> <img title="${oggetto.nome}" alt="${oggetto.descrizione}" src="${oggetto.url}" /> </td>
                <td> ${oggetto.pezzi} </td>
                <td> ${oggetto.prezzo} € </td>
            </tr>
    </table> <!--Fine riepilogo oggetto comprato-->
                
<p> <a href="Cliente.html?OggClickConfermato=${oggetto.getId()}"> Conferma </a> </p>
