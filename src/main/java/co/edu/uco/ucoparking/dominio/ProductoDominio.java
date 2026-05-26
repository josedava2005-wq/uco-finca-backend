package co.edu.uco.ucoparking.dominio;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.FincaDominio;
import co.edu.uco.ucoparking.transversal.UtilTexto;

public final class ProductoDominio {

    private UUID id;
    private String nombre;
    private String unidadMedida;
    private Double precioUnitario;
    private Double stockDisponible;
    private String descripcion;
    private FincaDominio finca;

    private ProductoDominio(final Builder builder) {
        setId(builder.id);
        setNombre(builder.nombre);
        setUnidadMedida(builder.unidadMedida);
        setPrecioUnitario(builder.precioUnitario);
        setStockDisponible(builder.stockDisponible);
        setDescripcion(builder.descripcion);
        setFinca(builder.finca);
    }

    public static Builder builder() { return new Builder(); }

    public UUID getId() { return id; }
    private void setId(final UUID id) { this.id = id; }
    public String getNombre() { return nombre; }
    private void setNombre(final String nombre) { this.nombre = UtilTexto.aplicarTrim(nombre); }
    public String getUnidadMedida() { return unidadMedida; }
    private void setUnidadMedida(final String unidadMedida) { this.unidadMedida = UtilTexto.aplicarTrim(unidadMedida); }
    public Double getPrecioUnitario() { return precioUnitario; }
    private void setPrecioUnitario(final Double precioUnitario) { this.precioUnitario = precioUnitario; }
    public Double getStockDisponible() { return stockDisponible; }
    private void setStockDisponible(final Double stockDisponible) { this.stockDisponible = stockDisponible; }
    public String getDescripcion() { return descripcion; }
    private void setDescripcion(final String descripcion) { this.descripcion = UtilTexto.aplicarTrim(descripcion); }
    public FincaDominio getFinca() { return finca; }
    private void setFinca(final FincaDominio finca) { this.finca = finca; }

    public static final class Builder {
        private UUID id;
        private String nombre;
        private String unidadMedida;
        private Double precioUnitario;
        private Double stockDisponible;
        private String descripcion;
        private FincaDominio finca;

        public Builder id(final UUID id) { this.id = id; return this; }
        public Builder nombre(final String nombre) { this.nombre = nombre; return this; }
        public Builder unidadMedida(final String unidadMedida) { this.unidadMedida = unidadMedida; return this; }
        public Builder precioUnitario(final Double precioUnitario) { this.precioUnitario = precioUnitario; return this; }
        public Builder stockDisponible(final Double stockDisponible) { this.stockDisponible = stockDisponible; return this; }
        public Builder descripcion(final String descripcion) { this.descripcion = descripcion; return this; }
        public Builder finca(final FincaDominio finca) { this.finca = finca; return this; }

        public ProductoDominio build() { return new ProductoDominio(this); }
    }
}
