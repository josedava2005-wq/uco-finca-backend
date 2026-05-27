package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.ProductoDatos;
import co.edu.uco.ucoparking.dominio.ProductoDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.ProductoEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.ProductoCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilTexto;
import co.edu.uco.ucoparking.transversal.UtilUUID;
import co.edu.uco.ucoparking.transversal.excepciones.NegocioException;

public final class ProductoCasoDeUsoImpl implements ProductoCasoDeUso {

    private final ProductoDatos datos;

    public ProductoCasoDeUsoImpl(final ProductoDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final ProductoDominio dominio) {
        if (UtilTexto.esNuloOVacio(dominio.getNombre())) {
            throw new NegocioException(
                    "Nombre de producto nulo o vacío en ProductoCasoDeUsoImpl.crear()",
                    "El nombre del producto es obligatorio");
        }
        if (dominio.getFinca() == null || dominio.getFinca().getId() == null) {
            throw new NegocioException(
                    "Finca o su ID es nulo en ProductoCasoDeUsoImpl.crear()",
                    "Debe indicar la finca del producto (idFinca)");
        }
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
                .stream().map(ProductoEntidadAssembler::toDominio).collect(Collectors.toList());
    }

    @Override
    public void modificar(final ProductoDominio dominio) {
        if (dominio.getId() == null) {
            throw new NegocioException(
                    "ID de producto nulo en ProductoCasoDeUsoImpl.modificar()",
                    "El ID del producto es obligatorio para modificar");
        }
        if (UtilTexto.esNuloOVacio(dominio.getNombre())) {
            throw new NegocioException(
                    "Nombre de producto nulo o vacío en ProductoCasoDeUsoImpl.modificar()",
                    "El nombre del producto es obligatorio");
        }
        if (dominio.getFinca() == null || dominio.getFinca().getId() == null) {
            throw new NegocioException(
                    "Finca o su ID es nulo en ProductoCasoDeUsoImpl.modificar()",
                    "Debe indicar la finca del producto (idFinca)");
        }
        datos.modificar(ProductoEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        if (id == null) {
            throw new NegocioException(
                    "ID de producto nulo en ProductoCasoDeUsoImpl.eliminar()",
                    "El ID del producto es obligatorio para eliminar");
        }
        datos.eliminar(id);
    }
}
