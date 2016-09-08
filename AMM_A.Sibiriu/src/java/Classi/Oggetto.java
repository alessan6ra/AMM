/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classi;

/**
 *
 * @author Alessandra
 */
public class Oggetto 
{
    
    //Attributi
    int id;
    private String nome;
    private String descrizione;
    private String url;
    private int pezzi;
    public double prezzo;
    private int idVend;
    
    
    //Costruttore
    public Oggetto()
    {
    id = 0;
    nome="";
    descrizione="";
    url = "";
    pezzi= 0;
    prezzo = 0.0;
    idVend=0;
    }
    
    
    //Metodi
    
    //return id
    public int getId() 
    {
        return id;
    }

    //@param id, id to set
    public void setId(int id) 
    {
        this.id = id;
    }

    //@return nome
    public String getNome() 
    {
        return nome;
    }

    //@param nome, nome to set
    public void setNome(String nome) 
    {
        this.nome= nome;
    }
    
    //@return descrizione
    public String getDescrizione() 
    {
        return descrizione;
    }

    //@param descrizione, descrizione to set
    public void setDescrizione(String descrizione) 
    {
        this.descrizione = descrizione;
    }
    
     //@return url
    public String getUrl() 
    {
        return url;
    }

    //@param url, url to set
    public void setUrl(String url) 
    {
        this.url = url;
    }
    
    //return pezzi
    public int getPezzi() 
    {
        return pezzi;
    }

    //@param pezzi, pezzi to set
    public void setPezzi(int pezzi)
    {
     this.pezzi = pezzi;
    }
    
    //@return prezzo
    public double getPrezzo() 
    {
        return prezzo;
    }
    
    //@param prezzo, prezzo to set
    public void setPrezzo(double prezzo) 
    {
        this.prezzo = prezzo;
    }
    
    
    //@return the idVend
    public Integer getIdVend() 
    {
        return idVend;
    }

    // @param idVend the idVend to set
    
    public void setIdVend(int idVend) {
        this.idVend = idVend;
    }

    
    
    
}