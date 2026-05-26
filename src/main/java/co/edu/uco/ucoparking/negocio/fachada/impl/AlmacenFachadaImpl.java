package co.edu.uco.ucoparking.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import co.edu.uco.ucoparking.datos.AlmacenDatos;
import co.edu.uco.ucoparking.dto.AlmacenDTO;
import co.edu.uco.ucoparking.negocio.assembler.DTO.AlmacenDTOAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.impl.AlmacenCasoDeUsoImpl;
import co.edu.uco.ucoparking.negocio.fachada.AlmacenFachada;

@Service
public final class AlmacenFachadaImpl implements AlmacenFachada {

    private final AlmacenDatos datos;

    public AlmacenFachadaImpl(final AlmacenDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final AlmacenDTO dto) {
        new AlmacenCasoDeUsoImpl(datos).crear(AlmacenDTOAssembler.toDominio(dto));
    }

    @Override
    public List<AlmacenDTO> consultar(final AlmacenDTO filtro) {
        return new AlmacenCasoDeUsoImpl(datos)
                .consultar(AlmacenDTOAssembler.toDominio(filtro))
                .stream()
                .map(AlmacenDTOAssembler::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final AlmacenDTO dto) {
        new AlmacenCasoDeUsoImpl(datos).modificar(AlmacenDTOAssembler.toDominio(dto));
    }

    @Override
    public void eliminar(final UUID id) {
        new AlmacenCasoDeUsoImpl(datos).eliminar(id);
    }
}
