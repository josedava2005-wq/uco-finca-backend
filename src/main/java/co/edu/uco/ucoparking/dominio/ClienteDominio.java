package co.edu.uco.ucoparking.dominio;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.CiudadDominio;
import co.edu.uco.ucoparking.transversal.UtilTexto;

public final class ClienteDominio {

    private UUID id;
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombre;
    private String correo;
    private String telefono;
    private CiudadDominio ciudad;

    private ClienteDominio(final Builder builder) {
        setId(builder.id);
        setTipoDocumento(builder.tipoDocumento);
        setNumeroDocumento(builder.numeroDocumento);
        setNombre(builder.nombre);
        setCorreo(builder.correo);
        setTelefono(builder.telefono);
        setCiudad(builder.ciudad);
    }

    public static Builder builder() { return new Builder(); }

    public UUID getId() { return id; }
    private void setId(final UUID id) { this.id = id; }
    public String getTipoDocumento() { return tipoDocumento; }
    private void setTipoDocumento(final String tipoDocumento) { this.tipoDocumento = UtilTexto.aplicarTrim(tipoDocumento); }
    public String getNumeroDocumento() { return numeroDocumento; }
    private void setNumeroDocumento(final String numeroDocumento) { this.numeroDocumento = UtilTexto.aplicarTrim(numeroDocumento); }
    public String getNombre() { return nombre; }
    private void setNombre(final String nombre) { this.nombre = UtilTexto.aplicarTrim(nombre); }
    public String getCorreo() { return correo; }
    private void setCorreo(final String correo) { this.correo = UtilTexto.aplicarTrim(correo); }
    public String getTelefono() { return telefono; }
    private void setTelefono(final String telefono) { this.telefono = UtilTexto.aplicarTrim(telefono); }
    public CiudadDominio getCiudad() { return ciudad; }
    private void setCiudad(final CiudadDominio ciudad) { this.ciudad = ciudad; }

    public static final class Builder {
        private UUID id;
        private String tipoDocumento;
        private String numeroDocumento;
        private String nombre;
        private String correo;
        private String telefono;
        private CiudadDominio ciudad;

        public Builder id(final UUID id) { this.id = id; return this; }
        public Builder tipoDocumento(final String tipoDocumento) { this.tipoDocumento = tipoDocumento; return this; }
        public Builder numeroDocumento(final String numeroDocumento) { this.numeroDocumento = numeroDocumento; return this; }
        public Builder nombre(final String nombre) { this.nombre = nombre; return this; }
        public Builder correo(final String correo) { this.correo = correo; return this; }
        public Builder telefono(final String telefono) { this.telefono = telefono; return this; }
        public Builder ciudad(final CiudadDominio ciudad) { this.ciudad = ciudad; return this; }

        public ClienteDominio build() { return new ClienteDominio(this); }
    }
}
