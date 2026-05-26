package co.edu.uco.ucoparking.negocio.fachada;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dto.TipoSuministroDTO;

public interface TipoSuministroFachada {
    void crear(TipoSuministroDTO dto);
    List<TipoSuministroDTO> consultar(TipoSuministroDTO filtro);
    void modificar(TipoSuministroDTO dto);
    void eliminar(UUID id);
}
