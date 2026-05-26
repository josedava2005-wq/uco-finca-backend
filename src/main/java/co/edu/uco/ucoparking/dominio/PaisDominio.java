package co.edu.uco.ucoparking.dominio;

import java.util.UUID;
import co.edu.uco.ucoparking.transversal.UtilTexto;

public final class PaisDominio {

    private UUID id;
    private String nombre;
    private String codigoISO;
    private String continente;
    private String idioma;
    private String moneda;
    private String telefono;

    private PaisDominio(final Builder builder) {
        setId(builder.id);
        setNombre(builder.nombre);
        setCodigoISO(builder.codigoISO);
        setContinente(builder.continente);
        setIdioma(builder.idioma);
        setMoneda(builder.moneda);
        setTelefono(builder.telefono);
    }

    public static Builder builder() { return new Builder(); }

    public UUID getId() { return id; }
    private void setId(final UUID id) { this.id = id; }
    public String getNombre() { return nombre; }
    private void setNombre(final String nombre) { this.nombre = UtilTexto.aplicarTrim(nombre); }
    public String getCodigoISO() { return codigoISO; }
    private void setCodigoISO(final String codigoISO) { this.codigoISO = UtilTexto.aplicarTrim(codigoISO); }
    public String getContinente() { return continente; }
    private void setContinente(final String continente) { this.continente = UtilTexto.aplicarTrim(continente); }
    public String getIdioma() { return idioma; }
    private void setIdioma(final String idioma) { this.idioma = UtilTexto.aplicarTrim(idioma); }
    public String getMoneda() { return moneda; }
    private void setMoneda(final String moneda) { this.moneda = UtilTexto.aplicarTrim(moneda); }
    public String getTelefono() { return telefono; }
    private void setTelefono(final String telefono) { this.telefono = UtilTexto.aplicarTrim(telefono); }

    public static final class Builder {
        private UUID id;
        private String nombre;
        private String codigoISO;
        private String continente;
        private String idioma;
        private String moneda;
        private String telefono;

        public Builder id(final UUID id) { this.id = id; return this; }
        public Builder nombre(final String nombre) { this.nombre = nombre; return this; }
        public Builder codigoISO(final String codigoISO) { this.codigoISO = codigoISO; return this; }
        public Builder continente(final String continente) { this.continente = continente; return this; }
        public Builder idioma(final String idioma) { this.idioma = idioma; return this; }
        public Builder moneda(final String moneda) { this.moneda = moneda; return this; }
        public Builder telefono(final String telefono) { this.telefono = telefono; return this; }

        public PaisDominio build() { return new PaisDominio(this); }
    }
}
