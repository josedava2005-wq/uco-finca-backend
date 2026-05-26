package co.edu.uco.ucoparking.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import co.edu.uco.ucoparking.datos.PaisDatos;
import co.edu.uco.ucoparking.dto.PaisDTO;
import co.edu.uco.ucoparking.negocio.assembler.DTO.PaisDTOAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.impl.PaisCasoDeUsoImpl;
import co.edu.uco.ucoparking.negocio.fachada.PaisFachada;

@Service
public final class PaisFachadaImpl implements PaisFachada {

    private final PaisDatos datos;

    public PaisFachadaImpl(final PaisDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final PaisDTO dto) {
        new PaisCasoDeUsoImpl(datos).crear(PaisDTOAssembler.toDominio(dto));
    }

    @Override
    public List<PaisDTO> consultar(final PaisDTO filtro) {
        return new PaisCasoDeUsoImpl(datos)
                .consultar(PaisDTOAssembler.toDominio(filtro))
                .stream()
                .map(PaisDTOAssembler::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final PaisDTO dto) {
        new PaisCasoDeUsoImpl(datos).modificar(PaisDTOAssembler.toDominio(dto));
    }

    @Override
    public void eliminar(final UUID id) {
        new PaisCasoDeUsoImpl(datos).eliminar(id);
    }
}
