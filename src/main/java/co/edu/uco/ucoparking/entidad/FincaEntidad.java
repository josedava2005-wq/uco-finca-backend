package co.edu.uco.ucoparking.entidad;

import java.util.UUID;

import co.edu.uco.ucoparking.entidad.LugarFincaEntidad;

public class FincaEntidad {

    private UUID id;
    private String nombre;
    private Double hectareas;
    private String fechaRegistro;
    private LugarFincaEntidad lugarFinca;

    public FincaEntidad() {}

    public FincaEntidad(final UUID id, final String nombre, final Double hectareas, final String fechaRegistro, final LugarFincaEntidad lugarFinca) {
        this.id = id;
        this.nombre = nombre;
        this.hectareas = hectareas;
        this.fechaRegistro = fechaRegistro;
        this.lugarFinca = lugarFinca;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(final String nombre) { this.nombre = nombre; }
    public Double getHectareas() { return hectareas; }
    public void setHectareas(final Double hectareas) { this.hectareas = hectareas; }
    public String getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(final String fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    public LugarFincaEntidad getLugarFinca() { return lugarFinca; }
    public void setLugarFinca(final LugarFincaEntidad lugarFinca) { this.lugarFinca = lugarFinca; }
}
