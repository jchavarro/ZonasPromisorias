package utp.edu.co.zonaspromisorias.service.interfaces;

import org.springframework.web.multipart.MultipartFile;
import utp.edu.co.zonaspromisorias.web.dto.FincaDto;
import utp.edu.co.zonaspromisorias.web.dto.response.FincaResponseDto;

import java.io.IOException;
import java.util.List;

public interface FincaService {
    FincaResponseDto obtenerFincaPorId(Integer id);

    FincaResponseDto guardarFinca(FincaDto fincaDto, MultipartFile imagenFinca) throws IOException;

    FincaResponseDto actualizarFinca(FincaDto fincaDto, MultipartFile imagenFinca) throws IOException;

    Boolean eliminarFinca(Integer id);

    List<FincaResponseDto> obtenerFincas(Integer id);
}
