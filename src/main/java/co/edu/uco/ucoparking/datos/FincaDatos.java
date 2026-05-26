package co.edu.uco.ucoparking.datos;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.entidad.FincaEntidad;

public interface FincaDatos {
    void crear(FincaEntidad entidad);
    List<FincaEntidad> consultar(FincaEntidad filtro);
    void modificar(FincaEntidad entidad);
    void eliminar(UUID id);
}
