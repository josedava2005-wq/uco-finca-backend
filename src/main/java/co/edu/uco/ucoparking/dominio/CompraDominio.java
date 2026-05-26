package co.edu.uco.ucoparking.dominio;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.ClienteDominio;
import co.edu.uco.ucoparking.transversal.UtilTexto;

public final class CompraDominio {

    private UUID id;
    private String fechaCompra;
    private Double total;
    private String estado;
    private ClienteDominio cliente;

    private CompraDominio(final Builder builder) {
        setId(builder.id);
        setFechaCompra(builder.fechaCompra);
        setTotal(builder.total);
        setEstado(builder.estado);
        setCliente(builder.cliente);
    }

    public static Builder builder() { return new Builder(); }

    public UUID getId() { return id; }
    private void setId(final UUID id) { this.id = id; }
    public String getFechaCompra() { return fechaCompra; }
    private void setFechaCompra(final String fechaCompra) { this.fechaCompra = UtilTexto.aplicarTrim(fechaCompra); }
    public Double getTotal() { return total; }
    private void setTotal(final Double total) { this.total = total; }
    public String getEstado() { return estado; }
    private void setEstado(final String estado) { this.estado = UtilTexto.aplicarTrim(estado); }
    public ClienteDominio getCliente() { return cliente; }
    private void setCliente(final ClienteDominio cliente) { this.cliente = cliente; }

    public static final class Builder {
        private UUID id;
        private String fechaCompra;
        private Double total;
        private String estado;
        private ClienteDominio cliente;

        public Builder id(final UUID id) { this.id = id; return this; }
        public Builder fechaCompra(final String fechaCompra) { this.fechaCompra = fechaCompra; return this; }
        public Builder total(final Double total) { this.total = total; return this; }
        public Builder estado(final String estado) { this.estado = estado; return this; }
        public Builder cliente(final ClienteDominio cliente) { this.cliente = cliente; return this; }

        public CompraDominio build() { return new CompraDominio(this); }
    }
}
