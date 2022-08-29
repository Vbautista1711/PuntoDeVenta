
package beans;


public class ArquilerPeliculas {
    private int codigo, id_cliente,id_pelicula;
    private String nombreP,fechaPrestamo,fechaEntrega;

    public ArquilerPeliculas() 
    {
        codigo=id_cliente=id_pelicula = 0;
        nombreP=fechaPrestamo=fechaEntrega="";
    }

    public ArquilerPeliculas(int codigo, int id_cliente, int id_pelicula, String nombreP, String fechaPrestamo, String fechaEntrega) {
        this.codigo = codigo;
        this.id_cliente = id_cliente;
        this.id_pelicula = id_pelicula;
        this.nombreP = nombreP;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
}
