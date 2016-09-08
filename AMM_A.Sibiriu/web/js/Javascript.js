/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    
    $("#filtra").keyup(function() {
        
        //preleva valore
        var text= $("#filtra").val(); 
        
        $.ajax({
            url : "filter.json",
            data:{
                cmd: "filtra",
                text: text
            },
            dataType: "json",
        
            success: function(data, state){
                aggiornaListaOggetti(data);
            },
            error: function(data, state){
               
            }
        });

        // in caso di successo
        function aggiornaListaOggetti(listaOggetti){
            
            //cancella la lista
             $("#lista").empty();
             
             //nel caso non si trovassero oggetti
             if(listaOggetti.size() === 0){
                var msg = document.createElement("p");
                msg.setAttribute("class", "messaggio"); 
                var text = document.createTextNode("La ricerca non ha prodotto risultati.");
                msg.appendChild(text);
                $(".corpo").appendChild(msg);
            }
            
             //nel caso trovassi oggetti
               for(var oggetto in listaOggetti)
              {
                    var newtr = document.createElement("tr");
                    newtr.setAttribute("class", "dispari");
                    
                    var newtd1 = document.createElement("td");
                    var newtd2 = document.createElement("td");
                    var newtd3 = document.createElement("td");
                    var newtd4 = document.createElement("td");
                    var newtd5 = document.createElement("td");
                
                    
                    //nome
                    var td1 = document.createTextNode(listaOggetti[oggetto].nome);
                    newtd1.appendChild(td1);
                    
                    //foto
                    var td2 = document.createElement("img");
                    td2.setAttribute("title", listaOggetti[oggetto].nome);
                    td2.setAttribute("alt", listaOggetti[oggetto].descrizione);
                    td2.setAttribute("src", listaOggetti[oggetto].url);
                    newtd2.appendChild(td2);
                    
                    //n pezzi
                    var td3 = document.createTextNode(listaOggetti[oggetto].pezzi);
                    newtd3.appendChild(td3);
                    
                    //prezzo
                    var td4 = document.createTextNode(listaOggetti[oggetto].prezzo + " €");
                    newtd4.appendChild(td4);
                    
                    //carrello
                    var link = document.createElement("a");
                    link.setAttribute("href", "Cliente.html?OggClick=" + listaOggetti[oggetto].id);
                    var registraTxt = document.createTextNode("Aggiungi");
                    link.appendChild(registraTxt);
                    newtd5.appendChild(link);
                
                    newtr.appendChild(newtd1);
                    newtr.appendChild(newtd2);
                    newtr.appendChild(newtd3);
                    newtr.appendChild(newtd4);
                    newtr.appendChild(newtd5);
                
                    $("#lista").append(newtr); 
                }
             
           
            
        }
    });
});