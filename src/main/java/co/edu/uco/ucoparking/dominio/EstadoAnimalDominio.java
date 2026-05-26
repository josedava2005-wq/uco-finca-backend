package co.edu.uco.ucoparking.dominio;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.AnimalDominio;
import co.edu.uco.ucoparking.transversal.UtilTexto;

public final class EstadoAnimalDominio {

    private UUID id;
    private String estado;
    private String fechaRegistro;
    private String observacion;
    private AnimalDominio animal;

    private EstadoAnimalDominio(final Builder builder) {
        setId(builder.id);
        setEstado(builder.estado);
        setFechaRegistro(builder.fechaRegistro);
        setObservacion(builder.observacion);
        setAnimal(builder.animal);
    }

    public static Builder builder() { return new Builder(); }

    public UUID getId() { return id; }
    private void setId(final UUID id) { this.id = id; }
    public String getEstado() { return estado; }
    private void setEstado(final String estado) { this.estado = UtilTexto.aplicarTrim(estado); }
    public String getFechaRegistro() { return fechaRegistro; }
    private void setFechaRegistro(final String fechaRegistro) { this.fechaRegistro = UtilTexto.aplicarTrim(fechaRegistro); }
    public String getObservacion() { return observacion; }
    private void setObservacion(final String observacion) { this.observacion = UtilTexto.aplicarTrim(observacion); }
    public AnimalDominio getAnimal() { return animal; }
    private void setAnimal(final AnimalDominio animal) { this.animal = animal; }

    public static final class Builder {
        private UUID id;
        private String estado;
        private String fechaRegistro;
        private String observacion;
        private AnimalDominio animal;

        public Builder id(final UUID id) { this.id = id; return this; }
        public Builder estado(final String estado) { this.estado = estado; return this; }
        public Builder fechaRegistro(final String fechaRegistro) { this.fechaRegistro = fechaRegistro; return this; }
        public Builder observacion(final String observacion) { this.observacion = observacion; return this; }
        public Builder animal(final AnimalDominio animal) { this.animal = animal; return this; }

        public EstadoAnimalDominio build() { return new EstadoAnimalDominio(this); }
    }
}
