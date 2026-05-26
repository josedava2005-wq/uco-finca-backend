package co.edu.uco.ucoparking.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import co.edu.uco.ucoparking.datos.CiudadDatos;
import co.edu.uco.ucoparking.dto.CiudadDTO;
import co.edu.uco.ucoparking.negocio.assembler.DTO.CiudadDTOAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.impl.CiudadCasoDeUsoImpl;
import co.edu.uco.ucoparking.negocio.fachada.CiudadFachada;

@Service
public final class CiudadFachadaImpl implements CiudadFachada {

    private final CiudadDatos datos;

    public CiudadFachadaImpl(final CiudadDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final CiudadDTO dto) {
        new CiudadCasoDeUsoImpl(datos).crear(CiudadDTOAssembler.toDominio(dto));
    }

    @Override
    public List<CiudadDTO> consultar(final CiudadDTO filtro) {
        return new CiudadCasoDeUsoImpl(datos)
                .consultar(CiudadDTOAssembler.toDominio(filtro))
                .stream()
                .map(CiudadDTOAssembler::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final CiudadDTO dto) {
        new CiudadCasoDeUsoImpl(datos).modificar(CiudadDTOAssembler.toDominio(dto));
    }

    @Override
    public void eliminar(final UUID id) {
        new CiudadCasoDeUsoImpl(datos).eliminar(id);
    }
}
