package co.edu.uco.ucoparking.datos.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import co.edu.uco.ucoparking.datos.DepartamentoDatos;
import co.edu.uco.ucoparking.datos.jpa.DepartamentoJpaRepository;
import co.edu.uco.ucoparking.entidad.DepartamentoEntidad;

/**
 * Implementación de DepartamentoDatos usando JPA / SQL Server.
 *
 * ANTES: usaba una List<DepartamentoEntidad> estática en memoria (datos volátiles).
 * AHORA: delega en DepartamentoJpaRepository que persiste en la tabla
 *        "departamento" de SQL Server.
 *
 * FLUJO:
 *   DepartamentoCasoDeUsoImpl → llama DepartamentoDatos (esta clase)
 *       → delega en DepartamentoJpaRepository
 *       → Hibernate genera SQL
 *       → SQL Server persiste el dato
 *
 * El resto de la arquitectura (CasoDeUso, Fachada, Controller) NO sabe que
 * internamente usamos JPA. Solo conoce la interfaz DepartamentoDatos.
 */
@Repository
public class DepartamentoDatosImpl implements DepartamentoDatos {

    // Spring inyecta automáticamente el JpaRepository generado por Spring Data
    private final DepartamentoJpaRepository jpaRepository;

    public DepartamentoDatosImpl(final DepartamentoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void crear(final DepartamentoEntidad entidad) {
        // save() detecta que el ID no existe en BD → ejecuta INSERT
        jpaRepository.save(entidad);
    }

    @Override
    public List<DepartamentoEntidad> consultar(final DepartamentoEntidad filtro) {
        // Por ahora: retorna todos los departamentos.
        // En el futuro se puede filtrar por nombre, pais, etc.
        return jpaRepository.findAll();
    }

    @Override
    public void modificar(final DepartamentoEntidad entidad) {
        // save() detecta que el ID ya existe en BD → ejecuta UPDATE
        jpaRepository.save(entidad);
    }

    @Override
    public void eliminar(final UUID id) {
        // deleteById genera: DELETE FROM departamento WHERE id = ?
        jpaRepository.deleteById(id);
    }
}
