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
import utp.edu.co.zonaspromisorias.service.interfaces.ControlFrutoService;
import utp.edu.co.zonaspromisorias.web.dto.ControlFrutoDto;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fruto")
public class ControlFrutoController {

    @Autowired
    private ControlFrutoService controlFrutoService;

    @GetMapping
    public ResponseEntity<List<ControlFrutoDto>> obtenerControlFruto(
            @RequestParam("idcatastral") final Integer idCatastral) {
        return new ResponseEntity<>(controlFrutoService.obtenerControlFrutoPorId(idCatastral), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ControlFrutoDto>> obtenerTodos() {
        return new ResponseEntity<>(controlFrutoService.obtenerTodos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<ControlFrutoDto>> crearControlFruto(
            @RequestBody final List<ControlFrutoDto> controlFrutoDto) {
        return new ResponseEntity<>(controlFrutoService.crearControlFruto(controlFrutoDto), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> eliminarControlFruto(@RequestParam("idcatastral") final Integer idCatastral,
                                                        @RequestParam("numerolote") final Integer numeroLote,
                                                        @RequestParam("fecha") final String fecha) {
        return new ResponseEntity<>(controlFrutoService.eliminarControlFruto(idCatastral, numeroLote, fecha),
                HttpStatus.OK);
    }
}
