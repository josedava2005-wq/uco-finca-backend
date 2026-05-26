package co.edu.uco.ucoparking.negocio.casosuso;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dominio.TipoSuministroDominio;

public interface TipoSuministroCasoDeUso {
    void crear(TipoSuministroDominio dominio);
    List<TipoSuministroDominio> consultar(TipoSuministroDominio filtro);
    void modificar(TipoSuministroDominio dominio);
    void eliminar(UUID id);
}
