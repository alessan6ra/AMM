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
public class Saldo { 
     
    private int conto; 
    private  Utente nome; 
    private int prezzo;
    
     
    /* costruttore */
    public Saldo(Utente nome, int contoiniz) { 
        this.nome = nome; 
        this.conto = contoiniz; 
    } 
 
    public void versamento() { 
         conto += prezzo; 
    } 
 
    public boolean prelievo() { 
        if(conto < prezzo) 
            return false; 
        conto -= prezzo; 
        return true; 
    }
     
    /**
     *
     * @return
     */
    public int getconto() { 
        return conto; 
    } 
 
    public Utente getnome() { 
        return nome; 
    } 
}