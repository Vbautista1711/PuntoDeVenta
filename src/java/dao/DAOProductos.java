
package dao;

import beans.Productos;
import conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DAOProductos {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Productos productos;

    public ArrayList mostrar() throws ClassNotFoundException {
        ArrayList<Productos> list = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try {
            con = ConexionMySQL.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                productos = new Productos();
                productos.setCodigo(rs.getInt("Codigo"));
                productos.setNombre(rs.getString("Nombre"));
                productos.setDescripcion(rs.getString("Descripcion"));
                productos.setCantidad(rs.getInt("Cantidad"));
                productos.setPrecio(rs.getInt("Precio"));
                list.add(productos);
            }
            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
        }
        return list;
    }

    public boolean agregar(Productos producto) throws ClassNotFoundException {

        String sql = "INSERT INTO productos ( Nombre, Descripcion, Cantidad, Precio) VALUES ('"
                + producto.getNombre() + "'," +
             "'" + producto.getDescripcion() + "',"+
                + producto.getCantidad() + ","
                + producto.getPrecio() + ")";

        try {
            con = ConexionMySQL.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
        }

        return true;

    }

    public Productos buscar(int codigo) throws ClassNotFoundException {

        String sql = "SELECT * FROM productos WHERE Codigo = " + codigo + " ";
        try {
            con = ConexionMySQL.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                productos = new Productos();
                productos.setCodigo(rs.getInt("Codigo"));
                productos.setNombre(rs.getString("Nombre"));
                productos.setDescripcion(rs.getString("Descripcion"));
                productos.setCantidad(rs.getInt("Cantidad"));
                productos.setPrecio(rs.getInt("Precio"));
            }
            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
        }
        return productos;

    }

    public boolean editar(Productos producto, int old) throws ClassNotFoundException 
    {
        String sql = "UPDATE productos SET "
                + " Nombre  = '" + producto.getNombre()+ "',"
                + " Descripcion  = '" + producto.getDescripcion()+ "',"
                + " Cantidad = " + producto.getCantidad()+","
                + " Precio = " + producto.getPrecio()
                + " WHERE productos.Codigo = " + old + "";

        try 
        {
            con = ConexionMySQL.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            con.close();

        } catch (SQLException ex) {
        }

        return true;
    }
    public boolean eliminar(int codigo) throws ClassNotFoundException
    {
     String sql= "DELETE FROM productos WHERE Codigo = " + codigo + "";
     
     try
     {
         con=ConexionMySQL.getConnection();
         ps=con.prepareStatement(sql);
         ps.executeUpdate();
         ps.close();
         con.close();
     } catch (SQLException e) {}
     
     return true;
    }

}
