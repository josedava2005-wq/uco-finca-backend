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
import co.edu.uco.ucoparking.dto.AlmacenDTO;
import co.edu.uco.ucoparking.negocio.fachada.AlmacenFachada;

@RestController
@RequestMapping("/api/almacens")
public class AlmacenController {

    private final AlmacenFachada fachada;

    public AlmacenController(final AlmacenFachada fachada) {
        this.fachada = fachada;
    }

    @PostMapping
    public ResponseEntity<Void> crear(@RequestBody final AlmacenDTO dto) {
        fachada.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<AlmacenDTO>> consultar() {
        return ResponseEntity.ok(fachada.consultar(new AlmacenDTO()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> modificar(@PathVariable final UUID id,
                                          @RequestBody final AlmacenDTO dto) {
        fachada.modificar(new AlmacenDTO(id, dto.getNombre(), dto.getCapacidadM2(), dto.getIdTipoAlmacen(), dto.getIdFinca()));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable final UUID id) {
        fachada.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
