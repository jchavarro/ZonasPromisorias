package utp.edu.co.zonaspromisorias.service.interfaces;

import utp.edu.co.zonaspromisorias.web.dto.ControlClimaDto;

import java.util.List;

public interface ControlClimaService {
    List<ControlClimaDto> obtenerControlClimaPorId(Integer idCatastral);

    List<ControlClimaDto> crearControlClima(List<ControlClimaDto> controlClimaDto);

    Boolean eliminarControlClima(Integer idCatastral, Integer numeroLote, String fecha);

    List<ControlClimaDto> obtenerTodos();
}
