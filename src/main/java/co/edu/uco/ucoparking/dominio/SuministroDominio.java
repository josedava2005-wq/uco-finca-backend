package co.edu.uco.ucoparking.dominio;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.AlmacenDominio;
import co.edu.uco.ucoparking.dominio.ProveedorDominio;
import co.edu.uco.ucoparking.dominio.TipoSuministroDominio;
import co.edu.uco.ucoparking.transversal.UtilTexto;

public final class SuministroDominio {

    private UUID id;
    private String nombre;
    private Double cantidad;
    private String unidadMedida;
    private TipoSuministroDominio tipoSuministro;
    private AlmacenDominio almacen;
    private ProveedorDominio proveedor;

    private SuministroDominio(final Builder builder) {
        setId(builder.id);
        setNombre(builder.nombre);
        setCantidad(builder.cantidad);
        setUnidadMedida(builder.unidadMedida);
        setTipoSuministro(builder.tipoSuministro);
        setAlmacen(builder.almacen);
        setProveedor(builder.proveedor);
    }

    public static Builder builder() { return new Builder(); }

    public UUID getId() { return id; }
    private void setId(final UUID id) { this.id = id; }
    public String getNombre() { return nombre; }
    private void setNombre(final String nombre) { this.nombre = UtilTexto.aplicarTrim(nombre); }
    public Double getCantidad() { return cantidad; }
    private void setCantidad(final Double cantidad) { this.cantidad = cantidad; }
    public String getUnidadMedida() { return unidadMedida; }
    private void setUnidadMedida(final String unidadMedida) { this.unidadMedida = UtilTexto.aplicarTrim(unidadMedida); }
    public TipoSuministroDominio getTipoSuministro() { return tipoSuministro; }
    private void setTipoSuministro(final TipoSuministroDominio tipoSuministro) { this.tipoSuministro = tipoSuministro; }
    public AlmacenDominio getAlmacen() { return almacen; }
    private void setAlmacen(final AlmacenDominio almacen) { this.almacen = almacen; }
    public ProveedorDominio getProveedor() { return proveedor; }
    private void setProveedor(final ProveedorDominio proveedor) { this.proveedor = proveedor; }

    public static final class Builder {
        private UUID id;
        private String nombre;
        private Double cantidad;
        private String unidadMedida;
        private TipoSuministroDominio tipoSuministro;
        private AlmacenDominio almacen;
        private ProveedorDominio proveedor;

        public Builder id(final UUID id) { this.id = id; return this; }
        public Builder nombre(final String nombre) { this.nombre = nombre; return this; }
        public Builder cantidad(final Double cantidad) { this.cantidad = cantidad; return this; }
        public Builder unidadMedida(final String unidadMedida) { this.unidadMedida = unidadMedida; return this; }
        public Builder tipoSuministro(final TipoSuministroDominio tipoSuministro) { this.tipoSuministro = tipoSuministro; return this; }
        public Builder almacen(final AlmacenDominio almacen) { this.almacen = almacen; return this; }
        public Builder proveedor(final ProveedorDominio proveedor) { this.proveedor = proveedor; return this; }

        public SuministroDominio build() { return new SuministroDominio(this); }
    }
}
