package co.edu.uco.ucoparking.dominio;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.CompraDominio;
import co.edu.uco.ucoparking.dominio.ProductoDominio;
import co.edu.uco.ucoparking.transversal.UtilTexto;

public final class ItemCompraDominio {

    private UUID id;
    private Double cantidad;
    private Double precioUnitario;
    private CompraDominio compra;
    private ProductoDominio producto;

    private ItemCompraDominio(final Builder builder) {
        setId(builder.id);
        setCantidad(builder.cantidad);
        setPrecioUnitario(builder.precioUnitario);
        setCompra(builder.compra);
        setProducto(builder.producto);
    }

    public static Builder builder() { return new Builder(); }

    public UUID getId() { return id; }
    private void setId(final UUID id) { this.id = id; }
    public Double getCantidad() { return cantidad; }
    private void setCantidad(final Double cantidad) { this.cantidad = cantidad; }
    public Double getPrecioUnitario() { return precioUnitario; }
    private void setPrecioUnitario(final Double precioUnitario) { this.precioUnitario = precioUnitario; }
    public CompraDominio getCompra() { return compra; }
    private void setCompra(final CompraDominio compra) { this.compra = compra; }
    public ProductoDominio getProducto() { return producto; }
    private void setProducto(final ProductoDominio producto) { this.producto = producto; }

    public static final class Builder {
        private UUID id;
        private Double cantidad;
        private Double precioUnitario;
        private CompraDominio compra;
        private ProductoDominio producto;

        public Builder id(final UUID id) { this.id = id; return this; }
        public Builder cantidad(final Double cantidad) { this.cantidad = cantidad; return this; }
        public Builder precioUnitario(final Double precioUnitario) { this.precioUnitario = precioUnitario; return this; }
        public Builder compra(final CompraDominio compra) { this.compra = compra; return this; }
        public Builder producto(final ProductoDominio producto) { this.producto = producto; return this; }

        public ItemCompraDominio build() { return new ItemCompraDominio(this); }
    }
}
