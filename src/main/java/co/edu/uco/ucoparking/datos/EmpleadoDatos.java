package co.edu.uco.ucoparking.datos;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.entidad.EmpleadoEntidad;

public interface EmpleadoDatos {
    void crear(EmpleadoEntidad entidad);
    List<EmpleadoEntidad> consultar(EmpleadoEntidad filtro);
    void modificar(EmpleadoEntidad entidad);
    void eliminar(UUID id);
}
