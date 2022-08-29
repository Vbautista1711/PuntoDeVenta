package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Privado
 */
public class ConexionMySQL 
{
    public static Connection getConnection() throws SQLException, ClassNotFoundException
    {
       Class.forName("com.mysql.jdbc.Driver"); 
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/puntoventa","root","");
    }
    public static void main(String arg[]) throws SQLException, ClassNotFoundException
    {
        ConexionMySQL.getConnection();
        System.out.println("Exitoso");
    }
    
}
