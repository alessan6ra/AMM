<%-- 
    Document   : cliente
    Created on : 29-ago-2016, 15.38.16
    Author     : Alessandra
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Handmade Bijoux-cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <!--Metainformazioni -->
        <meta name="keywords" content="handmade, fimo, bijoux,orechini, shop, acquista"> 
        <meta name="description" content="Pagina per effettuare acquisti su Handmade Bijoux">
        <meta name="author" content="Alessandra Sibiriu">  
        
        <!-- jQuery -->
        <script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
        <script type="text/javascript" src="js/Javascript.js"></script>
        
        <!--Collegamento della pagina al foglio di stile -->
        <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    
    <body>
        
    <header><p>HANDMADE BIJOUX </p> </header>   <!--Titolo-->
      
    <jsp:include page="blocchi/sidebar.jsp"/>  <!--Sidebar-->
      
    <div class="corpo"> 
       
    <c:choose>
    
    <c:when test="${isCliente == true}">  <!--Se è un cliente tutto ok può visualizzare contenuto -->
      
        <h1> Shop</h1>
            
        <div>        
        <h2> Bentornato/a ${cliente.username} il tuo credito disponibile è: ${cliente.saldo.getSaldo()}€</h2>
        </div>
                          
        <!--Milestone 5-->
        <div> 
        <label for="filtra">Ricerca:</label>
        <input type="text"  id="filtra" />
        </div>
        
        
        <p>Clicca sul "Aggiungi" per inserire l'oggetto nel carrello.</p>
        
        <jsp:include page="blocchi/tabellaOggetti.jsp"/> <!--Tabella degli oggetti acquistabili -->
        
        
    </c:when>
            
    <c:when test="${riepilogo == true}"> <!--Se ha cliccato su aggiungi nella tabella rimanda al riepilogo-->
        <h1> Shop</h1>
        
         <p> Clicca su conferma per confermare il seguente acquisto:</p>
         
        <jsp:include page="blocchi/tabellaRiepCliente.jsp"/> <!--Tabella di riepilogo dell'acquisto -->
    
    </c:when>  
            
                    
    <c:when test="${acquistoFallito}"><!--Se ha cliccato su conferma del riepilogo ma non ha credito-->
       <h1> Shop</h1>
            
            <p class="messaggio"> Errore: Non è stato possibile effettuare l'acquisto. Credito Insufficiente </p>
            <p> <a href="cliente.jsp"> Continua </a> </p>
            
    </c:when>
            
    <c:when test="${acquistoCompletato == true}"> <!--Se ha cliccato su conferma del riepilogo ed è tutto ok -->
        <h1> Shop</h1>
        
        <p class="messaggio">  Complimenti, l'acquisto è andato a buon fine!</p>
        
        <p> <a href="cliente.jsp">Continua</a> </p>
        
    </c:when>
            
    <c:otherwise>  <!--Se non è cliente non è autorizzato a visualizzare la pagina (o vendit o non loggato)-->
        
            <p class="messaggio"> Non sei autorizzato a visualizzare questa pagina. Effettua il login! </p>    
            <p> <a href="Login.jsp"> Continua  </a> </p>  
    </c:otherwise>
        
                
    </c:choose>
         
            
    <h2>Mappa del sito</h2>
    
    <ul>
    <li> <a href='descrizione.html'> Home Page </a> </li>
    <li> <a href='cliente.jsp'> Compra un oggetto </a> </li>
    <li> <a href='venditore.jsp'> Metti in vendita un oggetto </a> </li>
    </ul> 
    
    
   </div>
     
     <footer><p>Created by Alessandra Sibiriu</p></footer>
     
    </body>
</html>