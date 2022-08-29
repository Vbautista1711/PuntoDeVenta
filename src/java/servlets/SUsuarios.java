
package servlets;

import beans.Usuarios;
import dao.DAOUsuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SUsuarios", urlPatterns = {"/SUsuarios"})
public class SUsuarios extends HttpServlet {
    
    String menu;
    String agregaar;
    String editar;

    String accion;
    String acceso;
    
    
    private DAOUsuarios daoUsuarios;
    private Usuarios usuarios;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        
        agregaar = "/vistas/Usuarios.jsp";
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
            Usuarios usuario = new Usuarios();
            
           usuario.setNombre(request.getParameter("tfNombre"));
           usuario.setApellidoP(request.getParameter("tfApellidoP"));
           usuario.setApellidoM(request.getParameter("tfApellidoM"));
           usuario.setEmail(request.getParameter("tfEmail"));
           usuario.setUsuario(request.getParameter("tfUsuario"));
           usuario.setPassword(request.getParameter("tfPassword"));
           
           DAOUsuarios daoUsuarios = new DAOUsuarios();
           daoUsuarios.agregar(usuario);
           
           acceso = agregaar;
           
       }
       else if (accion != null && accion.equalsIgnoreCase("editar")) {
            request.setAttribute("codigo", request.getParameter("tfCodigoP"));
            acceso = agregaar;
        }
       else if (accion != null && accion.equalsIgnoreCase("Actualizar")) {

            usuarios = new Usuarios();
            int codigo = (Integer.parseInt(request.getParameter("tfCodigo")));
            usuarios.setNombre(request.getParameter("tfNombre"));
            usuarios.setApellidoP(request.getParameter("tfApellidoP"));
            usuarios.setApellidoM(request.getParameter("tfApellidoM"));
            usuarios.setEmail(request.getParameter("tfEmail"));
            usuarios.setUsuario(request.getParameter("tfUsuario"));
            usuarios.setPassword(request.getParameter("tfPassword"));


            daoUsuarios = new DAOUsuarios();
            daoUsuarios.editar(usuarios, codigo);
            acceso = agregaar;

        } 

       else if (accion != null && accion.equalsIgnoreCase("eliminar")) {
            int codigo = (Integer.parseInt(request.getParameter("tfCodigoP")));
            daoUsuarios = new DAOUsuarios();
            daoUsuarios.eliminar(codigo);
            acceso = agregaar;
        }
       else if (accion != null && accion.equalsIgnoreCase("Usuarios")) {
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
            Logger.getLogger(SUsuarios.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SUsuarios.class.getName()).log(Level.SEVERE, null, ex);
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
