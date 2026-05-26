package co.edu.uco.ucoparking.negocio.casosuso;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dominio.TipoAlmacenDominio;

public interface TipoAlmacenCasoDeUso {
    void crear(TipoAlmacenDominio dominio);
    List<TipoAlmacenDominio> consultar(TipoAlmacenDominio filtro);
    void modificar(TipoAlmacenDominio dominio);
    void eliminar(UUID id);
}
