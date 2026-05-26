package co.edu.uco.ucoparking.dto;

import java.util.UUID;

public final class AnimalDTO {

    private UUID id;
    private String nombre;
    private String especie;
    private String raza;
    private String sexo;
    private String fechaNacimiento;
    private Double pesoKg;
    private UUID idFinca;

    public AnimalDTO() { this(null, null, null, null, null, null, null, null); }

    public AnimalDTO(final UUID id, final String nombre, final String especie, final String raza, final String sexo, final String fechaNacimiento, final Double pesoKg, final UUID idFinca) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.pesoKg = pesoKg;
        this.idFinca = idFinca;
    }

    public UUID getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEspecie() { return especie; }
    public String getRaza() { return raza; }
    public String getSexo() { return sexo; }
    public String getFechaNacimiento() { return fechaNacimiento; }
    public Double getPesoKg() { return pesoKg; }
    public UUID getIdFinca() { return idFinca; }
}
