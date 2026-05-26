package co.edu.uco.ucoparking.dto;

import java.util.UUID;

public final class ClienteDTO {

    private UUID id;
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombre;
    private String correo;
    private String telefono;
    private UUID idCiudad;

    public ClienteDTO() { this(null, null, null, null, null, null, null); }

    public ClienteDTO(final UUID id, final String tipoDocumento, final String numeroDocumento, final String nombre, final String correo, final String telefono, final UUID idCiudad) {
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.idCiudad = idCiudad;
    }

    public UUID getId() { return id; }
    public String getTipoDocumento() { return tipoDocumento; }
    public String getNumeroDocumento() { return numeroDocumento; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }
    public UUID getIdCiudad() { return idCiudad; }
}
