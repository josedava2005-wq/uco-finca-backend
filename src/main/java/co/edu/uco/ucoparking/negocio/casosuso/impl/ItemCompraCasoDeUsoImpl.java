package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.ItemCompraDatos;
import co.edu.uco.ucoparking.dominio.ItemCompraDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.ItemCompraEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.ItemCompraCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilUUID;

public final class ItemCompraCasoDeUsoImpl implements ItemCompraCasoDeUso {

    private final ItemCompraDatos datos;

    public ItemCompraCasoDeUsoImpl(final ItemCompraDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final ItemCompraDominio dominio) {
        final ItemCompraDominio dominioConId = ItemCompraDominio.builder()
                .id(UtilUUID.generarNuevo())
                .cantidad(dominio.getCantidad())
                .precioUnitario(dominio.getPrecioUnitario())
                .compra(dominio.getCompra())
                .producto(dominio.getProducto())
                .build();
        datos.crear(ItemCompraEntidadAssembler.toEntidad(dominioConId));
    }

    @Override
    public List<ItemCompraDominio> consultar(final ItemCompraDominio filtro) {
        return datos.consultar(ItemCompraEntidadAssembler.toEntidad(filtro))
                .stream()
                .map(ItemCompraEntidadAssembler::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final ItemCompraDominio dominio) {
        datos.modificar(ItemCompraEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        datos.eliminar(id);
    }
}
