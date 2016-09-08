/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classi.OggettiFactory;
import Classi.Oggetto;
import Classi.Utente;
import Classi.UtentiFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "Cliente", urlPatterns = {"/Cliente.html"})
public class Cliente extends HttpServlet {

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
            throws ServletException, IOException, SQLException 
    { 
        
    HttpSession session = request.getSession(false);
    
    
    ArrayList<Oggetto> listaOggetti = OggettiFactory.getInstance().getListaOggetti();

    
    
    request.setAttribute("riepilogo", false);
       
        
        
        if(session.getAttribute("loggato") == null) //se non è loggato
        {
        request.getRequestDispatcher("cliente.jsp").forward(request, response);
        }
        
        
        else if (session.getAttribute("loggato") != null) //se è loggato
        {
            switch ((String)session.getAttribute("Utente"))
            {
                case ("venditore"): //se è venditore
                {
                request.setAttribute("isCliente", false);
                
                request.getRequestDispatcher("cliente.jsp").forward(request, response);
                break;
                }
                
                case ("cliente"): //se è cliente
                {    
                    String a = request.getParameter("OggClick");          
                
                    if (request.getParameter("OggClick") != null) //se è stato scelto un oggetto (quindi cliccato su aggiungi) lo associa ad oggetto scelto
                    {
                        Oggetto oggettoScelto = OggettiFactory.getInstance().getOggetto(Integer.parseInt(request.getParameter("OggClick")));

                    request.setAttribute("oggetto", oggettoScelto);
                    request.setAttribute("riepilogo", true);
                    
                    request.getRequestDispatcher("cliente.jsp").forward(request, response);                     
                    }  
                    
                    else if (request.getParameter("OggClickConfermato") != null) // se è stato anche confermato l'oggetto del riepilogo
                    {                                      
                        Oggetto oggettoScelto = OggettiFactory.getInstance().getOggetto(Integer.parseInt(request.getParameter("OggClickConfermato")));
                                                
                        Utente u = UtentiFactory.getInstance().getCliente((Utente)session.getAttribute("cliente")); 
                        session.setAttribute("cliente", u);
                        String acquisto = UtentiFactory.getInstance().AggiornaSaldo(oggettoScelto, (Utente) session.getAttribute("cliente"));
                        
                        if (acquisto != null) //cosa può succedere con l'acquisto 
                            switch (acquisto) 
                            {
                                case ("saldoaggiornato"): //tutto ok
                                {
                                    request.setAttribute("oggetto", oggettoScelto);
                                    request.setAttribute("acquistoCompletato", true);
                                    request.getRequestDispatcher("cliente.jsp").forward(request, response);
                                    break;
                                }
                                case ("saldoinsufficiente"): //non ha abbastanza credito
                                {
                                    request.setAttribute("acquistoFallito", true);
                                    request.getRequestDispatcher("cliente.jsp").forward(request, response);
                                    break;
                                }
                                case ("saldoNONaggiornato"): //errori di acquisto
                                {
                                    request.setAttribute("acquistoFallito", true);
                                    request.getRequestDispatcher("cliente.jsp").forward(request, response);
                                    break;
                                }
                            }
                    }

                    else
                    {
                    request.setAttribute("isCliente", true); 
                    
                    request.setAttribute("listaOggetti", listaOggetti);
                    request.setAttribute("cliente", (Utente)session.getAttribute("cliente"));
                    request.getRequestDispatcher("cliente.jsp").forward(request, response);                     
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
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
