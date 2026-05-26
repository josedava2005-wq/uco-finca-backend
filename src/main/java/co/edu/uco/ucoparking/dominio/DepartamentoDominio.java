package co.edu.uco.ucoparking.dominio;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.PaisDominio;
import co.edu.uco.ucoparking.transversal.UtilTexto;

public final class DepartamentoDominio {

    private UUID id;
    private String nombre;
    private String codigoDANE;
    private PaisDominio pais;

    private DepartamentoDominio(final Builder builder) {
        setId(builder.id);
        setNombre(builder.nombre);
        setCodigoDANE(builder.codigoDANE);
        setPais(builder.pais);
    }

    public static Builder builder() { return new Builder(); }

    public UUID getId() { return id; }
    private void setId(final UUID id) { this.id = id; }
    public String getNombre() { return nombre; }
    private void setNombre(final String nombre) { this.nombre = UtilTexto.aplicarTrim(nombre); }
    public String getCodigoDANE() { return codigoDANE; }
    private void setCodigoDANE(final String codigoDANE) { this.codigoDANE = UtilTexto.aplicarTrim(codigoDANE); }
    public PaisDominio getPais() { return pais; }
    private void setPais(final PaisDominio pais) { this.pais = pais; }

    public static final class Builder {
        private UUID id;
        private String nombre;
        private String codigoDANE;
        private PaisDominio pais;

        public Builder id(final UUID id) { this.id = id; return this; }
        public Builder nombre(final String nombre) { this.nombre = nombre; return this; }
        public Builder codigoDANE(final String codigoDANE) { this.codigoDANE = codigoDANE; return this; }
        public Builder pais(final PaisDominio pais) { this.pais = pais; return this; }

        public DepartamentoDominio build() { return new DepartamentoDominio(this); }
    }
}
