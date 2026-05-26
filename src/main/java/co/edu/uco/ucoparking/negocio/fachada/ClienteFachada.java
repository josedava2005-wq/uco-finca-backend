package co.edu.uco.ucoparking.negocio.fachada;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dto.ClienteDTO;

public interface ClienteFachada {
    void crear(ClienteDTO dto);
    List<ClienteDTO> consultar(ClienteDTO filtro);
    void modificar(ClienteDTO dto);
    void eliminar(UUID id);
}
