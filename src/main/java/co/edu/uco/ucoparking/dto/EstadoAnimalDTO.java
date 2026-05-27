package co.edu.uco.ucoparking.dto;

import java.util.UUID;

public final class EstadoAnimalDTO {

    private UUID id;
    private String estado;
    private String fechaRegistro;
    private String observacion;
    private UUID idAnimal;

    public EstadoAnimalDTO() { this(null, null, null, null, null); }

    public EstadoAnimalDTO(final UUID id, final String estado, final String fechaRegistro, final String observacion, final UUID idAnimal) {
        this.id = id;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
        this.observacion = observacion;
        this.idAnimal = idAnimal;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }
    public String getEstado() { return estado; }
    public void setEstado(final String estado) { this.estado = estado; }
    public String getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(final String fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    public String getObservacion() { return observacion; }
    public void setObservacion(final String observacion) { this.observacion = observacion; }
    public UUID getIdAnimal() { return idAnimal; }
    public void setIdAnimal(final UUID idAnimal) { this.idAnimal = idAnimal; }
}
