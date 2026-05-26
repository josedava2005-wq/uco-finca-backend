package co.edu.uco.ucoparking.entidad;

import java.util.UUID;

import co.edu.uco.ucoparking.entidad.AnimalEntidad;
import co.edu.uco.ucoparking.entidad.EmpleadoEntidad;

public class CuidadoEspecialEntidad {

    private UUID id;
    private String tipo;
    private String fechaHora;
    private String descripcion;
    private AnimalEntidad animal;
    private EmpleadoEntidad empleado;

    public CuidadoEspecialEntidad() {}

    public CuidadoEspecialEntidad(final UUID id, final String tipo, final String fechaHora, final String descripcion, final AnimalEntidad animal, final EmpleadoEntidad empleado) {
        this.id = id;
        this.tipo = tipo;
        this.fechaHora = fechaHora;
        this.descripcion = descripcion;
        this.animal = animal;
        this.empleado = empleado;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }
    public String getTipo() { return tipo; }
    public void setTipo(final String tipo) { this.tipo = tipo; }
    public String getFechaHora() { return fechaHora; }
    public void setFechaHora(final String fechaHora) { this.fechaHora = fechaHora; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(final String descripcion) { this.descripcion = descripcion; }
    public AnimalEntidad getAnimal() { return animal; }
    public void setAnimal(final AnimalEntidad animal) { this.animal = animal; }
    public EmpleadoEntidad getEmpleado() { return empleado; }
    public void setEmpleado(final EmpleadoEntidad empleado) { this.empleado = empleado; }
}
