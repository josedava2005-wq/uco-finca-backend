package co.edu.uco.ucoparking.entidad;

import java.util.UUID;

import co.edu.uco.ucoparking.entidad.CompraEntidad;
import co.edu.uco.ucoparking.entidad.ProductoEntidad;

public class ItemCompraEntidad {

    private UUID id;
    private Double cantidad;
    private Double precioUnitario;
    private CompraEntidad compra;
    private ProductoEntidad producto;

    public ItemCompraEntidad() {}

    public ItemCompraEntidad(final UUID id, final Double cantidad, final Double precioUnitario, final CompraEntidad compra, final ProductoEntidad producto) {
        this.id = id;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.compra = compra;
        this.producto = producto;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }
    public Double getCantidad() { return cantidad; }
    public void setCantidad(final Double cantidad) { this.cantidad = cantidad; }
    public Double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(final Double precioUnitario) { this.precioUnitario = precioUnitario; }
    public CompraEntidad getCompra() { return compra; }
    public void setCompra(final CompraEntidad compra) { this.compra = compra; }
    public ProductoEntidad getProducto() { return producto; }
    public void setProducto(final ProductoEntidad producto) { this.producto = producto; }
}
