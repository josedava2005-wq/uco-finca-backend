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
import co.edu.uco.ucoparking.dto.DetalleCompraDTO;
import co.edu.uco.ucoparking.negocio.fachada.DetalleCompraFachada;

@RestController
@RequestMapping("/api/detallecompras")
public class DetalleCompraController {

    private final DetalleCompraFachada fachada;

    public DetalleCompraController(final DetalleCompraFachada fachada) {
        this.fachada = fachada;
    }

    @PostMapping
    public ResponseEntity<Void> crear(@RequestBody final DetalleCompraDTO dto) {
        fachada.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<DetalleCompraDTO>> consultar() {
        return ResponseEntity.ok(fachada.consultar(new DetalleCompraDTO()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> modificar(@PathVariable final UUID id,
                                          @RequestBody final DetalleCompraDTO dto) {
        fachada.modificar(new DetalleCompraDTO(id, dto.getCostoUnitario(), dto.getSubtotal(), dto.getDescuento(), dto.getIdItemCompra()));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable final UUID id) {
        fachada.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
