<%-- 
    Document   : tabella_articoli
    Created on : 17-mag-2016, 16.18.41
    Author     : alessandra
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      
      <table>
            <!--Intestazione tabella-->
            <tr>
                <th>Nome</th>
                <th>Immagine</th>
                <th>Descrizione</th>
                <th>Prezzo</th>
                <th>Quantità</th>
                <th>Compra</th>
            </tr>
            <!--Primo articolo-->
            <c:forEach items="${ListaOggetti}" var="oggetto">
                <tr class="${Oggetto.getNomeogg()}">
                    <td><img title="${Oggetto.getNomeogg()}" alt="${Oggetto.getDescrizione()}" src="${Oggetto.getImg()}" width="130" height="130"></td>
                    <td>${Oggetto.getDescrizione()}</td>
                    <td>${Oggetto.getPrezzo()}</td>
                    <td>${Oggetto.getQuantità()}</td>
                    <td> <a href="cliente.html">Aggiungi</a></td>
                </tr>
            </c:forEach>
        </table>   
        
        
    </body>
</html>
