<%-- 
    Document   : tabellaOggetti
    Created on : 5-set-2016, 18.58.51
    Author     : Alessandra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




    <table> <!--Apertura  tabella-->
            <tr> <!--Intestazione della tabella-->
                <th> Nome </th>
                <th> Foto </th>
                <th> N°Pezzi </th>
                <th> Prezzo </th>
                <th> Carrello </th>
            </tr> <!--Fine intestazione della tabella-->
           
            <c:forEach var="oggetto" items="${listaOggetti}"> <!--per ogni oggetto della lista fai questo-->
                <tr class="dispari">
                    
                <td> ${oggetto.nome} </td>
                <td> <img title="${oggetto.nome}" alt="${oggetto.descrizione}" src="${oggetto.url}" /> </td>
                <td> ${oggetto.pezzi} </td>
                <td> ${oggetto.prezzo} € </td>
                <td> <a href="Cliente.html?OggClick=${oggetto.id}" > Aggiungi </a> </td>
               </tr>
            </c:forEach>
               
    </table><!--Chiusura tabella-->

