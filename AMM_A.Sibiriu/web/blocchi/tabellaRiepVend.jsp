<%-- 
    Document   : tabellaRiepVend
    Created on : 5-set-2016, 19.14.26
    Author     : Alessandra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<table>  <!--Inizia tabella riepilogo oggetto inserito nello shop-->
        <tr >
             <th> Nome </th>
             <th> Foto </th>
             <th> N°Pezzi  </th>
             <th> Prezzo </th>
        </tr>
                
            <tr class="dispari">
                <td> ${oggettoAggiunto.nome} </td>
                <td> <img title="${oggettoAggiunto.nome}"  alt="${oggettoAggiunto.descrizione}" src="${oggettoAggiunto.url}" /> </td>
                <td> ${oggettoAggiunto.pezzi} </td>
                <td> ${oggettoAggiunto.prezzo} € </td>
            </tr>
</table> <!--Finisce tabella riepilogo oggetto inserito nello shop-->
