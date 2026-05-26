package co.edu.uco.ucoparking.entidad;

import java.util.UUID;

public class ProveedorEntidad {

    private UUID id;
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;

    public ProveedorEntidad() {}

    public ProveedorEntidad(final UUID id, final String tipoDocumento, final String numeroDocumento, final String nombre, final String correo, final String telefono, final String direccion) {
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }
    public String getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(final String tipoDocumento) { this.tipoDocumento = tipoDocumento; }
    public String getNumeroDocumento() { return numeroDocumento; }
    public void setNumeroDocumento(final String numeroDocumento) { this.numeroDocumento = numeroDocumento; }
    public String getNombre() { return nombre; }
    public void setNombre(final String nombre) { this.nombre = nombre; }
    public String getCorreo() { return correo; }
    public void setCorreo(final String correo) { this.correo = correo; }
    public String getTelefono() { return telefono; }
    public void setTelefono(final String telefono) { this.telefono = telefono; }
    public String getDireccion() { return direccion; }
    public void setDireccion(final String direccion) { this.direccion = direccion; }
}
