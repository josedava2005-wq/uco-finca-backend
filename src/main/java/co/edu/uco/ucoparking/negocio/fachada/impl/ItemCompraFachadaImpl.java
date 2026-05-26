package co.edu.uco.ucoparking.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import co.edu.uco.ucoparking.datos.ItemCompraDatos;
import co.edu.uco.ucoparking.dto.ItemCompraDTO;
import co.edu.uco.ucoparking.negocio.assembler.DTO.ItemCompraDTOAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.impl.ItemCompraCasoDeUsoImpl;
import co.edu.uco.ucoparking.negocio.fachada.ItemCompraFachada;

@Service
public final class ItemCompraFachadaImpl implements ItemCompraFachada {

    private final ItemCompraDatos datos;

    public ItemCompraFachadaImpl(final ItemCompraDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final ItemCompraDTO dto) {
        new ItemCompraCasoDeUsoImpl(datos).crear(ItemCompraDTOAssembler.toDominio(dto));
    }

    @Override
    public List<ItemCompraDTO> consultar(final ItemCompraDTO filtro) {
        return new ItemCompraCasoDeUsoImpl(datos)
                .consultar(ItemCompraDTOAssembler.toDominio(filtro))
                .stream()
                .map(ItemCompraDTOAssembler::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final ItemCompraDTO dto) {
        new ItemCompraCasoDeUsoImpl(datos).modificar(ItemCompraDTOAssembler.toDominio(dto));
    }

    @Override
    public void eliminar(final UUID id) {
        new ItemCompraCasoDeUsoImpl(datos).eliminar(id);
    }
}
