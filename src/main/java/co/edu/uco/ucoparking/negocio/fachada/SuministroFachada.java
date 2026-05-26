package co.edu.uco.ucoparking.negocio.fachada;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dto.SuministroDTO;

public interface SuministroFachada {
    void crear(SuministroDTO dto);
    List<SuministroDTO> consultar(SuministroDTO filtro);
    void modificar(SuministroDTO dto);
    void eliminar(UUID id);
}
