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
public abstract class Utente {
    protected int id;
    protected String username;
    protected String password;
    public Saldo saldo;

    //Costruttore
    public Utente ()
    {
        id= 0;
        username="";
        password = "";
     }

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
    
    //@return the username
    public String getUsername() 
    {
        return username;
    }

    //@param username, username to set
    public void setUsername(String username) 
    {
        this.username = username;
    }
    
    //@return password
    public String getPassword() 
    {
        return password;
    }

    //@param password, password to set
    public void setPassword(String password) 
    {
        this.password = password;
    }
    
    public Saldo getSaldo() 
    {
        return saldo;
    } 
    
    public void setSaldo( Saldo saldo){
        this.saldo = saldo;
    }
            
  
}

