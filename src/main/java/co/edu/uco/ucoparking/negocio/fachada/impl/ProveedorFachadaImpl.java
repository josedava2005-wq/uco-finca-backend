package co.edu.uco.ucoparking.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import co.edu.uco.ucoparking.datos.ProveedorDatos;
import co.edu.uco.ucoparking.dto.ProveedorDTO;
import co.edu.uco.ucoparking.negocio.assembler.DTO.ProveedorDTOAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.impl.ProveedorCasoDeUsoImpl;
import co.edu.uco.ucoparking.negocio.fachada.ProveedorFachada;

@Service
public final class ProveedorFachadaImpl implements ProveedorFachada {

    private final ProveedorDatos datos;

    public ProveedorFachadaImpl(final ProveedorDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final ProveedorDTO dto) {
        new ProveedorCasoDeUsoImpl(datos).crear(ProveedorDTOAssembler.toDominio(dto));
    }

    @Override
    public List<ProveedorDTO> consultar(final ProveedorDTO filtro) {
        return new ProveedorCasoDeUsoImpl(datos)
                .consultar(ProveedorDTOAssembler.toDominio(filtro))
                .stream()
                .map(ProveedorDTOAssembler::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final ProveedorDTO dto) {
        new ProveedorCasoDeUsoImpl(datos).modificar(ProveedorDTOAssembler.toDominio(dto));
    }

    @Override
    public void eliminar(final UUID id) {
        new ProveedorCasoDeUsoImpl(datos).eliminar(id);
    }
}
