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
        
        <jsp:include page="tabella_articoli.jsp" />
        
                
        <h2>Mappa del sito</h2>
   <ul>
   <li> <a href='descrizione.html'> Home Page </a> </li>
   <li> <a href='login.html'> Login </a> </li>
   </ul>   
   </div>
      <jsp:include page="footer.jsp"/>
    </body>
</html>

