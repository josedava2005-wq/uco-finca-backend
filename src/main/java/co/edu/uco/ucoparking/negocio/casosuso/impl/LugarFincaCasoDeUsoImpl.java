package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.LugarFincaDatos;
import co.edu.uco.ucoparking.dominio.LugarFincaDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.LugarFincaEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.LugarFincaCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilTexto;
import co.edu.uco.ucoparking.transversal.UtilUUID;
import co.edu.uco.ucoparking.transversal.excepciones.NegocioException;

public final class LugarFincaCasoDeUsoImpl implements LugarFincaCasoDeUso {

    private final LugarFincaDatos datos;

    public LugarFincaCasoDeUsoImpl(final LugarFincaDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final LugarFincaDominio dominio) {
        if (UtilTexto.esNuloOVacio(dominio.getVereda())) {
            throw new NegocioException(
                    "Vereda de lugar finca nula o vacía en LugarFincaCasoDeUsoImpl.crear()",
                    "La vereda del lugar de la finca es obligatoria");
        }
        if (dominio.getCiudad() == null || dominio.getCiudad().getId() == null) {
            throw new NegocioException(
                    "Ciudad o su ID es nulo en LugarFincaCasoDeUsoImpl.crear()",
                    "Debe indicar la ciudad del lugar de la finca (idCiudad)");
        }
        final LugarFincaDominio dominioConId = LugarFincaDominio.builder()
                .id(UtilUUID.generarNuevo())
                .vereda(dominio.getVereda())
                .sector(dominio.getSector())
                .ciudad(dominio.getCiudad())
                .build();
        datos.crear(LugarFincaEntidadAssembler.toEntidad(dominioConId));
    }

    @Override
    public List<LugarFincaDominio> consultar(final LugarFincaDominio filtro) {
        return datos.consultar(LugarFincaEntidadAssembler.toEntidad(filtro))
                .stream().map(LugarFincaEntidadAssembler::toDominio).collect(Collectors.toList());
    }

    @Override
    public void modificar(final LugarFincaDominio dominio) {
        if (dominio.getId() == null) {
            throw new NegocioException(
                    "ID de lugar finca nulo en LugarFincaCasoDeUsoImpl.modificar()",
                    "El ID del lugar de la finca es obligatorio para modificar");
        }
        if (UtilTexto.esNuloOVacio(dominio.getVereda())) {
            throw new NegocioException(
                    "Vereda de lugar finca nula o vacía en LugarFincaCasoDeUsoImpl.modificar()",
                    "La vereda del lugar de la finca es obligatoria");
        }
        if (dominio.getCiudad() == null || dominio.getCiudad().getId() == null) {
            throw new NegocioException(
                    "Ciudad o su ID es nulo en LugarFincaCasoDeUsoImpl.modificar()",
                    "Debe indicar la ciudad del lugar de la finca (idCiudad)");
        }
        datos.modificar(LugarFincaEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        if (id == null) {
            throw new NegocioException(
                    "ID de lugar finca nulo en LugarFincaCasoDeUsoImpl.eliminar()",
                    "El ID del lugar de la finca es obligatorio para eliminar");
        }
        datos.eliminar(id);
    }
}
