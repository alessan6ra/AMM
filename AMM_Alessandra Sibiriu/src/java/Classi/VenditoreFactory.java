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
public class VenditoreFactory {

    private static VenditoreFactory singleton;

    public static VenditoreFactory getIstanza() {
        if (singleton == null) {
            singleton = new VenditoreFactory();
        }
        return singleton;
    }
    
    // Lista Venditori
    protected ArrayList<Utente> ListaVenditori = new ArrayList<Utente>();
    
   
    /* Costruttore */
    
    protected VenditoreFactory () {
    
    //Venditore1
        Venditore vend1= new Venditore();
        vend1.setNome("Alessia");
        vend1.setCognome("Armeni");
        vend1.setUsername("AA1");
        vend1.setPassword("1");
                
        vend1.setOggetti_vendita(arrayOggetti_vendita1);
        
       
        ListaVenditori.add(vend1);

        // Venditore2
        Venditore vend2= new Venditore();
        vend2.setNome("Barbara");
        vend2.setCognome("Bianchi");
        vend2.setUsername("BB2");
        vend2.setPassword("2");
        
       vend2.setOggetti_vendita(arrayOggetti_vendita2);
        
        ListaVenditori.add(vend2);

}
       
    /* Metodi */
    
    public ArrayList<Utente> getListaVenditori() {
        return ListaVenditori;
    }
    
    public Utente getVenditore(String username) {
        for(Utente u : ListaVenditori) {
            if(u.username == username)
                return u;
        }
        return null;
    }
    
}
