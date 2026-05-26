package co.edu.uco.ucoparking.negocio.fachada;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dto.RecoleccionDTO;

public interface RecoleccionFachada {
    void crear(RecoleccionDTO dto);
    List<RecoleccionDTO> consultar(RecoleccionDTO filtro);
    void modificar(RecoleccionDTO dto);
    void eliminar(UUID id);
}
