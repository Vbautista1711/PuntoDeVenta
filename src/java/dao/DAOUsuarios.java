
package dao;

import beans.Usuarios;
import conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOUsuarios {
    
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Usuarios usuarios;

    public ArrayList mostrar() throws ClassNotFoundException {
        ArrayList<Usuarios> list = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try {
            con = ConexionMySQL.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(); 
            while (rs.next()) {
                int i = 0;
                Usuarios usuario = new Usuarios();
                usuario.setCodigo(rs.getInt("Codigo"));
                usuario.setNombre(rs.getString("Nombre"));
                usuario.setApellidoP(rs.getString("ApellidoPaterno"));
                usuario.setApellidoM(rs.getString("ApellidoMaterno"));
                usuario.setEmail(rs.getString("Email"));
                usuario.setUsuario(rs.getString("Usuario"));
                usuario.setPassword(rs.getString("Password"));
                list.add(usuario);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
        }
        return list;
    }

    public boolean agregar(Usuarios usuario) throws ClassNotFoundException {
        String sql = "INSERT INTO usuarios ( Nombre, ApellidoPaterno, ApellidoMaterno, Email, Usuario, Password) VALUES ('"
                + usuario.getNombre() + "'," +
                 "'" + usuario.getApellidoP() + "',"
                + "'" + usuario.getApellidoM() + "',"
                + "'" + usuario.getEmail() + "',"
                + "'" + usuario.getUsuario() + "',"
                + "'" + usuario.getPassword() + "')";
                

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
    public boolean editar(Usuarios usuario, int old) throws ClassNotFoundException 
    {
        String sql = "UPDATE usuarios SET "
                + " Nombre  = '" + usuario.getNombre()+ "',"
                + " ApellidoPaterno  = '" + usuario.getApellidoP()+ "',"
                + " ApellidoMaterno = '" + usuario.getApellidoM()+ "',"
                + " Email  = '" + usuario.getEmail()+ "',"
                + " Usuario  = '" + usuario.getUsuario()+ "',"
                + " Password  = '" + usuario.getPassword()+ "'"
                + " WHERE Codigo = " + old + "";

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

    public Usuarios buscar(int codigo) throws ClassNotFoundException {

        String sql = "SELECT * FROM usuarios WHERE Codigo = " + codigo + " ";
        try {
            con = ConexionMySQL.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                usuarios = new Usuarios();
                usuarios.setCodigo(rs.getInt("Codigo"));
                usuarios.setNombre(rs.getString("Nombre"));
                usuarios.setApellidoP(rs.getString("ApellidoPaterno"));
                usuarios.setApellidoM(rs.getString("ApellidoMaterno"));
                usuarios.setEmail(rs.getString("Email"));
                usuarios.setUsuario(rs.getString("Usuario"));
                usuarios.setPassword(rs.getString("Password"));

            }
            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
        }
        return usuarios;

    }
    public boolean eliminar(int codigo) throws ClassNotFoundException
    {
     String sql= "DELETE FROM usuarios WHERE Codigo = " + codigo + "";
     
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
