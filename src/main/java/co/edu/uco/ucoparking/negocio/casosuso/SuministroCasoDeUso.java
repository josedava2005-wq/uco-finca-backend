package co.edu.uco.ucoparking.negocio.casosuso;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dominio.SuministroDominio;

public interface SuministroCasoDeUso {
    void crear(SuministroDominio dominio);
    List<SuministroDominio> consultar(SuministroDominio filtro);
    void modificar(SuministroDominio dominio);
    void eliminar(UUID id);
}
