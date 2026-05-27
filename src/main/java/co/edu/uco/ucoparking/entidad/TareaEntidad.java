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
 * Entidad JPA — tabla "tarea" en SQL Server.
 *
 * RELACIONES FK:
 *   id_empleado → empleado.id  (EmpleadoEntidad ya es @Entity ✅)
 *   id_finca    → finca.id     (FincaEntidad ya es @Entity ✅)
 *
 * COLUMNAS:
 *   id          → uniqueidentifier
 *   descripcion → varchar
 *   fecha_hora  → varchar (dominio trata fechas como String)
 *   estado      → varchar
 *   id_empleado → uniqueidentifier FK
 *   id_finca    → uniqueidentifier FK
 */
@Entity
@Table(name = "tarea")
public class TareaEntidad {

    @Id
    @Column(name = "id", columnDefinition = "uniqueidentifier", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    @Column(name = "fecha_hora", nullable = true, length = 50)
    private String fechaHora;

    @Column(name = "estado", nullable = true, length = 50)
    private String estado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_empleado", nullable = false)
    private EmpleadoEntidad empleado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_finca", nullable = false)
    private FincaEntidad finca;

    public TareaEntidad() {}

    public TareaEntidad(final UUID id, final String descripcion, final String fechaHora,
                        final String estado, final EmpleadoEntidad empleado, final FincaEntidad finca) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.empleado = empleado;
        this.finca = finca;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(final String descripcion) { this.descripcion = descripcion; }
    public String getFechaHora() { return fechaHora; }
    public void setFechaHora(final String fechaHora) { this.fechaHora = fechaHora; }
    public String getEstado() { return estado; }
    public void setEstado(final String estado) { this.estado = estado; }
    public EmpleadoEntidad getEmpleado() { return empleado; }
    public void setEmpleado(final EmpleadoEntidad empleado) { this.empleado = empleado; }
    public FincaEntidad getFinca() { return finca; }
    public void setFinca(final FincaEntidad finca) { this.finca = finca; }
}
