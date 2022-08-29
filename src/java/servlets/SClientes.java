/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Clientes;
import dao.DAOClientes;
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
@WebServlet(name = "SClientes", urlPatterns = {"/SClientes"})
public class SClientes extends HttpServlet {

    String menu;
    String agregaar;
    String editar;

    String accion;
    String acceso;
    
    
    private DAOClientes daoClientes;
    private Clientes clientes;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");

        agregaar = "/vistas/Clientes.jsp";
        String cate = "/vistas/Categorias.jsp";
        String clien = "/vistas/Clientes.jsp";
        String produc = "/vistas/Productos.jsp";
        String usua = "/vistas/Usuarios.jsp";
        String venta = "/vistas/Ventas.jsp";
        menu = "vistas/Menu.jsp";
        acceso = "";

        accion = request.getParameter("tfAccion");
        
        if(accion!=null && accion.equalsIgnoreCase("Registrar"))
       {
            Clientes cliente = new Clientes();
            
           cliente.setNombre(request.getParameter("tfNombre"));
           cliente.setApellidoP(request.getParameter("tfApellidoP"));
           cliente.setApellidoM(request.getParameter("tfApellidoM"));
           cliente.setDireccion(request.getParameter("tfDirec"));
           cliente.setTelefono(Integer.parseInt(request.getParameter("tfTel")));
           
           DAOClientes daoClientes = new DAOClientes();
           daoClientes.agregar(cliente);
           
           acceso = agregaar;
           
       }
       else if (accion != null && accion.equalsIgnoreCase("editar")) {
            request.setAttribute("codigo", request.getParameter("tfCodigoP"));
            acceso = agregaar;
        }
       else if (accion != null && accion.equalsIgnoreCase("Actualizar")) {

            clientes = new Clientes();
            int codigo = (Integer.parseInt(request.getParameter("tfCodigo")));
            clientes.setNombre(request.getParameter("tfNombre"));
            clientes.setApellidoP(request.getParameter("tfApellidoP"));
            clientes.setApellidoM(request.getParameter("tfApellidoM"));
            clientes.setDireccion(request.getParameter("tfDirec"));
            
            clientes.setTelefono(Integer.parseInt(request.getParameter("tfTel")));


            daoClientes = new DAOClientes();
            daoClientes.editar(clientes, codigo);
            acceso = agregaar;

        } 

       else if (accion != null && accion.equalsIgnoreCase("eliminar")) {
            int codigo = (Integer.parseInt(request.getParameter("tfCodigoP")));
            daoClientes = new DAOClientes();
            daoClientes.eliminar(codigo);
            acceso = agregaar;
        }
       else if (accion != null && accion.equalsIgnoreCase("Clientes")) {
            acceso = agregaar;
        }
       else if (accion != null && accion.equalsIgnoreCase("Productos")) {
            acceso = produc;
        } 
        else if (accion != null && accion.equalsIgnoreCase("Clientes")) {
            acceso = clien;
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
            Logger.getLogger(SClientes.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SClientes.class.getName()).log(Level.SEVERE, null, ex);
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
