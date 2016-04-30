/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.M3;

import java.util.ArrayList;

/**
 *
 * @author alessandra
 */
public class Cliente extends Utente{
    
      /* Attributi */
    private ArrayList<Oggetto_acquistato> Lista_acquisti = new ArrayList<Oggetto_acquistato>();
    
               
    /* Metodi */
    /**
     * @return the Lista_acquisti
     */
    public ArrayList<Oggetto_acquistato> getLista_acquisti() {
        return Lista_acquisti;
    }

    /**
     * @param Lista_acquisti the Lista_acquisti to set
     */
    public void setLista_acquisti(ArrayList<Oggetto_acquistato> Lista_acquisti) {
        this.Lista_acquisti = Lista_acquisti;
    }
}

