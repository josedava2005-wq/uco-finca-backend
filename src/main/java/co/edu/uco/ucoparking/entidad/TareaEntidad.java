package co.edu.uco.ucoparking.entidad;

import java.util.UUID;

import co.edu.uco.ucoparking.entidad.EmpleadoEntidad;
import co.edu.uco.ucoparking.entidad.FincaEntidad;

public class TareaEntidad {

    private UUID id;
    private String descripcion;
    private String fechaHora;
    private String estado;
    private EmpleadoEntidad empleado;
    private FincaEntidad finca;

    public TareaEntidad() {}

    public TareaEntidad(final UUID id, final String descripcion, final String fechaHora, final String estado, final EmpleadoEntidad empleado, final FincaEntidad finca) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.empleado = empleado;
        this.finca = finca;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(final String descripcion) { this.descripcion = descripcion; }
    public String getFechaHora() { return fechaHora; }
    public void setFechaHora(final String fechaHora) { this.fechaHora = fechaHora; }
    public String getEstado() { return estado; }
    public void setEstado(final String estado) { this.estado = estado; }
    public EmpleadoEntidad getEmpleado() { return empleado; }
    public void setEmpleado(final EmpleadoEntidad empleado) { this.empleado = empleado; }
    public FincaEntidad getFinca() { return finca; }
    public void setFinca(final FincaEntidad finca) { this.finca = finca; }
}
