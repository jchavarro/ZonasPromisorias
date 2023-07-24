package utp.edu.co.zonaspromisorias.service.interfaces;

import utp.edu.co.zonaspromisorias.web.dto.LoteDto;

import java.util.List;

public interface LoteService {
    LoteDto obtenerLotePorId(Integer idCatastral, Integer numeroLote);

    List<LoteDto> obtenerLotesPorIdCatastral();

    LoteDto guardarLote(LoteDto loteDto);

    LoteDto actualizarLote(LoteDto loteDto);

    Boolean eliminarLote(Integer idCatastral, Integer numeroLote);
}
