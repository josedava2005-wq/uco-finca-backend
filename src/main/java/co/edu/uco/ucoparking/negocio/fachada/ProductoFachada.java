package co.edu.uco.ucoparking.negocio.fachada;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dto.ProductoDTO;

public interface ProductoFachada {
    void crear(ProductoDTO dto);
    List<ProductoDTO> consultar(ProductoDTO filtro);
    void modificar(ProductoDTO dto);
    void eliminar(UUID id);
}
