package utp.edu.co.zonaspromisorias.service.interfaces;

import utp.edu.co.zonaspromisorias.web.dto.CoordenadasDto;

import java.util.List;

public interface CoordenadasService {

    List<CoordenadasDto> obtenerCoordenadasPorIdCatastral(Integer idCatastral);
    List<CoordenadasDto> obtenerCoordenadasPorIdCatastral(Integer idCatastral, Integer numeroLote);

    List<CoordenadasDto> guardarCoordenadas(List<CoordenadasDto> coordenadasDto);

    Boolean eliminarCoordenadas(Integer idCatastral, Integer numeroLote);
}
