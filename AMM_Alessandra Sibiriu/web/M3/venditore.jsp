<%-- 
    Document   : venditore
    Created on : 2-mag-2016, 17.19.47
    Author     : alessandra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Handmade Bijoux-venditore</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <meta name="keywords" content="handmade, fimo, bijoux,orechini, shop, vendi"> 
        <meta name="description" content="Pagina per mettere in vendita oggetti su Handmade Bijoux">
        <meta name="author" content="Alessandra Sibiriu"> 
        
        <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
        
    </head>
    <body>
        <jsp:include page="header.jsp" />
        
       <jsp:include page="sidebar.jsp" />
        
        <div class="content">
        <h1>Aggiungi un oggetto nello shop </h1>
        <p>Compila i campi sottostanti e aggiungi l'immagine dell'oggetto da mettere in vendita.
        Ad operazione finita clicca su "Metti in vendita" </p>
        
        <form  id="form2" method="GET">
       <div>

       <label for="NomeOggetto">Nome oggetto </label>
       <input type="text" name="NomeOggetto" id="NomeOggetto"/>
       
       <label for="URLimmagine">URL immagine oggetto </label>
       <input type="url" name="URLimmagine" id="URLimmagine"/>
       
       <label for="Descrizioneoggetto">Descrizione dell'oggetto </label>
       <textarea rows='6' cols='20' name="Descrizioneoggetto" id="Descrizioneoggetto">Inserisci una descrizione dell'oggetto</textarea>
       
       <label for="Prezzo">Prezzo </label>
       <input type="number" min="1" max="100"  name="Prezzo" id="Prezzo"/> euro
       
       <label for="Numoggetti">Quantità di oggetti disponibili </label>
       <input type="number" min="1" max="50" name="Numoggetti" id="Numoggetti"/> oggetti 
 
    </div>       
    <input class="inputtasto" type="submit" value="Metti in vendita" />
    <input class="inputtasto" type="submit" value="Reimposta"/>
     
   
</form>
        
        
        
        
        
        <h2>Mappa del sito</h2>
   <ul>
   <li> <a href='descrizione.html'> Home Page </a> </li>
   <li> <a href='login.html'> Login </a> </li>
   </ul>   
        
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>

