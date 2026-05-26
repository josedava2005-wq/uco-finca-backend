package co.edu.uco.ucoparking.dominio;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.ItemCompraDominio;
import co.edu.uco.ucoparking.transversal.UtilTexto;

public final class DetalleCompraDominio {

    private UUID id;
    private Double costoUnitario;
    private Double subtotal;
    private Double descuento;
    private ItemCompraDominio itemCompra;

    private DetalleCompraDominio(final Builder builder) {
        setId(builder.id);
        setCostoUnitario(builder.costoUnitario);
        setSubtotal(builder.subtotal);
        setDescuento(builder.descuento);
        setItemCompra(builder.itemCompra);
    }

    public static Builder builder() { return new Builder(); }

    public UUID getId() { return id; }
    private void setId(final UUID id) { this.id = id; }
    public Double getCostoUnitario() { return costoUnitario; }
    private void setCostoUnitario(final Double costoUnitario) { this.costoUnitario = costoUnitario; }
    public Double getSubtotal() { return subtotal; }
    private void setSubtotal(final Double subtotal) { this.subtotal = subtotal; }
    public Double getDescuento() { return descuento; }
    private void setDescuento(final Double descuento) { this.descuento = descuento; }
    public ItemCompraDominio getItemCompra() { return itemCompra; }
    private void setItemCompra(final ItemCompraDominio itemCompra) { this.itemCompra = itemCompra; }

    public static final class Builder {
        private UUID id;
        private Double costoUnitario;
        private Double subtotal;
        private Double descuento;
        private ItemCompraDominio itemCompra;

        public Builder id(final UUID id) { this.id = id; return this; }
        public Builder costoUnitario(final Double costoUnitario) { this.costoUnitario = costoUnitario; return this; }
        public Builder subtotal(final Double subtotal) { this.subtotal = subtotal; return this; }
        public Builder descuento(final Double descuento) { this.descuento = descuento; return this; }
        public Builder itemCompra(final ItemCompraDominio itemCompra) { this.itemCompra = itemCompra; return this; }

        public DetalleCompraDominio build() { return new DetalleCompraDominio(this); }
    }
}
