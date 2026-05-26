package co.edu.uco.ucoparking.dominio;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.FincaDominio;
import co.edu.uco.ucoparking.dominio.TipoAlmacenDominio;
import co.edu.uco.ucoparking.transversal.UtilTexto;

public final class AlmacenDominio {

    private UUID id;
    private String nombre;
    private Double capacidadM2;
    private TipoAlmacenDominio tipoAlmacen;
    private FincaDominio finca;

    private AlmacenDominio(final Builder builder) {
        setId(builder.id);
        setNombre(builder.nombre);
        setCapacidadM2(builder.capacidadM2);
        setTipoAlmacen(builder.tipoAlmacen);
        setFinca(builder.finca);
    }

    public static Builder builder() { return new Builder(); }

    public UUID getId() { return id; }
    private void setId(final UUID id) { this.id = id; }
    public String getNombre() { return nombre; }
    private void setNombre(final String nombre) { this.nombre = UtilTexto.aplicarTrim(nombre); }
    public Double getCapacidadM2() { return capacidadM2; }
    private void setCapacidadM2(final Double capacidadM2) { this.capacidadM2 = capacidadM2; }
    public TipoAlmacenDominio getTipoAlmacen() { return tipoAlmacen; }
    private void setTipoAlmacen(final TipoAlmacenDominio tipoAlmacen) { this.tipoAlmacen = tipoAlmacen; }
    public FincaDominio getFinca() { return finca; }
    private void setFinca(final FincaDominio finca) { this.finca = finca; }

    public static final class Builder {
        private UUID id;
        private String nombre;
        private Double capacidadM2;
        private TipoAlmacenDominio tipoAlmacen;
        private FincaDominio finca;

        public Builder id(final UUID id) { this.id = id; return this; }
        public Builder nombre(final String nombre) { this.nombre = nombre; return this; }
        public Builder capacidadM2(final Double capacidadM2) { this.capacidadM2 = capacidadM2; return this; }
        public Builder tipoAlmacen(final TipoAlmacenDominio tipoAlmacen) { this.tipoAlmacen = tipoAlmacen; return this; }
        public Builder finca(final FincaDominio finca) { this.finca = finca; return this; }

        public AlmacenDominio build() { return new AlmacenDominio(this); }
    }
}
