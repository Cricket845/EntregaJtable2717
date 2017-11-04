/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.daoAgencia;
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
import modelo.Agencia;
import net.sf.json.JSONObject;

/**
 *
 * @author Victor1
 */
@WebServlet(name = "ControlA", urlPatterns = {"/ControlA"})
public class ControlA extends HttpServlet {
 private HttpServletRequest varRequest = null;
    private HttpServletResponse varResponse = null;
    private PrintWriter varOut = null;
    private HttpSession varSession = null;
    private daoAgencia daoAgencia = null;
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        daoAgencia= new daoAgencia();
        response.setContentType("text/html;charset=UTF-8");
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
        }
    }
private void list() throws SQLException {
        
        int IdUsuario = Integer.parseInt(varRequest.getParameter("IdUsuario"));
        JSONObject varJObjectLista = daoAgencia.select(IdUsuario);
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
        Agencia dat = new Agencia();
        dat.setIdUsuario(Integer.parseInt(varRequest.getParameter("IdUsuario").trim()));
        dat.setNombre(varRequest.getParameter("Nombre"));
        dat.setEstado(varRequest.getParameter("Estado"));
        dat.setDireccion(varRequest.getParameter("Direccion"));
        dat.setTelefono(varRequest.getParameter("Telefono"));
        JSONObject varJObjectNuevoRegistro = daoAgencia.insert(dat);
        varOut.print(varJObjectNuevoRegistro);
    }
    private void update() throws SQLException {
        Agencia dat = new Agencia();
         dat.setIdAgencia(Integer.parseInt(varRequest.getParameter("IdAgencia").trim()));
        dat.setIdUsuario(Integer.parseInt(varRequest.getParameter("IdUsuario").trim()));
        dat.setNombre(varRequest.getParameter("Nombre"));
        dat.setEstado(varRequest.getParameter("Estado"));
        dat.setDireccion(varRequest.getParameter("Direccion"));
        dat.setTelefono(varRequest.getParameter("Telefono"));
        JSONObject varJObjectNuevoRegistro = daoAgencia.update(dat);
        varOut.print(varJObjectNuevoRegistro);
    }
    private void delete() throws SQLException {
        String IdAgencia = varRequest.getParameter("IdAgencia").trim();
        JSONObject varJObjectLista = daoAgencia.delete(IdAgencia);
        varOut.print(varJObjectLista);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     try {
         processRequest(request, response);
     } catch (SQLException ex) {
         Logger.getLogger(ControlA.class.getName()).log(Level.SEVERE, null, ex);
     }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     try {
         processRequest(request, response);
     } catch (SQLException ex) {
         Logger.getLogger(ControlA.class.getName()).log(Level.SEVERE, null, ex);
     }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
