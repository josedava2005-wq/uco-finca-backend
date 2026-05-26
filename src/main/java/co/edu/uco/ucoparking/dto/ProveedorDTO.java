package co.edu.uco.ucoparking.dto;

import java.util.UUID;

public final class ProveedorDTO {

    private UUID id;
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;

    public ProveedorDTO() { this(null, null, null, null, null, null, null); }

    public ProveedorDTO(final UUID id, final String tipoDocumento, final String numeroDocumento, final String nombre, final String correo, final String telefono, final String direccion) {
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public UUID getId() { return id; }
    public String getTipoDocumento() { return tipoDocumento; }
    public String getNumeroDocumento() { return numeroDocumento; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }
    public String getDireccion() { return direccion; }
}
