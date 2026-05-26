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
import co.edu.uco.ucoparking.dto.CuidadoMedicoDTO;
import co.edu.uco.ucoparking.negocio.fachada.CuidadoMedicoFachada;

@RestController
@RequestMapping("/api/cuidadomedicos")
public class CuidadoMedicoController {

    private final CuidadoMedicoFachada fachada;

    public CuidadoMedicoController(final CuidadoMedicoFachada fachada) {
        this.fachada = fachada;
    }

    @PostMapping
    public ResponseEntity<Void> crear(@RequestBody final CuidadoMedicoDTO dto) {
        fachada.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<CuidadoMedicoDTO>> consultar() {
        return ResponseEntity.ok(fachada.consultar(new CuidadoMedicoDTO()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> modificar(@PathVariable final UUID id,
                                          @RequestBody final CuidadoMedicoDTO dto) {
        fachada.modificar(new CuidadoMedicoDTO(id, dto.getTipo(), dto.getFechaHora(), dto.getDescripcion(), dto.getMedicamento(), dto.getIdAnimal(), dto.getIdEmpleado()));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable final UUID id) {
        fachada.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
