package co.edu.uco.ucoparking.dto;

import java.util.UUID;

public final class EmpleadoDTO {

    private UUID id;
    private String nombre;
    private String tipoDocumento;
    private String numeroDocumento;
    private String cargo;
    private String telefono;
    private String fechaVinculacion;
    private UUID idFinca;

    public EmpleadoDTO() { this(null, null, null, null, null, null, null, null); }

    public EmpleadoDTO(final UUID id, final String nombre, final String tipoDocumento, final String numeroDocumento, final String cargo, final String telefono, final String fechaVinculacion, final UUID idFinca) {
        this.id = id;
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.cargo = cargo;
        this.telefono = telefono;
        this.fechaVinculacion = fechaVinculacion;
        this.idFinca = idFinca;
    }

    public UUID getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTipoDocumento() { return tipoDocumento; }
    public String getNumeroDocumento() { return numeroDocumento; }
    public String getCargo() { return cargo; }
    public String getTelefono() { return telefono; }
    public String getFechaVinculacion() { return fechaVinculacion; }
    public UUID getIdFinca() { return idFinca; }
}
