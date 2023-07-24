package utp.edu.co.zonaspromisorias.service.interfaces;

import utp.edu.co.zonaspromisorias.web.dto.AsociacionDto;

public interface AsociacionService {
    AsociacionDto obtenerAsociacionPorId(Integer id);

    AsociacionDto guardarAsociacion(AsociacionDto asociacionDto);

    AsociacionDto actualizarAsociacion(AsociacionDto asociacionDto);

    Boolean eliminarAsociacion(Integer id);
}
