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
import co.edu.uco.ucoparking.dto.AnimalDTO;
import co.edu.uco.ucoparking.negocio.fachada.AnimalFachada;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    private final AnimalFachada fachada;

    public AnimalController(final AnimalFachada fachada) {
        this.fachada = fachada;
    }

    @PostMapping
    public ResponseEntity<Void> crear(@RequestBody final AnimalDTO dto) {
        fachada.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<AnimalDTO>> consultar() {
        return ResponseEntity.ok(fachada.consultar(new AnimalDTO()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> modificar(@PathVariable final UUID id,
                                          @RequestBody final AnimalDTO dto) {
        fachada.modificar(new AnimalDTO(id, dto.getNombre(), dto.getEspecie(), dto.getRaza(), dto.getSexo(), dto.getFechaNacimiento(), dto.getPesoKg(), dto.getIdFinca()));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable final UUID id) {
        fachada.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
