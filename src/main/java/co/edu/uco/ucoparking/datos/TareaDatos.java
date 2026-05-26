package co.edu.uco.ucoparking.datos;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.entidad.TareaEntidad;

public interface TareaDatos {
    void crear(TareaEntidad entidad);
    List<TareaEntidad> consultar(TareaEntidad filtro);
    void modificar(TareaEntidad entidad);
    void eliminar(UUID id);
}
