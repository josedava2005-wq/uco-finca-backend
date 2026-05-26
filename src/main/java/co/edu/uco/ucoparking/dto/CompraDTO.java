package co.edu.uco.ucoparking.dto;

import java.util.UUID;

public final class CompraDTO {

    private UUID id;
    private String fechaCompra;
    private Double total;
    private String estado;
    private UUID idCliente;

    public CompraDTO() { this(null, null, null, null, null); }

    public CompraDTO(final UUID id, final String fechaCompra, final Double total, final String estado, final UUID idCliente) {
        this.id = id;
        this.fechaCompra = fechaCompra;
        this.total = total;
        this.estado = estado;
        this.idCliente = idCliente;
    }

    public UUID getId() { return id; }
    public String getFechaCompra() { return fechaCompra; }
    public Double getTotal() { return total; }
    public String getEstado() { return estado; }
    public UUID getIdCliente() { return idCliente; }
}
