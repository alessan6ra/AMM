<%-- 
    Document   : formModifica
    Created on : 5-set-2016, 19.11.56
    Author     : Alessandra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


    <form action="Venditore.html" method="post"> <!--Inizia form per modifica oggetto-->
        <div>
            <label for="nome"> Nome oggetto: </label>
            <input type="text" name="Nome" id="nome" />
            
            <label for="immagine"> URL immagine: </label>
            <input type="url" name="Url" id="immagine" />
            
            <label for="descrizione"> Descrizione: </label>
            <textarea rows="6" cols="25" maxlength="200" name="Descrizione" id="descrizione" > </textarea>
                               
            <label for="pezzi"> Pezzi disponibili: </label>
            <input type="number" min="1" max="100" name="Pezzi" id="pezzi"/>
            
            <label for="prezzo"> Prezzo (€): </label>
            <input type="number" min="1" max="100" name="Prezzo" id="prezzo"/>
            
        </div>
            
        <div class="padding">
            <input class="submit" type="submit" value="Modifica oggetto" name="AggiornaOggetto"/>
        </div>
    </form> <!--Finisce form per modifica oggetto-->
