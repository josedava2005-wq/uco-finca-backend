package co.edu.uco.ucoparking.entidad;

import java.util.UUID;

import co.edu.uco.ucoparking.entidad.ClienteEntidad;

public class CompraEntidad {

    private UUID id;
    private String fechaCompra;
    private Double total;
    private String estado;
    private ClienteEntidad cliente;

    public CompraEntidad() {}

    public CompraEntidad(final UUID id, final String fechaCompra, final Double total, final String estado, final ClienteEntidad cliente) {
        this.id = id;
        this.fechaCompra = fechaCompra;
        this.total = total;
        this.estado = estado;
        this.cliente = cliente;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }
    public String getFechaCompra() { return fechaCompra; }
    public void setFechaCompra(final String fechaCompra) { this.fechaCompra = fechaCompra; }
    public Double getTotal() { return total; }
    public void setTotal(final Double total) { this.total = total; }
    public String getEstado() { return estado; }
    public void setEstado(final String estado) { this.estado = estado; }
    public ClienteEntidad getCliente() { return cliente; }
    public void setCliente(final ClienteEntidad cliente) { this.cliente = cliente; }
}
