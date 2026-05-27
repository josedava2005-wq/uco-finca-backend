package co.edu.uco.ucoparking.entidad;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad JPA que representa la tabla "proveedor" en SQL Server.
 *
 * Sin relaciones FK externas — entidad independiente.
 *
 * COLUMNAS SQL SERVER:
 *   id               → uniqueidentifier (PK)
 *   tipo_documento   → varchar
 *   numero_documento → varchar
 *   nombre           → varchar
 *   correo           → varchar
 *   telefono         → varchar
 *   direccion        → varchar
 */
@Entity
@Table(name = "proveedor")
public class ProveedorEntidad {

    @Id
    @Column(name = "id", columnDefinition = "uniqueidentifier", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "tipo_documento", nullable = false, length = 50)
    private String tipoDocumento;

    @Column(name = "numero_documento", nullable = false, length = 20)
    private String numeroDocumento;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    @Column(name = "correo", nullable = true, length = 200)
    private String correo;

    @Column(name = "telefono", nullable = true, length = 20)
    private String telefono;

    @Column(name = "direccion", nullable = true, length = 300)
    private String direccion;

    public ProveedorEntidad() {}

    public ProveedorEntidad(final UUID id, final String tipoDocumento, final String numeroDocumento,
                            final String nombre, final String correo, final String telefono,
                            final String direccion) {
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public UUID getId() { return id; }
    public void setId(final UUID id) { this.id = id; }
    public String getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(final String tipoDocumento) { this.tipoDocumento = tipoDocumento; }
    public String getNumeroDocumento() { return numeroDocumento; }
    public void setNumeroDocumento(final String numeroDocumento) { this.numeroDocumento = numeroDocumento; }
    public String getNombre() { return nombre; }
    public void setNombre(final String nombre) { this.nombre = nombre; }
    public String getCorreo() { return correo; }
    public void setCorreo(final String correo) { this.correo = correo; }
    public String getTelefono() { return telefono; }
    public void setTelefono(final String telefono) { this.telefono = telefono; }
    public String getDireccion() { return direccion; }
    public void setDireccion(final String direccion) { this.direccion = direccion; }
}
