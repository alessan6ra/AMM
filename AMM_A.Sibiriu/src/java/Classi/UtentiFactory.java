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
public class UtentiFactory 
{
    //Attributi
    private static UtentiFactory singleton;
    String connectionString;
    
    public static UtentiFactory getInstance() 
    {
        if (singleton == null)
        {
            singleton = new UtentiFactory();
        }
        return singleton;
    }   
    
    
    
    //Costruttore
    private UtentiFactory() {}
    
  
// Metodi 
    
    
    public void setConnectionString(String s)
    {
	this.connectionString = s;
    }
    
    public String getConnectionString()
    {
	return this.connectionString;
    }
       
    
    
     //ricavare dati utente (venditore e cliente ) da username e psw
    public Utente getUtente(String username, String password)
    {
        try 
        {
            try (Connection conn = DriverManager.getConnection(connectionString, "alessandra", "123456")) 
            {
                String query = "SELECT * FROM Venditore WHERE username = ? and password = ? ";
                
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, username);
                stmt.setString(2, password);
                
                ResultSet r = stmt.executeQuery();
                
                if(r.next()){
                U_Venditore v = new U_Venditore();
                v.setId(r.getInt("id"));
                v.setUsername(r.getString("username"));
                v.setPassword(r.getString("password"));
                v.setSaldo(new Saldo(r.getDouble("saldo")));
                    
                    stmt.close();
                    conn.close();
                    return v;
                }
                
                query = "SELECT * FROM Cliente WHERE username = ? and password = ? ";
                stmt = conn.prepareStatement(query);
                stmt.setString(1, username);
                stmt.setString(2, password);
                r = stmt.executeQuery();
                
                if(r.next()){
                U_Cliente c = new U_Cliente();
                c.setId(r.getInt("id"));
                c.setUsername(r.getString("username"));
                c.setPassword(r.getString("password"));
                c.setSaldo(new Saldo(r.getDouble("saldo")));
                
                stmt.close();
                conn.close();
                return c;
                    
                }
                
                stmt.close();
                conn.close();
            }
        } 
        
        catch (Exception e) { }
        
