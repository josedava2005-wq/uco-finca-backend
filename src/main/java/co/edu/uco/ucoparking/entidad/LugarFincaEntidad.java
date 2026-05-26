package co.edu.uco.ucoparking.entidad;

import java.util.UUID;

import co.edu.uco.ucoparking.entidad.CiudadEntidad;

public class LugarFincaEntidad {

    private UUID id;
    private String vereda;
    private String sector;
    private CiudadEntidad ciudad;

    public LugarFincaEntidad() {}

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
