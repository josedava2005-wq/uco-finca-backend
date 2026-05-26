package co.edu.uco.ucoparking.negocio.casosuso;

import java.util.List;
import java.util.UUID;
import co.edu.uco.ucoparking.dominio.DetalleCompraDominio;

public interface DetalleCompraCasoDeUso {
    void crear(DetalleCompraDominio dominio);
    List<DetalleCompraDominio> consultar(DetalleCompraDominio filtro);
    void modificar(DetalleCompraDominio dominio);
    void eliminar(UUID id);
}