        return null;
    }
    
    
     //ricavo dati cliente da suo id
     public Utente getCliente(Utente utente)
     {
        try 
        {
            Connection conn = DriverManager.getConnection(connectionString, "alessandra", "123456");
            
            String query = "SELECT * FROM Cliente WHERE id = " + utente.getId();
            Statement stmt = conn.createStatement();
            ResultSet r = stmt.executeQuery(query);
            
            if(r.next())
            {
                U_Cliente c = new U_Cliente();
                c.setId(r.getInt("id"));
                c.setUsername(r.getString("username"));
                c.setPassword(r.getString("password"));
                c.setSaldo(new Saldo(r.getDouble("saldo")));
                
                stmt.close();
                conn.close();
                return c;
            }
            stmt.close();
            conn.close();
        }
        catch (Exception e) { }
        return null;
    }
    
      //ricavare dati venditore da suo id
    public Utente getVenditore(Utente utente)
    {
        try 
        {
            Connection conn = DriverManager.getConnection(connectionString, "alessandra", "123456");
            
            String query = "SELECT * FROM Venditore WHERE id = " + utente.getId();
            Statement stmt = conn.createStatement();
            ResultSet r = stmt.executeQuery(query);
            
            if(r.next())
            {
                U_Venditore v = new U_Venditore();
                v.setId(r.getInt("id"));
                v.setUsername(r.getString("username"));
                v.setPassword(r.getString("password"));
                v.setSaldo(new Saldo(r.getDouble("saldo")));
                
                stmt.close();
                conn.close();
                return v;
            }
            stmt.close();
            conn.close();
        }
        catch (Exception e) { }
        return null;
    }
    
   
    
    
    //restituisce saldo del cliente da id
    public Double getSaldo(int idCliente) throws SQLException
    {
        Double saldo = null;
        try 
        {
            Connection conn = DriverManager.getConnection(connectionString, "alessandra", "123456");
            String query = "SELECT saldo FROM Cliente WHERE id = " + idCliente;
            Statement stmt = conn.createStatement();
            ResultSet r = stmt.executeQuery(query);
               
            if (r.next())
            {
                saldo = r.getDouble("saldo");
            }
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
         
        }
        return saldo;
    }
    
    
    //per la transazione modifica il saldo del cliente e venditore
    
    public String AggiornaSaldo(Oggetto o, Utente cliente) throws SQLException 
    {
        Connection conn = DriverManager.getConnection(connectionString, "alessandra", "123456");
        PreparedStatement aggiornaOggetti = null;
        PreparedStatement aggiornaCreditoCliente = null; 
        PreparedStatement aggiornaCreditoVenditore = null;
        PreparedStatement aggiornaPezziDisp = null;
        
        String cancellaOggetto = "DELETE from Oggetto where id = ?";
        String aggiornaPezzi = "UPDATE Oggetto SET pezzi = pezzi - 1 WHERE id = ? ";
        String aggiornaSaldoCliente = "UPDATE Cliente SET saldo = saldo - ? WHERE id = ? ";
        String aggiornaSaldoVenditore = "UPDATE Venditore SET saldo = saldo + ? WHERE id = ? ";
        
        try {
            conn.setAutoCommit(false);
            
            double saldo = getSaldo(cliente.getId());
            
            //se prezzo oggetto è minore del saldo del cliente
            if (o.getPrezzo() < saldo)
            {
                if (o.getPezzi() == 1) //se ho un solo pezzo disponibile
                {
                    aggiornaOggetti = conn.prepareStatement(cancellaOggetto); 
                    aggiornaCreditoCliente = conn.prepareStatement(aggiornaSaldoCliente); 
                    aggiornaCreditoVenditore = conn.prepareStatement(aggiornaSaldoVenditore); 
                
                    aggiornaOggetti.setInt(1, o.getId());
                
                    aggiornaCreditoCliente.setDouble(1, o.getPrezzo());
                    aggiornaCreditoCliente.setInt(2, cliente.getId());
            
                    aggiornaCreditoVenditore.setDouble(1, o.getPrezzo());
                    aggiornaCreditoVenditore.setInt(2, o.getIdVend());              
                            
                    int res1 = aggiornaOggetti.executeUpdate();
                    int res2 = aggiornaCreditoCliente.executeUpdate();
                    int res3 = aggiornaCreditoVenditore.executeUpdate();
                
                    if(res1 != 1 || res2 !=1 || res3 != 1 )
                    { //se va male una di queste torna al punto di partenza
                        conn.rollback();
                        return "fallita";
                    }
                }
                else if (o.getPezzi() > 1) // se ho piu pezzi disponibili
                {
                    aggiornaPezziDisp = conn.prepareStatement(aggiornaPezzi);
                    aggiornaCreditoCliente = conn.prepareStatement(aggiornaSaldoCliente);
                    aggiornaCreditoVenditore = conn.prepareStatement(aggiornaSaldoVenditore);
                
                    aggiornaPezziDisp.setInt(1, o.getId());
                          
                    aggiornaCreditoCliente.setDouble(1, o.getPrezzo());
                    aggiornaCreditoCliente.setInt(2, cliente.getId());
            
                    aggiornaCreditoVenditore.setDouble(1, o.getPrezzo());
                    aggiornaCreditoVenditore.setInt(2, o.getIdVend());              
                            
                    int res1 = aggiornaPezziDisp.executeUpdate();
                    int res2 = aggiornaCreditoCliente.executeUpdate();
                    int res3 = aggiornaCreditoVenditore.executeUpdate();
                
                    if(res1 != 1 || res2 !=1 || res3 != 1 )//se va male una di queste torna al punto di partenza
                    { 
                        conn.rollback();
                        return "saldoNONaggiornato";
                    }
                }   
                conn.commit();
                return "saldoaggiornato";
            }
                        
            else   //se il prezzo è maggiore del saldo del cliente
            {
                return "saldoinsufficiente";
            }
        } 
        catch (SQLException e)
        {
            conn.rollback();
            throw e;
        }
        finally 
        {
            if(aggiornaOggetti != null)
            {
                aggiornaOggetti.close();
            }
            if(aggiornaCreditoCliente != null)
            {
                aggiornaCreditoCliente.close();
            }
            if(aggiornaCreditoVenditore != null)
            {
                aggiornaCreditoVenditore.close();
            }
            if(aggiornaPezziDisp != null)
            {
                aggiornaPezziDisp.close();
            }
        }
    }
    
}