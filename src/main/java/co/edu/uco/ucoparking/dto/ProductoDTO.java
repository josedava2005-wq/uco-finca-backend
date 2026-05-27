package co.edu.uco.ucoparking.dto;

import java.util.UUID;

public final class ProductoDTO {

    private UUID id;
    private String nombre;
    private String unidadMedida;
    private Double precioUnitario;
    private Double stockDisponible;
    private String descripcion;
    private UUID idFinca;

    public ProductoDTO() { this(null, null, null, null, null, null, null); }

    public ProductoDTO(final UUID id, final String nombre, final String unidadMedida, final Double precioUnitario, final Double stockDisponible, final String descripcion, final UUID idFinca) {
        this.id = id;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.precioUnitario = precioUnitario;
        this.stockDisponible = stockDisponible;
        this.descripcion = descripcion;
        this.idFinca = idFinca;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(final String nombre) { this.nombre = nombre; }
    public String getUnidadMedida() { return unidadMedida; }
    public void setUnidadMedida(final String unidadMedida) { this.unidadMedida = unidadMedida; }
    public Double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(final Double precioUnitario) { this.precioUnitario = precioUnitario; }
    public Double getStockDisponible() { return stockDisponible; }
    public void setStockDisponible(final Double stockDisponible) { this.stockDisponible = stockDisponible; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(final String descripcion) { this.descripcion = descripcion; }
    public UUID getIdFinca() { return idFinca; }
    public void setIdFinca(final UUID idFinca) { this.idFinca = idFinca; }
}
