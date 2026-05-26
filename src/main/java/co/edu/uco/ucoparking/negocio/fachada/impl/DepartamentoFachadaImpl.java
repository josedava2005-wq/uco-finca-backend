package co.edu.uco.ucoparking.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import co.edu.uco.ucoparking.datos.DepartamentoDatos;
import co.edu.uco.ucoparking.dto.DepartamentoDTO;
import co.edu.uco.ucoparking.negocio.assembler.DTO.DepartamentoDTOAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.impl.DepartamentoCasoDeUsoImpl;
import co.edu.uco.ucoparking.negocio.fachada.DepartamentoFachada;

@Service
public final class DepartamentoFachadaImpl implements DepartamentoFachada {

    private final DepartamentoDatos datos;

    public DepartamentoFachadaImpl(final DepartamentoDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final DepartamentoDTO dto) {
        new DepartamentoCasoDeUsoImpl(datos).crear(DepartamentoDTOAssembler.toDominio(dto));
    }

    @Override
    public List<DepartamentoDTO> consultar(final DepartamentoDTO filtro) {
        return new DepartamentoCasoDeUsoImpl(datos)
                .consultar(DepartamentoDTOAssembler.toDominio(filtro))
                .stream()
                .map(DepartamentoDTOAssembler::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final DepartamentoDTO dto) {
        new DepartamentoCasoDeUsoImpl(datos).modificar(DepartamentoDTOAssembler.toDominio(dto));
    }

    @Override
    public void eliminar(final UUID id) {
        new DepartamentoCasoDeUsoImpl(datos).eliminar(id);
    }
}
