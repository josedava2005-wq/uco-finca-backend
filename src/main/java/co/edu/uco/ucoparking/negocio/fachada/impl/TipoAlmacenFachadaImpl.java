package co.edu.uco.ucoparking.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import co.edu.uco.ucoparking.datos.TipoAlmacenDatos;
import co.edu.uco.ucoparking.dto.TipoAlmacenDTO;
import co.edu.uco.ucoparking.negocio.assembler.DTO.TipoAlmacenDTOAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.impl.TipoAlmacenCasoDeUsoImpl;
import co.edu.uco.ucoparking.negocio.fachada.TipoAlmacenFachada;

@Service
public final class TipoAlmacenFachadaImpl implements TipoAlmacenFachada {

    private final TipoAlmacenDatos datos;

    public TipoAlmacenFachadaImpl(final TipoAlmacenDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final TipoAlmacenDTO dto) {
        new TipoAlmacenCasoDeUsoImpl(datos).crear(TipoAlmacenDTOAssembler.toDominio(dto));
    }

    @Override
    public List<TipoAlmacenDTO> consultar(final TipoAlmacenDTO filtro) {
        return new TipoAlmacenCasoDeUsoImpl(datos)
                .consultar(TipoAlmacenDTOAssembler.toDominio(filtro))
                .stream()
                .map(TipoAlmacenDTOAssembler::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final TipoAlmacenDTO dto) {
        new TipoAlmacenCasoDeUsoImpl(datos).modificar(TipoAlmacenDTOAssembler.toDominio(dto));
    }

    @Override
    public void eliminar(final UUID id) {
        new TipoAlmacenCasoDeUsoImpl(datos).eliminar(id);
    }
}
