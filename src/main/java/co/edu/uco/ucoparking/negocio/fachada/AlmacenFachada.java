package co.edu.uco.ucoparking.negocio.fachada;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dto.AlmacenDTO;

public interface AlmacenFachada {
    void crear(AlmacenDTO dto);
    List<AlmacenDTO> consultar(AlmacenDTO filtro);
    void modificar(AlmacenDTO dto);
    void eliminar(UUID id);
}
