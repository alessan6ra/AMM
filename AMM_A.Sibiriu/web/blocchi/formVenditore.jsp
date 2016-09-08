<%-- 
    Document   : formVenditore
    Created on : 5-set-2016, 19.02.10
    Author     : Alessandra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <form action="Venditore.html" method="post"> <!--Inizia form insermento oggetto-->
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
            <input class="submit" type="submit" value="Metti in vendita" name="SubmitVenditore"/>
        </div>
    </form> <!--Finisce form insermento oggetto-->
</div>

 <h3>Modifica o Cancella Oggetto </h3> 
 <p>Scegli l'oggetto tra gli oggetti che hai messo in vendita quello che vuoi modificare o eliminare dallo shop e clicca sull'azione desiderata </p>       
        <div>
            
            <form action="Venditore.html"> <!--Inizia form scelta oggetto + azione: modifica o cancella-->
                <select name="ID">
                    <c:forEach var="oggetto" items="${listaOggettiVenditore}">    
                    <option value="${oggetto.id}"> Nome: ${oggetto.nome} </option>
                    </c:forEach> 
                </select>
                
                <div class="padding">
                    <input class="submit" type="submit" name="OggettoMod" value="Modifica">
                </div>
                <div class="padding">
                    <input class="submit" type="submit" name="OggettoCanc" value="Cancella">
                </div>
                
            </form>  <!--Finisce form scelta oggetto + azione: modifica o cancella-->
         </div>   
