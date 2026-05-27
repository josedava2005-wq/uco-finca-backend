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
 * Entidad JPA que representa la tabla "lugar_finca" en SQL Server.
 *
 * RELACIÓN CON CIUDAD:
 *   Un lugar de finca pertenece a una ciudad → relación N:1 (ManyToOne).
 *   La columna "id_ciudad" en la tabla lugar_finca es la FK
 *   que apunta a ciudad.id.
 *
 * CADENA COMPLETA:
 *   LugarFinca → Ciudad → Departamento → País
 *   Cada nivel carga EAGER al siguiente para evitar LazyInitializationException
 *   cuando los assemblers acceden a los objetos fuera del contexto transaccional.
 *
 * FetchType.EAGER:
 *   Hibernate cargará la Ciudad (y transitivamente Departamento y País) en el
 *   mismo SELECT usando JOINs. Necesario porque LugarFincaEntidadAssembler
 *   accede a entidad.getCiudad() fuera de la sesión JPA.
 */
@Entity
@Table(name = "lugar_finca")
public class LugarFincaEntidad {

    @Id
    @Column(name = "id", columnDefinition = "uniqueidentifier", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "vereda", nullable = false, length = 150)
    private String vereda;

    @Column(name = "sector", nullable = false, length = 150)
    private String sector;

    // Relación N:1 — muchos lugares de finca pueden estar en la misma ciudad.
    //
    // @JoinColumn(name = "id_ciudad") → columna FK en la tabla lugar_finca
    // que referencia la PK "id" de la tabla ciudad.
    //
    // CiudadEntidad ya tiene FetchType.EAGER hacia DepartamentoEntidad,
    // y DepartamentoEntidad tiene FetchType.EAGER hacia PaisEntidad,
    // por lo que la cadena LugarFinca→Ciudad→Departamento→País se resuelve completamente.
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_ciudad", nullable = false)
    private CiudadEntidad ciudad;

    // Constructor vacío REQUERIDO por JPA/Hibernate
    public LugarFincaEntidad() {}

    // Constructor completo usado por LugarFincaEntidadAssembler.toEntidad()
    public LugarFincaEntidad(final UUID id, final String vereda, final String sector, final CiudadEntidad ciudad) {
        this.id = id;
        this.vereda = vereda;
        this.sector = sector;
        this.ciudad = ciudad;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }

    public String getVereda() { return vereda; }
    public void setVereda(final String vereda) { this.vereda = vereda; }

    public String getSector() { return sector; }
    public void setSector(final String sector) { this.sector = sector; }

    public CiudadEntidad getCiudad() { return ciudad; }
    public void setCiudad(final CiudadEntidad ciudad) { this.ciudad = ciudad; }
}
