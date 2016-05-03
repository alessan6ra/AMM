/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classi;

import java.util.ArrayList;

/**
 *
 * @author alessandra
 */
public class Oggetto_acquistatoFactory {

    private static Classi.Oggetto_acquistatoFactory singleton;

    public static Classi.Oggetto_acquistatoFactory getIstanza() {
        if (singleton == null) {
            singleton = new Classi.Oggetto_acquistatoFactory();
        }
        return singleton;
    }
    
    /* Costruttore */
    
    
    
    // Lista Oggetti_acquistati
    protected ArrayList<Oggetto_acquistato> ListaOggetti_acquistati = new ArrayList<Oggetto_acquistato>();
    
    protected Oggetto_acquistatoFactory () {
    
    // Oggetti acqustati da Cliente1
    
         Oggetto_acquistato oA1 = new Oggetto_acquistato();
         oA1.setNomeOgg(o1.nomeogg);
         oA1.setPrezzo(o1.prezzo);
         oA1.setQuantità(1);
         
         Oggetto_acquistato oA2 = new Oggetto_acquistato();
         oA2.setNomeOgg(o6.nomeogg);
         oA2.setPrezzo(o6.prezzo);
         oA2.setQuantità(1);
         
         
        ArrayList<Oggetto_acquistato> arrayOggetti_acquistatiC1 = new ArrayList<Oggetto_acquistato>();
         
        arrayOggetti_acquistatiC1.add(oA1);
        arrayOggetti_acquistatiC1.add(oA2);
        cl1.setOggetti_acquistati(arrayOggetti_acquistatiC1);
        
        
        //Metodi
   }
     
}