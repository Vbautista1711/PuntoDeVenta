package dao;

import beans.Clientes;
import conexion.ConexionMySQL;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOClientes {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Clientes clientes;

    public ArrayList mostrar() throws ClassNotFoundException {
        ArrayList<Clientes> list = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try {
            con = ConexionMySQL.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(); 
            while (rs.next()) {
                int i = 0;
                Clientes cliente = new Clientes();
                cliente.setCodigo(rs.getInt("Codigo"));
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setApellidoP(rs.getString("ApellidoPaterno"));
                cliente.setApellidoM(rs.getString("ApellidoMaterno"));
                cliente.setDireccion(rs.getString("Direccion"));
                cliente.setTelefono(rs.getInt("Telefono"));
                list.add(cliente);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
        }
        return list;
    }

    public boolean agregar(Clientes cliente) throws ClassNotFoundException {
        String sql = "INSERT INTO clientes ( Nombre, ApellidoPaterno, ApellidoMaterno, Direccion, Telefono) VALUES ('"
                + cliente.getNombre() + "'," +
                 "'" + cliente.getApellidoP() + "',"
                + "'" + cliente.getApellidoM() + "',"
                + "'" + cliente.getDireccion() + "',"
                + cliente.getTelefono() + ")";

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
    public boolean editar(Clientes cliente, int old) throws ClassNotFoundException 
    {
        String sql = "UPDATE clientes SET "
                + " Nombre  = '" + cliente.getNombre()+ "',"
                + " ApellidoPaterno  = '" + cliente.getApellidoP()+ "',"
                + " ApellidoMaterno = '" + cliente.getApellidoM()+ "',"
                + " Direccion  = '" + cliente.getDireccion()+ "',"
                + " Telefono  = " + cliente.getTelefono()
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

    public Clientes buscar(int codigo) throws ClassNotFoundException {

        String sql = "SELECT * FROM clientes WHERE Codigo = " + codigo + " ";
        try {
            con = ConexionMySQL.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                clientes = new Clientes();
                clientes.setCodigo(rs.getInt("Codigo"));
                clientes.setNombre(rs.getString("Nombre"));
                clientes.setApellidoP(rs.getString("ApellidoPaterno"));
                clientes.setApellidoM(rs.getString("ApellidoMaterno"));
                clientes.setDireccion(rs.getString("Direccion"));
                clientes.setTelefono(rs.getInt("Telefono"));

            }
            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
        }
        return clientes;

    }
    public boolean eliminar(int codigo) throws ClassNotFoundException
    {
     String sql= "DELETE FROM clientes WHERE Codigo = " + codigo + "";
     
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
