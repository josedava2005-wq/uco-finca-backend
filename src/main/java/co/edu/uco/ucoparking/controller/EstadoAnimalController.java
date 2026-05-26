package co.edu.uco.ucoparking.controller;

import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.uco.ucoparking.dto.EstadoAnimalDTO;
import co.edu.uco.ucoparking.negocio.fachada.EstadoAnimalFachada;

@RestController
@RequestMapping("/api/estadoanimals")
public class EstadoAnimalController {

    private final EstadoAnimalFachada fachada;

    public EstadoAnimalController(final EstadoAnimalFachada fachada) {
        this.fachada = fachada;
    }

    @PostMapping
    public ResponseEntity<Void> crear(@RequestBody final EstadoAnimalDTO dto) {
        fachada.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<EstadoAnimalDTO>> consultar() {
        return ResponseEntity.ok(fachada.consultar(new EstadoAnimalDTO()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> modificar(@PathVariable final UUID id,
                                          @RequestBody final EstadoAnimalDTO dto) {
        fachada.modificar(new EstadoAnimalDTO(id, dto.getEstado(), dto.getFechaRegistro(), dto.getObservacion(), dto.getIdAnimal()));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable final UUID id) {
        fachada.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
