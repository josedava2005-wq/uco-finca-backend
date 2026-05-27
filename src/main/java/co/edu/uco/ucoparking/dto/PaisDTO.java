package co.edu.uco.ucoparking.dto;

import java.util.UUID;

public final class PaisDTO {

    private UUID id;
    private String nombre;
    private String codigoISO;
    private String continente;
    private String idioma;
    private String moneda;
    private String telefono;

    public PaisDTO() { this(null, null, null, null, null, null, null); }

    public PaisDTO(final UUID id, final String nombre, final String codigoISO, final String continente, final String idioma, final String moneda, final String telefono) {
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
