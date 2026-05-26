package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.ProductoDatos;
import co.edu.uco.ucoparking.dominio.ProductoDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.ProductoEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.ProductoCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilUUID;

public final class ProductoCasoDeUsoImpl implements ProductoCasoDeUso {

    private final ProductoDatos datos;

    public ProductoCasoDeUsoImpl(final ProductoDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final ProductoDominio dominio) {
        final ProductoDominio dominioConId = ProductoDominio.builder()
                .id(UtilUUID.generarNuevo())
                .nombre(dominio.getNombre())
                .unidadMedida(dominio.getUnidadMedida())
                .precioUnitario(dominio.getPrecioUnitario())
                .stockDisponible(dominio.getStockDisponible())
                .descripcion(dominio.getDescripcion())
                .finca(dominio.getFinca())
                .build();
        datos.crear(ProductoEntidadAssembler.toEntidad(dominioConId));
    }

    @Override
    public List<ProductoDominio> consultar(final ProductoDominio filtro) {
        return datos.consultar(ProductoEntidadAssembler.toEntidad(filtro))
                .stream()
                .map(ProductoEntidadAssembler::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final ProductoDominio dominio) {
        datos.modificar(ProductoEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        datos.eliminar(id);
    }
}
