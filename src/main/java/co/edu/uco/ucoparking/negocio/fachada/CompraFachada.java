package co.edu.uco.ucoparking.negocio.fachada;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dto.CompraDTO;

public interface CompraFachada {
    void crear(CompraDTO dto);
    List<CompraDTO> consultar(CompraDTO filtro);
    void modificar(CompraDTO dto);
    void eliminar(UUID id);
}
