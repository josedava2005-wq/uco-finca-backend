package co.edu.uco.ucoparking.dto;

import java.util.UUID;

public final class LugarFincaDTO {

    private UUID id;
    private String vereda;
    private String sector;
    private UUID idCiudad;

    public LugarFincaDTO() { this(null, null, null, null); }

    public LugarFincaDTO(final UUID id, final String vereda, final String sector, final UUID idCiudad) {
        this.id = id;
        this.vereda = vereda;
        this.sector = sector;
        this.idCiudad = idCiudad;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }
    public String getVereda() { return vereda; }
    public void setVereda(final String vereda) { this.vereda = vereda; }
    public String getSector() { return sector; }
    public void setSector(final String sector) { this.sector = sector; }
    public UUID getIdCiudad() { return idCiudad; }
    public void setIdCiudad(final UUID idCiudad) { this.idCiudad = idCiudad; }
}
