/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classi;

/**
 * @author alessandra
 **/

public class Saldo { 
     
    private int saldo; 
   
    /*Costruttore*/
    
    public Saldo () { 
      saldo=0;
    }
    
    /*Metodi*/
    
    public boolean Pagamento(int prezzo){
        if(prezzo <= this.saldo)
            return true;
        else
            return false;
    }
    
    public int getSaldo() {
        return saldo;
    }
    
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    
}