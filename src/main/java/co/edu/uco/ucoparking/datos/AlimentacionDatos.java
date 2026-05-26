package co.edu.uco.ucoparking.datos;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.entidad.AlimentacionEntidad;

public interface AlimentacionDatos {
    void crear(AlimentacionEntidad entidad);
    List<AlimentacionEntidad> consultar(AlimentacionEntidad filtro);
    void modificar(AlimentacionEntidad entidad);
    void eliminar(UUID id);
}
