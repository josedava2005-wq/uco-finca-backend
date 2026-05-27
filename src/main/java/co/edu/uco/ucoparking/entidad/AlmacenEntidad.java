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
 * Entidad JPA que representa la tabla "almacen" en SQL Server.
 *
 * RELACIONES:
 *   1. Un almacén pertenece a una finca     → FK: id_finca        → finca.id
 *   2. Un almacén tiene un tipo de almacén  → FK: id_tipo_almacen → tipo_almacen.id
 *
 * Ambas FK son EAGER: los objetos relacionados se cargan en el mismo SELECT.
 *
 * CADENA COMPLETA (todo EAGER):
 *   Almacen → Finca → LugarFinca → Ciudad → Departamento → País
 *   Almacen → TipoAlmacen  (ya @Entity ✅, sin FK adicionales)
 *
 * COLUMNAS SQL SERVER:
 *   id               → uniqueidentifier  (PK)
 *   nombre           → varchar/nvarchar
 *   capacidad_m2     → float/decimal
 *   id_tipo_almacen  → uniqueidentifier  (FK → tipo_almacen.id)
 *   id_finca         → uniqueidentifier  (FK → finca.id)
 */
@Entity
@Table(name = "almacen")
public class AlmacenEntidad {

    @Id
    @Column(name = "id", columnDefinition = "uniqueidentifier", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    @Column(name = "capacidad_m2", nullable = true)
    private Double capacidadM2;

    // Relación N:1 hacia TipoAlmacen (ya es @Entity ✅ desde Sprint QA-2)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tipo_almacen", nullable = false)
    private TipoAlmacenEntidad tipoAlmacen;

    // Relación N:1 hacia Finca (ya es @Entity ✅ desde Sprint QA-4)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_finca", nullable = false)
    private FincaEntidad finca;

    // Constructor vacío REQUERIDO por JPA/Hibernate
    public AlmacenEntidad() {}

    // Constructor completo usado por AlmacenEntidadAssembler.toEntidad()
    public AlmacenEntidad(final UUID id, final String nombre, final Double capacidadM2,
                          final TipoAlmacenEntidad tipoAlmacen, final FincaEntidad finca) {
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
