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
 * Entidad JPA que representa la tabla "empleado" en SQL Server.
 *
 * RELACIÓN CON FINCA:
 *   Un empleado trabaja en una finca → relación N:1 (ManyToOne).
 *   La columna "id_finca" en la tabla empleado es la FK que apunta a finca.id.
 *
 * CADENA COMPLETA (todo EAGER):
 *   Empleado → Finca → LugarFinca → Ciudad → Departamento → País
 *
 * COLUMNAS SQL SERVER:
 *   id                 → uniqueidentifier  (PK)
 *   nombre             → varchar/nvarchar
 *   tipo_documento     → varchar/nvarchar
 *   numero_documento   → varchar/nvarchar
 *   cargo              → varchar/nvarchar
 *   telefono           → varchar/nvarchar
 *   fecha_vinculacion  → varchar  (dominio lo trata como String)
 *                        si la columna es DATE → ajustar a LocalDate
 *   id_finca           → uniqueidentifier  (FK → finca.id)
 */
@Entity
@Table(name = "empleado")
public class EmpleadoEntidad {

    @Id
    @Column(name = "id", columnDefinition = "uniqueidentifier", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    @Column(name = "tipo_documento", nullable = false, length = 50)
    private String tipoDocumento;

    @Column(name = "numero_documento", nullable = false, length = 20)
    private String numeroDocumento;

    @Column(name = "cargo", nullable = true, length = 100)
    private String cargo;

    @Column(name = "telefono", nullable = true, length = 20)
    private String telefono;

    // fecha_vinculacion: el dominio lo trata como String.
    // Si la columna SQL Server es DATE → ajustar a java.time.LocalDate.
    @Column(name = "fecha_vinculacion", nullable = true, length = 50)
    private String fechaVinculacion;

    // Relación N:1 — muchos empleados pueden trabajar en la misma finca.
    // FincaEntidad ya es @Entity con cadena EAGER completa hacia País.
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_finca", nullable = false)
    private FincaEntidad finca;

    // Constructor vacío REQUERIDO por JPA/Hibernate
    public EmpleadoEntidad() {}

    // Constructor completo usado por EmpleadoEntidadAssembler.toEntidad()
    public EmpleadoEntidad(final UUID id, final String nombre, final String tipoDocumento,
                           final String numeroDocumento, final String cargo, final String telefono,
                           final String fechaVinculacion, final FincaEntidad finca) {
        this.id = id;
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.cargo = cargo;
        this.telefono = telefono;
        this.fechaVinculacion = fechaVinculacion;
        this.finca = finca;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(final String nombre) { this.nombre = nombre; }

    public String getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(final String tipoDocumento) { this.tipoDocumento = tipoDocumento; }

    public String getNumeroDocumento() { return numeroDocumento; }
    public void setNumeroDocumento(final String numeroDocumento) { this.numeroDocumento = numeroDocumento; }

    public String getCargo() { return cargo; }
    public void setCargo(final String cargo) { this.cargo = cargo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(final String telefono) { this.telefono = telefono; }

    public String getFechaVinculacion() { return fechaVinculacion; }
    public void setFechaVinculacion(final String fechaVinculacion) { this.fechaVinculacion = fechaVinculacion; }

    public FincaEntidad getFinca() { return finca; }
    public void setFinca(final FincaEntidad finca) { this.finca = finca; }
}
