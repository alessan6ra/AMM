<%-- 
    Document   : venditore
    Created on : 29-ago-2016, 15.38.22
    Author     : Alessandra
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Handmade Bijoux-venditore</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <!--Metainformazioni -->
        <meta name="keywords" content="handmade, fimo, bijoux,orechini, shop, vendi"> 
        <meta name="description" content="Pagina per mettere in vendita oggetti su Handmade Bijoux">
        <meta name="author" content="Alessandra Sibiriu"> 
        <!--Collegamento della pagina al foglio di stile -->
        <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
        </head>
    
    <body>
        
    <header><p>HANDMADE BIJOUX </p> </header>   <!--Titolo-->

    <jsp:include page="blocchi/sidebar.jsp"/> <!--Sidebar-->
        
    <div class="corpo">
        
    <c:choose> 
                                 
    <c:when test="${ Modifica == false && isCliente == false}">  <!--Se Modifica è falso ed è venditore posso visualizzare la pag per inserire oggetto -->
        
        <h1>Pagina Venditore </h1>
        
        <div>     
        <h2> Bentornato/a ${venditore.username}  il tuo credito disponibile è: ${venditore.saldo.getSaldo()}€</h2>
        </div>
        
        
        <div>
        <h3>Aggiungi Oggetto </h3> 
        <p>Compila il campo sottostante e aggiungi l'immagine dell'oggetto da mettere in vendita.
        Ad operazione finita clicca su "Metti in vendita" </p>
        </div>
       
        <jsp:include page="blocchi/formVenditore.jsp"/> <!--Form del Venditore per inserire oggetto, modificarlo o cancellarlo-->
            
            
    </c:when>
        
        
    <c:when test="${ Modifica == true }">  <!--se Modifica è vero visualizza il form per modificare oggetto -->
        
         <c:if test="${errore == true}">  <!--Se psw e username sono errati compare avviso di errore-->
                <p class="messaggio"> Errore: accertati di aver compilato tutti i campi prima di procedere con l'inserimento/modifica dell'oggetto </p>     
                <p > <a href="venditore.jsp"> Continua </a> </p>
            </c:if>  
                
        <div>
        <h1>Modifica un oggetto nello shop </h1>
        <p>Bene, per modificare l'oggetto precedentemente selezionato compila  i campi sottostanti 
        Ad operazione finita clicca su "Modifica Oggetto" </p>
        </div>
       
        <jsp:include page="blocchi/formModifica.jsp"/> <!--Form dove inserire dati da sostituire-->
            
    </c:when>
    
   <c:when test="${riepilogo == true }"> <!--Se si clicca tasto ed ha compilato tutti i campi-->
       
        <h3> Riepilogo Inserimento/Modifica/Cancellazione </h3>
        
            <jsp:include page="blocchi/tabellaRiepVend.jsp"/>
        <p class="messaggio"> Complimenti, l'operazione è andato a buon fine!</p> <!--modificare-->
        <p> <a href="venditore.jsp"> Continua  </a> </p>    
                
    </c:when>
        
    <c:when test="${formIncompleto == true }">  <!--Se il form non è compilato messaggio di errore -->
        
        <p class="messaggio" > Errore: accertati di aver compilato tutti i campi prima di procedere con l'inserimento/modifica dell'oggetto </p>
        <p > <a href="venditore.jsp"> Continua </a> </p>
        
    </c:when>

         
    <c:otherwise>  <!--Se non  è venditore  non è autorizzato a visualizzare la pagina (o cliente o non loggato)-->
        <p class="messaggio"> Non sei autorizzato a visualizzare questa pagina. Effettua il login! </p>    
        
        <p> <a href="Login.jsp"> Continua  </a> </p>   
    </c:otherwise>
        
       
    </c:choose>
        
        
    <h2>Mappa del sito</h2> 
    <ul>
    <li> <a href='descrizione.html'> Home Page </a> </li>
    <li> <a href='Login.jsp'> Login </a> </li> 
    </ul>   
    
    </div>
     
     <footer><p>Created by Alessandra Sibiriu</p></footer>
   
    </body>
</html>
