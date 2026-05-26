package co.edu.uco.ucoparking.entidad;

import java.util.UUID;

import co.edu.uco.ucoparking.entidad.ItemCompraEntidad;

public class DetalleCompraEntidad {

    private UUID id;
    private Double costoUnitario;
    private Double subtotal;
    private Double descuento;
    private ItemCompraEntidad itemCompra;

    public DetalleCompraEntidad() {}

    public DetalleCompraEntidad(final UUID id, final Double costoUnitario, final Double subtotal, final Double descuento, final ItemCompraEntidad itemCompra) {
        this.id = id;
        this.costoUnitario = costoUnitario;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.itemCompra = itemCompra;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }
    public Double getCostoUnitario() { return costoUnitario; }
    public void setCostoUnitario(final Double costoUnitario) { this.costoUnitario = costoUnitario; }
    public Double getSubtotal() { return subtotal; }
    public void setSubtotal(final Double subtotal) { this.subtotal = subtotal; }
    public Double getDescuento() { return descuento; }
    public void setDescuento(final Double descuento) { this.descuento = descuento; }
    public ItemCompraEntidad getItemCompra() { return itemCompra; }
    public void setItemCompra(final ItemCompraEntidad itemCompra) { this.itemCompra = itemCompra; }
}
