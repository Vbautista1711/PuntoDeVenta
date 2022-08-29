
package beans;


public class Usuarios {
    
    private int  codigo;
    private String nombre,apellidoP,apellidoM, email, usuario, password;

    public Usuarios() 
    {
        codigo= 0;
        nombre= apellidoP=apellidoM=email=usuario=password="";
    }

    public Usuarios( int codigo, String nombre, String apellidoP, String apellidoM, String email, String usuario, String password) {
        
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.email = email;
        this.usuario=usuario;
        this.password=password;
        
    }

     public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }
    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
