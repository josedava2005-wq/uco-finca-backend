package co.edu.uco.ucoparking.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import co.edu.uco.ucoparking.datos.TipoSuministroDatos;
import co.edu.uco.ucoparking.dto.TipoSuministroDTO;
import co.edu.uco.ucoparking.negocio.assembler.DTO.TipoSuministroDTOAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.impl.TipoSuministroCasoDeUsoImpl;
import co.edu.uco.ucoparking.negocio.fachada.TipoSuministroFachada;

@Service
public final class TipoSuministroFachadaImpl implements TipoSuministroFachada {

    private final TipoSuministroDatos datos;

    public TipoSuministroFachadaImpl(final TipoSuministroDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final TipoSuministroDTO dto) {
        new TipoSuministroCasoDeUsoImpl(datos).crear(TipoSuministroDTOAssembler.toDominio(dto));
    }

    @Override
    public List<TipoSuministroDTO> consultar(final TipoSuministroDTO filtro) {
        return new TipoSuministroCasoDeUsoImpl(datos)
                .consultar(TipoSuministroDTOAssembler.toDominio(filtro))
                .stream()
                .map(TipoSuministroDTOAssembler::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final TipoSuministroDTO dto) {
        new TipoSuministroCasoDeUsoImpl(datos).modificar(TipoSuministroDTOAssembler.toDominio(dto));
    }

    @Override
    public void eliminar(final UUID id) {
        new TipoSuministroCasoDeUsoImpl(datos).eliminar(id);
    }
}
