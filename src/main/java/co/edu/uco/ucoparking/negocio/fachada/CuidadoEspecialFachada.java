package co.edu.uco.ucoparking.negocio.fachada;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dto.CuidadoEspecialDTO;

public interface CuidadoEspecialFachada {
    void crear(CuidadoEspecialDTO dto);
    List<CuidadoEspecialDTO> consultar(CuidadoEspecialDTO filtro);
    void modificar(CuidadoEspecialDTO dto);
    void eliminar(UUID id);
}
