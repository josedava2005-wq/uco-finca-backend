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
    public String getVereda() { return vereda; }
    public String getSector() { return sector; }
    public UUID getIdCiudad() { return idCiudad; }
}
