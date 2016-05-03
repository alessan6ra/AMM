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
public class Oggetto_venditaFactory {
    
    private static Oggetto_venditaFactory singleton;

    public static Oggetto_venditaFactory getIstanza() {
        if (singleton == null) {
            singleton = new Oggetto_venditaFactory();
        }
        return singleton;
    }

    
    // Lista oggetti vendita
     ArrayList<Oggetto_vendita> ListaOggetti_vendita = new ArrayList<Oggetto_vendita>();
        
   
    /* Costruttore */
    
    public Oggetto_venditaFactory () {

    // Oggetti in vendita        
        Oggetto_vendita o1 = new Oggetto_vendita ();
        o1.setNomeOgg("Orecchini Etnici");
        o1.setPrezzo(5);
        o1.setQuantità(2);
        o1.setImg("img/etnici.jpg");
        
        ListaOggetti_vendita.add(o1);
        
        Oggetto_vendita o2 = new Oggetto_vendita ();
        o2.setNomeOgg("Orecchini Minnie");
        o2.setPrezzo(2);
        o2.setQuantità(6);
        o2.setImg("img/minnie.jpg");
        
        ListaOggetti_vendita.add(o2);
       
        Oggetto_vendita o3 = new Oggetto_vendita ();
        o3.setNomeOgg("Orecchini Rose viola");
        o3.setPrezzo(3);
        o3.setQuantità(1);
        o3.setImg("M3/img/rose.jpg");
        ListaOggetti_vendita.add(o3);
        
        Oggetto_vendita o4 = new Oggetto_vendita ();
        o4.setNomeOgg("Orecchini Zampette");
        o4.setPrezzo(2);
        o4.setQuantità(5);
        o4.setImg("img/zampe.jpg");
        ListaOggetti_vendita.add(o4);
        
        Oggetto_vendita o5 = new Oggetto_vendita ();
        o5.setNomeOgg("Orecchini Cuoricini");
        o5.setPrezzo(3);
        o5.setQuantità(4);
        o5.setImg("img/cuori.jpg");
        ListaOggetti_vendita.add(o5);
        
        Oggetto_vendita o6 = new Oggetto_vendita ();
        o6.setNomeOgg("Orecchini Fiore");
        o6.setPrezzo(3);
        o6.setQuantità(1);
        o6.setImg("img/fiori.jpg"); 
        ListaOggetti_vendita.add(o6);
    
        //array oggetti vendita
        ArrayList<Oggetto_vendita> arrayOggetti_vendita1 = new ArrayList<Oggetto_vendita>();
        arrayOggetti_vendita1.add(o1);
        arrayOggetti_vendita1.add(o2);
        arrayOggetti_vendita1.add(o3); 
        
        ArrayList<Oggetto_vendita> arrayOggetti_vendita2 = new ArrayList<Oggetto_vendita>();
        arrayOggetti_vendita2.add(o4);
        arrayOggetti_vendita2.add(o5);
        arrayOggetti_vendita2.add(o6);   
        
    
        
    }
    
        
    }

