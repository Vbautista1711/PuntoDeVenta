package beans;

public class Productos {

    private int  codigo,precio,cantidad;
    private String nombre,descripcion;

    public Productos() 
    {
        codigo=precio=cantidad= 0;
        nombre= descripcion="";
    }

    public Productos( int codigo,int precio,int cantidad, String nombre, String descripcion) {
        
        this.codigo = codigo;
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        
    }

     public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   
}
