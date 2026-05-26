package co.edu.uco.ucoparking.datos;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.entidad.TipoSuministroEntidad;

public interface TipoSuministroDatos {
    void crear(TipoSuministroEntidad entidad);
    List<TipoSuministroEntidad> consultar(TipoSuministroEntidad filtro);
    void modificar(TipoSuministroEntidad entidad);
    void eliminar(UUID id);
}
