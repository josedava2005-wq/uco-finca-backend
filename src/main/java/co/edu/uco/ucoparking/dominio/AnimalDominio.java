package co.edu.uco.ucoparking.dominio;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.FincaDominio;
import co.edu.uco.ucoparking.transversal.UtilTexto;

public final class AnimalDominio {

    private UUID id;
    private String nombre;
    private String especie;
    private String raza;
    private String sexo;
    private String fechaNacimiento;
    private Double pesoKg;
    private FincaDominio finca;

    private AnimalDominio(final Builder builder) {
        setId(builder.id);
        setNombre(builder.nombre);
        setEspecie(builder.especie);
        setRaza(builder.raza);
        setSexo(builder.sexo);
        setFechaNacimiento(builder.fechaNacimiento);
        setPesoKg(builder.pesoKg);
        setFinca(builder.finca);
    }

    public static Builder builder() { return new Builder(); }

    public UUID getId() { return id; }
    private void setId(final UUID id) { this.id = id; }
    public String getNombre() { return nombre; }
    private void setNombre(final String nombre) { this.nombre = UtilTexto.aplicarTrim(nombre); }
    public String getEspecie() { return especie; }
    private void setEspecie(final String especie) { this.especie = UtilTexto.aplicarTrim(especie); }
    public String getRaza() { return raza; }
    private void setRaza(final String raza) { this.raza = UtilTexto.aplicarTrim(raza); }
    public String getSexo() { return sexo; }
    private void setSexo(final String sexo) { this.sexo = UtilTexto.aplicarTrim(sexo); }
    public String getFechaNacimiento() { return fechaNacimiento; }
    private void setFechaNacimiento(final String fechaNacimiento) { this.fechaNacimiento = UtilTexto.aplicarTrim(fechaNacimiento); }
    public Double getPesoKg() { return pesoKg; }
    private void setPesoKg(final Double pesoKg) { this.pesoKg = pesoKg; }
    public FincaDominio getFinca() { return finca; }
    private void setFinca(final FincaDominio finca) { this.finca = finca; }

    public static final class Builder {
        private UUID id;
        private String nombre;
        private String especie;
        private String raza;
        private String sexo;
        private String fechaNacimiento;
        private Double pesoKg;
        private FincaDominio finca;

        public Builder id(final UUID id) { this.id = id; return this; }
        public Builder nombre(final String nombre) { this.nombre = nombre; return this; }
        public Builder especie(final String especie) { this.especie = especie; return this; }
        public Builder raza(final String raza) { this.raza = raza; return this; }
        public Builder sexo(final String sexo) { this.sexo = sexo; return this; }
        public Builder fechaNacimiento(final String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; return this; }
        public Builder pesoKg(final Double pesoKg) { this.pesoKg = pesoKg; return this; }
        public Builder finca(final FincaDominio finca) { this.finca = finca; return this; }

        public AnimalDominio build() { return new AnimalDominio(this); }
    }
}
