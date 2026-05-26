package co.edu.uco.ucoparking.datos;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.entidad.CuidadoEspecialEntidad;

public interface CuidadoEspecialDatos {
    void crear(CuidadoEspecialEntidad entidad);
    List<CuidadoEspecialEntidad> consultar(CuidadoEspecialEntidad filtro);
    void modificar(CuidadoEspecialEntidad entidad);
    void eliminar(UUID id);
}
