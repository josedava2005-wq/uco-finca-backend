package co.edu.uco.ucoparking.dto;

import java.util.UUID;

public final class FincaDTO {

    private UUID id;
    private String nombre;
    private Double hectareas;
    private String fechaRegistro;
    private UUID idLugarFinca;

    public FincaDTO() { this(null, null, null, null, null); }

    public FincaDTO(final UUID id, final String nombre, final Double hectareas, final String fechaRegistro, final UUID idLugarFinca) {
        this.id = id;
        this.nombre = nombre;
        this.hectareas = hectareas;
        this.fechaRegistro = fechaRegistro;
        this.idLugarFinca = idLugarFinca;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(final String nombre) { this.nombre = nombre; }
    public Double getHectareas() { return hectareas; }
    public void setHectareas(final Double hectareas) { this.hectareas = hectareas; }
    public String getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(final String fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    public UUID getIdLugarFinca() { return idLugarFinca; }
    public void setIdLugarFinca(final UUID idLugarFinca) { this.idLugarFinca = idLugarFinca; }
}
