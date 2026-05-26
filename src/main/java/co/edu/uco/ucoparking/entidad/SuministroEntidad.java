package co.edu.uco.ucoparking.entidad;

import java.util.UUID;

import co.edu.uco.ucoparking.entidad.AlmacenEntidad;
import co.edu.uco.ucoparking.entidad.ProveedorEntidad;
import co.edu.uco.ucoparking.entidad.TipoSuministroEntidad;

public class SuministroEntidad {

    private UUID id;
    private String nombre;
    private Double cantidad;
    private String unidadMedida;
    private TipoSuministroEntidad tipoSuministro;
    private AlmacenEntidad almacen;
    private ProveedorEntidad proveedor;

    public SuministroEntidad() {}

    public SuministroEntidad(final UUID id, final String nombre, final Double cantidad, final String unidadMedida, final TipoSuministroEntidad tipoSuministro, final AlmacenEntidad almacen, final ProveedorEntidad proveedor) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
        this.tipoSuministro = tipoSuministro;
        this.almacen = almacen;
        this.proveedor = proveedor;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(final String nombre) { this.nombre = nombre; }
    public Double getCantidad() { return cantidad; }
    public void setCantidad(final Double cantidad) { this.cantidad = cantidad; }
    public String getUnidadMedida() { return unidadMedida; }
    public void setUnidadMedida(final String unidadMedida) { this.unidadMedida = unidadMedida; }
    public TipoSuministroEntidad getTipoSuministro() { return tipoSuministro; }
    public void setTipoSuministro(final TipoSuministroEntidad tipoSuministro) { this.tipoSuministro = tipoSuministro; }
    public AlmacenEntidad getAlmacen() { return almacen; }
    public void setAlmacen(final AlmacenEntidad almacen) { this.almacen = almacen; }
    public ProveedorEntidad getProveedor() { return proveedor; }
    public void setProveedor(final ProveedorEntidad proveedor) { this.proveedor = proveedor; }
}
