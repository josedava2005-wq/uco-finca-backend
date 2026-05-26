package co.edu.uco.ucoparking.entidad;

import java.util.UUID;

import co.edu.uco.ucoparking.entidad.FincaEntidad;
import co.edu.uco.ucoparking.entidad.TipoAlmacenEntidad;

public class AlmacenEntidad {

    private UUID id;
    private String nombre;
    private Double capacidadM2;
    private TipoAlmacenEntidad tipoAlmacen;
    private FincaEntidad finca;

    public AlmacenEntidad() {}

    public AlmacenEntidad(final UUID id, final String nombre, final Double capacidadM2, final TipoAlmacenEntidad tipoAlmacen, final FincaEntidad finca) {
        this.id = id;
        this.nombre = nombre;
        this.capacidadM2 = capacidadM2;
        this.tipoAlmacen = tipoAlmacen;
        this.finca = finca;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(final String nombre) { this.nombre = nombre; }
    public Double getCapacidadM2() { return capacidadM2; }
    public void setCapacidadM2(final Double capacidadM2) { this.capacidadM2 = capacidadM2; }
    public TipoAlmacenEntidad getTipoAlmacen() { return tipoAlmacen; }
    public void setTipoAlmacen(final TipoAlmacenEntidad tipoAlmacen) { this.tipoAlmacen = tipoAlmacen; }
    public FincaEntidad getFinca() { return finca; }
    public void setFinca(final FincaEntidad finca) { this.finca = finca; }
}
