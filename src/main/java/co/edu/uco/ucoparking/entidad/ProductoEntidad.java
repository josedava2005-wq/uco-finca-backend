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
 * Entidad JPA que representa la tabla "producto" en SQL Server.
 *
 * RELACIÓN CON FINCA:
 *   Un producto pertenece a una finca → relación N:1 (ManyToOne).
 *   La columna "id_finca" en la tabla producto es la FK que apunta a finca.id.
 *
 * CADENA COMPLETA (todo EAGER):
 *   Producto → Finca → LugarFinca → Ciudad → Departamento → País
 *
 * COLUMNAS SQL SERVER:
 *   id               → uniqueidentifier  (PK)
 *   nombre           → varchar/nvarchar
 *   unidad_medida    → varchar/nvarchar
 *   precio_unitario  → float/decimal
 *   stock_disponible → float/decimal
 *   descripcion      → varchar/nvarchar
 *   id_finca         → uniqueidentifier  (FK → finca.id)
 */
@Entity
@Table(name = "producto")
public class ProductoEntidad {

    @Id
    @Column(name = "id", columnDefinition = "uniqueidentifier", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    @Column(name = "unidad_medida", nullable = true, length = 50)
    private String unidadMedida;

    @Column(name = "precio_unitario", nullable = true)
    private Double precioUnitario;

    @Column(name = "stock_disponible", nullable = true)
    private Double stockDisponible;

    @Column(name = "descripcion", nullable = true, length = 500)
    private String descripcion;

    // Relación N:1 — muchos productos pueden pertenecer a la misma finca.
    // FincaEntidad ya es @Entity con cadena EAGER completa hacia País.
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_finca", nullable = false)
    private FincaEntidad finca;

    // Constructor vacío REQUERIDO por JPA/Hibernate
    public ProductoEntidad() {}

    // Constructor completo usado por ProductoEntidadAssembler.toEntidad()
    public ProductoEntidad(final UUID id, final String nombre, final String unidadMedida,
                           final Double precioUnitario, final Double stockDisponible,
                           final String descripcion, final FincaEntidad finca) {
        this.id = id;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.precioUnitario = precioUnitario;
        this.stockDisponible = stockDisponible;
        this.descripcion = descripcion;
        this.finca = finca;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(final String nombre) { this.nombre = nombre; }

    public String getUnidadMedida() { return unidadMedida; }
    public void setUnidadMedida(final String unidadMedida) { this.unidadMedida = unidadMedida; }

    public Double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(final Double precioUnitario) { this.precioUnitario = precioUnitario; }

    public Double getStockDisponible() { return stockDisponible; }
    public void setStockDisponible(final Double stockDisponible) { this.stockDisponible = stockDisponible; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(final String descripcion) { this.descripcion = descripcion; }

    public FincaEntidad getFinca() { return finca; }
    public void setFinca(final FincaEntidad finca) { this.finca = finca; }
}
