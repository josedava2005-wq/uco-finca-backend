package co.edu.uco.ucoparking.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import co.edu.uco.ucoparking.datos.AlimentacionDatos;
import co.edu.uco.ucoparking.dto.AlimentacionDTO;
import co.edu.uco.ucoparking.negocio.assembler.DTO.AlimentacionDTOAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.impl.AlimentacionCasoDeUsoImpl;
import co.edu.uco.ucoparking.negocio.fachada.AlimentacionFachada;

@Service
public final class AlimentacionFachadaImpl implements AlimentacionFachada {

    private final AlimentacionDatos datos;

    public AlimentacionFachadaImpl(final AlimentacionDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final AlimentacionDTO dto) {
        new AlimentacionCasoDeUsoImpl(datos).crear(AlimentacionDTOAssembler.toDominio(dto));
    }

    @Override
    public List<AlimentacionDTO> consultar(final AlimentacionDTO filtro) {
        return new AlimentacionCasoDeUsoImpl(datos)
                .consultar(AlimentacionDTOAssembler.toDominio(filtro))
                .stream()
                .map(AlimentacionDTOAssembler::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final AlimentacionDTO dto) {
        new AlimentacionCasoDeUsoImpl(datos).modificar(AlimentacionDTOAssembler.toDominio(dto));
    }

    @Override
    public void eliminar(final UUID id) {
        new AlimentacionCasoDeUsoImpl(datos).eliminar(id);
    }
}
