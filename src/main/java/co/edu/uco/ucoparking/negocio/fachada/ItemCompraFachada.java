package co.edu.uco.ucoparking.negocio.fachada;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dto.ItemCompraDTO;

public interface ItemCompraFachada {
    void crear(ItemCompraDTO dto);
    List<ItemCompraDTO> consultar(ItemCompraDTO filtro);
    void modificar(ItemCompraDTO dto);
    void eliminar(UUID id);
}
