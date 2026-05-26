package co.edu.uco.ucoparking.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import co.edu.uco.ucoparking.datos.SuministroDatos;
import co.edu.uco.ucoparking.dto.SuministroDTO;
import co.edu.uco.ucoparking.negocio.assembler.DTO.SuministroDTOAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.impl.SuministroCasoDeUsoImpl;
import co.edu.uco.ucoparking.negocio.fachada.SuministroFachada;

@Service
public final class SuministroFachadaImpl implements SuministroFachada {

    private final SuministroDatos datos;

    public SuministroFachadaImpl(final SuministroDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final SuministroDTO dto) {
        new SuministroCasoDeUsoImpl(datos).crear(SuministroDTOAssembler.toDominio(dto));
    }

    @Override
    public List<SuministroDTO> consultar(final SuministroDTO filtro) {
        return new SuministroCasoDeUsoImpl(datos)
                .consultar(SuministroDTOAssembler.toDominio(filtro))
                .stream()
                .map(SuministroDTOAssembler::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final SuministroDTO dto) {
        new SuministroCasoDeUsoImpl(datos).modificar(SuministroDTOAssembler.toDominio(dto));
    }

    @Override
    public void eliminar(final UUID id) {
        new SuministroCasoDeUsoImpl(datos).eliminar(id);
    }
}
