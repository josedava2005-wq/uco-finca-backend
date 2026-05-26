package co.edu.uco.ucoparking.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import co.edu.uco.ucoparking.datos.TareaDatos;
import co.edu.uco.ucoparking.dto.TareaDTO;
import co.edu.uco.ucoparking.negocio.assembler.DTO.TareaDTOAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.impl.TareaCasoDeUsoImpl;
import co.edu.uco.ucoparking.negocio.fachada.TareaFachada;

@Service
public final class TareaFachadaImpl implements TareaFachada {

    private final TareaDatos datos;

    public TareaFachadaImpl(final TareaDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final TareaDTO dto) {
        new TareaCasoDeUsoImpl(datos).crear(TareaDTOAssembler.toDominio(dto));
    }

    @Override
    public List<TareaDTO> consultar(final TareaDTO filtro) {
        return new TareaCasoDeUsoImpl(datos)
                .consultar(TareaDTOAssembler.toDominio(filtro))
                .stream()
                .map(TareaDTOAssembler::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final TareaDTO dto) {
        new TareaCasoDeUsoImpl(datos).modificar(TareaDTOAssembler.toDominio(dto));
    }

    @Override
    public void eliminar(final UUID id) {
        new TareaCasoDeUsoImpl(datos).eliminar(id);
    }
}
