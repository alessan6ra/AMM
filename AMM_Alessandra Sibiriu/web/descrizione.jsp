<%-- 
    Document   : descrizione
    Created on : 2-mag-2016, 17.19.21
    Author     : alessandra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Handmade Bijoux</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <meta name="keywords" content="handmade, fimo, bijoux,orechini, shop"> 
        <meta name="description" content="Home page di Handmade Bijoux">
        <meta name="author" content="Alessandra Sibiriu">        
        
        <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
        
    </head>
    
    <body>
        <jsp:include page="header.jsp" />
        
      <jsp:include page="sidebar.jsp" />
      
      <div class="content">
       <h1>Benvenuti!!</h1> 
          
      <ul>
          <li> <a href="#primo"> Cos'è Handmade Bijoux </a> </li>
          <li> <a href="#secondo"> FAQ </a></li>
          <li> <a href="#terzo"> Che cos'è il FIMO? </a> </li>
          <li> <a href="#quarto"> Come si acquista un oggetto? </a> </li>
          <li> <a href="#quinto"> Come si vende un oggetto? </a> </li>
          <li> <a href="#sesto"> Pagamenti e Spedizioni </a> </li> 
          <li> <a href="#settimo"> Login </a> </li>
      </ul>
           
      <h2 id="primo"> Cos'è Handmade Bijoux? </h2>
      
      <p>Handmade Bijoux è una vetrina virtuale, in cui è possibile vendere e acquistare creazioni fatto a mano.
         Handmade è sinonimo di unico e dietro la realizzazione di ogni oggetto c'è un lavoro di abilità manuale e tanta pazienza.
         In questo shop troverete orecchini, collane, portachiavi e tanto altro.
      </p>
      
      <h2 id="secondo">  FAQ </h2>
      <p>Risposte alle domande più frequenti. </p>
      
      <h3 id="terzo" > Che cos'è il FIMO? </h3>
      <p>Il Fimo è un pasta sintetica termoindurente che viene modellata completamente a mano. 
          Da "cruda" ha una consistenza simile alla plastillina, mentre una volta cotta assume una consistenza resistente come la plastica.
          Non macchia. Non scolorisce. 
      </p>
      
      <h3 id="quarto" >  Come si acquista un oggetto?  </h3> 
      <p>E' necessario accedere con le proprie credenziali dalla pagina login e
         successivamente, dalla pagina cliente è possibile aggiungere l'oggetto nel carrello. </p>
    
      <h3 id="quinto"> Come si vende un oggetto? </h3> 
      <p>E' necessario accedere con le proprie credenziali dalla pagina login e
         successivamente, dalla pagina venditore è possibile aggiungere l'oggetto
         che si vuole mettere in vendita </p>
      
 
      
      <h3 id="sesto">  Pagamenti e Spedizioni</h3> 
       <p>I pagamenti avvengono attraverso una moneta virtuale e la spedizione, 
          a carico del cliente,avverrà tramite corr iere.<p>
           
      <h2 id="settimo">  Login </h2>
      <p>Accedi al sito con le tue credenziali <a href='login.html'>cliccando qui.</a></p>
      
      </div>
    
     <jsp:include page="footer.jsp"/>
    
    </body>
</html>
