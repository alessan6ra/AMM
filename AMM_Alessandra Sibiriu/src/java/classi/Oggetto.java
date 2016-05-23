/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classi;

/**
 *
 * @author alessandra
 */
public class Oggetto {
    
    protected String nomeogg;
    protected int prezzo;
    protected int quantità;
    protected String descrizione;  
    protected String img;
    
    /* Costruttore */
    public Oggetto() {
        this.nomeogg = "";
        this.prezzo= 0;
        this.quantità= 0;
        this.descrizione="";
        this.img="";
    }
    
   /*Metodi*/
    
    /**
     * @return the nomeogg
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
     * @return the descrizione
     */
    public String getDescrizione() {
        return descrizione;
    }
    
    /**
     * @param descrizione the descrizione to set
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
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
