package co.edu.uco.ucoparking.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import co.edu.uco.ucoparking.datos.AnimalDatos;
import co.edu.uco.ucoparking.dto.AnimalDTO;
import co.edu.uco.ucoparking.negocio.assembler.DTO.AnimalDTOAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.impl.AnimalCasoDeUsoImpl;
import co.edu.uco.ucoparking.negocio.fachada.AnimalFachada;

@Service
public final class AnimalFachadaImpl implements AnimalFachada {

    private final AnimalDatos datos;

    public AnimalFachadaImpl(final AnimalDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final AnimalDTO dto) {
        new AnimalCasoDeUsoImpl(datos).crear(AnimalDTOAssembler.toDominio(dto));
    }

    @Override
    public List<AnimalDTO> consultar(final AnimalDTO filtro) {
        return new AnimalCasoDeUsoImpl(datos)
                .consultar(AnimalDTOAssembler.toDominio(filtro))
                .stream()
                .map(AnimalDTOAssembler::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final AnimalDTO dto) {
        new AnimalCasoDeUsoImpl(datos).modificar(AnimalDTOAssembler.toDominio(dto));
    }

    @Override
    public void eliminar(final UUID id) {
        new AnimalCasoDeUsoImpl(datos).eliminar(id);
    }
}
