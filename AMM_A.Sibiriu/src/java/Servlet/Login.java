/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classi.U_Cliente;
import Classi.OggettiFactory;
import Classi.Oggetto;
import Classi.Utente;
import Classi.UtentiFactory;
import Classi.U_Venditore;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"}, loadOnStartup = 0)
public class Login extends HttpServlet {

  private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";
    
 @Override 
    public void init(){
        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
           Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        UtentiFactory.getInstance().setConnectionString(dbConnection);
        OggettiFactory.getInstance().setConnectionString(dbConnection);
    } 
    

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
            throws ServletException, IOException{

        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        
        ArrayList<Oggetto> listaOggetti = OggettiFactory.getInstance().getListaOggetti();
        
    if(request.getParameter("Submit") != null) //se è stato cliccato tasto Login
    {
        String username = request.getParameter("Username");
        String password = request.getParameter("Password");
            
        Utente u = UtentiFactory.getInstance().getUtente(username, password);   
     
            if(u != null) //se è stato trovato utente con quei dati
            {   
            session.setAttribute("loggato", true); //loggato 
            session.setAttribute("id", u.getId());

                if(u instanceof U_Cliente) //se è un cliente
                { 
                request.setAttribute("isCliente", true);  //vero se è cliente falso se è venditore
                session.setAttribute("cliente", u); 
		session.setAttribute("Utente", "cliente");   
                request.setAttribute("listaOggetti", listaOggetti);
                request.getRequestDispatcher("cliente.jsp").forward(request, response);
                }
            
                else 
                {
                request.setAttribute("isCliente", false); //vero se è cliente falso se è venditore
                
                request.setAttribute("Modifica", false);
                
                session.setAttribute("Utente", "venditore");   
                session.setAttribute("venditore", u);  
                Utente u1 = UtentiFactory.getInstance().getVenditore((Utente)session.getAttribute("venditore"));
                
                ArrayList<Oggetto> listaOggettiVend = OggettiFactory.getInstance().getListaOggetti(u1);
                request.setAttribute("listaOggettiVenditore", listaOggettiVend); /////////////////////////////////////////////////////////
		
                request.getRequestDispatcher("venditore.jsp").forward(request, response);
                
                
                    
                }
            }
        
        request.setAttribute("errore", true); 
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    
            
    
    }
    
    else if(request.getParameter("Submit") == null) // se non ho cliccato su Login
    {
        
        if (session.getAttribute("loggato") != null) //se è loggato 
        {
            
            switch ((String) session.getAttribute("Utente")) 
            {
                case ("cliente"): //se è cliente
                {
                request.setAttribute("isCliente", true); //vero se è cliente falso se è venditore
                
                Utente u = UtentiFactory.getInstance().getCliente((Utente)session.getAttribute("cliente"));
                session.setAttribute("cliente", u);
                
                request.setAttribute("listaOggetti", listaOggetti);
                request.getRequestDispatcher("cliente.jsp").forward(request, response);
                break;
                
                
                }
                
                case ("venditore"): //se è venditore
                {
                    Utente u = UtentiFactory.getInstance().getVenditore((Utente)session.getAttribute("venditore"));
                    session.setAttribute("venditore", u);
                            
                    request.setAttribute("isCliente", false);
                    request.setAttribute("riepilogo", false);
                    request.setAttribute("Update", false);
                            
                    Utente u1 = UtentiFactory.getInstance().getVenditore((Utente)session.getAttribute("venditore"));
                    ArrayList<Oggetto> listaOggettiVend = OggettiFactory.getInstance().getListaOggetti(u1);
                    request.setAttribute("listaOggettiVenditore", listaOggettiVend); ///////////////////////////////////////////////////////////////
                            
                    request.getRequestDispatcher("Login_Venditore.jsp").forward(request, response);
                        
                                
                break;
                }
            }
        }
        else  //se non è stato cliccato tasto login e non è gia loggato mi rimanda alla pagina login
        {
        request.getRequestDispatcher("Login.jsp").forward(request, response);
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
