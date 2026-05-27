package co.edu.uco.ucoparking.entidad;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entidad JPA — tabla "suministro" en SQL Server.
 *
 * RELACIONES FK:
 *   id_tipo_suministro → tipo_suministro.id  (TipoSuministroEntidad ya es @Entity ✅)
 *   id_almacen         → almacen.id           (AlmacenEntidad ya es @Entity ✅)
 *   id_proveedor       → proveedor.id         (ProveedorEntidad ya es @Entity ✅)
 *
 * COLUMNAS:
 *   id                 → uniqueidentifier
 *   nombre             → varchar
 *   cantidad           → float
 *   unidad_medida      → varchar
 *   id_tipo_suministro → uniqueidentifier FK
 *   id_almacen         → uniqueidentifier FK
 *   id_proveedor       → uniqueidentifier FK
 */
@Entity
@Table(name = "suministro")
public class SuministroEntidad {

    @Id
    @Column(name = "id", columnDefinition = "uniqueidentifier", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    @Column(name = "cantidad", nullable = true)
    private Double cantidad;

    @Column(name = "unidad_medida", nullable = true, length = 50)
    private String unidadMedida;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tipo_suministro", nullable = false)
    private TipoSuministroEntidad tipoSuministro;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_almacen", nullable = false)
    private AlmacenEntidad almacen;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_proveedor", nullable = false)
    private ProveedorEntidad proveedor;

    public SuministroEntidad() {}

    public SuministroEntidad(final UUID id, final String nombre, final Double cantidad,
                             final String unidadMedida, final TipoSuministroEntidad tipoSuministro,
                             final AlmacenEntidad almacen, final ProveedorEntidad proveedor) {
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
