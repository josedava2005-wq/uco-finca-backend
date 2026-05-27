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
 * Entidad JPA que representa la tabla "ciudad" en SQL Server.
 *
 * RELACIÓN CON DEPARTAMENTO:
 *   Una ciudad pertenece a un departamento → relación N:1 (ManyToOne).
 *   La columna "id_departamento" en la tabla ciudad es la FK
 *   que apunta a departamento.id.
 *
 * CADENA COMPLETA:
 *   Ciudad → Departamento → País
 *   Cada nivel carga EAGER al siguiente para evitar LazyInitializationException
 *   cuando los assemblers acceden a los objetos fuera del contexto transaccional.
 *
 * FetchType.EAGER:
 *   Hibernate cargará el Departamento (y transitivamente el País) en el mismo
 *   SELECT usando JOIN. Necesario porque CiudadEntidadAssembler.toDominio()
 *   accede a entidad.getDepartamento() fuera de la sesión JPA.
 *   Con LAZY la sesión ya estaría cerrada y lanzaría LazyInitializationException.
 */
@Entity
@Table(name = "ciudad")
public class CiudadEntidad {

    @Id
    @Column(name = "id", columnDefinition = "uniqueidentifier", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    // Relación N:1 — muchas ciudades pueden pertenecer al mismo departamento.
    //
    // @JoinColumn(name = "id_departamento") → columna FK en la tabla ciudad
    // que referencia la PK "id" de la tabla departamento.
    //
    // DepartamentoEntidad ya tiene FetchType.EAGER hacia PaisEntidad,
    // por lo que la cadena Ciudad→Departamento→País se resuelve completamente.
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_departamento", nullable = false)
    private DepartamentoEntidad departamento;

    // Constructor vacío REQUERIDO por JPA/Hibernate
    public CiudadEntidad() {}

    // Constructor completo usado por CiudadEntidadAssembler.toEntidad()
    public CiudadEntidad(final UUID id, final String nombre, final DepartamentoEntidad departamento) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(final String nombre) { this.nombre = nombre; }

    public DepartamentoEntidad getDepartamento() { return departamento; }
    public void setDepartamento(final DepartamentoEntidad departamento) { this.departamento = departamento; }
}
