package co.edu.uco.ucoparking.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import co.edu.uco.ucoparking.datos.CuidadoMedicoDatos;
import co.edu.uco.ucoparking.dto.CuidadoMedicoDTO;
import co.edu.uco.ucoparking.negocio.assembler.DTO.CuidadoMedicoDTOAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.impl.CuidadoMedicoCasoDeUsoImpl;
import co.edu.uco.ucoparking.negocio.fachada.CuidadoMedicoFachada;

@Service
public final class CuidadoMedicoFachadaImpl implements CuidadoMedicoFachada {

    private final CuidadoMedicoDatos datos;

    public CuidadoMedicoFachadaImpl(final CuidadoMedicoDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final CuidadoMedicoDTO dto) {
        new CuidadoMedicoCasoDeUsoImpl(datos).crear(CuidadoMedicoDTOAssembler.toDominio(dto));
    }

    @Override
    public List<CuidadoMedicoDTO> consultar(final CuidadoMedicoDTO filtro) {
        return new CuidadoMedicoCasoDeUsoImpl(datos)
                .consultar(CuidadoMedicoDTOAssembler.toDominio(filtro))
                .stream()
                .map(CuidadoMedicoDTOAssembler::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final CuidadoMedicoDTO dto) {
        new CuidadoMedicoCasoDeUsoImpl(datos).modificar(CuidadoMedicoDTOAssembler.toDominio(dto));
    }

    @Override
    public void eliminar(final UUID id) {
        new CuidadoMedicoCasoDeUsoImpl(datos).eliminar(id);
    }
}
