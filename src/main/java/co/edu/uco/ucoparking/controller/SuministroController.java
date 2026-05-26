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
import co.edu.uco.ucoparking.dto.SuministroDTO;
import co.edu.uco.ucoparking.negocio.fachada.SuministroFachada;

@RestController
@RequestMapping("/api/suministros")
public class SuministroController {

    private final SuministroFachada fachada;

    public SuministroController(final SuministroFachada fachada) {
        this.fachada = fachada;
    }

    @PostMapping
    public ResponseEntity<Void> crear(@RequestBody final SuministroDTO dto) {
        fachada.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<SuministroDTO>> consultar() {
        return ResponseEntity.ok(fachada.consultar(new SuministroDTO()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> modificar(@PathVariable final UUID id,
                                          @RequestBody final SuministroDTO dto) {
        fachada.modificar(new SuministroDTO(id, dto.getNombre(), dto.getCantidad(), dto.getUnidadMedida(), dto.getIdTipoSuministro(), dto.getIdAlmacen(), dto.getIdProveedor()));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable final UUID id) {
        fachada.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
