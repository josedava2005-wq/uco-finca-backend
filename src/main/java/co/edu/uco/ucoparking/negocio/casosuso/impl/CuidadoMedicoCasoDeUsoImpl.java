package co.edu.uco.ucoparking.negocio.casosuso.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import co.edu.uco.ucoparking.datos.CuidadoMedicoDatos;
import co.edu.uco.ucoparking.dominio.CuidadoMedicoDominio;
import co.edu.uco.ucoparking.negocio.assembler.entidad.CuidadoMedicoEntidadAssembler;
import co.edu.uco.ucoparking.negocio.casosuso.CuidadoMedicoCasoDeUso;
import co.edu.uco.ucoparking.transversal.UtilUUID;

public final class CuidadoMedicoCasoDeUsoImpl implements CuidadoMedicoCasoDeUso {

    private final CuidadoMedicoDatos datos;

    public CuidadoMedicoCasoDeUsoImpl(final CuidadoMedicoDatos datos) {
        this.datos = datos;
    }

    @Override
    public void crear(final CuidadoMedicoDominio dominio) {
        final CuidadoMedicoDominio dominioConId = CuidadoMedicoDominio.builder()
                .id(UtilUUID.generarNuevo())
                .tipo(dominio.getTipo())
                .fechaHora(dominio.getFechaHora())
                .descripcion(dominio.getDescripcion())
                .medicamento(dominio.getMedicamento())
                .animal(dominio.getAnimal())
                .empleado(dominio.getEmpleado())
                .build();
        datos.crear(CuidadoMedicoEntidadAssembler.toEntidad(dominioConId));
    }

    @Override
    public List<CuidadoMedicoDominio> consultar(final CuidadoMedicoDominio filtro) {
        return datos.consultar(CuidadoMedicoEntidadAssembler.toEntidad(filtro))
                .stream()
                .map(CuidadoMedicoEntidadAssembler::toDominio)
                .collect(Collectors.toList());
    }

    @Override
    public void modificar(final CuidadoMedicoDominio dominio) {
        datos.modificar(CuidadoMedicoEntidadAssembler.toEntidad(dominio));
    }

    @Override
    public void eliminar(final UUID id) {
        datos.eliminar(id);
    }
}
