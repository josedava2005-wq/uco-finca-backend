package co.edu.uco.ucoparking.negocio.assembler.DTO;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.FincaDominio;
import co.edu.uco.ucoparking.dominio.ProductoDominio;
import co.edu.uco.ucoparking.dto.ProductoDTO;

public final class ProductoDTOAssembler {

    private ProductoDTOAssembler() {}

    public static ProductoDominio toDominio(final ProductoDTO dto) {
        FincaDominio finca = dto.getIdFinca() != null
                ? FincaDominio.builder().id(dto.getIdFinca()).build() : null;
        return ProductoDominio.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .unidadMedida(dto.getUnidadMedida())
                .precioUnitario(dto.getPrecioUnitario())
                .stockDisponible(dto.getStockDisponible())
                .descripcion(dto.getDescripcion())
                .finca(finca)
                .build();
    }

    public static ProductoDTO toDTO(final ProductoDominio dominio) {
        return new ProductoDTO(dominio.getId(), dominio.getNombre(), dominio.getUnidadMedida(), dominio.getPrecioUnitario(), dominio.getStockDisponible(), dominio.getDescripcion(), dominio.getFinca() != null ? dominio.getFinca().getId() : null);
    }
}
