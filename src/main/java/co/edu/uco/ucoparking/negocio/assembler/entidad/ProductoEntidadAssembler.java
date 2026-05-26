package co.edu.uco.ucoparking.negocio.assembler.entidad;

import co.edu.uco.ucoparking.dominio.FincaDominio;
import co.edu.uco.ucoparking.dominio.ProductoDominio;
import co.edu.uco.ucoparking.entidad.FincaEntidad;
import co.edu.uco.ucoparking.entidad.ProductoEntidad;
import co.edu.uco.ucoparking.negocio.assembler.entidad.FincaEntidadAssembler;

public final class ProductoEntidadAssembler {

    private ProductoEntidadAssembler() {}

    public static ProductoEntidad toEntidad(final ProductoDominio dominio) {
        FincaEntidad fincaEnt = dominio.getFinca() != null
                ? FincaEntidadAssembler.toEntidad(dominio.getFinca()) : null;
        return new ProductoEntidad(dominio.getId(), dominio.getNombre(), dominio.getUnidadMedida(), dominio.getPrecioUnitario(), dominio.getStockDisponible(), dominio.getDescripcion(), fincaEnt);
    }

    public static ProductoDominio toDominio(final ProductoEntidad entidad) {
        return ProductoDominio.builder()
                .id(entidad.getId())
                .nombre(entidad.getNombre())
                .unidadMedida(entidad.getUnidadMedida())
                .precioUnitario(entidad.getPrecioUnitario())
                .stockDisponible(entidad.getStockDisponible())
                .descripcion(entidad.getDescripcion())
                .finca(entidad.getFinca() != null ? FincaEntidadAssembler.toDominio(entidad.getFinca()) : null)
                .build();
    }
}
