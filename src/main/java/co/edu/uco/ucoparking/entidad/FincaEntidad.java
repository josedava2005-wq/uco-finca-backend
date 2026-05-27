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
 * Entidad JPA que representa la tabla "finca" en SQL Server.
 *
 * RELACIÓN CON LUGAR_FINCA:
 *   Una finca se ubica en un lugar de finca → relación N:1 (ManyToOne).
 *   La columna "id_lugar_finca" en la tabla finca es la FK
 *   que apunta a lugar_finca.id.
 *
 * CADENA COMPLETA (todo EAGER):
 *   Finca → LugarFinca → Ciudad → Departamento → País
 *   Hibernate resuelve toda la cadena en un único SELECT con 4 JOINs.
 *   No hay riesgo de LazyInitializationException en ningún assembler.
 *
 * NODO CENTRAL DEL SISTEMA:
 *   Esta entidad es referenciada por:
 *     - AnimalEntidad    (@ManyToOne → finca)
 *     - EmpleadoEntidad  (@ManyToOne → finca)
 *     - AlmacenEntidad   (@ManyToOne → finca)
 *     - ProductoEntidad  (@ManyToOne → finca)
 *   Al estar anotada como @Entity, esas entidades ya pueden referenciarla
 *   con @JoinColumn(name = "id_finca") en sus respectivas migraciones.
 *
 * COLUMNAS SQL SERVER:
 *   id              → uniqueidentifier  (PK)
 *   nombre          → varchar/nvarchar
 *   hectareas       → float/decimal
 *   fecha_registro  → varchar/nvarchar  (el dominio lo trata como String)
 *   id_lugar_finca  → uniqueidentifier  (FK → lugar_finca.id)
 *
 * NOTA sobre fecha_registro:
 *   El dominio usa String para la fecha. Si en SQL Server la columna es
 *   de tipo DATE o DATETIME, Hibernate lanzará un tipo mismatch.
 *   En ese caso, cambiar columnDefinition a "date" y el tipo Java a
 *   java.time.LocalDate (coordinado con el dominio).
 *   Si la columna es VARCHAR, este mapeo es correcto tal como está.
 */
@Entity
@Table(name = "finca")
public class FincaEntidad {

    @Id
    @Column(name = "id", columnDefinition = "uniqueidentifier", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    @Column(name = "hectareas", nullable = true)
    private Double hectareas;

    // fecha_registro: el dominio lo maneja como String.
    // Si la columna SQL Server es VARCHAR → este mapeo es correcto.
    // Si la columna SQL Server es DATE    → ajustar a java.time.LocalDate.
    @Column(name = "fecha_registro", nullable = true, length = 50)
    private String fechaRegistro;

    // Relación N:1 — muchas fincas pueden estar en el mismo lugar de finca.
    //
    // @JoinColumn(name = "id_lugar_finca") → columna FK en la tabla finca
    // que referencia la PK "id" de la tabla lugar_finca.
    //
    // LugarFincaEntidad ya tiene FetchType.EAGER hacia CiudadEntidad,
    // CiudadEntidad hacia DepartamentoEntidad, DepartamentoEntidad hacia PaisEntidad.
    // La cadena completa se resuelve sin LazyInitializationException.
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_lugar_finca", nullable = false)
    private LugarFincaEntidad lugarFinca;

    // Constructor vacío REQUERIDO por JPA/Hibernate
    public FincaEntidad() {}

    // Constructor completo usado por FincaEntidadAssembler.toEntidad()
    public FincaEntidad(final UUID id, final String nombre, final Double hectareas,
                        final String fechaRegistro, final LugarFincaEntidad lugarFinca) {
        this.id = id;
        this.nombre = nombre;
        this.hectareas = hectareas;
        this.fechaRegistro = fechaRegistro;
        this.lugarFinca = lugarFinca;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(final String nombre) { this.nombre = nombre; }

    public Double getHectareas() { return hectareas; }
    public void setHectareas(final Double hectareas) { this.hectareas = hectareas; }

    public String getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(final String fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    public LugarFincaEntidad getLugarFinca() { return lugarFinca; }
    public void setLugarFinca(final LugarFincaEntidad lugarFinca) { this.lugarFinca = lugarFinca; }
}
