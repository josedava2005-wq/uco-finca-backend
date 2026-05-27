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
 * Entidad JPA — tabla "alimentacion" en SQL Server.
 *
 * RELACIONES FK:
 *   id_animal   → animal.id    (AnimalEntidad ya es @Entity ✅)
 *   id_empleado → empleado.id  (EmpleadoEntidad ya es @Entity ✅)
 *
 * COLUMNAS:
 *   id            → uniqueidentifier
 *   fecha_hora    → varchar
 *   cantidad      → float
 *   unidad_medida → varchar
 *   tipo_alimento → varchar
 *   id_animal     → uniqueidentifier FK
 *   id_empleado   → uniqueidentifier FK
 */
@Entity
@Table(name = "alimentacion")
public class AlimentacionEntidad {

    @Id
    @Column(name = "id", columnDefinition = "uniqueidentifier", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "fecha_hora", nullable = true, length = 50)
    private String fechaHora;

    @Column(name = "cantidad", nullable = true)
    private Double cantidad;

    @Column(name = "unidad_medida", nullable = true, length = 50)
    private String unidadMedida;

    @Column(name = "tipo_alimento", nullable = true, length = 100)
    private String tipoAlimento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_animal", nullable = false)
    private AnimalEntidad animal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_empleado", nullable = false)
    private EmpleadoEntidad empleado;

    public AlimentacionEntidad() {}

    public AlimentacionEntidad(final UUID id, final String fechaHora, final Double cantidad,
                               final String unidadMedida, final String tipoAlimento,
                               final AnimalEntidad animal, final EmpleadoEntidad empleado) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
        this.tipoAlimento = tipoAlimento;
        this.animal = animal;
        this.empleado = empleado;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }
    public String getFechaHora() { return fechaHora; }
    public void setFechaHora(final String fechaHora) { this.fechaHora = fechaHora; }
    public Double getCantidad() { return cantidad; }
    public void setCantidad(final Double cantidad) { this.cantidad = cantidad; }
    public String getUnidadMedida() { return unidadMedida; }
    public void setUnidadMedida(final String unidadMedida) { this.unidadMedida = unidadMedida; }
    public String getTipoAlimento() { return tipoAlimento; }
    public void setTipoAlimento(final String tipoAlimento) { this.tipoAlimento = tipoAlimento; }
    public AnimalEntidad getAnimal() { return animal; }
    public void setAnimal(final AnimalEntidad animal) { this.animal = animal; }
    public EmpleadoEntidad getEmpleado() { return empleado; }
    public void setEmpleado(final EmpleadoEntidad empleado) { this.empleado = empleado; }
}
