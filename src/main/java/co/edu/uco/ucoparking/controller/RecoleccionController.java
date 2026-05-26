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
import co.edu.uco.ucoparking.dto.RecoleccionDTO;
import co.edu.uco.ucoparking.negocio.fachada.RecoleccionFachada;

@RestController
@RequestMapping("/api/recoleccions")
public class RecoleccionController {

    private final RecoleccionFachada fachada;

    public RecoleccionController(final RecoleccionFachada fachada) {
        this.fachada = fachada;
    }

    @PostMapping
    public ResponseEntity<Void> crear(@RequestBody final RecoleccionDTO dto) {
        fachada.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<RecoleccionDTO>> consultar() {
        return ResponseEntity.ok(fachada.consultar(new RecoleccionDTO()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> modificar(@PathVariable final UUID id,
                                          @RequestBody final RecoleccionDTO dto) {
        fachada.modificar(new RecoleccionDTO(id, dto.getFechaHora(), dto.getCantidad(), dto.getUnidadMedida(), dto.getIdProducto(), dto.getIdAnimal(), dto.getIdEmpleado()));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable final UUID id) {
        fachada.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
