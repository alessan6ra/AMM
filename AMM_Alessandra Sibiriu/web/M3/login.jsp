<%-- 
    Document   : login
    Created on : 2-mag-2016, 17.19.38
    Author     : alessandra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Handmade Bijoux-Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <meta name="keywords" content="handmade, fimo, bijoux,orechini, shop, login"> 
        <meta name="description" content="Effettuare login su Handmade Bijoux">
        <meta name="author" content="Alessandra Sibiriu">    
        
        <link href="style.css" rel="stylesheet" type="text/css" media="screen" />       
        
    </head>
    <body>
        <jsp:include page="header.jsp" />
        
       <jsp:include page="sidebar.jsp" />
        
      <div class="content">
        
      <h1>Accedi al sito </h1>
      <p>Per accedere al sito, inserisci il tuo username e password negli appositi 
         campi e clicca su login.</p>
      
      <form id="form2" method="GET">
           
        <div> 
           
             <label for="Username"> Nome utente </label>
             <input  type="text" name="Username" id="Username" value="Username"/>
       
             <label for="pswd"> Password </label>
             <input  type="password" name="pswd" id="pswd" value="valoscurato"/>
             
             <input class="inputtasto" type="submit" value="Login" />
       
        </div>
      </form>
      
   <h2>Mappa del sito</h2>
   <ul>
   <li> <a href='descrizione.html'> Home Page </a> </li>
   <li> <a href='cliente.html'> Compra un oggetto </a> </li>
   <li> <a href='venditore.html'> Metti in vendita un oggetto </a> </li>
    </ul>   
   
   </div>
         <jsp:include page="footer.jsp"/>
    </body>
</html>

