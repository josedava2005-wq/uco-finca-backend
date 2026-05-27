package co.edu.uco.ucoparking.entidad;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad JPA que representa la tabla "tipo_suministro" en SQL Server.
 *
 * Entidad de catálogo (lookup table): no tiene FK hacia otras tablas.
 * Hibernate genera: SELECT id, nombre, descripcion FROM tipo_suministro
 */
@Entity
@Table(name = "tipo_suministro")
public class TipoSuministroEntidad {

    @Id
    @Column(name = "id", columnDefinition = "uniqueidentifier", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    public TipoSuministroEntidad() {}

    public TipoSuministroEntidad(final UUID id, final String nombre, final String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(final String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(final String descripcion) { this.descripcion = descripcion; }
}
