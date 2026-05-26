package co.edu.uco.ucoparking.datos;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.entidad.RecoleccionEntidad;

public interface RecoleccionDatos {
    void crear(RecoleccionEntidad entidad);
    List<RecoleccionEntidad> consultar(RecoleccionEntidad filtro);
    void modificar(RecoleccionEntidad entidad);
    void eliminar(UUID id);
}
