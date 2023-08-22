package utp.edu.co.zonaspromisorias.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utp.edu.co.zonaspromisorias.service.interfaces.LoteService;
import utp.edu.co.zonaspromisorias.web.dto.LoteDto;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lote")
public class LoteController {

    @Autowired
    private LoteService loteService;

    @GetMapping
    public ResponseEntity<LoteDto> obtenerLotePorId(@RequestParam("idcatastral") final Integer idCatastral,
                                                    @RequestParam("numerolote") final Integer numeroLote) {
        return new ResponseEntity<>(loteService.obtenerLotePorId(idCatastral, numeroLote), HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<List<LoteDto>> obtenerLotesPorIdCatastral(@RequestParam("idcatastral")
                                                                        final Integer idCatastral) {
        return new ResponseEntity<>(loteService.obtenerLotesPorIdCatastral(idCatastral), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LoteDto> guardarLote(@RequestBody final LoteDto loteDto) {
        return new ResponseEntity<>(loteService.guardarLote(loteDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<LoteDto> actualizarLote(@RequestBody final LoteDto loteDto) {
        return new ResponseEntity<>(loteService.actualizarLote(loteDto), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> eliminarLote(@RequestParam("idcatastral") final Integer idCatastral,
                                                @RequestParam("numerolote") final Integer numeroLote) {
        return new ResponseEntity<>(loteService.eliminarLote(idCatastral, numeroLote), HttpStatus.OK);
    }
}
