package co.edu.uco.ucoparking.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import co.edu.uco.ucoparking.datos.LugarFincaDatos;
import co.edu.uco.ucoparking.dto.LugarFincaDTO;
import co.edu.uco.ucoparking.negocio.assembler.DTO.LugarFincaDTOAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.impl.LugarFincaCasoDeUsoImpl;
import co.edu.uco.ucoparking.negocio.fachada.LugarFincaFachada;

@Service
public final class LugarFincaFachadaImpl implements LugarFincaFachada {

    private final LugarFincaDatos datos;

    public LugarFincaFachadaImpl(final LugarFincaDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final LugarFincaDTO dto) {
        new LugarFincaCasoDeUsoImpl(datos).crear(LugarFincaDTOAssembler.toDominio(dto));
    }

    @Override
    public List<LugarFincaDTO> consultar(final LugarFincaDTO filtro) {
        return new LugarFincaCasoDeUsoImpl(datos)
                .consultar(LugarFincaDTOAssembler.toDominio(filtro))
                .stream()
                .map(LugarFincaDTOAssembler::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final LugarFincaDTO dto) {
        new LugarFincaCasoDeUsoImpl(datos).modificar(LugarFincaDTOAssembler.toDominio(dto));
    }

    @Override
    public void eliminar(final UUID id) {
        new LugarFincaCasoDeUsoImpl(datos).eliminar(id);
    }
}
