package co.edu.uco.ucoparking.entidad;

import java.util.UUID;

import co.edu.uco.ucoparking.entidad.DepartamentoEntidad;

public class CiudadEntidad {

    private UUID id;
    private String nombre;
    private DepartamentoEntidad departamento;

    public CiudadEntidad() {}

    public CiudadEntidad(final UUID id, final String nombre, final DepartamentoEntidad departamento) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(final String nombre) { this.nombre = nombre; }
    public DepartamentoEntidad getDepartamento() { return departamento; }
    public void setDepartamento(final DepartamentoEntidad departamento) { this.departamento = departamento; }
}
