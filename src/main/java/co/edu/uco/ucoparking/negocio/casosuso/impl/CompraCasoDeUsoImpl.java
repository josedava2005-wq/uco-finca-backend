package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.CompraDatos;
import co.edu.uco.ucoparking.dominio.CompraDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.CompraEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.CompraCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilUUID;

public final class CompraCasoDeUsoImpl implements CompraCasoDeUso {

    private final CompraDatos datos;

    public CompraCasoDeUsoImpl(final CompraDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final CompraDominio dominio) {
        final CompraDominio dominioConId = CompraDominio.builder()
                .id(UtilUUID.generarNuevo())
                .fechaCompra(dominio.getFechaCompra())
                .total(dominio.getTotal())
                .estado(dominio.getEstado())
                .cliente(dominio.getCliente())
                .build();
        datos.crear(CompraEntidadAssembler.toEntidad(dominioConId));
    }

    @Override
    public List<CompraDominio> consultar(final CompraDominio filtro) {
        return datos.consultar(CompraEntidadAssembler.toEntidad(filtro))
                .stream()
                .map(CompraEntidadAssembler::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final CompraDominio dominio) {
        datos.modificar(CompraEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        datos.eliminar(id);
    }
}
