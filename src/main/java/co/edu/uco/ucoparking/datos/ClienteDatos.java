package co.edu.uco.ucoparking.datos;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.entidad.ClienteEntidad;

public interface ClienteDatos {
    void crear(ClienteEntidad entidad);
    List<ClienteEntidad> consultar(ClienteEntidad filtro);
    void modificar(ClienteEntidad entidad);
    void eliminar(UUID id);
}
