package utp.edu.co.zonaspromisorias.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utp.edu.co.zonaspromisorias.service.interfaces.AsociacionService;
import utp.edu.co.zonaspromisorias.web.dto.AsociacionDto;

@RestController
@RequestMapping("/api/v1/asociacion")
public class AsociacionController {

    @Autowired
    private AsociacionService asociacionService;

    @GetMapping
    public ResponseEntity<AsociacionDto> obtenerAsociacionPorId(@RequestParam("nitAsociacion") final Integer id) {
        return new ResponseEntity<>(asociacionService.obtenerAsociacionPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AsociacionDto> guardarAsociacion(@RequestBody final AsociacionDto asociacionDto) {
        return new ResponseEntity<>(asociacionService.guardarAsociacion(asociacionDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AsociacionDto> actualizarAsociacion(@RequestBody final AsociacionDto asociacionDto) {
        return new ResponseEntity<>(asociacionService.actualizarAsociacion(asociacionDto), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> eliminarAsociacion(@RequestParam("nitAsociacion") final Integer id) {
        return new ResponseEntity<>(asociacionService.eliminarAsociacion(id), HttpStatus.OK);
    }
}
