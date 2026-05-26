package co.edu.uco.ucoparking.dto;

import java.util.UUID;

public final class AlimentacionDTO {

    private UUID id;
    private String fechaHora;
    private Double cantidad;
    private String unidadMedida;
    private String tipoAlimento;
    private UUID idAnimal;
    private UUID idEmpleado;

    public AlimentacionDTO() { this(null, null, null, null, null, null, null); }

    public AlimentacionDTO(final UUID id, final String fechaHora, final Double cantidad, final String unidadMedida, final String tipoAlimento, final UUID idAnimal, final UUID idEmpleado) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
        this.tipoAlimento = tipoAlimento;
        this.idAnimal = idAnimal;
        this.idEmpleado = idEmpleado;
    }

    public UUID getId() { return id; }
    public String getFechaHora() { return fechaHora; }
    public Double getCantidad() { return cantidad; }
    public String getUnidadMedida() { return unidadMedida; }
    public String getTipoAlimento() { return tipoAlimento; }
    public UUID getIdAnimal() { return idAnimal; }
    public UUID getIdEmpleado() { return idEmpleado; }
}
