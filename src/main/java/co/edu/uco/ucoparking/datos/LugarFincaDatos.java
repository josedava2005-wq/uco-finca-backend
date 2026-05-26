package co.edu.uco.ucoparking.datos;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.entidad.LugarFincaEntidad;

public interface LugarFincaDatos {
    void crear(LugarFincaEntidad entidad);
    List<LugarFincaEntidad> consultar(LugarFincaEntidad filtro);
    void modificar(LugarFincaEntidad entidad);
    void eliminar(UUID id);
}
