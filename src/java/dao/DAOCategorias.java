
package dao;

import beans.Categorias;
import conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DAOCategorias {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Categorias categorias;

    public ArrayList mostrar() throws ClassNotFoundException {
        ArrayList<Categorias> list = new ArrayList<>();
        String sql = "SELECT * FROM categorias";
        try {
            con = ConexionMySQL.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                categorias = new Categorias();
                categorias.setCodigo(rs.getInt("Codigo"));
                categorias.setNombre(rs.getString("Nombre"));
                
                list.add(categorias);
            }
            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
        }
        return list;
    }

    public boolean agregar(Categorias categoria) throws ClassNotFoundException {

        String sql = "INSERT INTO categorias (Nombre) VALUES ('"
                + categoria.getNombre() +"')";

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

    public Categorias buscar(int codigo) throws ClassNotFoundException {

        String sql = "SELECT * FROM categorias WHERE Codigo = " + codigo + " ";
        try {
            con = ConexionMySQL.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                categorias = new Categorias();
                categorias.setCodigo(rs.getInt("Codigo"));
                categorias.setNombre(rs.getString("Nombre"));
                
            }
            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
        }
        return categorias;

    }

    public boolean editar(Categorias categoria, int old) throws ClassNotFoundException 
    {
        String sql = "UPDATE categorias SET "
                + " Nombre  = '" + categoria.getNombre()+ "'"
                + " WHERE categorias.Codigo = " + old + "";

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
     String sql= "DELETE FROM categorias WHERE Codigo = " + codigo + "";
     
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
