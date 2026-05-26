package co.edu.uco.ucoparking.negocio.fachada;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dto.DetalleCompraDTO;

public interface DetalleCompraFachada {
    void crear(DetalleCompraDTO dto);
    List<DetalleCompraDTO> consultar(DetalleCompraDTO filtro);
    void modificar(DetalleCompraDTO dto);
    void eliminar(UUID id);
}
