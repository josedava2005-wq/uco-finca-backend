package co.edu.uco.ucoparking.entidad;

import java.util.UUID;

import co.edu.uco.ucoparking.entidad.AnimalEntidad;
import co.edu.uco.ucoparking.entidad.EmpleadoEntidad;

public class AlimentacionEntidad {

    private UUID id;
    private String fechaHora;
    private Double cantidad;
    private String unidadMedida;
    private String tipoAlimento;
    private AnimalEntidad animal;
    private EmpleadoEntidad empleado;

    public AlimentacionEntidad() {}

    public AlimentacionEntidad(final UUID id, final String fechaHora, final Double cantidad, final String unidadMedida, final String tipoAlimento, final AnimalEntidad animal, final EmpleadoEntidad empleado) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
        this.tipoAlimento = tipoAlimento;
        this.animal = animal;
        this.empleado = empleado;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }
    public String getFechaHora() { return fechaHora; }
    public void setFechaHora(final String fechaHora) { this.fechaHora = fechaHora; }
    public Double getCantidad() { return cantidad; }
    public void setCantidad(final Double cantidad) { this.cantidad = cantidad; }
    public String getUnidadMedida() { return unidadMedida; }
    public void setUnidadMedida(final String unidadMedida) { this.unidadMedida = unidadMedida; }
    public String getTipoAlimento() { return tipoAlimento; }
    public void setTipoAlimento(final String tipoAlimento) { this.tipoAlimento = tipoAlimento; }
    public AnimalEntidad getAnimal() { return animal; }
    public void setAnimal(final AnimalEntidad animal) { this.animal = animal; }
    public EmpleadoEntidad getEmpleado() { return empleado; }
    public void setEmpleado(final EmpleadoEntidad empleado) { this.empleado = empleado; }
}
