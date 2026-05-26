package co.edu.uco.ucoparking.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import co.edu.uco.ucoparking.datos.CompraDatos;
import co.edu.uco.ucoparking.dto.CompraDTO;
import co.edu.uco.ucoparking.negocio.assembler.DTO.CompraDTOAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.impl.CompraCasoDeUsoImpl;
import co.edu.uco.ucoparking.negocio.fachada.CompraFachada;

@Service
public final class CompraFachadaImpl implements CompraFachada {

    private final CompraDatos datos;

    public CompraFachadaImpl(final CompraDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final CompraDTO dto) {
        new CompraCasoDeUsoImpl(datos).crear(CompraDTOAssembler.toDominio(dto));
    }

    @Override
    public List<CompraDTO> consultar(final CompraDTO filtro) {
        return new CompraCasoDeUsoImpl(datos)
                .consultar(CompraDTOAssembler.toDominio(filtro))
                .stream()
                .map(CompraDTOAssembler::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final CompraDTO dto) {
        new CompraCasoDeUsoImpl(datos).modificar(CompraDTOAssembler.toDominio(dto));
    }

    @Override
    public void eliminar(final UUID id) {
        new CompraCasoDeUsoImpl(datos).eliminar(id);
    }
}
