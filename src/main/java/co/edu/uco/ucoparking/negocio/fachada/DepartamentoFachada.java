package co.edu.uco.ucoparking.negocio.fachada;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dto.DepartamentoDTO;

public interface DepartamentoFachada {
    void crear(DepartamentoDTO dto);
    List<DepartamentoDTO> consultar(DepartamentoDTO filtro);
    void modificar(DepartamentoDTO dto);
    void eliminar(UUID id);
}
