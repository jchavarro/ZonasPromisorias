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
import utp.edu.co.zonaspromisorias.service.interfaces.ProductorService;
import utp.edu.co.zonaspromisorias.web.dto.ProductorDto;

@RestController
@RequestMapping("/api/v1/productor")
public class ProductorController {

    @Autowired
    private ProductorService productorService;

    @GetMapping
    public ResponseEntity<ProductorDto> obtenerProductorPorId(@RequestParam("nitProductor") final Integer id) {
        return new ResponseEntity<>(productorService.obtenerProductorPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductorDto> guardarProductor(@RequestBody final ProductorDto productorDto) {
        return new ResponseEntity<>(productorService.guardarProductor(productorDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProductorDto> actualizarProductor(@RequestBody final ProductorDto productorDto) {
        return new ResponseEntity<>(productorService.actualizarProductor(productorDto), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> eliminarProductor(@RequestParam("nitProductor") final Integer id) {
        return new ResponseEntity<>(productorService.eliminarProductor(id), HttpStatus.OK);
    }
}
