package co.edu.uco.ucoparking.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import co.edu.uco.ucoparking.datos.CuidadoEspecialDatos;
import co.edu.uco.ucoparking.dto.CuidadoEspecialDTO;
import co.edu.uco.ucoparking.negocio.assembler.DTO.CuidadoEspecialDTOAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.impl.CuidadoEspecialCasoDeUsoImpl;
import co.edu.uco.ucoparking.negocio.fachada.CuidadoEspecialFachada;

@Service
public final class CuidadoEspecialFachadaImpl implements CuidadoEspecialFachada {

    private final CuidadoEspecialDatos datos;

    public CuidadoEspecialFachadaImpl(final CuidadoEspecialDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final CuidadoEspecialDTO dto) {
        new CuidadoEspecialCasoDeUsoImpl(datos).crear(CuidadoEspecialDTOAssembler.toDominio(dto));
    }

    @Override
    public List<CuidadoEspecialDTO> consultar(final CuidadoEspecialDTO filtro) {
        return new CuidadoEspecialCasoDeUsoImpl(datos)
                .consultar(CuidadoEspecialDTOAssembler.toDominio(filtro))
                .stream()
                .map(CuidadoEspecialDTOAssembler::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final CuidadoEspecialDTO dto) {
        new CuidadoEspecialCasoDeUsoImpl(datos).modificar(CuidadoEspecialDTOAssembler.toDominio(dto));
    }

    @Override
    public void eliminar(final UUID id) {
        new CuidadoEspecialCasoDeUsoImpl(datos).eliminar(id);
    }
}
