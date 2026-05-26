package co.edu.uco.ucoparking.dto;

import java.util.UUID;

public final class CuidadoMedicoDTO {

    private UUID id;
    private String tipo;
    private String fechaHora;
    private String descripcion;
    private String medicamento;
    private UUID idAnimal;
    private UUID idEmpleado;

    public CuidadoMedicoDTO() { this(null, null, null, null, null, null, null); }

    public CuidadoMedicoDTO(final UUID id, final String tipo, final String fechaHora, final String descripcion, final String medicamento, final UUID idAnimal, final UUID idEmpleado) {
        this.id = id;
        this.tipo = tipo;
        this.fechaHora = fechaHora;
        this.descripcion = descripcion;
        this.medicamento = medicamento;
        this.idAnimal = idAnimal;
        this.idEmpleado = idEmpleado;
    }

    public UUID getId() { return id; }
    public String getTipo() { return tipo; }
    public String getFechaHora() { return fechaHora; }
    public String getDescripcion() { return descripcion; }
    public String getMedicamento() { return medicamento; }
    public UUID getIdAnimal() { return idAnimal; }
    public UUID getIdEmpleado() { return idEmpleado; }
}
