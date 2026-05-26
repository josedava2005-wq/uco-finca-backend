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
import co.edu.uco.ucoparking.dto.TipoSuministroDTO;
import co.edu.uco.ucoparking.negocio.fachada.TipoSuministroFachada;

@RestController
@RequestMapping("/api/tiposuministros")
public class TipoSuministroController {

    private final TipoSuministroFachada fachada;

    public TipoSuministroController(final TipoSuministroFachada fachada) {
        this.fachada = fachada;
    }

    @PostMapping
    public ResponseEntity<Void> crear(@RequestBody final TipoSuministroDTO dto) {
        fachada.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<TipoSuministroDTO>> consultar() {
        return ResponseEntity.ok(fachada.consultar(new TipoSuministroDTO()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> modificar(@PathVariable final UUID id,
                                          @RequestBody final TipoSuministroDTO dto) {
        fachada.modificar(new TipoSuministroDTO(id, dto.getNombre(), dto.getDescripcion()));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable final UUID id) {
        fachada.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
