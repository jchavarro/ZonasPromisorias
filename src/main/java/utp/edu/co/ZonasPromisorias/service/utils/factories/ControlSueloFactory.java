package utp.edu.co.zonaspromisorias.service.utils.factories;

import utp.edu.co.zonaspromisorias.model.entities.ControlSueloEntity;
import utp.edu.co.zonaspromisorias.model.entities.FincaEntity;
import utp.edu.co.zonaspromisorias.model.entities.LoteEntity;
import utp.edu.co.zonaspromisorias.model.entities.ids.ControlSueloId;
import utp.edu.co.zonaspromisorias.model.entities.ids.LoteId;
import utp.edu.co.zonaspromisorias.web.dto.ControlSueloDto;

import java.sql.Timestamp;

public final class ControlSueloFactory {

    private ControlSueloFactory() {
    }

    public static ControlSueloEntity crearControlSueloEntityPorControlSueloDto(ControlSueloDto controlSueloDto) {
        return ControlSueloEntity.builder()
                .id(new ControlSueloId(
                        LoteEntity.builder()
                                .id(new LoteId(
                                        FincaEntity.builder().idCatastral(controlSueloDto.getIdCatastral()).build(),
                                        controlSueloDto.getNumeroLote())).build(),
                        Timestamp.valueOf(controlSueloDto.getFecha())))
                .medidaPh(controlSueloDto.getMedidaPh())
                .materiaOrganica(controlSueloDto.getMateriaOrganica())
                .elementoK(controlSueloDto.getElementoK())
                .elementoCa(controlSueloDto.getElementoCa())
                .elementoMg(controlSueloDto.getElementoMg())
                .elementoNa(controlSueloDto.getElementoNa())
                .elementoP(controlSueloDto.getElementoP())
                .build();
    }

    public static ControlSueloDto crearControlSueloDtoPorControlSueloEntity(ControlSueloEntity controlSueloEntity) {
        return ControlSueloDto.builder()
                .idCatastral(controlSueloEntity.getId().getLote().getId().getFinca().getIdCatastral())
                .numeroLote(controlSueloEntity.getId().getLote().getId().getNumeroLote())
                .fecha(controlSueloEntity.getId().getFecha().toString())
                .medidaPh(controlSueloEntity.getMedidaPh())
                .materiaOrganica(controlSueloEntity.getMateriaOrganica())
                .elementoK(controlSueloEntity.getElementoK())
                .elementoCa(controlSueloEntity.getElementoCa())
                .elementoMg(controlSueloEntity.getElementoMg())
                .elementoNa(controlSueloEntity.getElementoNa())
                .elementoP(controlSueloEntity.getElementoP())
                .build();
    }

    public static ControlSueloId crearControlSueloId(Integer idCatastral, Integer numeroLote, String fecha) {
        return new ControlSueloId(
                LoteEntity.builder()
                        .id(new LoteId(
                                FincaEntity.builder().idCatastral(idCatastral).build(),
                                numeroLote)).build(),
                Timestamp.valueOf(fecha));
    }
}
