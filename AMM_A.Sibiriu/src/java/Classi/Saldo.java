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
public class Saldo 
{
    //Attributi
    private double saldo;
    
    
    //Costruttore
    
     public Saldo()
   {
    saldo= 0.0;
   }
     
        
    public Saldo (Double saldo)
    {
        this.saldo = saldo;
    } 
    
//Metodi
    
    //return saldo
    public double getSaldo() 
    {
        return saldo;
    }

    //@param saldo, saldo to set
    public void setSaldo(double saldo)
    {
        this.saldo = saldo;
    }
    
}
