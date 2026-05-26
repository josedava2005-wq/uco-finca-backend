package co.edu.uco.ucoparking.dominio;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.EmpleadoDominio;
import co.edu.uco.ucoparking.dominio.FincaDominio;
import co.edu.uco.ucoparking.transversal.UtilTexto;

public final class TareaDominio {

    private UUID id;
    private String descripcion;
    private String fechaHora;
    private String estado;
    private EmpleadoDominio empleado;
    private FincaDominio finca;

    private TareaDominio(final Builder builder) {
        setId(builder.id);
        setDescripcion(builder.descripcion);
        setFechaHora(builder.fechaHora);
        setEstado(builder.estado);
        setEmpleado(builder.empleado);
        setFinca(builder.finca);
    }

    public static Builder builder() { return new Builder(); }

    public UUID getId() { return id; }
    private void setId(final UUID id) { this.id = id; }
    public String getDescripcion() { return descripcion; }
    private void setDescripcion(final String descripcion) { this.descripcion = UtilTexto.aplicarTrim(descripcion); }
    public String getFechaHora() { return fechaHora; }
    private void setFechaHora(final String fechaHora) { this.fechaHora = UtilTexto.aplicarTrim(fechaHora); }
    public String getEstado() { return estado; }
    private void setEstado(final String estado) { this.estado = UtilTexto.aplicarTrim(estado); }
    public EmpleadoDominio getEmpleado() { return empleado; }
    private void setEmpleado(final EmpleadoDominio empleado) { this.empleado = empleado; }
    public FincaDominio getFinca() { return finca; }
    private void setFinca(final FincaDominio finca) { this.finca = finca; }

    public static final class Builder {
        private UUID id;
        private String descripcion;
        private String fechaHora;
        private String estado;
        private EmpleadoDominio empleado;
        private FincaDominio finca;

        public Builder id(final UUID id) { this.id = id; return this; }
        public Builder descripcion(final String descripcion) { this.descripcion = descripcion; return this; }
        public Builder fechaHora(final String fechaHora) { this.fechaHora = fechaHora; return this; }
        public Builder estado(final String estado) { this.estado = estado; return this; }
        public Builder empleado(final EmpleadoDominio empleado) { this.empleado = empleado; return this; }
        public Builder finca(final FincaDominio finca) { this.finca = finca; return this; }

        public TareaDominio build() { return new TareaDominio(this); }
    }
}
