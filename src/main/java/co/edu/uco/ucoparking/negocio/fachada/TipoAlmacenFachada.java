package co.edu.uco.ucoparking.negocio.fachada;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dto.TipoAlmacenDTO;

public interface TipoAlmacenFachada {
    void crear(TipoAlmacenDTO dto);
    List<TipoAlmacenDTO> consultar(TipoAlmacenDTO filtro);
    void modificar(TipoAlmacenDTO dto);
    void eliminar(UUID id);
}
