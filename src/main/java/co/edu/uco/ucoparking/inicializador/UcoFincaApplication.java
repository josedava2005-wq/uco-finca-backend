package co.edu.uco.ucoparking.inicializador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "co.edu.uco.ucoparking")
public class UcoFincaApplication {
    public static void main(final String[] args) {
        SpringApplication.run(UcoFincaApplication.class, args);
    }
}
