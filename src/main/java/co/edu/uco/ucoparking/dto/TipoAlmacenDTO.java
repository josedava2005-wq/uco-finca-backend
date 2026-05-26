package co.edu.uco.ucoparking.dto;

import java.util.UUID;

public final class TipoAlmacenDTO {

    private UUID id;
    private String nombre;
    private String descripcion;

    public TipoAlmacenDTO() { this(null, null, null); }

    public TipoAlmacenDTO(final UUID id, final String nombre, final String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public UUID getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
}
