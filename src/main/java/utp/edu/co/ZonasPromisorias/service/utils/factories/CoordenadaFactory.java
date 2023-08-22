package utp.edu.co.zonaspromisorias.service.utils.factories;

import utp.edu.co.zonaspromisorias.model.entities.CoordenadasPoligonoEntity;
import utp.edu.co.zonaspromisorias.model.entities.FincaEntity;
import utp.edu.co.zonaspromisorias.model.entities.LoteEntity;
import utp.edu.co.zonaspromisorias.model.entities.ids.CoordenadasPoligonoId;
import utp.edu.co.zonaspromisorias.model.entities.ids.LoteId;
import utp.edu.co.zonaspromisorias.web.dto.CoordenadasDto;

public final class CoordenadaFactory {
    private CoordenadaFactory() {
    }

    public static CoordenadasPoligonoEntity crearCoordenadaEntityPorCoordenadaDto(CoordenadasDto coordenadaDto) {
        return CoordenadasPoligonoEntity.builder()
                .id(new CoordenadasPoligonoId(
                        LoteEntity.builder()
                                .id(new LoteId(
                                        FincaEntity.builder().idCatastral(coordenadaDto.getIdCatastral()).build(),
                                        coordenadaDto.getNumeroLote())).build(),
                        coordenadaDto.getCoordenadaX(),
                        coordenadaDto.getCoordenadaY()))
                .build();
    }

    public static CoordenadasDto crearCoordenadaDtoPorCoordenadaEntity(CoordenadasPoligonoEntity coordenadaEntity) {
        return CoordenadasDto.builder()
                .idCatastral(coordenadaEntity.getId().getLote().getId().getFinca().getIdCatastral())
                .numeroLote(coordenadaEntity.getId().getLote().getId().getNumeroLote())
                .coordenadaX(coordenadaEntity.getId().getCoordenadaX())
                .coordenadaY(coordenadaEntity.getId().getCoordenadaY())
                .build();
    }
}
