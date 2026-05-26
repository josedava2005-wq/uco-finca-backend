package co.edu.uco.ucoparking.negocio.assembler.entidad;

import co.edu.uco.ucoparking.dominio.ClienteDominio;
import co.edu.uco.ucoparking.dominio.CompraDominio;
import co.edu.uco.ucoparking.entidad.ClienteEntidad;
import co.edu.uco.ucoparking.entidad.CompraEntidad;
import co.edu.uco.ucoparking.negocio.assembler.entidad.ClienteEntidadAssembler;

public final class CompraEntidadAssembler {

    private CompraEntidadAssembler() {}

    public static CompraEntidad toEntidad(final CompraDominio dominio) {
        ClienteEntidad clienteEnt = dominio.getCliente() != null
                ? ClienteEntidadAssembler.toEntidad(dominio.getCliente()) : null;
        return new CompraEntidad(dominio.getId(), dominio.getFechaCompra(), dominio.getTotal(), dominio.getEstado(), clienteEnt);
    }

    public static CompraDominio toDominio(final CompraEntidad entidad) {
        return CompraDominio.builder()
                .id(entidad.getId())
                .fechaCompra(entidad.getFechaCompra())
                .total(entidad.getTotal())
                .estado(entidad.getEstado())
                .cliente(entidad.getCliente() != null ? ClienteEntidadAssembler.toDominio(entidad.getCliente()) : null)
                .build();
    }
}
