package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.DetalleCompraDatos;
import co.edu.uco.ucoparking.dominio.DetalleCompraDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.DetalleCompraEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.DetalleCompraCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilUUID;

public final class DetalleCompraCasoDeUsoImpl implements DetalleCompraCasoDeUso {

    private final DetalleCompraDatos datos;

    public DetalleCompraCasoDeUsoImpl(final DetalleCompraDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final DetalleCompraDominio dominio) {
        final DetalleCompraDominio dominioConId = DetalleCompraDominio.builder()
                .id(UtilUUID.generarNuevo())
                .costoUnitario(dominio.getCostoUnitario())
                .subtotal(dominio.getSubtotal())
                .descuento(dominio.getDescuento())
                .itemCompra(dominio.getItemCompra())
                .build();
        datos.crear(DetalleCompraEntidadAssembler.toEntidad(dominioConId));
    }

    @Override
    public List<DetalleCompraDominio> consultar(final DetalleCompraDominio filtro) {
        return datos.consultar(DetalleCompraEntidadAssembler.toEntidad(filtro))
                .stream()
                .map(DetalleCompraEntidadAssembler::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final DetalleCompraDominio dominio) {
        datos.modificar(DetalleCompraEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        datos.eliminar(id);
    }
}
