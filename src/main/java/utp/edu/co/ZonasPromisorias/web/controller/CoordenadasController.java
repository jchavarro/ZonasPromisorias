package utp.edu.co.zonaspromisorias.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utp.edu.co.zonaspromisorias.service.interfaces.CoordenadasService;
import utp.edu.co.zonaspromisorias.web.dto.CoordenadasDto;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coordenadas")
public class CoordenadasController {

    @Autowired
    private CoordenadasService coordenadasService;

    @GetMapping
    public ResponseEntity<List<CoordenadasDto>> obtenerCoordenadasPorLote(
            @RequestParam("idcatastral") final Integer idCatastral,
            @RequestParam("numerolote") final Integer numeroLote) {
        return new ResponseEntity<>(coordenadasService
                .obtenerCoordenadasPorIdCatastral(idCatastral, numeroLote), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<CoordenadasDto>> guardarCoordenadas(
            @RequestBody final List<CoordenadasDto> coordenadasDto) {
        return new ResponseEntity<>(coordenadasService.guardarCoordenadas(coordenadasDto), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> eliminarCoordenadas(@RequestParam("idcatastral") final Integer idCatastral,
                                                       @RequestParam("numerolote") final Integer numeroLote) {
        return new ResponseEntity<>(coordenadasService.eliminarCoordenadas(idCatastral, numeroLote), HttpStatus.OK);
    }

}
