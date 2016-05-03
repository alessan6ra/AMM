<%-- 
    Document   : cliente
    Created on : 2-mag-2016, 17.17.38
    Author     : alessandra
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Handmade Bijoux-cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <meta name="keywords" content="handmade, fimo, bijoux,orechini, shop, acquista"> 
        <meta name="description" content="Pagina per effettuare acquisti su Handmade Bijoux">
        <meta name="author" content="Alessandra Sibiriu">        
        
        <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
        
    </head>
    
    <body>
      <jsp:include page="header.jsp" />
          
    <jsp:include page="sidebar.jsp" />
       
       
        <div class="content">
        
        <h1> Shop</h1>
        
        <p>Clicca sul "Aggiungi" per inserire l'oggetto nel carrello.</p>
        
        <table>
                    <c:forEach var="Oggetto_vendita" items="${ListaOggetti_vendita}">
                        <tr>
                            <td><h2 class="titolotab">${Oggetto_vendita.nomeogg}</h2>
                            <img class="immagine" title="${Oggetto_vendita.nomeogg}" alt="${Oggetto_vendita.nomeogg}" src="${Oggetto_vendita.img}" width="130" height="130"></td>
                            <p>${Oggetto_venduto.quantità}</p>
                            <p>${Oggetto_venduto.prezzo}</p>
                            <a href="cliente.html">Aggiungi</a></td>
                        </tr>
                    </c:forEach>
                               
                </table>
        
                
        <h2>Mappa del sito</h2>
   <ul>
   <li> <a href='descrizione.html'> Home Page </a> </li>
   <li> <a href='login.html'> Login </a> </li>
   </ul>   
   </div>
      <jsp:include page="footer.jsp"/>
    </body>
</html>

