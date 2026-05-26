package co.edu.uco.ucoparking.entidad;

import java.util.UUID;

import co.edu.uco.ucoparking.entidad.PaisEntidad;

public class DepartamentoEntidad {

    private UUID id;
    private String nombre;
    private String codigoDANE;
    private PaisEntidad pais;

    public DepartamentoEntidad() {}

    public DepartamentoEntidad(final UUID id, final String nombre, final String codigoDANE, final PaisEntidad pais) {
        this.id = id;
        this.nombre = nombre;
        this.codigoDANE = codigoDANE;
        this.pais = pais;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(final String nombre) { this.nombre = nombre; }
    public String getCodigoDANE() { return codigoDANE; }
    public void setCodigoDANE(final String codigoDANE) { this.codigoDANE = codigoDANE; }
    public PaisEntidad getPais() { return pais; }
    public void setPais(final PaisEntidad pais) { this.pais = pais; }
}
