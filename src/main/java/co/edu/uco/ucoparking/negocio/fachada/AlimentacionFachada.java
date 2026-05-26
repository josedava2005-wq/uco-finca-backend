package co.edu.uco.ucoparking.negocio.fachada;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dto.AlimentacionDTO;

public interface AlimentacionFachada {
    void crear(AlimentacionDTO dto);
    List<AlimentacionDTO> consultar(AlimentacionDTO filtro);
    void modificar(AlimentacionDTO dto);
    void eliminar(UUID id);
}
