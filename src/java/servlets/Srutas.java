/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Privado
 */
@WebServlet(name = "Srutas", urlPatterns = {"/Srutas"})
public class Srutas extends HttpServlet {

    String menu;
    String index;
    String productos;
    String usuarios;
    String categorias;
    String clientes;
    String ventas;

    String accion;
    String acceso;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        
        index="/vistas/Menu.jsp";
        categorias = "/vistas/Categorias.jsp";
        clientes = "/vistas/Clientes.jsp";
        productos = "/vistas/Productos.jsp";
        usuarios = "/vistas/Usuarios.jsp";
        ventas = "/vistas/Ventas.jsp";
        
        menu = "vistas/Menu.jsp";
        acceso = "";

        accion = request.getParameter("tfAccion");

        if(accion != null && accion.equalsIgnoreCase("menu")){
            acceso=menu;
        }
        else if (accion != null && accion.equalsIgnoreCase("Productos")) {
            acceso = productos;
        }
         else if (accion != null && accion.equalsIgnoreCase("Usuarios")) {
            acceso = usuarios;
        }
        else if (accion != null && accion.equalsIgnoreCase("Clientes")) {
            acceso = clientes;
        } 
        else if (accion != null && accion.equalsIgnoreCase("Categorias")) {
            acceso = categorias;
        }
        else if (accion != null && accion.equalsIgnoreCase("Ventas")) {
            acceso = ventas;
        } 
        else {
            acceso = index;
        }
        request.getRequestDispatcher(acceso).forward(request, response);
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
