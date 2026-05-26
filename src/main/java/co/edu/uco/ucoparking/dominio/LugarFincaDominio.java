package co.edu.uco.ucoparking.dominio;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.CiudadDominio;
import co.edu.uco.ucoparking.transversal.UtilTexto;

public final class LugarFincaDominio {

    private UUID id;
    private String vereda;
    private String sector;
    private CiudadDominio ciudad;

    private LugarFincaDominio(final Builder builder) {
        setId(builder.id);
        setVereda(builder.vereda);
        setSector(builder.sector);
        setCiudad(builder.ciudad);
    }

    public static Builder builder() { return new Builder(); }

    public UUID getId() { return id; }
    private void setId(final UUID id) { this.id = id; }
    public String getVereda() { return vereda; }
    private void setVereda(final String vereda) { this.vereda = UtilTexto.aplicarTrim(vereda); }
    public String getSector() { return sector; }
    private void setSector(final String sector) { this.sector = UtilTexto.aplicarTrim(sector); }
    public CiudadDominio getCiudad() { return ciudad; }
    private void setCiudad(final CiudadDominio ciudad) { this.ciudad = ciudad; }

    public static final class Builder {
        private UUID id;
        private String vereda;
        private String sector;
        private CiudadDominio ciudad;

        public Builder id(final UUID id) { this.id = id; return this; }
        public Builder vereda(final String vereda) { this.vereda = vereda; return this; }
        public Builder sector(final String sector) { this.sector = sector; return this; }
        public Builder ciudad(final CiudadDominio ciudad) { this.ciudad = ciudad; return this; }

        public LugarFincaDominio build() { return new LugarFincaDominio(this); }
    }
}
