package co.edu.uco.ucoparking.dto;

import java.util.UUID;

public final class CuidadoEspecialDTO {

    private UUID id;
    private String tipo;
    private String fechaHora;
    private String descripcion;
    private UUID idAnimal;
    private UUID idEmpleado;

    public CuidadoEspecialDTO() { this(null, null, null, null, null, null); }

    public CuidadoEspecialDTO(final UUID id, final String tipo, final String fechaHora, final String descripcion, final UUID idAnimal, final UUID idEmpleado) {
        this.id = id;
        this.tipo = tipo;
        this.fechaHora = fechaHora;
        this.descripcion = descripcion;
        this.idAnimal = idAnimal;
        this.idEmpleado = idEmpleado;
    }

    public UUID getId() { return id; }
    public String getTipo() { return tipo; }
    public String getFechaHora() { return fechaHora; }
    public String getDescripcion() { return descripcion; }
    public UUID getIdAnimal() { return idAnimal; }
    public UUID getIdEmpleado() { return idEmpleado; }
}
