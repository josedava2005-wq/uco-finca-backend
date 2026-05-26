package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.AlimentacionDatos;
import co.edu.uco.ucoparking.dominio.AlimentacionDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.AlimentacionEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.AlimentacionCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilUUID;

public final class AlimentacionCasoDeUsoImpl implements AlimentacionCasoDeUso {

    private final AlimentacionDatos datos;

    public AlimentacionCasoDeUsoImpl(final AlimentacionDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final AlimentacionDominio dominio) {
        final AlimentacionDominio dominioConId = AlimentacionDominio.builder()
                .id(UtilUUID.generarNuevo())
                .fechaHora(dominio.getFechaHora())
                .cantidad(dominio.getCantidad())
                .unidadMedida(dominio.getUnidadMedida())
                .tipoAlimento(dominio.getTipoAlimento())
                .animal(dominio.getAnimal())
                .empleado(dominio.getEmpleado())
                .build();
        datos.crear(AlimentacionEntidadAssembler.toEntidad(dominioConId));
    }

    @Override
    public List<AlimentacionDominio> consultar(final AlimentacionDominio filtro) {
        return datos.consultar(AlimentacionEntidadAssembler.toEntidad(filtro))
                .stream()
                .map(AlimentacionEntidadAssembler::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final AlimentacionDominio dominio) {
        datos.modificar(AlimentacionEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        datos.eliminar(id);
    }
}
