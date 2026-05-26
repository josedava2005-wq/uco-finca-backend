package co.edu.uco.ucoparking.negocio.fachada;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dto.CiudadDTO;

public interface CiudadFachada {
    void crear(CiudadDTO dto);
    List<CiudadDTO> consultar(CiudadDTO filtro);
    void modificar(CiudadDTO dto);
    void eliminar(UUID id);
}
