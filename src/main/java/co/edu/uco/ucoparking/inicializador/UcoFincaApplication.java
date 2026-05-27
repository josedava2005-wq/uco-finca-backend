package co.edu.uco.ucoparking.inicializador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Clase principal de arranque de Spring Boot.
 *
 * ¿POR QUÉ ESTAS TRES ANOTACIONES?
 * ──────────────────────────────────
 * Spring Boot tiene TRES mecanismos de escaneo independientes:
 *
 * 1. @SpringBootApplication(scanBasePackages)
 *    → Escanea @Component, @Service, @Repository, @Controller, etc.
 *    → Cubre: controllers, facades, casos de uso, datos, etc.
 *
 * 2. @EnableJpaRepositories(basePackages)
 *    → Escanea interfaces que extienden JpaRepository / CrudRepository.
 *    → SIN esta anotación → Spring Data JPA solo escanea el paquete
 *      de esta clase (inicializador) → "Found 0 JPA repository interfaces"
 *    → Cubre: PaisJpaRepository, DepartamentoJpaRepository, etc.
 *
 * 3. @EntityScan(basePackages)
 *    → Escanea clases anotadas con @Entity (entidades Hibernate/JPA).
 *    → SIN esta anotación → Hibernate solo carga entidades del paquete
 *      de esta clase → "Not a managed type: DepartamentoEntidad"
 *    → Cubre: PaisEntidad, DepartamentoEntidad, etc.
 *
 * LOS TRES apuntan a "co.edu.uco.ucoparking" para cubrir todo el proyecto.
 */
@SpringBootApplication(scanBasePackages = "co.edu.uco.ucoparking")
@EnableJpaRepositories(basePackages  = "co.edu.uco.ucoparking")
@EntityScan(basePackages             = "co.edu.uco.ucoparking")
public class UcoFincaApplication {

    public static void main(final String[] args) {
        SpringApplication.run(UcoFincaApplication.class, args);
    }
}
