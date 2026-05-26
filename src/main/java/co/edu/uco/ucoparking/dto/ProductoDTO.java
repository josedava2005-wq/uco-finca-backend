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
    public String getNombre() { return nombre; }
    public String getUnidadMedida() { return unidadMedida; }
    public Double getPrecioUnitario() { return precioUnitario; }
    public Double getStockDisponible() { return stockDisponible; }
    public String getDescripcion() { return descripcion; }
    public UUID getIdFinca() { return idFinca; }
}
