/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.M3;

/**
 *
 * @author alessandra
 */

/* ho utilizzato string perchè è un valore da modificare*/
public class Oggetto_vendita {
    protected String nomeogg;
    protected int quantità;
    protected int prezzo;
    
    
     /* Costruttore */
    public Oggetto_vendita()
    {
        prezzo= 0;
        quantità= 0;
        nomeogg = "";
       
    }
    
     /**
     * @return the prezzo
     */
    public int getprezzo() {
        return prezzo;
    }

    /**
     * @param prezzo the prezzo to set
     */
    public void setprezzo(int prezzo) {
        this.prezzo = prezzo;
    }
    
    /**
    * @return the quantità
    */
    public int getquantità() {
        return quantità;
    }
    
    /**
     * @param quantità the quantità to set
     */
    public void setquantità(int quantità) {
        this.quantità = quantità;
    }
   
    /**
     * @return the nome
     */
    public String getnomeogg() {
        return nomeogg;
    }
    
    /**
     * @param nomeogg the nomeogg to set
     */
    public void setnomeogg(String nomeogg) {
        this.nomeogg = nomeogg;
    }
    
    
}
