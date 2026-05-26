package co.edu.uco.ucoparking.negocio.fachada;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dto.LugarFincaDTO;

public interface LugarFincaFachada {
    void crear(LugarFincaDTO dto);
    List<LugarFincaDTO> consultar(LugarFincaDTO filtro);
    void modificar(LugarFincaDTO dto);
    void eliminar(UUID id);
}
