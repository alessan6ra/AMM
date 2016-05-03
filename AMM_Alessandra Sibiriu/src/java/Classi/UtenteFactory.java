/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classi;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author alessandra
 */

public class UtenteFactory {

    private static UtenteFactory singleton;

    public static UtenteFactory getIstanza() {
        if (singleton == null) {
            singleton = new UtenteFactory();
        }
        return singleton;
    }
 
    
    //Lista utenti
    private ArrayList<Utente> ListaUtenti = new ArrayList<Utente>();
    private Collection<? extends Utente> ListaVenditori;
    private Collection<? extends Utente> ListaClienti;
    
    
    // Metodi 
    
    public ArrayList<Utente> getListaUtenti() {
        ListaUtenti.addAll(ListaVenditori);
        ListaUtenti.addAll(ListaClienti);
        
        return ListaUtenti;
    }

    public Object getListaClienti() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    

