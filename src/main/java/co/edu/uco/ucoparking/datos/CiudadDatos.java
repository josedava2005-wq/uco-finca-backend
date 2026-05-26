package co.edu.uco.ucoparking.datos;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.entidad.CiudadEntidad;

public interface CiudadDatos {
    void crear(CiudadEntidad entidad);
    List<CiudadEntidad> consultar(CiudadEntidad filtro);
    void modificar(CiudadEntidad entidad);
    void eliminar(UUID id);
}
