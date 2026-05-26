package co.edu.uco.ucoparking.negocio.fachada;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dto.TareaDTO;

public interface TareaFachada {
    void crear(TareaDTO dto);
    List<TareaDTO> consultar(TareaDTO filtro);
    void modificar(TareaDTO dto);
    void eliminar(UUID id);
}
