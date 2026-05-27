package co.edu.uco.ucoparking.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import co.edu.uco.ucoparking.dto.ApiErrorResponse;
import co.edu.uco.ucoparking.transversal.excepciones.NegocioException;
import co.edu.uco.ucoparking.transversal.excepciones.UcoException;
import jakarta.persistence.EntityNotFoundException;

/**
 * Manejador global de excepciones para todos los controllers REST.
 *
 * ANTES: cualquier excepción no capturada producía la página de error
 *        "Whitelabel Error Page" de Spring Boot (HTML o JSON opaco).
 *        El frontend recibía un 500 sin información útil.
 *
 * AHORA: todas las excepciones se transforman en un ApiErrorResponse JSON
 *        limpio con el código HTTP correcto y un mensaje claro.
 *
 * JERARQUÍA DE MANEJO (de más específico a más general):
 *
 *   NegocioException        → 422 Unprocessable Entity
 *     (reglas de negocio violadas: nombre vacío, FK null, etc.)
 *
 *   UcoException            → 422 Unprocessable Entity
 *     (base de NegocioException y DatosException)
 *
 *   EntityNotFoundException → 404 Not Found
 *     (entidad no existe en BD: buscar/eliminar/modificar por ID)
 *
 *   EmptyResultDataAccessException → 404 Not Found
 *     (Spring Data lanza esto en deleteById si el ID no existe)
 *
 *   DataIntegrityViolationException → 409 Conflict
 *     (violación FK en SQL Server: el ID referenciado no existe)
 *     (columna UNIQUE duplicada)
 *
 *   HttpMessageNotReadableException → 400 Bad Request
 *     (JSON malformado en el body del request)
 *
 *   MethodArgumentTypeMismatchException → 400 Bad Request
 *     (UUID inválido en PathVariable: ej: /api/fincas/no-es-uuid)
 *
 *   Exception (catch-all)   → 500 Internal Server Error
 *     (cualquier error no anticipado; loguear para debugging)
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    // ─────────────────────────────────────────────────────────────
    // NEGOCIO: validaciones de reglas de negocio (422)
    // ─────────────────────────────────────────────────────────────

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<ApiErrorResponse> handleNegocio(final NegocioException ex) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(new ApiErrorResponse(
                        422,
                        "Entidad no procesable",
                        ex.getMensajeUsuario(),
                        ex.getMensajeTecnico()));
    }

    @ExceptionHandler(UcoException.class)
    public ResponseEntity<ApiErrorResponse> handleUco(final UcoException ex) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(new ApiErrorResponse(
                        422,
                        "Entidad no procesable",
                        ex.getMensajeUsuario(),
                        ex.getMensajeTecnico()));
    }

    // ─────────────────────────────────────────────────────────────
    // NOT FOUND: entidad no existe (404)
    // ─────────────────────────────────────────────────────────────

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleEntityNotFound(final EntityNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ApiErrorResponse(
                        404,
                        "Recurso no encontrado",
                        "El recurso solicitado no existe",
                        ex.getMessage()));
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ApiErrorResponse> handleEmptyResult(final EmptyResultDataAccessException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ApiErrorResponse(
                        404,
                        "Recurso no encontrado",
                        "El registro que intenta eliminar no existe",
                        ex.getMessage()));
    }

    // ─────────────────────────────────────────────────────────────
    // CONFLICTO: FK inválida o dato duplicado (409)
    // ─────────────────────────────────────────────────────────────

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiErrorResponse> handleDataIntegrity(final DataIntegrityViolationException ex) {
        final String msg = ex.getMostSpecificCause().getMessage();

        // FK inválida: el ID referenciado no existe en la tabla padre
        if (msg != null && msg.toLowerCase().contains("foreign key")) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new ApiErrorResponse(
                            409,
                            "Conflicto de integridad",
                            "Uno de los IDs referenciados (FK) no existe en la base de datos",
                            msg));
        }

        // UNIQUE constraint: dato duplicado
        if (msg != null && (msg.toLowerCase().contains("unique") || msg.toLowerCase().contains("duplicate"))) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new ApiErrorResponse(
                            409,
                            "Dato duplicado",
                            "Ya existe un registro con ese valor. No se permiten duplicados",
                            msg));
        }

        // Otra violación de integridad
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ApiErrorResponse(
                        409,
                        "Conflicto de integridad",
                        "El dato no puede guardarse por restricciones de la base de datos",
                        msg));
    }

    // ─────────────────────────────────────────────────────────────
    // BAD REQUEST: JSON malformado o UUID inválido (400)
    // ─────────────────────────────────────────────────────────────

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiErrorResponse> handleBadJson(final HttpMessageNotReadableException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ApiErrorResponse(
                        400,
                        "Solicitud inválida",
                        "El cuerpo de la solicitud tiene formato JSON inválido",
                        ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiErrorResponse> handleTypeMismatch(final MethodArgumentTypeMismatchException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ApiErrorResponse(
                        400,
                        "Parámetro inválido",
                        "El parámetro '" + ex.getName() + "' tiene un formato inválido. Se esperaba: "
                                + (ex.getRequiredType() != null ? ex.getRequiredType().getSimpleName() : "desconocido"),
                        ex.getMessage()));
    }

    // ─────────────────────────────────────────────────────────────
    // CATCH-ALL: cualquier error no anticipado (500)
    // ─────────────────────────────────────────────────────────────

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGeneral(final Exception ex) {
        // Loguear el error completo para diagnóstico
        ex.printStackTrace();
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiErrorResponse(
                        500,
                        "Error interno del servidor",
                        "Ocurrió un error inesperado. Contacte al administrador",
                        ex.getClass().getSimpleName() + ": " + ex.getMessage()));
    }
}
