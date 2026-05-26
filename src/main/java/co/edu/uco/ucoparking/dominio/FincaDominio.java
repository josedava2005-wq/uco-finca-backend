package co.edu.uco.ucoparking.dominio;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.LugarFincaDominio;
import co.edu.uco.ucoparking.transversal.UtilTexto;

public final class FincaDominio {

    private UUID id;
    private String nombre;
    private Double hectareas;
    private String fechaRegistro;
    private LugarFincaDominio lugarFinca;

    private FincaDominio(final Builder builder) {
        setId(builder.id);
        setNombre(builder.nombre);
        setHectareas(builder.hectareas);
        setFechaRegistro(builder.fechaRegistro);
        setLugarFinca(builder.lugarFinca);
    }

    public static Builder builder() { return new Builder(); }

    public UUID getId() { return id; }
    private void setId(final UUID id) { this.id = id; }
    public String getNombre() { return nombre; }
    private void setNombre(final String nombre) { this.nombre = UtilTexto.aplicarTrim(nombre); }
    public Double getHectareas() { return hectareas; }
    private void setHectareas(final Double hectareas) { this.hectareas = hectareas; }
    public String getFechaRegistro() { return fechaRegistro; }
    private void setFechaRegistro(final String fechaRegistro) { this.fechaRegistro = UtilTexto.aplicarTrim(fechaRegistro); }
    public LugarFincaDominio getLugarFinca() { return lugarFinca; }
    private void setLugarFinca(final LugarFincaDominio lugarFinca) { this.lugarFinca = lugarFinca; }

    public static final class Builder {
        private UUID id;
        private String nombre;
        private Double hectareas;
        private String fechaRegistro;
        private LugarFincaDominio lugarFinca;

        public Builder id(final UUID id) { this.id = id; return this; }
        public Builder nombre(final String nombre) { this.nombre = nombre; return this; }
        public Builder hectareas(final Double hectareas) { this.hectareas = hectareas; return this; }
        public Builder fechaRegistro(final String fechaRegistro) { this.fechaRegistro = fechaRegistro; return this; }
        public Builder lugarFinca(final LugarFincaDominio lugarFinca) { this.lugarFinca = lugarFinca; return this; }

        public FincaDominio build() { return new FincaDominio(this); }
    }
}
