package co.edu.uco.ucoparking.negocio.fachada;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dto.AnimalDTO;

public interface AnimalFachada {
    void crear(AnimalDTO dto);
    List<AnimalDTO> consultar(AnimalDTO filtro);
    void modificar(AnimalDTO dto);
    void eliminar(UUID id);
}
