package co.edu.uco.ucoparking.negocio.casosuso;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dominio.CuidadoMedicoDominio;

public interface CuidadoMedicoCasoDeUso {
    void crear(CuidadoMedicoDominio dominio);
    List<CuidadoMedicoDominio> consultar(CuidadoMedicoDominio filtro);
    void modificar(CuidadoMedicoDominio dominio);
    void eliminar(UUID id);
}
