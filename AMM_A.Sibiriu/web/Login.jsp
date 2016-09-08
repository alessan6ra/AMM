<%-- 
    Document   : Login
    Created on : 29-ago-2016, 15.38.06
    Author     : Alessandra
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Handmade Bijoux-Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <!--Metainformazioni -->
        <meta name="keywords" content="handmade, fimo, bijoux,orechini, shop, login"> 
        <meta name="description" content="Effettuare login su Handmade Bijoux">
        <meta name="author" content="Alessandra Sibiriu"> 
        <!--Collegamento della pagina al foglio di stile -->
        <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
        </head>
    
    <body>
        
    <header><p>HANDMADE BIJOUX </p> </header>   <!--Titolo-->
     
    <jsp:include page="blocchi/sidebar.jsp"/>   <!--Sidebar-->
     
    <div class="corpo">  
         
        <h1>Accedi al sito </h1>
        <p>Per accedere al sito, inserisci il tuo username e password negli appositi campi e clicca su "Login".</p>

        <div>
            
            <c:if test="${errore == true}">  <!--Se psw e username sono errati compare avviso di errore-->
                <p class="messaggio"> Errore: La combinazione Username e Password non è valida. Riprova!</p>     
            </c:if>  
                
        <jsp:include page="blocchi/formLogin.jsp"/> <!--Form di Login-->
        
    </div>
        
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