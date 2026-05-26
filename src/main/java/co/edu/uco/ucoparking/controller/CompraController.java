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
import co.edu.uco.ucoparking.dto.CompraDTO;
import co.edu.uco.ucoparking.negocio.fachada.CompraFachada;

@RestController
@RequestMapping("/api/compras")
public class CompraController {

    private final CompraFachada fachada;

    public CompraController(final CompraFachada fachada) {
        this.fachada = fachada;
    }

    @PostMapping
    public ResponseEntity<Void> crear(@RequestBody final CompraDTO dto) {
        fachada.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<CompraDTO>> consultar() {
        return ResponseEntity.ok(fachada.consultar(new CompraDTO()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> modificar(@PathVariable final UUID id,
                                          @RequestBody final CompraDTO dto) {
        fachada.modificar(new CompraDTO(id, dto.getFechaCompra(), dto.getTotal(), dto.getEstado(), dto.getIdCliente()));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable final UUID id) {
        fachada.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
