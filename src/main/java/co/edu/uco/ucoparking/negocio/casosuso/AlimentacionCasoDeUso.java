package co.edu.uco.ucoparking.negocio.casosuso;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dominio.AlimentacionDominio;

public interface AlimentacionCasoDeUso {
    void crear(AlimentacionDominio dominio);
    List<AlimentacionDominio> consultar(AlimentacionDominio filtro);
    void modificar(AlimentacionDominio dominio);
    void eliminar(UUID id);
}
