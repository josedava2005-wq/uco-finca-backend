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
 * Entidad JPA que representa la tabla "departamento" en SQL Server.
 *
 * RELACIÓN CON PAIS:
 *   Un departamento pertenece a un país → relación N:1 (ManyToOne).
 *   La columna "pais_id" en la tabla departamento es la FK que apunta a pais.id.
 *
 * IMPORTANTE:
 *   El campo Java "codigoDANE" se mapea a la columna SQL "codigo_dane"
 *   usando la convención snake_case habitual en bases de datos.
 */
@Entity
@Table(name = "departamento")
public class DepartamentoEntidad {

    @Id
    @Column(name = "id", columnDefinition = "uniqueidentifier", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    // El campo Java "codigoDANE" se llama "codigo_dane" en la columna SQL
    @Column(name = "codigo_dane", length = 10)
    private String codigoDANE;

    // Relación N:1 — muchos departamentos pueden pertenecer al mismo país.
    //
    // FetchType.EAGER: Hibernate carga el País en el mismo SELECT (JOIN).
    // Necesario porque DepartamentoEntidadAssembler.toDominio() SIEMPRE accede
    // a pais.getNombre(), pais.getId(), etc. fuera del contexto transaccional
    // de SimpleJpaRepository. Con LAZY, la sesión ya estaría cerrada y
    // getPais().getNombre() lanzaría LazyInitializationException.
    //
    // SQL generado: SELECT d.*, p.* FROM departamento d
    //               LEFT JOIN pais p ON d.pais_id = p.id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pais", nullable = false)
    private PaisEntidad pais;

    // Constructor vacío REQUERIDO por JPA/Hibernate
    public DepartamentoEntidad() {}

    // Constructor completo usado por DepartamentoEntidadAssembler.toEntidad()
    public DepartamentoEntidad(final UUID id, final String nombre,
                               final String codigoDANE, final PaisEntidad pais) {
        this.id = id;
        this.nombre = nombre;
        this.codigoDANE = codigoDANE;
        this.pais = pais;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(final String nombre) { this.nombre = nombre; }

    public String getCodigoDANE() { return codigoDANE; }
    public void setCodigoDANE(final String codigoDANE) { this.codigoDANE = codigoDANE; }

    public PaisEntidad getPais() { return pais; }
    public void setPais(final PaisEntidad pais) { this.pais = pais; }
}
