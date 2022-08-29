/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Productos;
import dao.DAOProductos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Privado
 */
@WebServlet(name = "SRProductos", urlPatterns = {"/SRProductos"})
public class SProductos extends HttpServlet {

    String menu;
    String agregaar;
    String editar;

    String accion;
    String acceso;

    private Productos producto;
    private DAOProductos daoProductos;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");

        agregaar = "/vistas/Productos.jsp";
        String cate = "/vistas/Categorias.jsp";
        String Clien = "/vistas/Clientes.jsp";
        String produc = "/vistas/Productos.jsp";
        String usua = "/vistas/Usuarios.jsp";
        String venta = "/vistas/Ventas.jsp";
        menu = "vistas/Menu.jsp";
        acceso = "";

        accion = request.getParameter("tfAccion");

        if (accion != null && accion.equalsIgnoreCase("Registrar")) {

            Productos producto = new Productos();

            producto.setNombre(request.getParameter("tfNombre"));
            producto.setDescripcion(request.getParameter("tfDescripcion"));
            producto.setCantidad(Integer.parseInt(request.getParameter("tfCantidad")));
            producto.setPrecio(Integer.parseInt(request.getParameter("tfCant")));

            daoProductos = new DAOProductos();
            daoProductos.agregar(producto);
            acceso = agregaar;

        } 
        else if (accion != null && accion.equalsIgnoreCase("editar")) {
            request.setAttribute("codigo", request.getParameter("tfCodigoP"));
            acceso = agregaar;
        } 
        else if (accion != null && accion.equalsIgnoreCase("Actualizar")) {

            Productos productos = new Productos();
            int codigo = (Integer.parseInt(request.getParameter("tfCodigo")));
            productos.setNombre(request.getParameter("tfNombre"));
            productos.setDescripcion(request.getParameter("tfDescripcion"));
            
            productos.setCantidad(Integer.parseInt(request.getParameter("tfCantidad")));
            productos.setPrecio(Integer.parseInt(request.getParameter("tfCant")));

            daoProductos = new DAOProductos();
            daoProductos.editar(productos, codigo);
            acceso = agregaar;

        } 
        else if (accion != null && accion.equalsIgnoreCase("eliminar")) {
            int codigo = (Integer.parseInt(request.getParameter("tfCodigoP")));
            daoProductos = new DAOProductos();
            daoProductos.eliminar(codigo);
            acceso = agregaar;
        }
        else if (accion != null && accion.equalsIgnoreCase("Productos")) {
            acceso = agregaar;
        } 
        else if (accion != null && accion.equalsIgnoreCase("Clientes")) {
            acceso = Clien;
        } 
        else if (accion != null && accion.equalsIgnoreCase("Productos")) {
            acceso = produc;
        } 
        else if (accion != null && accion.equalsIgnoreCase("Categorias")) {
            acceso = cate;
        }
        else if (accion != null && accion.equalsIgnoreCase("Usuarios")) {
            acceso = usua;
        }
        else if (accion != null && accion.equalsIgnoreCase("Ventas")) {
            acceso = venta;
        }

        else {
            acceso = menu;
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SProductos.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SProductos.class.getName()).log(Level.SEVERE, null, ex);
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
