package utp.edu.co.zonaspromisorias.service.interfaces;

import utp.edu.co.zonaspromisorias.web.dto.ControlFrutoDto;

import java.util.List;

public interface ControlFrutoService {
    List<ControlFrutoDto> obtenerControlFrutoPorId(Integer idCatastral);

    List<ControlFrutoDto> crearControlFruto(List<ControlFrutoDto> controlFrutoDto);

    Boolean eliminarControlFruto(Integer idCatastral, Integer numeroLote, String fecha);

    List<ControlFrutoDto> obtenerTodos();
}
