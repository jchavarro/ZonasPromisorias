package utp.edu.co.zonaspromisorias.service.interfaces;

import utp.edu.co.zonaspromisorias.web.dto.ControlSueloDto;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface ControlSueloService {
    List<ControlSueloDto> obtenerTodos(Integer idCatastral);

    List<ControlSueloDto> obtenerTodos();

    List<ControlSueloDto> guardarControlSuelo(List<ControlSueloDto> controlSueloDto);

    Boolean eliminarControlSuelo(Integer idCatastral, Integer numeroLote, String fecha);
}
