package co.edu.uco.ucoparking.datos;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.entidad.SuministroEntidad;

public interface SuministroDatos {
    void crear(SuministroEntidad entidad);
    List<SuministroEntidad> consultar(SuministroEntidad filtro);
    void modificar(SuministroEntidad entidad);
    void eliminar(UUID id);
}
