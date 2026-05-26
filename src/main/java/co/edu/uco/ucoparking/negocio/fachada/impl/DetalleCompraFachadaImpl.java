package co.edu.uco.ucoparking.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import co.edu.uco.ucoparking.datos.DetalleCompraDatos;
import co.edu.uco.ucoparking.dto.DetalleCompraDTO;
import co.edu.uco.ucoparking.negocio.assembler.DTO.DetalleCompraDTOAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.impl.DetalleCompraCasoDeUsoImpl;
import co.edu.uco.ucoparking.negocio.fachada.DetalleCompraFachada;

@Service
public final class DetalleCompraFachadaImpl implements DetalleCompraFachada {

    private final DetalleCompraDatos datos;

    public DetalleCompraFachadaImpl(final DetalleCompraDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final DetalleCompraDTO dto) {
        new DetalleCompraCasoDeUsoImpl(datos).crear(DetalleCompraDTOAssembler.toDominio(dto));
    }

    @Override
    public List<DetalleCompraDTO> consultar(final DetalleCompraDTO filtro) {
        return new DetalleCompraCasoDeUsoImpl(datos)
                .consultar(DetalleCompraDTOAssembler.toDominio(filtro))
                .stream()
                .map(DetalleCompraDTOAssembler::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final DetalleCompraDTO dto) {
        new DetalleCompraCasoDeUsoImpl(datos).modificar(DetalleCompraDTOAssembler.toDominio(dto));
    }

    @Override
    public void eliminar(final UUID id) {
        new DetalleCompraCasoDeUsoImpl(datos).eliminar(id);
    }
}
