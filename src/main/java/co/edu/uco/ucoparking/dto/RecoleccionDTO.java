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
    public String getFechaHora() { return fechaHora; }
    public Double getCantidad() { return cantidad; }
    public String getUnidadMedida() { return unidadMedida; }
    public UUID getIdProducto() { return idProducto; }
    public UUID getIdAnimal() { return idAnimal; }
    public UUID getIdEmpleado() { return idEmpleado; }
}
