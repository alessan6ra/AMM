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
    
    private String nomeogg;
    private int prezzo;
    private int quantità;
    private String descrizione;  //aggiungere nella tabella, aggiungere nella factory, metto orecchini come descrizione
    private String img;
    
    /* Costruttore */
    public Oggetto() {
        nomeogg = "";
        prezzo= 0;
        quantità= 0;
        descrizione="";
    }
    
   /*Metodi*/
    
    public int getPrezzo() {
        return prezzo;
    }

    
    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }
    
  
    public int getQuantità() {
        return quantità;
    }
  
    public void setQuantità(int quantità) {
        this.quantità = quantità;
    }
   
    
    public String getNomeOgg() {
        return nomeogg;
    }
    
    
    public void setNomeOgg(String nomeogg) {
        this.nomeogg = nomeogg;
    }
    
    public String getDescrizione() {
        return descrizione;
    }
    
    
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    
    public String getImg() {
        return img;
    }
    
    
    public void setImg(String img) {
          this.img = img;
    }
}
