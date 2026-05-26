package co.edu.uco.ucoparking.negocio.assembler.DTO;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.ClienteDominio;
import co.edu.uco.ucoparking.dominio.CompraDominio;
import co.edu.uco.ucoparking.dto.CompraDTO;

public final class CompraDTOAssembler {

    private CompraDTOAssembler() {}

    public static CompraDominio toDominio(final CompraDTO dto) {
        ClienteDominio cliente = dto.getIdCliente() != null
                ? ClienteDominio.builder().id(dto.getIdCliente()).build() : null;
        return CompraDominio.builder()
                .id(dto.getId())
                .fechaCompra(dto.getFechaCompra())
                .total(dto.getTotal())
                .estado(dto.getEstado())
                .cliente(cliente)
                .build();
    }

    public static CompraDTO toDTO(final CompraDominio dominio) {
        return new CompraDTO(dominio.getId(), dominio.getFechaCompra(), dominio.getTotal(), dominio.getEstado(), dominio.getCliente() != null ? dominio.getCliente().getId() : null);
    }
}
