/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classi;
import java.util.ArrayList;

/**
 *
 * @author alessandra
 */

public class ClienteFactory {

    private static Classi.ClienteFactory singleton;
    public static Classi.ClienteFactory getIstanza() {
        if (singleton == null) {
            singleton = new Classi.ClienteFactory();
        }
        return singleton;
    }
    
    
    // Lista Clienti
    private ArrayList<Utente> ListaClienti = new ArrayList<Utente>();


     /* Costruttore */
    
    protected ClienteFactory () {
        
        // Cliente1
        Cliente cl1= new Cliente();
        cl1.setNome("Celeste");
        cl1.setCognome("Cossu");
        cl1.setUsername("CC1");
        cl1.setPassword("1");
        
         ListaClienti.add(cl1);
         
               
        
        // Cliente2
        Cliente cl2= new Cliente();
        cl2.setNome("Daniela");
        cl2.setCognome("Dessena");
        cl2.setUsername("DD2");
        cl2.setPassword("2");
        
        ListaClienti.add(cl2);    
    }

    
     /* Metodi */ 
     public ArrayList<Utente> getListaClienti() {
        return ListaClienti;
    }
    
    public Utente getCliente(String username) {
        for(Utente u : ListaClienti) {
            if(u.username == username)
                return u;
        }
        return null;
    }
}
