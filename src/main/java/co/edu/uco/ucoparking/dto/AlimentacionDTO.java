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
    public void setId(final UUID id) { this.id = id; }
    public String getFechaHora() { return fechaHora; }
    public void setFechaHora(final String fechaHora) { this.fechaHora = fechaHora; }
    public Double getCantidad() { return cantidad; }
    public void setCantidad(final Double cantidad) { this.cantidad = cantidad; }
    public String getUnidadMedida() { return unidadMedida; }
    public void setUnidadMedida(final String unidadMedida) { this.unidadMedida = unidadMedida; }
    public String getTipoAlimento() { return tipoAlimento; }
    public void setTipoAlimento(final String tipoAlimento) { this.tipoAlimento = tipoAlimento; }
    public UUID getIdAnimal() { return idAnimal; }
    public void setIdAnimal(final UUID idAnimal) { this.idAnimal = idAnimal; }
    public UUID getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(final UUID idEmpleado) { this.idEmpleado = idEmpleado; }
}
