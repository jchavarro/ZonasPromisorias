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
import utp.edu.co.zonaspromisorias.service.interfaces.ControlClimaService;
import utp.edu.co.zonaspromisorias.web.dto.ControlClimaDto;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clima")
public class ControlClimaController {

    @Autowired
    private ControlClimaService controlClimaService;

    @GetMapping
    public ResponseEntity<List<ControlClimaDto>> obtenerControlClima(@RequestParam("idcatastral") final Integer idCatastral,
                                                               @RequestParam("numerolote") final Integer numeroLote) {
        return new ResponseEntity<>(controlClimaService.obtenerControlClimaPorId(idCatastral, numeroLote),
                HttpStatus.FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ControlClimaDto>> obtenerTodos() {
        return new ResponseEntity<>(controlClimaService.obtenerTodos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<ControlClimaDto>> crearControlClima(
            @RequestBody final List<ControlClimaDto> controlClimaDto) {
        return new ResponseEntity<>(controlClimaService.crearControlClima(controlClimaDto), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> eliminarControlClima(@RequestParam("idcatastral") final Integer idCatastral,
                                                        @RequestParam("numerolote") final Integer numeroLote,
                                                        @RequestParam("fecha") final String fecha) {
        return new ResponseEntity<>(controlClimaService.eliminarControlClima(idCatastral, numeroLote, fecha),
                HttpStatus.OK);
    }

}
