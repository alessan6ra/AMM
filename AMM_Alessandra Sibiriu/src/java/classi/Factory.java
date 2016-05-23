/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classi;

import java.util.ArrayList;

/**
 *
 * @author alessandra
 */
    
  public class Factory {
    private static Factory singleton;
    public static Factory getInstance(){
        if (singleton == null){
            singleton = new Factory();
        }
        return singleton;
    }  
    
    
   // Lista Oggetti
    ArrayList<Oggetto> ListaOggetti = new ArrayList<>(); //mancano <Utente> vedo se funziona altrimenti modifico
    //Lista Venditori
    ArrayList<Utente> ListaVenditori = new ArrayList<>();
    //Lista Clienti
    ArrayList<Utente> ListaClienti = new ArrayList<>(); 
    
    
    //Costruttore
    public Factory(){
          
     //Oggetti
    Oggetto o1 = new Oggetto();
        o1.setNomeOgg("Orecchini Etnici");
        o1.setPrezzo(5);
        o1.setQuantità(2);
        o1.setDescrizione("orecchini");
        o1.setImg("./img/etnici.jpg"); //ho modificato il percorso
    ListaOggetti.add(o1);
   
    Oggetto o2 = new Oggetto();
        o2.setNomeOgg("Orecchini Minnie");
        o2.setPrezzo(2);
        o2.setQuantità(6);
        o2.setDescrizione("orecchini");
        o2.setImg("./img/minnie.jpg"); //ho modificato il percorso
    ListaOggetti.add(o2);
  
       
    Oggetto o3 = new Oggetto();
        o3.setNomeOgg("Orecchini Rose viola");
        o3.setPrezzo(3);
        o3.setQuantità(1);
        o3.setDescrizione("orecchini");
        o3.setImg("./img/rose.jpg"); //ho modificato il percorso
    ListaOggetti.add(o3);
     
    Oggetto o4 = new Oggetto();
        o4.setNomeOgg("Orecchini Zampette");
        o4.setPrezzo(2);
        o4.setQuantità(5);
        o4.setDescrizione("orecchini");
        o4.setImg("./img/zampe.jpg"); //ho modificato il percorso
    ListaOggetti.add(o4);
    
    Oggetto o5 = new Oggetto();
        o5.setNomeOgg("Orecchini Cuoricini");
        o5.setPrezzo(3);
        o5.setQuantità(4);
        o5.setDescrizione("orecchini");
        o5.setImg("./img/cuori.jpg"); //ho modificato il percorso
    ListaOggetti.add(o5);
        
    Oggetto o6 = new Oggetto();
        o6.setNomeOgg("Orecchini Fiore");
        o6.setPrezzo(3);
        o6.setQuantità(1);
        o6.setDescrizione("orecchini");
        o6.setImg("./img/fiori.jpg");  //ho modificato il percorso
    ListaOggetti.add(o6);
        
        
    //Saldo
    Saldo s1= new Saldo();
    s1.setSaldo(14);
    
    Saldo s2= new Saldo();
    s2.setSaldo(28);
    
    Saldo s3= new Saldo();
    s3.setSaldo(40);
    
    Saldo s4= new Saldo();
    s4.setSaldo(35);
    
    //Venditore 1
   Venditore vend1= new Venditore();
        vend1.setNome("Alessia");
        vend1.setCognome("Armeni");
        vend1.setUsername("AA1");
        vend1.setPassword("111"); 
        vend1.setTipoUtente("Venditore"); //pensare se serve o no
        vend1.setSaldo(s1);
    ListaVenditori.add(vend1);
    
     //Venditore2
    Venditore vend2= new Venditore();
        vend2.setNome("Barbara");
        vend2.setCognome("Bianchi");
        vend2.setUsername("BB2");
        vend2.setPassword("222"); 
        vend2.setTipoUtente("Venditore"); //pensare se serve o no
        vend2.setSaldo(s2);
    ListaVenditori.add(vend2);    
        
        
     //Cliente1
     Cliente cl1= new Cliente();
        cl1.setNome("Celeste");
        cl1.setCognome("Cossu");
        cl1.setUsername("CC1");
        cl1.setPassword("111"); 
        cl1.setTipoUtente("Cliente"); //pensare se serve o no
        cl1.setSaldo(s3);
    ListaClienti.add(cl1);   
        
    //Cliente2
    Cliente cl2= new Cliente();
        cl2.setNome("Daniela");
        cl2.setCognome("Dessena");
        cl2.setUsername("DD2");
        cl2.setPassword("222"); 
        cl2.setTipoUtente("Cliente"); //pensare se serve o no
        cl2.setSaldo(s4);
    ListaClienti.add(cl2);   
    
    }
    
    //Metodi
    
    public ArrayList getListaVenditori(){
        return ListaVenditori;
    }
    
    public ArrayList getListaClienti(){
        return ListaClienti;
    }
    
    public ArrayList<Utente> getListaUtenti(){
        ArrayList<Utente> ListaUtenti = new ArrayList(); //Creo lista utenti
        ListaUtenti.addAll(ListaVenditori);
        ListaUtenti.addAll(ListaClienti);
        return ListaUtenti;
    }
    
    public Utente getUtenteUsername(String username){
        for(Utente u : getListaUtenti()){
            if(u.getUsername() == username)
                return u;
        }
        return null;
    }
    
     public ArrayList getListaOggetti(){
        return ListaOggetti;
    }
     
      public Oggetto  getNomeOgg(String nomeogg){
        for(Oggetto  o : ListaOggetti){
            if(o.getNomeOgg().equals(nomeogg))
                return o;
        }
        return null;
    }
      
}
