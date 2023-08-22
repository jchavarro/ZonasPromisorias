package utp.edu.co.zonaspromisorias.service.interfaces;

import utp.edu.co.zonaspromisorias.web.dto.FincaDto;

import java.util.List;

public interface FincaService {
    FincaDto obtenerFincaPorId(Integer id);

    FincaDto guardarFinca(FincaDto fincaDto);

    FincaDto actualizarFinca(FincaDto fincaDto);

    Boolean eliminarFinca(Integer id);

    List<FincaDto> obtenerFincas(Integer id);
}
