/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Alessandra
 */
public class OggettiFactory {
    
    
    //Attributi
    private static OggettiFactory singleton;
    String connectionString;
    
    
    public static OggettiFactory getInstance()
    {
        if (singleton == null) {
            singleton = new OggettiFactory();
        }
        return singleton;
    }
    
    
    //Costruttore
    private OggettiFactory() { }
        
    
    
    //Metodi
    
    
    public void setConnectionString(String s)
    {
	this.connectionString = s;
    }
    
    public String getConnectionString()
    {
	return this.connectionString;
    } 
    
    
    //Ricavo oggetto a partire da id
    public Oggetto getOggetto(int id){
        try {       
        Connection conn = DriverManager.getConnection(connectionString, "alessandra", "123456");
        String query = "SELECT * FROM Oggetto WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);
        ResultSet r = stmt.executeQuery();
        
        if(r.next()){
            Oggetto o = new Oggetto();
            o.setId(r.getInt("id"));
            o.setNome(r.getString("nome"));
            o.setDescrizione(r.getString("descrizione"));
            o.setUrl(r.getString("url"));
            o.setPezzi(r.getInt("pezzi"));
            o.setPrezzo(r.getDouble("prezzo"));           
            o.setIdVend(r.getInt("idVend"));
            
            stmt.close();
            conn.close();
            return o;
        }
        
        stmt.close();
        conn.close();
        } 
        catch (Exception e) {
           
        }
        
        return null;       
    }
    
    //Ricavo oggetto a partire da parametri
    public Oggetto getOggetto(Oggetto obj) 
    {
        try {       
        Connection conn = DriverManager.getConnection(connectionString, "alessandra", "123456");
        String query = "SELECT * FROM Oggetto WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, obj.id);
        ResultSet r = stmt.executeQuery();
        
        if(r.next()){
             Oggetto o = new Oggetto();
            o.setId(r.getInt("id"));
            o.setNome(r.getString("nome"));
            o.setDescrizione(r.getString("descrizione"));
            o.setUrl(r.getString("url"));
            o.setPezzi(r.getInt("pezzi"));
            o.setPrezzo(r.getDouble("prezzo"));           
            o.setIdVend(r.getInt("idVend"));
            
            stmt.close();
            conn.close();
            return o;
        }
        
        stmt.close();
        conn.close();
        } 
        catch (Exception e) {
          
        }
        
        return null;       
    }

    //ricavo la lista oggetti venduti nello shop 
    
