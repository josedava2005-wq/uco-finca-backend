package co.edu.uco.ucoparking.datos;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.entidad.ProveedorEntidad;

public interface ProveedorDatos {
    void crear(ProveedorEntidad entidad);
    List<ProveedorEntidad> consultar(ProveedorEntidad filtro);
    void modificar(ProveedorEntidad entidad);
    void eliminar(UUID id);
}
