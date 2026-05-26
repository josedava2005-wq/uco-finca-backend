package co.edu.uco.ucoparking.negocio.casosuso;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dominio.CompraDominio;

public interface CompraCasoDeUso {
    void crear(CompraDominio dominio);
    List<CompraDominio> consultar(CompraDominio filtro);
    void modificar(CompraDominio dominio);
    void eliminar(UUID id);
}
