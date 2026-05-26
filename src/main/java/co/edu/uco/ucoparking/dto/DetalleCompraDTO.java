package co.edu.uco.ucoparking.dto;

import java.util.UUID;

public final class DetalleCompraDTO {

    private UUID id;
    private Double costoUnitario;
    private Double subtotal;
    private Double descuento;
    private UUID idItemCompra;

    public DetalleCompraDTO() { this(null, null, null, null, null); }

    public DetalleCompraDTO(final UUID id, final Double costoUnitario, final Double subtotal, final Double descuento, final UUID idItemCompra) {
        this.id = id;
        this.costoUnitario = costoUnitario;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.idItemCompra = idItemCompra;
    }

    public UUID getId() { return id; }
    public Double getCostoUnitario() { return costoUnitario; }
    public Double getSubtotal() { return subtotal; }
    public Double getDescuento() { return descuento; }
    public UUID getIdItemCompra() { return idItemCompra; }
}