    public ArrayList<Oggetto> getListaOggetti(){
        ArrayList<Oggetto> listaOggetti = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(connectionString, "alessandra", "123456");
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM Oggetto";
            ResultSet r = stmt.executeQuery(query);
            
            while(r.next()){
            Oggetto o = new Oggetto();
            o.setId(r.getInt("id"));
            o.setNome(r.getString("nome"));
            o.setDescrizione(r.getString("descrizione"));
            o.setUrl(r.getString("url"));
            o.setPezzi(r.getInt("pezzi"));
            o.setPrezzo(r.getDouble("prezzo"));           
            o.setIdVend(r.getInt("idVend"));
            listaOggetti.add(o);
            }
            
            stmt.close();
            conn.close();
        }
        catch (Exception e) {
            
        }
        return listaOggetti;        
    }
    
    //ricavo la lista degli oggetti venduti dal vendiitore a partire da suo id
    public ArrayList<Oggetto> getListaOggetti(Utente venditore){
        ArrayList<Oggetto> listaOggetti = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(connectionString, "alessandra", "123456");
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM Oggetto WHERE idVend =" + venditore.getId();
            ResultSet r = stmt.executeQuery(query);
            
            while(r.next()){
            Oggetto o = new Oggetto();
            o.setId(r.getInt("id"));
            o.setNome(r.getString("nome"));
            o.setDescrizione(r.getString("descrizione"));
            o.setUrl(r.getString("url"));
            o.setPezzi(r.getInt("pezzi"));
            o.setPrezzo(r.getDouble("prezzo"));           
            o.setIdVend(r.getInt("idVend"));
            listaOggetti.add(o);
                
            }
            
            stmt.close();
            conn.close();
        }
        catch (Exception e) {
        
        }
        return listaOggetti;        
    }   
    
    
    
   //inserire oggetto
    public void AggiungiOggetto(Oggetto oggetto) {
        try {  
            Connection conn = DriverManager.getConnection(connectionString, "alessandra", "123456");
            
            String query = "INSERT INTO Oggetto (id, nome, descrizione, url, pezzi, prezzo, idVend)"
                                   + "values (default, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, oggetto.getNome());
            stmt.setString(2, oggetto.getDescrizione());
            stmt.setString(3, oggetto.getUrl());
            stmt.setInt(4, oggetto.getPezzi());   
            stmt.setDouble(5, oggetto.getPrezzo());     
            stmt.setInt(6, oggetto.getIdVend());     
        
            int r1 = stmt.executeUpdate();
        
            if (r1 == 1){
                System.out.println("\nComplimenti hai appena messo in vendita un oggetto nello shop\n");
            }
            
            stmt.close();
            conn.close();
        } 
        catch (Exception e) {
           
        }
    } 
   
       //modificare oggetto
    public void ModificaOggetto(Oggetto oggetto) {
        try {  
            Connection conn = DriverManager.getConnection(connectionString, "alessandra", "123456");
            String query = "UPDATE Oggetto SET nome = ?, descrizione = ?, url = ? , pezzi = ?, prezzo = ? WHERE id = " + oggetto.getId();
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, oggetto.getNome());
            stmt.setString(2, oggetto.getDescrizione());
            stmt.setString(3, oggetto.getUrl());
            stmt.setInt(4, oggetto.getPezzi());       
            stmt.setDouble(5, oggetto.getPrezzo());
            
            int r1 = stmt.executeUpdate();
        
            if (r1 == 1){
                System.out.println("\nLa modifica dell'oggetto selezionato è avvenuta correttamente\n");
            }
            
            stmt.close();
            conn.close();
        } 
        catch (Exception e) {
         
        }
    } 

       //cancellare oggetto
    public void CancellaOggetto(int id) {
        try {  
             
            Connection conn = DriverManager.getConnection(connectionString, "alessandra", "123456");
            String query = "DELETE FROM Oggetto WHERE id = " + id;
            PreparedStatement stmt = conn.prepareStatement(query);
       
            int r1 = stmt.executeUpdate();
        
            if (r1 == 1){
                System.out.println("\nHai appena cancellato dallo shop l'oggetto selezionato \n");
            }
            
            stmt.close();
            conn.close();
        } 
        catch (Exception e) {
           
        }
    }
    
    //per ricercare valori dalla lista MILESTONE 5
    public ArrayList<Oggetto> getRicercaLista(String text){
        ArrayList<Oggetto> listaOggetti = new ArrayList<>();
        
        try {
            Connection conn = DriverManager.getConnection(connectionString, "alessandra", "123456");
            String query = "SELECT * FROM Oggetto WHERE nome LIKE ? OR descrizione LIKE ? ";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            text = "%" + text + "%";
            stmt.setString(1,text);
            stmt.setString(2, text);
            
            ResultSet r = stmt.executeQuery();
            
            while(r.next()){
                Oggetto o = new Oggetto();
                o.setId(r.getInt("id"));
                o.setNome(r.getString("nome"));
                o.setDescrizione(r.getString("descrizione"));
                o.setUrl(r.getString("url"));
                o.setPezzi(r.getInt("pezzi"));
                o.setPrezzo(r.getDouble("prezzo"));  
                o.setIdVend(r.getInt("idVend"));
                listaOggetti.add(o);
            }
            
            stmt.close();
            conn.close();       
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return listaOggetti;
    }
    
    
    
}
