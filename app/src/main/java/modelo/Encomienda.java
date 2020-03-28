package modelo;

public class Encomienda
{
    private int idEntrega;
    private String direccion;
    private String rutDestinatario;
    private String nombreDestinatario;
    private String fechaIngreso;
    private String fechaRecepcion;
    private int estado;

    public Encomienda(int idEntrega, String direccion, String rutDestinatario, String nombreDestinatario, String fechaIngreso, String fechaRecepcion, int estado) {
        this.idEntrega = idEntrega;
        this.direccion = direccion;
        this.rutDestinatario = rutDestinatario;
        this.nombreDestinatario = nombreDestinatario;
        this.fechaIngreso = fechaIngreso;
        this.fechaRecepcion = fechaRecepcion;
        this.estado = estado;
    }

    public int getIdEntrega() {
        return idEntrega;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getRutDestinatario() {
        return rutDestinatario;
    }

    public String getNombreDestinatario() {
        return nombreDestinatario;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public String getFechaRecepcion() {
        return fechaRecepcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setIdEntrega(int idEntrega) {
        this.idEntrega = idEntrega;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setRutDestinatario(String rutDestinatario) {
        this.rutDestinatario = rutDestinatario;
    }

    public void setNombreDestinatario(String nombreDestinatario) {
        this.nombreDestinatario = nombreDestinatario;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setFechaRecepcion(String fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
