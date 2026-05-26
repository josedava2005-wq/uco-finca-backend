package co.edu.uco.ucoparking.dto;

import java.util.UUID;

public final class TareaDTO {

    private UUID id;
    private String descripcion;
    private String fechaHora;
    private String estado;
    private UUID idEmpleado;
    private UUID idFinca;

    public TareaDTO() { this(null, null, null, null, null, null); }

    public TareaDTO(final UUID id, final String descripcion, final String fechaHora, final String estado, final UUID idEmpleado, final UUID idFinca) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.idEmpleado = idEmpleado;
        this.idFinca = idFinca;
    }

    public UUID getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public String getFechaHora() { return fechaHora; }
    public String getEstado() { return estado; }
    public UUID getIdEmpleado() { return idEmpleado; }
    public UUID getIdFinca() { return idFinca; }
}
