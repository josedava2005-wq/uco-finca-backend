package co.edu.uco.ucoparking.negocio.assembler.DTO;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.DetalleCompraDominio;
import co.edu.uco.ucoparking.dominio.ItemCompraDominio;
import co.edu.uco.ucoparking.dto.DetalleCompraDTO;

public final class DetalleCompraDTOAssembler {

    private DetalleCompraDTOAssembler() {}

    public static DetalleCompraDominio toDominio(final DetalleCompraDTO dto) {
        ItemCompraDominio itemCompra = dto.getIdItemCompra() != null
                ? ItemCompraDominio.builder().id(dto.getIdItemCompra()).build() : null;
        return DetalleCompraDominio.builder()
                .id(dto.getId())
                .costoUnitario(dto.getCostoUnitario())
                .subtotal(dto.getSubtotal())
                .descuento(dto.getDescuento())
                .itemCompra(itemCompra)
                .build();
    }

    public static DetalleCompraDTO toDTO(final DetalleCompraDominio dominio) {
        return new DetalleCompraDTO(dominio.getId(), dominio.getCostoUnitario(), dominio.getSubtotal(), dominio.getDescuento(), dominio.getItemCompra() != null ? dominio.getItemCompra().getId() : null);
    }
}
