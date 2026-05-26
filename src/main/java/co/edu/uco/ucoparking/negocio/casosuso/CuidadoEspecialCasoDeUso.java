package co.edu.uco.ucoparking.negocio.casosuso;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dominio.CuidadoEspecialDominio;

public interface CuidadoEspecialCasoDeUso {
    void crear(CuidadoEspecialDominio dominio);
    List<CuidadoEspecialDominio> consultar(CuidadoEspecialDominio filtro);
    void modificar(CuidadoEspecialDominio dominio);
    void eliminar(UUID id);
}
