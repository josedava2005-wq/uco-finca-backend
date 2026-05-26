package co.edu.uco.ucoparking.negocio.fachada;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dto.EmpleadoDTO;

public interface EmpleadoFachada {
    void crear(EmpleadoDTO dto);
    List<EmpleadoDTO> consultar(EmpleadoDTO filtro);
    void modificar(EmpleadoDTO dto);
    void eliminar(UUID id);
}
