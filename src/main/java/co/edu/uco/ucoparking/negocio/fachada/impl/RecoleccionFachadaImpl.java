package co.edu.uco.ucoparking.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import co.edu.uco.ucoparking.datos.RecoleccionDatos;
import co.edu.uco.ucoparking.dto.RecoleccionDTO;
import co.edu.uco.ucoparking.negocio.assembler.DTO.RecoleccionDTOAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.impl.RecoleccionCasoDeUsoImpl;
import co.edu.uco.ucoparking.negocio.fachada.RecoleccionFachada;

@Service
public final class RecoleccionFachadaImpl implements RecoleccionFachada {

    private final RecoleccionDatos datos;

    public RecoleccionFachadaImpl(final RecoleccionDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final RecoleccionDTO dto) {
        new RecoleccionCasoDeUsoImpl(datos).crear(RecoleccionDTOAssembler.toDominio(dto));
    }

    @Override
    public List<RecoleccionDTO> consultar(final RecoleccionDTO filtro) {
        return new RecoleccionCasoDeUsoImpl(datos)
                .consultar(RecoleccionDTOAssembler.toDominio(filtro))
                .stream()
                .map(RecoleccionDTOAssembler::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final RecoleccionDTO dto) {
        new RecoleccionCasoDeUsoImpl(datos).modificar(RecoleccionDTOAssembler.toDominio(dto));
    }

    @Override
    public void eliminar(final UUID id) {
        new RecoleccionCasoDeUsoImpl(datos).eliminar(id);
    }
}
