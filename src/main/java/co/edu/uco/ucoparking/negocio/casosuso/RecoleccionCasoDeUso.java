package co.edu.uco.ucoparking.negocio.casosuso;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dominio.RecoleccionDominio;

public interface RecoleccionCasoDeUso {
    void crear(RecoleccionDominio dominio);
    List<RecoleccionDominio> consultar(RecoleccionDominio filtro);
    void modificar(RecoleccionDominio dominio);
    void eliminar(UUID id);
}
