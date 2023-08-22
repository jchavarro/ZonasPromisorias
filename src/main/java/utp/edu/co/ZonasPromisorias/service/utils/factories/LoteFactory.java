package utp.edu.co.zonaspromisorias.service.utils.factories;

import utp.edu.co.zonaspromisorias.model.entities.FincaEntity;
import utp.edu.co.zonaspromisorias.model.entities.LoteEntity;
import utp.edu.co.zonaspromisorias.model.entities.ids.LoteId;
import utp.edu.co.zonaspromisorias.web.dto.LoteDto;

public final class LoteFactory {

    private LoteFactory() {
    }

    public static LoteEntity crearLoteEntityPorLoteDto(LoteDto loteDto) {
        return LoteEntity.builder()
                .id(new LoteId(
                        FincaEntity.builder().idCatastral(loteDto.getIdCatastral()).build(),
                        loteDto.getNumeroLote()))
                .nombreLote(loteDto.getNombreLote())
                .build();
    }

    public static LoteDto crearLoteDtoPorLoteEntity(LoteEntity loteEntity) {
        return LoteDto.builder()
                .idCatastral(loteEntity.getId().getFinca().getIdCatastral())
                .numeroLote(loteEntity.getId().getNumeroLote())
                .nombreLote(loteEntity.getNombreLote())
                .build();
    }
}
