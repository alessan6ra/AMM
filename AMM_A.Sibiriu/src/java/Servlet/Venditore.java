/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classi.OggettiFactory;
import Classi.Oggetto;
import Classi.Utente;
import Classi.U_Venditore;
import Classi.UtentiFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alessandra
 */
@WebServlet(name = "Venditore", urlPatterns = {"/Venditore.html"})
public class Venditore extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException 
    {
        
    HttpSession session = request.getSession(false);
    request.setAttribute("riepilogo", false);
                
       
        if (session.getAttribute("loggato") == null) //se non è loggato
        {        
        request.getRequestDispatcher("venditore.jsp").forward(request, response);
        }

        else if(session.getAttribute("loggato") != null) //se è loggato
        {
            switch ((String)session.getAttribute("Utente"))
            {
                case("cliente"):  //se è cliente
                {
                request.setAttribute("isCliente", true);
                request.getRequestDispatcher("venditore.jsp").forward(request, response);
                break;
                }
                
                case ("venditore"): //se è un venditore
                {
                 
         
                    if(request.getParameter("SubmitVenditore") != null) //se ho cliccato il tasto per inserire oggetto
                    {
                        Oggetto oggettoAggiunto = new Oggetto(); 
                        oggettoAggiunto.setNome(request.getParameter("Nome"));
                        oggettoAggiunto.setDescrizione(request.getParameter("Descrizione"));
                        oggettoAggiunto.setUrl(request.getParameter("Url"));
                        
                        
                        Utente c = UtentiFactory.getInstance().getVenditore((Utente)session.getAttribute("venditore"));
                        oggettoAggiunto.setIdVend(c.getId()); //prende l'id del venditore da inserire nei parametri dell'oggetto messo in vendita

                        
                        try //prova ad inserirlo
                        {
                        oggettoAggiunto.setPezzi(Integer.parseInt(request.getParameter("Pezzi")));
                        } 
                        
                        catch (Exception e) //ad eccezione di questo valore
                        {
                        oggettoAggiunto.setPezzi(0);
                        }

                        try //prova ad inserirlo
                        {
                        oggettoAggiunto.setPrezzo(Double.parseDouble(request.getParameter("Prezzo")));
                        } 

                        catch (Exception e) //ad eccezione di questo valore
                        {
                        oggettoAggiunto.setPrezzo(0.0);
                        }
               
                        if (oggettoAggiunto.getNome() == null    //controllo per campi vuoti: se uno di questi è vuoto  
                            || oggettoAggiunto.getDescrizione() == null
                            || oggettoAggiunto.getUrl() == null 
                            || oggettoAggiunto.getPezzi() == 0 
                            || oggettoAggiunto.getPrezzo() == 0.0) 
                        {
                            
                            request.setAttribute("formIncompleto", true);
                            request.setAttribute("isCliente", false);
                           

                            request.getRequestDispatcher("venditore.jsp").forward(request, response);
                            
                        }
                        else  //se è tutto ok quindi tutto compilato
                        {
                           OggettiFactory.getInstance().AggiungiOggetto(oggettoAggiunto);
                            
                            request.setAttribute("oggettoAggiunto", oggettoAggiunto);
                            request.setAttribute("isCliente", false);                           
                            request.setAttribute("riepilogo", true);
                            request.getRequestDispatcher("venditore.jsp").forward(request, response);
                            
                        }
                    } 
                    
                    
                    else if (request.getParameter("OggettoCanc") != null) //se si è cliccato tasto per cancellare oggetto 
                    {
                        int idOggettoC = Integer.parseInt(request.getParameter("ID"));
                        Oggetto oggettoCanc = OggettiFactory.getInstance().getOggetto(idOggettoC);
                        OggettiFactory.getInstance().CancellaOggetto(idOggettoC);
                        
                        request.setAttribute("oggettoAggiunto", oggettoCanc);
                        request.setAttribute("riepilogo", true);
                        request.setAttribute("Delete", true);
                        request.getRequestDispatcher("venditore.jsp").forward(request, response);
                    }

                    else if (request.getParameter("OggettoMod") != null) //se si è cliccato oggetto per modificarlo
                    {
                        int idOggettoM = Integer.parseInt(request.getParameter("ID"));
                        Oggetto obj = OggettiFactory.getInstance().getOggetto(idOggettoM);
                        session.setAttribute("Obj", obj);
                        
                        request.setAttribute("Modifica", true);
                        request.setAttribute("isCliente", false);
                        request.getRequestDispatcher("venditore.jsp").forward(request, response);
                    }

                                        
                    else if (request.getParameter("AggiornaOggetto") != null) //nel form modifica oggetto se si cliccata tasto per salvare modifiche
                    {
                        Oggetto oggettoMod = new Oggetto();
                        oggettoMod.setNome(request.getParameter("Nome"));
                        oggettoMod.setUrl(request.getParameter("Url"));
                        oggettoMod.setDescrizione(request.getParameter("Descrizione"));
                        
                        Oggetto object = OggettiFactory.getInstance().getOggetto((Oggetto)session.getAttribute("Obj"));
                        oggettoMod.setId(object.getId());
                        
                        Utente v = UtentiFactory.getInstance().getVenditore((Utente)session.getAttribute("venditore"));
                        oggettoMod.setIdVend(v.getId());
                        
                        try {
                            oggettoMod.setPezzi(Integer.parseInt(request.getParameter("Pezzi")));
                        } 
                        
                        catch (Exception e) {
                            oggettoMod.setPezzi(0);
                        }

                        try {
                            oggettoMod.setPrezzo(Double.parseDouble(request.getParameter("Prezzo")));
                        } 

                        catch (Exception e) {
                            oggettoMod.setPrezzo(0);
                        }
                        
                        if (oggettoMod.getNome() != null && oggettoMod.getUrl() != null && oggettoMod.getDescrizione() != null &&
                            oggettoMod.getPezzi() != 0 && oggettoMod.getPrezzo() != 0.0)  //se tutto è compilato
                        {
                            OggettiFactory.getInstance().ModificaOggetto(oggettoMod);
                            request.setAttribute("oggettoAggiunto", oggettoMod);
                            request.setAttribute("riepilogo", true);
                            request.setAttribute("Modifica", false);
                            request.getRequestDispatcher("venditore.jsp").forward(request, response);
                    
                        }
                        else //se ci sono parti non compilate
                        {
                            request.setAttribute("errore", true);
                            request.setAttribute("formIncompleto", true);
                            request.getRequestDispatcher("venditore.jsp").forward(request, response);
                        }
                    }
                    

                    else if(request.getParameter("SubmitVenditore") == null && request.getParameter("OggettoMod") == null && request.getParameter("AggiornaOggetto") == null)
                    {
                        Utente u = UtentiFactory.getInstance().getVenditore((Utente)session.getAttribute("venditore"));
                        session.setAttribute("venditore", u);
                        request.getRequestDispatcher("venditore.jsp").forward(request, response);

                    }
                    
                    
                break;
                }
            }
        } 
    }
       

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
