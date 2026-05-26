package co.edu.uco.ucoparking.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import co.edu.uco.ucoparking.datos.EstadoAnimalDatos;
import co.edu.uco.ucoparking.dto.EstadoAnimalDTO;
import co.edu.uco.ucoparking.negocio.assembler.DTO.EstadoAnimalDTOAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.impl.EstadoAnimalCasoDeUsoImpl;
import co.edu.uco.ucoparking.negocio.fachada.EstadoAnimalFachada;

@Service
public final class EstadoAnimalFachadaImpl implements EstadoAnimalFachada {

    private final EstadoAnimalDatos datos;

    public EstadoAnimalFachadaImpl(final EstadoAnimalDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final EstadoAnimalDTO dto) {
        new EstadoAnimalCasoDeUsoImpl(datos).crear(EstadoAnimalDTOAssembler.toDominio(dto));
    }

    @Override
    public List<EstadoAnimalDTO> consultar(final EstadoAnimalDTO filtro) {
        return new EstadoAnimalCasoDeUsoImpl(datos)
                .consultar(EstadoAnimalDTOAssembler.toDominio(filtro))
                .stream()
                .map(EstadoAnimalDTOAssembler::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final EstadoAnimalDTO dto) {
        new EstadoAnimalCasoDeUsoImpl(datos).modificar(EstadoAnimalDTOAssembler.toDominio(dto));
    }

    @Override
    public void eliminar(final UUID id) {
        new EstadoAnimalCasoDeUsoImpl(datos).eliminar(id);
    }
}
