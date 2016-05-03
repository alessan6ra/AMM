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
public class Venditore extends Utente{
    
    private ArrayList<Oggetto_vendita> Oggetti_vendita = new ArrayList<Oggetto_vendita>();
    
    
    
     /**
     * @return the Tutti_oggetti_vendita
     */
    public ArrayList<Oggetto_vendita> getOggetti_vendita() {
        return Oggetti_vendita;
    }

    void setOggetti_vendita(ArrayList<Oggetto_vendita> arrayOggetti_vendita) {
        this.Oggetti_vendita = Oggetti_vendita;
    }

    
}


