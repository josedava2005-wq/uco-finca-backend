package co.edu.uco.ucoparking.dominio;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.FincaDominio;
import co.edu.uco.ucoparking.transversal.UtilTexto;

public final class EmpleadoDominio {

    private UUID id;
    private String nombre;
    private String tipoDocumento;
    private String numeroDocumento;
    private String cargo;
    private String telefono;
    private String fechaVinculacion;
    private FincaDominio finca;

    private EmpleadoDominio(final Builder builder) {
        setId(builder.id);
        setNombre(builder.nombre);
        setTipoDocumento(builder.tipoDocumento);
        setNumeroDocumento(builder.numeroDocumento);
        setCargo(builder.cargo);
        setTelefono(builder.telefono);
        setFechaVinculacion(builder.fechaVinculacion);
        setFinca(builder.finca);
    }

    public static Builder builder() { return new Builder(); }

    public UUID getId() { return id; }
    private void setId(final UUID id) { this.id = id; }
    public String getNombre() { return nombre; }
    private void setNombre(final String nombre) { this.nombre = UtilTexto.aplicarTrim(nombre); }
    public String getTipoDocumento() { return tipoDocumento; }
    private void setTipoDocumento(final String tipoDocumento) { this.tipoDocumento = UtilTexto.aplicarTrim(tipoDocumento); }
    public String getNumeroDocumento() { return numeroDocumento; }
    private void setNumeroDocumento(final String numeroDocumento) { this.numeroDocumento = UtilTexto.aplicarTrim(numeroDocumento); }
    public String getCargo() { return cargo; }
    private void setCargo(final String cargo) { this.cargo = UtilTexto.aplicarTrim(cargo); }
    public String getTelefono() { return telefono; }
    private void setTelefono(final String telefono) { this.telefono = UtilTexto.aplicarTrim(telefono); }
    public String getFechaVinculacion() { return fechaVinculacion; }
    private void setFechaVinculacion(final String fechaVinculacion) { this.fechaVinculacion = UtilTexto.aplicarTrim(fechaVinculacion); }
    public FincaDominio getFinca() { return finca; }
    private void setFinca(final FincaDominio finca) { this.finca = finca; }

    public static final class Builder {
        private UUID id;
        private String nombre;
        private String tipoDocumento;
        private String numeroDocumento;
        private String cargo;
        private String telefono;
        private String fechaVinculacion;
        private FincaDominio finca;

        public Builder id(final UUID id) { this.id = id; return this; }
        public Builder nombre(final String nombre) { this.nombre = nombre; return this; }
        public Builder tipoDocumento(final String tipoDocumento) { this.tipoDocumento = tipoDocumento; return this; }
        public Builder numeroDocumento(final String numeroDocumento) { this.numeroDocumento = numeroDocumento; return this; }
        public Builder cargo(final String cargo) { this.cargo = cargo; return this; }
        public Builder telefono(final String telefono) { this.telefono = telefono; return this; }
        public Builder fechaVinculacion(final String fechaVinculacion) { this.fechaVinculacion = fechaVinculacion; return this; }
        public Builder finca(final FincaDominio finca) { this.finca = finca; return this; }

        public EmpleadoDominio build() { return new EmpleadoDominio(this); }
    }
}
