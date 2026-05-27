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
 * Entidad JPA — tabla "estado_animal" en SQL Server.
 *
 * RELACIONES FK:
 *   id_animal → animal.id  (AnimalEntidad ya es @Entity ✅)
 *
 * COLUMNAS:
 *   id             → uniqueidentifier
 *   estado         → varchar
 *   fecha_registro → varchar
 *   observacion    → varchar
 *   id_animal      → uniqueidentifier FK
 */
@Entity
@Table(name = "estado_animal")
public class EstadoAnimalEntidad {

    @Id
    @Column(name = "id", columnDefinition = "uniqueidentifier", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "estado", nullable = false, length = 100)
    private String estado;

    @Column(name = "fecha_registro", nullable = true, length = 50)
    private String fechaRegistro;

    @Column(name = "observacion", nullable = true, length = 500)
    private String observacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_animal", nullable = false)
    private AnimalEntidad animal;

    public EstadoAnimalEntidad() {}

    public EstadoAnimalEntidad(final UUID id, final String estado, final String fechaRegistro,
                               final String observacion, final AnimalEntidad animal) {
        this.id = id;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
        this.observacion = observacion;
        this.animal = animal;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }
    public String getEstado() { return estado; }
    public void setEstado(final String estado) { this.estado = estado; }
    public String getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(final String fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    public String getObservacion() { return observacion; }
    public void setObservacion(final String observacion) { this.observacion = observacion; }
    public AnimalEntidad getAnimal() { return animal; }
    public void setAnimal(final AnimalEntidad animal) { this.animal = animal; }
}
