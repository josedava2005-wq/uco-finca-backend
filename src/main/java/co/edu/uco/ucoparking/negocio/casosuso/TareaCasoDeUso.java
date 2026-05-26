package co.edu.uco.ucoparking.negocio.casosuso;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dominio.TareaDominio;

public interface TareaCasoDeUso {
    void crear(TareaDominio dominio);
    List<TareaDominio> consultar(TareaDominio filtro);
    void modificar(TareaDominio dominio);
    void eliminar(UUID id);
}
