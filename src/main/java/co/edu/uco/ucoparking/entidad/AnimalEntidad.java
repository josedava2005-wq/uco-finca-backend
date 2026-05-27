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
 * Entidad JPA que representa la tabla "animal" en SQL Server.
 *
 * RELACIÓN CON FINCA:
 *   Un animal pertenece a una finca → relación N:1 (ManyToOne).
 *   La columna "id_finca" en la tabla animal es la FK que apunta a finca.id.
 *
 * CADENA COMPLETA (todo EAGER):
 *   Animal → Finca → LugarFinca → Ciudad → Departamento → País
 *   Hibernate resuelve toda la cadena en un único SELECT con 5 JOINs.
 *
 * COLUMNAS SQL SERVER:
 *   id               → uniqueidentifier  (PK)
 *   nombre           → varchar/nvarchar
 *   especie          → varchar/nvarchar
 *   raza             → varchar/nvarchar
 *   sexo             → varchar/nvarchar
 *   fecha_nacimiento → varchar  (dominio lo trata como String)
 *                      si la columna es DATE → ajustar a LocalDate
 *   peso_kg          → float/decimal
 *   id_finca         → uniqueidentifier  (FK → finca.id)
 */
@Entity
@Table(name = "animal")
public class AnimalEntidad {

    @Id
    @Column(name = "id", columnDefinition = "uniqueidentifier", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    @Column(name = "especie", nullable = false, length = 100)
    private String especie;

    @Column(name = "raza", nullable = true, length = 100)
    private String raza;

    @Column(name = "sexo", nullable = true, length = 20)
    private String sexo;

    // fecha_nacimiento: el dominio lo trata como String.
    // Si la columna SQL Server es DATE → ajustar a java.time.LocalDate.
    @Column(name = "fecha_nacimiento", nullable = true, length = 50)
    private String fechaNacimiento;

    @Column(name = "peso_kg", nullable = true)
    private Double pesoKg;

    // Relación N:1 — muchos animales pueden pertenecer a la misma finca.
    // FincaEntidad ya es @Entity con cadena EAGER completa hacia País.
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_finca", nullable = false)
    private FincaEntidad finca;

    // Constructor vacío REQUERIDO por JPA/Hibernate
    public AnimalEntidad() {}

    // Constructor completo usado por AnimalEntidadAssembler.toEntidad()
    public AnimalEntidad(final UUID id, final String nombre, final String especie,
                         final String raza, final String sexo, final String fechaNacimiento,
                         final Double pesoKg, final FincaEntidad finca) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.pesoKg = pesoKg;
        this.finca = finca;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(final String nombre) { this.nombre = nombre; }

    public String getEspecie() { return especie; }
    public void setEspecie(final String especie) { this.especie = especie; }

    public String getRaza() { return raza; }
    public void setRaza(final String raza) { this.raza = raza; }

    public String getSexo() { return sexo; }
    public void setSexo(final String sexo) { this.sexo = sexo; }

    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(final String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public Double getPesoKg() { return pesoKg; }
    public void setPesoKg(final Double pesoKg) { this.pesoKg = pesoKg; }

    public FincaEntidad getFinca() { return finca; }
    public void setFinca(final FincaEntidad finca) { this.finca = finca; }
}
