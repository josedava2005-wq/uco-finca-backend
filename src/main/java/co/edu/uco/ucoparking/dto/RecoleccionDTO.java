package co.edu.uco.ucoparking.dto;

import java.util.UUID;

public final class RecoleccionDTO {

    private UUID id;
    private String fechaHora;
    private Double cantidad;
    private String unidadMedida;
    private UUID idProducto;
    private UUID idAnimal;
    private UUID idEmpleado;

    public RecoleccionDTO() { this(null, null, null, null, null, null, null); }

    public RecoleccionDTO(final UUID id, final String fechaHora, final Double cantidad, final String unidadMedida, final UUID idProducto, final UUID idAnimal, final UUID idEmpleado) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
        this.idProducto = idProducto;
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
    public UUID getIdProducto() { return idProducto; }
    public void setIdProducto(final UUID idProducto) { this.idProducto = idProducto; }
    public UUID getIdAnimal() { return idAnimal; }
    public void setIdAnimal(final UUID idAnimal) { this.idAnimal = idAnimal; }
    public UUID getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(final UUID idEmpleado) { this.idEmpleado = idEmpleado; }
}
