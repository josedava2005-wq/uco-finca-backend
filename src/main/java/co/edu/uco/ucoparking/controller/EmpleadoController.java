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
import co.edu.uco.ucoparking.dto.EmpleadoDTO;
import co.edu.uco.ucoparking.negocio.fachada.EmpleadoFachada;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    private final EmpleadoFachada fachada;

    public EmpleadoController(final EmpleadoFachada fachada) {
        this.fachada = fachada;
    }

    @PostMapping
    public ResponseEntity<Void> crear(@RequestBody final EmpleadoDTO dto) {
        fachada.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> consultar() {
        return ResponseEntity.ok(fachada.consultar(new EmpleadoDTO()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> modificar(@PathVariable final UUID id,
                                          @RequestBody final EmpleadoDTO dto) {
        fachada.modificar(new EmpleadoDTO(id, dto.getNombre(), dto.getTipoDocumento(), dto.getNumeroDocumento(), dto.getCargo(), dto.getTelefono(), dto.getFechaVinculacion(), dto.getIdFinca()));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable final UUID id) {
        fachada.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
