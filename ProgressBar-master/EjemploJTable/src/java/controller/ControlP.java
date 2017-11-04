/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.daoPeriodico;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Periodico;
import net.sf.json.JSONObject;
/**
 *
 * @author Victor1
 */
@WebServlet(name = "ControlP", urlPatterns = {"/ControlP"})
public class ControlP extends HttpServlet {
  private HttpServletRequest varRequest = null;
    private HttpServletResponse varResponse = null;
    private PrintWriter varOut = null;
    private HttpSession varSession = null;
    private daoPeriodico daoPeriodico = null;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, SQLException {
        daoPeriodico= new daoPeriodico();
       
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("txt/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            varRequest = request;
            varResponse = response;
            varSession = request.getSession();
            varOut = varResponse.getWriter();
            if (varRequest.getParameter("action").equals("list")) {
               list();
            } else if (varRequest.getParameter("action").equals("create")) {
                create();
            } else if (varRequest.getParameter("action").equals("update")) {
            update();
            } else if (varRequest.getParameter("action").equals("delete")) {
                delete();
            }
            
            varOut.close();
        }    }
     private void list() throws SQLException {
        
        int IdUsuario = Integer.parseInt(varRequest.getParameter("IdUsuario"));
        JSONObject varJObjectLista = daoPeriodico.select(IdUsuario);
        varOut.print(varJObjectLista);
    }
     public boolean esNumero(String texto) {
        boolean es = false;
        try {
            Integer.parseInt(texto);
            es = true;
        } catch (Exception e) {
            es = false;
        }
        return es;
    }

    private void create() throws SQLException {
        Periodico dat = new Periodico();
        dat.setIdUsuario(Integer.parseInt(varRequest.getParameter("IdUsuario").trim()));
        dat.setNombre(varRequest.getParameter("Nombre"));
        dat.setEstado(varRequest.getParameter("Estado"));
        dat.setTipo(varRequest.getParameter("Tipo"));
        dat.setPrecio(varRequest.getParameter("Precio"));
        JSONObject varJObjectNuevoRegistro = daoPeriodico.insert(dat);
        varOut.print(varJObjectNuevoRegistro);
    }

    private void update() throws SQLException {
        Periodico dat = new Periodico();
         dat.setIdPeriodico(Integer.parseInt(varRequest.getParameter("IdPeriodico").trim()));
        dat.setIdUsuario(Integer.parseInt(varRequest.getParameter("IdUsuario").trim()));
        dat.setNombre(varRequest.getParameter("Nombre"));
        dat.setEstado(varRequest.getParameter("Estado"));
        dat.setTipo(varRequest.getParameter("Tipo"));
        dat.setPrecio(varRequest.getParameter("Precio"));
        JSONObject varJObjectNuevoRegistro = daoPeriodico.update(dat);
        varOut.print(varJObjectNuevoRegistro);
    }

    private void delete() throws SQLException {
        String IdPeriodico = varRequest.getParameter("IdPeriodico").trim();
        JSONObject varJObjectLista = daoPeriodico.delete(IdPeriodico);
        varOut.print(varJObjectLista);
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
          Logger.getLogger(ControlP.class.getName()).log(Level.SEVERE, null, ex);
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
          Logger.getLogger(ControlP.class.getName()).log(Level.SEVERE, null, ex);
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
