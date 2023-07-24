package utp.edu.co.zonaspromisorias.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utp.edu.co.zonaspromisorias.model.entities.FincaEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoteDto {

    private FincaDto finca;

    private Integer numeroLote;

    private String nombreLote;
}
