package co.edu.uco.ucoparking.dominio;

import java.util.UUID;
import co.edu.uco.ucoparking.dominio.AnimalDominio;
import co.edu.uco.ucoparking.dominio.EmpleadoDominio;
import co.edu.uco.ucoparking.dominio.ProductoDominio;
import co.edu.uco.ucoparking.transversal.UtilTexto;

public final class RecoleccionDominio {

    private UUID id;
    private String fechaHora;
    private Double cantidad;
    private String unidadMedida;
    private ProductoDominio producto;
    private AnimalDominio animal;
    private EmpleadoDominio empleado;

    private RecoleccionDominio(final Builder builder) {
        setId(builder.id);
        setFechaHora(builder.fechaHora);
        setCantidad(builder.cantidad);
        setUnidadMedida(builder.unidadMedida);
        setProducto(builder.producto);
        setAnimal(builder.animal);
        setEmpleado(builder.empleado);
    }

    public static Builder builder() { return new Builder(); }

    public UUID getId() { return id; }
    private void setId(final UUID id) { this.id = id; }
    public String getFechaHora() { return fechaHora; }
    private void setFechaHora(final String fechaHora) { this.fechaHora = UtilTexto.aplicarTrim(fechaHora); }
    public Double getCantidad() { return cantidad; }
    private void setCantidad(final Double cantidad) { this.cantidad = cantidad; }
    public String getUnidadMedida() { return unidadMedida; }
    private void setUnidadMedida(final String unidadMedida) { this.unidadMedida = UtilTexto.aplicarTrim(unidadMedida); }
    public ProductoDominio getProducto() { return producto; }
    private void setProducto(final ProductoDominio producto) { this.producto = producto; }
    public AnimalDominio getAnimal() { return animal; }
    private void setAnimal(final AnimalDominio animal) { this.animal = animal; }
    public EmpleadoDominio getEmpleado() { return empleado; }
    private void setEmpleado(final EmpleadoDominio empleado) { this.empleado = empleado; }

    public static final class Builder {
        private UUID id;
        private String fechaHora;
        private Double cantidad;
        private String unidadMedida;
        private ProductoDominio producto;
        private AnimalDominio animal;
        private EmpleadoDominio empleado;

        public Builder id(final UUID id) { this.id = id; return this; }
        public Builder fechaHora(final String fechaHora) { this.fechaHora = fechaHora; return this; }
        public Builder cantidad(final Double cantidad) { this.cantidad = cantidad; return this; }
        public Builder unidadMedida(final String unidadMedida) { this.unidadMedida = unidadMedida; return this; }
        public Builder producto(final ProductoDominio producto) { this.producto = producto; return this; }
        public Builder animal(final AnimalDominio animal) { this.animal = animal; return this; }
        public Builder empleado(final EmpleadoDominio empleado) { this.empleado = empleado; return this; }

        public RecoleccionDominio build() { return new RecoleccionDominio(this); }
    }
}
