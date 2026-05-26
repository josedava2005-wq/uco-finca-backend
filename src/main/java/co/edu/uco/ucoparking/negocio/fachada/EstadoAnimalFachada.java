package co.edu.uco.ucoparking.negocio.fachada;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dto.EstadoAnimalDTO;

public interface EstadoAnimalFachada {
    void crear(EstadoAnimalDTO dto);
    List<EstadoAnimalDTO> consultar(EstadoAnimalDTO filtro);
    void modificar(EstadoAnimalDTO dto);
    void eliminar(UUID id);
}
