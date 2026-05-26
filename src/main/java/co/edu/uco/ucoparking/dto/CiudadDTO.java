package co.edu.uco.ucoparking.dto;

import java.util.UUID;

public final class CiudadDTO {

    private UUID id;
    private String nombre;
    private UUID idDepartamento;

    public CiudadDTO() { this(null, null, null); }

    public CiudadDTO(final UUID id, final String nombre, final UUID idDepartamento) {
        this.id = id;
        this.nombre = nombre;
        this.idDepartamento = idDepartamento;
    }

    public UUID getId() { return id; }
    public String getNombre() { return nombre; }
    public UUID getIdDepartamento() { return idDepartamento; }
}
