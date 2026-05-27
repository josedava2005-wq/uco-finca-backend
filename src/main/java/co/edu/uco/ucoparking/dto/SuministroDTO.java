package co.edu.uco.ucoparking.dto;

import java.util.UUID;

public final class SuministroDTO {

    private UUID id;
    private String nombre;
    private Double cantidad;
    private String unidadMedida;
    private UUID idTipoSuministro;
    private UUID idAlmacen;
    private UUID idProveedor;

    public SuministroDTO() { this(null, null, null, null, null, null, null); }

    public SuministroDTO(final UUID id, final String nombre, final Double cantidad, final String unidadMedida, final UUID idTipoSuministro, final UUID idAlmacen, final UUID idProveedor) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
        this.idTipoSuministro = idTipoSuministro;
        this.idAlmacen = idAlmacen;
        this.idProveedor = idProveedor;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(final String nombre) { this.nombre = nombre; }
    public Double getCantidad() { return cantidad; }
    public void setCantidad(final Double cantidad) { this.cantidad = cantidad; }
    public String getUnidadMedida() { return unidadMedida; }
    public void setUnidadMedida(final String unidadMedida) { this.unidadMedida = unidadMedida; }
    public UUID getIdTipoSuministro() { return idTipoSuministro; }
    public void setIdTipoSuministro(final UUID idTipoSuministro) { this.idTipoSuministro = idTipoSuministro; }
    public UUID getIdAlmacen() { return idAlmacen; }
    public void setIdAlmacen(final UUID idAlmacen) { this.idAlmacen = idAlmacen; }
    public UUID getIdProveedor() { return idProveedor; }
    public void setIdProveedor(final UUID idProveedor) { this.idProveedor = idProveedor; }
}
