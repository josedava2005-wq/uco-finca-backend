package co.edu.uco.ucoparking.entidad;

import java.util.UUID;

import co.edu.uco.ucoparking.entidad.AnimalEntidad;

public class EstadoAnimalEntidad {

    private UUID id;
    private String estado;
    private String fechaRegistro;
    private String observacion;
    private AnimalEntidad animal;

    public EstadoAnimalEntidad() {}

    public EstadoAnimalEntidad(final UUID id, final String estado, final String fechaRegistro, final String observacion, final AnimalEntidad animal) {
        this.id = id;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
        this.observacion = observacion;
        this.animal = animal;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }
    public String getEstado() { return estado; }
    public void setEstado(final String estado) { this.estado = estado; }
    public String getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(final String fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    public String getObservacion() { return observacion; }
    public void setObservacion(final String observacion) { this.observacion = observacion; }
    public AnimalEntidad getAnimal() { return animal; }
    public void setAnimal(final AnimalEntidad animal) { this.animal = animal; }
}
