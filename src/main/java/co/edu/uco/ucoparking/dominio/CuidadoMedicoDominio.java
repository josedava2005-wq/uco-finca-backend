package co.edu.uco.ucoparking.dominio;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.AnimalDominio;
import co.edu.uco.ucoparking.dominio.EmpleadoDominio;
import co.edu.uco.ucoparking.transversal.UtilTexto;

public final class CuidadoMedicoDominio {

    private UUID id;
    private String tipo;
    private String fechaHora;
    private String descripcion;
    private String medicamento;
    private AnimalDominio animal;
    private EmpleadoDominio empleado;

    private CuidadoMedicoDominio(final Builder builder) {
        setId(builder.id);
        setTipo(builder.tipo);
        setFechaHora(builder.fechaHora);
        setDescripcion(builder.descripcion);
        setMedicamento(builder.medicamento);
        setAnimal(builder.animal);
        setEmpleado(builder.empleado);
    }

    public static Builder builder() { return new Builder(); }

    public UUID getId() { return id; }
    private void setId(final UUID id) { this.id = id; }
    public String getTipo() { return tipo; }
    private void setTipo(final String tipo) { this.tipo = UtilTexto.aplicarTrim(tipo); }
    public String getFechaHora() { return fechaHora; }
    private void setFechaHora(final String fechaHora) { this.fechaHora = UtilTexto.aplicarTrim(fechaHora); }
    public String getDescripcion() { return descripcion; }
    private void setDescripcion(final String descripcion) { this.descripcion = UtilTexto.aplicarTrim(descripcion); }
    public String getMedicamento() { return medicamento; }
    private void setMedicamento(final String medicamento) { this.medicamento = UtilTexto.aplicarTrim(medicamento); }
    public AnimalDominio getAnimal() { return animal; }
    private void setAnimal(final AnimalDominio animal) { this.animal = animal; }
    public EmpleadoDominio getEmpleado() { return empleado; }
    private void setEmpleado(final EmpleadoDominio empleado) { this.empleado = empleado; }

    public static final class Builder {
        private UUID id;
        private String tipo;
        private String fechaHora;
        private String descripcion;
        private String medicamento;
        private AnimalDominio animal;
        private EmpleadoDominio empleado;

        public Builder id(final UUID id) { this.id = id; return this; }
        public Builder tipo(final String tipo) { this.tipo = tipo; return this; }
        public Builder fechaHora(final String fechaHora) { this.fechaHora = fechaHora; return this; }
        public Builder descripcion(final String descripcion) { this.descripcion = descripcion; return this; }
        public Builder medicamento(final String medicamento) { this.medicamento = medicamento; return this; }
        public Builder animal(final AnimalDominio animal) { this.animal = animal; return this; }
        public Builder empleado(final EmpleadoDominio empleado) { this.empleado = empleado; return this; }

        public CuidadoMedicoDominio build() { return new CuidadoMedicoDominio(this); }
    }
}
