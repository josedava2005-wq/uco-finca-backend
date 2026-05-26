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
    public String getNombre() { return nombre; }
    public Double getHectareas() { return hectareas; }
    public String getFechaRegistro() { return fechaRegistro; }
    public UUID getIdLugarFinca() { return idLugarFinca; }
}
