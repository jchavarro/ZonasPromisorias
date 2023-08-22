package utp.edu.co.zonaspromisorias.service.utils.factories;

import utp.edu.co.zonaspromisorias.model.entities.ControlClimaEntity;
import utp.edu.co.zonaspromisorias.model.entities.FincaEntity;
import utp.edu.co.zonaspromisorias.model.entities.LoteEntity;
import utp.edu.co.zonaspromisorias.model.entities.ids.ControlClimaId;
import utp.edu.co.zonaspromisorias.model.entities.ids.LoteId;
import utp.edu.co.zonaspromisorias.web.dto.ControlClimaDto;

import java.sql.Timestamp;

public final class ControlClimaFactory {

    private ControlClimaFactory() {
    }

    public static ControlClimaDto crearControlClimaDtoPorClimaEntity(ControlClimaEntity controlClimaEntity) {
        return ControlClimaDto.builder()
                .idCatastral(controlClimaEntity.getId().getLote().getId().getFinca().getIdCatastral())
                .numeroLote(controlClimaEntity.getId().getLote().getId().getNumeroLote())
                .fecha(controlClimaEntity.getId().getFecha().toString())
                .temperatura(controlClimaEntity.getTemperatura())
                .humedadRelativa(controlClimaEntity.getHumedadRelativa())
                .precipitacion(controlClimaEntity.getPrecipitacion())
                .radiacionSolar(controlClimaEntity.getRadiacionSolar())
                .direccionViento(controlClimaEntity.getDireccionViento())
                .velocidadViento(controlClimaEntity.getVelocidadViento())
                .build();
    }

    public static ControlClimaEntity crearControlClimaEntityPorClimaDto(ControlClimaDto controlClimaDto) {
        return ControlClimaEntity.builder()
                .id(crearControlClimaId(controlClimaDto.getIdCatastral(), controlClimaDto.getNumeroLote(),
                        controlClimaDto.getFecha()))
                .temperatura(controlClimaDto.getTemperatura())
                .humedadRelativa(controlClimaDto.getHumedadRelativa())
                .precipitacion(controlClimaDto.getPrecipitacion())
                .radiacionSolar(controlClimaDto.getRadiacionSolar())
                .direccionViento(controlClimaDto.getDireccionViento())
                .velocidadViento(controlClimaDto.getVelocidadViento())
                .build();
    }

    public static ControlClimaId crearControlClimaId(Integer idCatastral, Integer numeroLote, String fecha) {
        return new ControlClimaId(
                LoteEntity.builder()
                        .id(new LoteId(
                                FincaEntity.builder().idCatastral(idCatastral).build(),
                                numeroLote)).build(),
                Timestamp.valueOf(fecha));
    }

}
