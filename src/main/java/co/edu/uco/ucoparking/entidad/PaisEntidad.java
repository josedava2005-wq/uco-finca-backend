package co.edu.uco.ucoparking.entidad;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad JPA que representa la tabla "pais" en SQL Server.
 *
 * IMPORTANTE: Esta clase es el PUENTE entre el modelo de dominio Java
 * y la base de datos relacional. Hibernate lee las anotaciones para saber:
 *   - En qué tabla guardar los datos (@Table)
 *   - Qué campo es la clave primaria (@Id)
 *   - Cómo se llama cada columna en SQL (@Column)
 *
 * NO contiene lógica de negocio. Solo es un contenedor de datos con mapeo.
 */
@Entity
@Table(name = "pais")
public class PaisEntidad {

    @Id
    @Column(name = "id", columnDefinition = "uniqueidentifier", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    // El campo Java se llama "codigoISO" pero la columna SQL se llama "codigo_iso"
    // @Column hace ese mapeo explícito
    @Column(name = "codigo_iso", length = 10)
    private String codigoISO;

    @Column(name = "continente", length = 50)
    private String continente;

    @Column(name = "idioma", length = 50)
    private String idioma;

    @Column(name = "moneda", length = 50)
    private String moneda;

    @Column(name = "telefono", length = 20)
    private String telefono;

    // Constructor vacío REQUERIDO por JPA/Hibernate
    public PaisEntidad() {}

    // Constructor completo usado por PaisEntidadAssembler.toEntidad()
    public PaisEntidad(final UUID id, final String nombre, final String codigoISO,
                       final String continente, final String idioma,
                       final String moneda, final String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.codigoISO = codigoISO;
        this.continente = continente;
        this.idioma = idioma;
        this.moneda = moneda;
        this.telefono = telefono;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(final String nombre) { this.nombre = nombre; }
    public String getCodigoISO() { return codigoISO; }
    public void setCodigoISO(final String codigoISO) { this.codigoISO = codigoISO; }
    public String getContinente() { return continente; }
    public void setContinente(final String continente) { this.continente = continente; }
    public String getIdioma() { return idioma; }
    public void setIdioma(final String idioma) { this.idioma = idioma; }
    public String getMoneda() { return moneda; }
    public void setMoneda(final String moneda) { this.moneda = moneda; }
    public String getTelefono() { return telefono; }
    public void setTelefono(final String telefono) { this.telefono = telefono; }
}
