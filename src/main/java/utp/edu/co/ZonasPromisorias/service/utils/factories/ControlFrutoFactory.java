package utp.edu.co.zonaspromisorias.service.utils.factories;

import utp.edu.co.zonaspromisorias.model.entities.ControlFrutoEntity;
import utp.edu.co.zonaspromisorias.model.entities.FincaEntity;
import utp.edu.co.zonaspromisorias.model.entities.LoteEntity;
import utp.edu.co.zonaspromisorias.model.entities.ids.ControlFrutoId;
import utp.edu.co.zonaspromisorias.model.entities.ids.LoteId;
import utp.edu.co.zonaspromisorias.web.dto.ControlFrutoDto;

import java.sql.Timestamp;

public final class ControlFrutoFactory {

    private ControlFrutoFactory() {
    }

    public static ControlFrutoDto crearControlFrutoDtoPorControlFrutoEntity(ControlFrutoEntity controlFrutoEntity) {
        return ControlFrutoDto.builder()
                .idCatastral(controlFrutoEntity.getId().getLote().getId().getFinca().getIdCatastral())
                .numeroLote(controlFrutoEntity.getId().getLote().getId().getNumeroLote())
                .fecha(controlFrutoEntity.getId().getFecha().toString())
                .tamano(controlFrutoEntity.getTamano())
                .perfilesAcidosGrasos(controlFrutoEntity.getPerfilesAcidosGrasos())
                .materiaSeca(controlFrutoEntity.getMateriaSeca())
                .contenidoHumedad(controlFrutoEntity.getContenidoHumedad())
                .elementoCa(controlFrutoEntity.getElementoCa())
                .build();
    }

    public static ControlFrutoEntity crearControlFrutoEntityPorControlFrutoDto(ControlFrutoDto controlFrutoDto) {
        return ControlFrutoEntity.builder()
                .id(ControlFrutoFactory.crearControlFrutoId(controlFrutoDto.getIdCatastral(), controlFrutoDto.getNumeroLote(), controlFrutoDto.getFecha()))
                .tamano(controlFrutoDto.getTamano())
                .perfilesAcidosGrasos(controlFrutoDto.getPerfilesAcidosGrasos())
                .materiaSeca(controlFrutoDto.getMateriaSeca())
                .contenidoHumedad(controlFrutoDto.getContenidoHumedad())
                .elementoCa(controlFrutoDto.getElementoCa())
                .build();
    }

    public static ControlFrutoId crearControlFrutoId(Integer idCatastral, Integer numeroLote, String fecha) {
        return new ControlFrutoId(
                LoteEntity.builder()
                        .id(new LoteId(
                                FincaEntity.builder().idCatastral(idCatastral).build(),
                                numeroLote)).build(),
                Timestamp.valueOf(fecha));
    }

}
