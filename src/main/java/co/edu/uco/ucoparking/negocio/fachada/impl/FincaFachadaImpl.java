package co.edu.uco.ucoparking.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import co.edu.uco.ucoparking.datos.FincaDatos;
import co.edu.uco.ucoparking.dto.FincaDTO;
import co.edu.uco.ucoparking.negocio.assembler.DTO.FincaDTOAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.impl.FincaCasoDeUsoImpl;
import co.edu.uco.ucoparking.negocio.fachada.FincaFachada;

@Service
public final class FincaFachadaImpl implements FincaFachada {

    private final FincaDatos datos;

    public FincaFachadaImpl(final FincaDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final FincaDTO dto) {
        new FincaCasoDeUsoImpl(datos).crear(FincaDTOAssembler.toDominio(dto));
    }

    @Override
    public List<FincaDTO> consultar(final FincaDTO filtro) {
        return new FincaCasoDeUsoImpl(datos)
                .consultar(FincaDTOAssembler.toDominio(filtro))
                .stream()
                .map(FincaDTOAssembler::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final FincaDTO dto) {
        new FincaCasoDeUsoImpl(datos).modificar(FincaDTOAssembler.toDominio(dto));
    }

    @Override
    public void eliminar(final UUID id) {
        new FincaCasoDeUsoImpl(datos).eliminar(id);
    }
}
