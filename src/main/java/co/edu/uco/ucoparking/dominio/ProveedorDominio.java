package co.edu.uco.ucoparking.dominio;

import java.util.UUID;
import co.edu.uco.ucoparking.transversal.UtilTexto;

public final class ProveedorDominio {

    private UUID id;
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;

    private ProveedorDominio(final Builder builder) {
        setId(builder.id);
        setTipoDocumento(builder.tipoDocumento);
        setNumeroDocumento(builder.numeroDocumento);
        setNombre(builder.nombre);
        setCorreo(builder.correo);
        setTelefono(builder.telefono);
        setDireccion(builder.direccion);
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
    public String getDireccion() { return direccion; }
    private void setDireccion(final String direccion) { this.direccion = UtilTexto.aplicarTrim(direccion); }

    public static final class Builder {
        private UUID id;
        private String tipoDocumento;
        private String numeroDocumento;
        private String nombre;
        private String correo;
        private String telefono;
        private String direccion;

        public Builder id(final UUID id) { this.id = id; return this; }
        public Builder tipoDocumento(final String tipoDocumento) { this.tipoDocumento = tipoDocumento; return this; }
        public Builder numeroDocumento(final String numeroDocumento) { this.numeroDocumento = numeroDocumento; return this; }
        public Builder nombre(final String nombre) { this.nombre = nombre; return this; }
        public Builder correo(final String correo) { this.correo = correo; return this; }
        public Builder telefono(final String telefono) { this.telefono = telefono; return this; }
        public Builder direccion(final String direccion) { this.direccion = direccion; return this; }

        public ProveedorDominio build() { return new ProveedorDominio(this); }
    }
}
