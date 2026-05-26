package co.edu.uco.ucoparking.negocio.casosuso;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dominio.AlmacenDominio;

public interface AlmacenCasoDeUso {
    void crear(AlmacenDominio dominio);
    List<AlmacenDominio> consultar(AlmacenDominio filtro);
    void modificar(AlmacenDominio dominio);
    void eliminar(UUID id);
}
