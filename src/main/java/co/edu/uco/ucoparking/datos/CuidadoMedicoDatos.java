package co.edu.uco.ucoparking.datos;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.entidad.CuidadoMedicoEntidad;

public interface CuidadoMedicoDatos {
    void crear(CuidadoMedicoEntidad entidad);
    List<CuidadoMedicoEntidad> consultar(CuidadoMedicoEntidad filtro);
    void modificar(CuidadoMedicoEntidad entidad);
    void eliminar(UUID id);
}
