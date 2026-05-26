package co.edu.uco.ucoparking.dominio;

import java.util.UUID;
import co.edu.uco.ucoparking.transversal.UtilTexto;

public final class TipoSuministroDominio {

    private UUID id;
    private String nombre;
    private String descripcion;

    private TipoSuministroDominio(final Builder builder) {
        setId(builder.id);
        setNombre(builder.nombre);
        setDescripcion(builder.descripcion);
    }

    public static Builder builder() { return new Builder(); }

    public UUID getId() { return id; }
    private void setId(final UUID id) { this.id = id; }
    public String getNombre() { return nombre; }
    private void setNombre(final String nombre) { this.nombre = UtilTexto.aplicarTrim(nombre); }
    public String getDescripcion() { return descripcion; }
    private void setDescripcion(final String descripcion) { this.descripcion = UtilTexto.aplicarTrim(descripcion); }

    public static final class Builder {
        private UUID id;
        private String nombre;
        private String descripcion;

        public Builder id(final UUID id) { this.id = id; return this; }
        public Builder nombre(final String nombre) { this.nombre = nombre; return this; }
        public Builder descripcion(final String descripcion) { this.descripcion = descripcion; return this; }

        public TipoSuministroDominio build() { return new TipoSuministroDominio(this); }
    }
}
