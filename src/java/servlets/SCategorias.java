
package servlets;

import beans.Categorias;
import dao.DAOCategorias;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SCategorias", urlPatterns = {"/SCategorias"})
public class SCategorias extends HttpServlet {

    String menu;
    String agregaar;
    String editar;

    String accion;
    String acceso;

    private Categorias categoria;
    private DAOCategorias daoCategorias;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException{
        response.setContentType("text/html;charset=UTF-8");
        
        agregaar = "/vistas/Categorias.jsp";
        String cate = "/vistas/Categorias.jsp";
        String Clien = "/vistas/Clientes.jsp";
        String produc = "/vistas/Productos.jsp";
        String usua = "/vistas/Usuarios.jsp";
        String venta = "/vistas/Ventas.jsp";
        
        menu = "vistas/Menu.jsp";
        acceso = "";

        accion = request.getParameter("tfAccion");

        if (accion != null && accion.equalsIgnoreCase("Registrar")) {

            Categorias categoria = new Categorias();

            categoria.setNombre(request.getParameter("tfNombre"));
            

            daoCategorias = new DAOCategorias();
            daoCategorias.agregar(categoria);
            acceso = agregaar;

        } 
        else if (accion != null && accion.equalsIgnoreCase("editar")) {
            request.setAttribute("codigo", request.getParameter("tfCodigoP"));
            acceso = agregaar;
        } 
        else if (accion != null && accion.equalsIgnoreCase("Actualizar")) {

            Categorias categorias = new Categorias();
            int codigo = (Integer.parseInt(request.getParameter("tfCodigo")));
            categorias.setNombre(request.getParameter("tfNombre"));

            daoCategorias = new DAOCategorias();
            daoCategorias.editar(categorias, codigo);
            acceso = agregaar;

        } 
        else if (accion != null && accion.equalsIgnoreCase("eliminar")) {
            int codigo = (Integer.parseInt(request.getParameter("tfCodigoP")));
            daoCategorias = new DAOCategorias();
            daoCategorias.eliminar(codigo);
            acceso = agregaar;
        }
        else if (accion != null && accion.equalsIgnoreCase("Categorias")) {
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
            Logger.getLogger(SCategorias.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SCategorias.class.getName()).log(Level.SEVERE, null, ex);
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
