package co.edu.uco.ucoparking.negocio.fachada;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dto.PaisDTO;

public interface PaisFachada {
    void crear(PaisDTO dto);
    List<PaisDTO> consultar(PaisDTO filtro);
    void modificar(PaisDTO dto);
    void eliminar(UUID id);
}
