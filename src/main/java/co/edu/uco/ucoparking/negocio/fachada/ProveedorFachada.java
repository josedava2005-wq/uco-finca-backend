package co.edu.uco.ucoparking.negocio.fachada;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dto.ProveedorDTO;

public interface ProveedorFachada {
    void crear(ProveedorDTO dto);
    List<ProveedorDTO> consultar(ProveedorDTO filtro);
    void modificar(ProveedorDTO dto);
    void eliminar(UUID id);
}
