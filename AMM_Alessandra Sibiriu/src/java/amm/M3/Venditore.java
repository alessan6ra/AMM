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
public class Venditore {
    
    private ArrayList<Oggetto_vendita> Tutti_oggetti_vendita = new ArrayList<Oggetto_vendita>();
    
     /**
     * @return the Tutti_oggetti_vendita
     */
    public ArrayList<Oggetto_vendita> getTutti_oggetti_vendita() {
        return Tutti_oggetti_vendita;
    }

    /**
     * @param  Tutti_oggetti_vendita
     */
    public void setTutti_oggetti_vendita(ArrayList<Oggetto_vendita> Tutti_oggetti_vendita) {
        this.Tutti_oggetti_vendita = Tutti_oggetti_vendita;
    }
}


