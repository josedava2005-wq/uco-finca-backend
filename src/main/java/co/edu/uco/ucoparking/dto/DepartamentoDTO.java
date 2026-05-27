package co.edu.uco.ucoparking.dto;

import java.util.UUID;

public final class DepartamentoDTO {

    private UUID id;
    private String nombre;
    private String codigoDANE;
    private UUID idPais;

    public DepartamentoDTO() { this(null, null, null, null); }

    public DepartamentoDTO(final UUID id, final String nombre, final String codigoDANE, final UUID idPais) {
        this.id = id;
        this.nombre = nombre;
        this.codigoDANE = codigoDANE;
        this.idPais = idPais;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(final String nombre) { this.nombre = nombre; }
    public String getCodigoDANE() { return codigoDANE; }
    public void setCodigoDANE(final String codigoDANE) { this.codigoDANE = codigoDANE; }
    public UUID getIdPais() { return idPais; }
    public void setIdPais(final UUID idPais) { this.idPais = idPais; }
}
