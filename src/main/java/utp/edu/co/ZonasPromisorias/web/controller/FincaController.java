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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import utp.edu.co.zonaspromisorias.service.interfaces.FincaService;
import utp.edu.co.zonaspromisorias.web.dto.FincaDto;
import utp.edu.co.zonaspromisorias.web.dto.response.FincaResponseDto;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/finca")
public class FincaController {

    @Autowired
    private FincaService fincaService;

    @GetMapping
    public ResponseEntity<FincaResponseDto> obtenerFincaPorId(@RequestParam("idcatastral") final Integer id) {
        return new ResponseEntity<>(fincaService.obtenerFincaPorId(id), HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<List<FincaResponseDto>> obtenerFincasPorProductor(
            @RequestParam("idproductor") final Integer id) {
        return new ResponseEntity<>(fincaService.obtenerFincas(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FincaResponseDto> guardarFinca(@RequestPart("finca") final FincaDto fincaDto,
                                                         @RequestPart("imagenFinca") final MultipartFile imagenFinca)
            throws IOException {
        return new ResponseEntity<>(fincaService.guardarFinca(fincaDto, imagenFinca), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<FincaResponseDto> actualizarFinca(@RequestPart("finca") final FincaDto fincaDto,
                                                            @RequestPart("imagenFinca") final MultipartFile imagenFinca)
            throws IOException {
        return new ResponseEntity<>(fincaService.actualizarFinca(fincaDto, imagenFinca), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> eliminarFinca(@RequestParam("idcatastral") final Integer id) {
        return new ResponseEntity<>(fincaService.eliminarFinca(id), HttpStatus.OK);
    }
}
