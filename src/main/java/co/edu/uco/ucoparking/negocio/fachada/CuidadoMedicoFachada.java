package co.edu.uco.ucoparking.negocio.fachada;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dto.CuidadoMedicoDTO;

public interface CuidadoMedicoFachada {
    void crear(CuidadoMedicoDTO dto);
    List<CuidadoMedicoDTO> consultar(CuidadoMedicoDTO filtro);
    void modificar(CuidadoMedicoDTO dto);
    void eliminar(UUID id);
}
