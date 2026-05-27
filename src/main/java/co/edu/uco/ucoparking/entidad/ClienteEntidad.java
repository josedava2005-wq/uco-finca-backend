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
 * Entidad JPA que representa la tabla "cliente" en SQL Server.
 *
 * RELACIÓN CON CIUDAD:
 *   Un cliente reside en una ciudad → relación N:1 (ManyToOne).
 *   La columna "id_ciudad" en la tabla cliente es la FK
 *   que apunta a ciudad.id.
 *
 * CADENA COMPLETA:
 *   Cliente → Ciudad → Departamento → País
 *   Cada nivel carga EAGER al siguiente para evitar LazyInitializationException
 *   cuando los assemblers acceden a los objetos fuera del contexto transaccional.
 *
 * COLUMNAS SQL SERVER (snake_case):
 *   id               → UUID (uniqueidentifier)
 *   tipo_documento   → VARCHAR
 *   numero_documento → VARCHAR
 *   nombre           → VARCHAR
 *   correo           → VARCHAR
 *   telefono         → VARCHAR
 *   id_ciudad        → FK → ciudad.id
 */
@Entity
@Table(name = "cliente")
public class ClienteEntidad {

    @Id
    @Column(name = "id", columnDefinition = "uniqueidentifier", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "tipo_documento", nullable = false, length = 50)
    private String tipoDocumento;

    @Column(name = "numero_documento", nullable = false, length = 20)
    private String numeroDocumento;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    @Column(name = "correo", nullable = false, length = 200)
    private String correo;

    @Column(name = "telefono", nullable = false, length = 20)
    private String telefono;

    // Relación N:1 — muchos clientes pueden estar en la misma ciudad.
    //
    // @JoinColumn(name = "id_ciudad") → columna FK en la tabla cliente
    // que referencia la PK "id" de la tabla ciudad.
    //
    // CiudadEntidad ya tiene FetchType.EAGER hacia DepartamentoEntidad,
    // y DepartamentoEntidad tiene FetchType.EAGER hacia PaisEntidad,
    // por lo que la cadena Cliente→Ciudad→Departamento→País se resuelve completamente.
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_ciudad", nullable = false)
    private CiudadEntidad ciudad;

    // Constructor vacío REQUERIDO por JPA/Hibernate
    public ClienteEntidad() {}

    // Constructor completo usado por ClienteEntidadAssembler.toEntidad()
    public ClienteEntidad(final UUID id, final String tipoDocumento, final String numeroDocumento,
                          final String nombre, final String correo, final String telefono,
                          final CiudadEntidad ciudad) {
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.ciudad = ciudad;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }

    public String getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(final String tipoDocumento) { this.tipoDocumento = tipoDocumento; }

    public String getNumeroDocumento() { return numeroDocumento; }
    public void setNumeroDocumento(final String numeroDocumento) { this.numeroDocumento = numeroDocumento; }

    public String getNombre() { return nombre; }
    public void setNombre(final String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(final String correo) { this.correo = correo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(final String telefono) { this.telefono = telefono; }

    public CiudadEntidad getCiudad() { return ciudad; }
    public void setCiudad(final CiudadEntidad ciudad) { this.ciudad = ciudad; }
}
