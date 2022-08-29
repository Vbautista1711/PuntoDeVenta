
package beans;


public class Clientes {
    private int  codigo,telefono;
    private String nombre,apellidoP,apellidoM,direccion;

    public Clientes() 
    {
        codigo=telefono= 0;
        nombre= apellidoP=apellidoM=direccion="";
    }

    public Clientes( int codigo,int telefono, String nombre, String apellidoP, String apellidoM,String direccion) {
        
        this.codigo = codigo;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.direccion = direccion;
        
    }

     public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
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
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
