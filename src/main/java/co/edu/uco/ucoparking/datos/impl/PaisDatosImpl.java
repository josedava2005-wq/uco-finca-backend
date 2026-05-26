package co.edu.uco.ucoparking.datos.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import co.edu.uco.ucoparking.datos.PaisDatos;
import co.edu.uco.ucoparking.datos.jpa.PaisJpaRepository;
import co.edu.uco.ucoparking.entidad.PaisEntidad;

/**
 * Implementación de PaisDatos usando JPA / SQL Server.
 *
 * ANTES: usaba una List<PaisEntidad> estática en memoria (datos volátiles).
 * AHORA: delega en PaisJpaRepository que persiste en la tabla "pais" de SQL Server.
 *
 * FLUJO:
 *   PaisCasoDeUsoImpl → llama PaisDatos (esta clase) → delega en PaisJpaRepository
 *                                                        → Hibernate genera SQL
 *                                                        → SQL Server persiste el dato
 *
 * El resto de la arquitectura (CasoDeUso, Fachada, Controller) NO sabe que
 * internamente usamos JPA. Solo conoce la interfaz PaisDatos.
 */
@Repository
public class PaisDatosImpl implements PaisDatos {

    // Spring inyecta automáticamente el JpaRepository generado por Spring Data
    private final PaisJpaRepository jpaRepository;

    public PaisDatosImpl(final PaisJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void crear(final PaisEntidad entidad) {
        // save() detecta que el ID no existe en BD → ejecuta INSERT
        jpaRepository.save(entidad);
    }

    @Override
    public List<PaisEntidad> consultar(final PaisEntidad filtro) {
        // Por ahora: retorna todos los países.
        // En el futuro se puede filtrar por nombre, codigo, etc.
        return jpaRepository.findAll();
    }

    @Override
    public void modificar(final PaisEntidad entidad) {
        // save() detecta que el ID ya existe en BD → ejecuta UPDATE
        jpaRepository.save(entidad);
    }

    @Override
    public void eliminar(final UUID id) {
        // deleteById genera: DELETE FROM pais WHERE id = ?
        jpaRepository.deleteById(id);
    }
}
