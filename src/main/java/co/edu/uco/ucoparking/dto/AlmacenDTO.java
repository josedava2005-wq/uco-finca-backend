package co.edu.uco.ucoparking.dto;

import java.util.UUID;

public final class AlmacenDTO {

    private UUID id;
    private String nombre;
    private Double capacidadM2;
    private UUID idTipoAlmacen;
    private UUID idFinca;

    public AlmacenDTO() { this(null, null, null, null, null); }

    public AlmacenDTO(final UUID id, final String nombre, final Double capacidadM2, final UUID idTipoAlmacen, final UUID idFinca) {
        this.id = id;
        this.nombre = nombre;
        this.capacidadM2 = capacidadM2;
        this.idTipoAlmacen = idTipoAlmacen;
        this.idFinca = idFinca;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(final String nombre) { this.nombre = nombre; }
    public Double getCapacidadM2() { return capacidadM2; }
    public void setCapacidadM2(final Double capacidadM2) { this.capacidadM2 = capacidadM2; }
    public UUID getIdTipoAlmacen() { return idTipoAlmacen; }
    public void setIdTipoAlmacen(final UUID idTipoAlmacen) { this.idTipoAlmacen = idTipoAlmacen; }
    public UUID getIdFinca() { return idFinca; }
    public void setIdFinca(final UUID idFinca) { this.idFinca = idFinca; }
}
