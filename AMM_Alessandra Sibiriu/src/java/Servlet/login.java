/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import classi.Factory;
import classi.Utente;
import classi.Venditore;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alessandra
 */
@WebServlet(name = "login", urlPatterns = {"/M3/login"})
public class login extends HttpServlet {

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
            throws ServletException, IOException { 
      response.setContentType("text/html;charset=UTF-8");
        
        //inizializzazione sessione
        HttpSession session = request.getSession(true);
        
        if (request.getParameter("Submit") != null) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            ArrayList<Utente> ListaUtenti = Factory.getInstance().getListaUtenti();

            for (Utente u : ListaUtenti) {
                if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                    
                    //attributi sessione
                    session.setAttribute("loggedId", true);
                    session.setAttribute("Username", u.getUsername());
                                        
                    if (u instanceof Venditore) {
                        session.setAttribute("venditore", u);                       
                        request.getRequestDispatcher("/M3/Venditore.html").forward(request, response);
                    }
                    else{
                        session.setAttribute("cliente", u);
                        request.getRequestDispatcher("/M3/Cliente.html").forward(request, response);
                    }
                }request.setAttribute("error" ,"Username o password non validi, riprova");
                 request.getRequestDispatcher("/M3/login.jsp").forward(request,response); 
            }
        } else if (request.getParameter("Submit") == null) 
         { 
            
             if (request.getParameter("LoggedIn")!=null) 
             {
                 switch ((String)  session.getAttribute("Utente"))   
                 { 
                    case ("cliente"):
                    {
                    request.setAttribute("ListaOggetti","ListaOggetti" );
                    request.setAttribute("buyer",true);
                    request.getRequestDispatcher("/M3/cliente.jsp").forward(request,response);
             break;
                    }
                    case ("venditore"):
                    {
                    request.setAttribute("seller",true);
                    request.getRequestDispatcher("/M3/venditore.jsp").forward(request, response);
             break;
                    }
                }
          
        } request.getRequestDispatcher("/M3/login.jsp").forward(request,response);
                
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