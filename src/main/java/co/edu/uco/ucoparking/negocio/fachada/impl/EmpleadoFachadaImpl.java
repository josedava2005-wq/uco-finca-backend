package co.edu.uco.ucoparking.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import co.edu.uco.ucoparking.datos.EmpleadoDatos;
import co.edu.uco.ucoparking.dto.EmpleadoDTO;
import co.edu.uco.ucoparking.negocio.assembler.DTO.EmpleadoDTOAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.impl.EmpleadoCasoDeUsoImpl;
import co.edu.uco.ucoparking.negocio.fachada.EmpleadoFachada;

@Service
public final class EmpleadoFachadaImpl implements EmpleadoFachada {

    private final EmpleadoDatos datos;

    public EmpleadoFachadaImpl(final EmpleadoDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final EmpleadoDTO dto) {
        new EmpleadoCasoDeUsoImpl(datos).crear(EmpleadoDTOAssembler.toDominio(dto));
    }

    @Override
    public List<EmpleadoDTO> consultar(final EmpleadoDTO filtro) {
        return new EmpleadoCasoDeUsoImpl(datos)
                .consultar(EmpleadoDTOAssembler.toDominio(filtro))
                .stream()
                .map(EmpleadoDTOAssembler::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final EmpleadoDTO dto) {
        new EmpleadoCasoDeUsoImpl(datos).modificar(EmpleadoDTOAssembler.toDominio(dto));
    }

    @Override
    public void eliminar(final UUID id) {
        new EmpleadoCasoDeUsoImpl(datos).eliminar(id);
    }
}
