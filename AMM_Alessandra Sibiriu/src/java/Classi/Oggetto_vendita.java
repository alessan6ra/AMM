/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classi;

/**
 *
 * @author alessandra
 */

/* ho utilizzato string perchè è un valore da modificare*/
public class Oggetto_vendita {
    
    protected String nomeogg;
    protected int prezzo;
    protected int quantità;
    protected String img;
    
     /* Costruttore */
    public Oggetto_vendita()
    {
        nomeogg = "";
        prezzo= 0;
        quantità= 0;
    }

        
    
     /**
     * @return the prezzo
     */
    public int getPrezzo() {
        return prezzo;
    }

    /**
     * @param prezzo the prezzo to set
     */
    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }
    
    /**
    * @return the quantità
    */
    public int getQuantità() {
        return quantità;
    }
    
    /**
     * @param quantità the quantità to set
     */
    public void setQuantità(int quantità) {
        this.quantità = quantità;
    }
   
    /**
     * @return the nome
     */
    public String getNomeOgg() {
        return nomeogg;
    }
    
    /**
     * @param nomeogg the nomeogg to set
     */
    public void setNomeOgg(String nomeogg) {
        this.nomeogg = nomeogg;
    }
    
    /**
     * @return the img
     */
    
    public String getImg() {
        return img;
    }
    
    /**
     * @param img the img to set
     */
    
    
    public void setImg(String img) {
          this.img = img;
    }
}
