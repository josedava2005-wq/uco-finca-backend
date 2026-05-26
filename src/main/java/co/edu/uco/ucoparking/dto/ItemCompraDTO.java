package co.edu.uco.ucoparking.dto;

import java.util.UUID;

public final class ItemCompraDTO {

    private UUID id;
    private Double cantidad;
    private Double precioUnitario;
    private UUID idCompra;
    private UUID idProducto;

    public ItemCompraDTO() { this(null, null, null, null, null); }

    public ItemCompraDTO(final UUID id, final Double cantidad, final Double precioUnitario, final UUID idCompra, final UUID idProducto) {
        this.id = id;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.idCompra = idCompra;
        this.idProducto = idProducto;
    }

    public UUID getId() { return id; }
    public Double getCantidad() { return cantidad; }
    public Double getPrecioUnitario() { return precioUnitario; }
    public UUID getIdCompra() { return idCompra; }
    public UUID getIdProducto() { return idProducto; }
}
