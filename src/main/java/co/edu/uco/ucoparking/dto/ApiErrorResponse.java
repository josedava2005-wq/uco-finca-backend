package co.edu.uco.ucoparking.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * DTO estándar para respuestas de error HTTP.
 *
 * Reemplaza el "Whitelabel Error Page" de Spring Boot con una respuesta
 * JSON limpia, predecible y útil tanto para el frontend como para depuración.
 *
 * Estructura JSON resultante:
 * {
 *   "timestamp":    "2025-05-27T10:30:00",
 *   "status":       422,
 *   "error":        "Unprocessable Entity",
 *   "mensaje":      "El nombre de la finca es obligatorio",
 *   "detalle":      "El campo nombre de FincaDominio es nulo o vacío en crear()"
 * }
 *
 * CAMPOS:
 *   timestamp  → cuándo ocurrió el error (ISO-8601)
 *   status     → código HTTP numérico
 *   error      → nombre legible del código HTTP
 *   mensaje    → mensaje para el USUARIO (limpio, sin stack trace)
 *   detalle    → mensaje TÉCNICO (para logs / debug; puede ocultarse en prod)
 */
public final class ApiErrorResponse {

    private final String timestamp;
    private final int status;
    private final String error;
    private final String mensaje;
    private final String detalle;

    public ApiErrorResponse(final int status, final String error,
                            final String mensaje, final String detalle) {
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        this.status = status;
        this.error = error;
        this.mensaje = mensaje;
        this.detalle = detalle;
    }

    public String getTimestamp() { return timestamp; }
    public int getStatus()       { return status; }
    public String getError()     { return error; }
    public String getMensaje()   { return mensaje; }
    public String getDetalle()   { return detalle; }
}
