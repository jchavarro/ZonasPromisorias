package utp.edu.co.zonaspromisorias.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utp.edu.co.zonaspromisorias.service.interfaces.ControlSueloService;
import utp.edu.co.zonaspromisorias.web.dto.ControlSueloDto;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/suelo")
public class ControlSueloController {

    @Autowired
    private ControlSueloService controlSueloService;


    @GetMapping("/all")
    public ResponseEntity<List<ControlSueloDto>> obtenerTodos() {
        return new ResponseEntity<>(controlSueloService
                .obtenerTodos(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ControlSueloDto>> obtenerTodos(@RequestParam("idcatastral") final Integer idCatastral,
                                                              @RequestParam("numerolote") final Integer numeroLote) {
        return new ResponseEntity<>(controlSueloService
                .obtenerTodos(idCatastral, numeroLote), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<ControlSueloDto>> guardarControlSuelo(
            @RequestBody final List<ControlSueloDto> controlSueloDto) {
        return new ResponseEntity<>(controlSueloService.guardarControlSuelo(controlSueloDto), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> eliminarControlSuelo(@RequestParam("idcatastral") final Integer idCatastral,
                                                        @RequestParam("numerolote") final Integer numeroLote,
                                                        @RequestParam("fecha") final String fecha) {
        return new ResponseEntity<>(controlSueloService
                .eliminarControlSuelo(idCatastral, numeroLote, fecha), HttpStatus.OK);
    }


}
