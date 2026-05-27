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
    public UUID getIdFinca() { return idFinca; }
    public void setIdFinca(final UUID idFinca) { this.idFinca = idFinca; }
}
