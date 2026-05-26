package co.edu.uco.ucoparking.negocio.assembler.DTO;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.CompraDominio;
import co.edu.uco.ucoparking.dominio.ItemCompraDominio;
import co.edu.uco.ucoparking.dominio.ProductoDominio;
import co.edu.uco.ucoparking.dto.ItemCompraDTO;

public final class ItemCompraDTOAssembler {

    private ItemCompraDTOAssembler() {}

    public static ItemCompraDominio toDominio(final ItemCompraDTO dto) {
        CompraDominio compra = dto.getIdCompra() != null
                ? CompraDominio.builder().id(dto.getIdCompra()).build() : null;
        ProductoDominio producto = dto.getIdProducto() != null
                ? ProductoDominio.builder().id(dto.getIdProducto()).build() : null;
        return ItemCompraDominio.builder()
                .id(dto.getId())
                .cantidad(dto.getCantidad())
                .precioUnitario(dto.getPrecioUnitario())
                .compra(compra)
                .producto(producto)
                .build();
    }

    public static ItemCompraDTO toDTO(final ItemCompraDominio dominio) {
        return new ItemCompraDTO(dominio.getId(), dominio.getCantidad(), dominio.getPrecioUnitario(), dominio.getCompra() != null ? dominio.getCompra().getId() : null, dominio.getProducto() != null ? dominio.getProducto().getId() : null);
    }
}
