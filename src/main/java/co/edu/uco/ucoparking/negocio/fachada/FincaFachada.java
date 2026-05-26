package co.edu.uco.ucoparking.negocio.fachada;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dto.FincaDTO;

public interface FincaFachada {
    void crear(FincaDTO dto);
    List<FincaDTO> consultar(FincaDTO filtro);
    void modificar(FincaDTO dto);
    void eliminar(UUID id);
}
